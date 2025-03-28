package com.example.alcocalendar.core.database

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.alcocalendar.core.data.local.DrinkingSessionDatabase
import com.example.alcocalendar.core.data.local.dao.DrinkingSessionDao
import com.example.alcocalendar.core.data.local.entity.DrinkIntakeEntity
import com.example.alcocalendar.core.data.local.entity.DrinkingSessionEntity
import com.example.alcocalendar.features.session_manage.drink_intake.data.local.dao.DrinkIntakeDao
import com.example.alcocalendar.core.data.local.entity.drink_types.BeerType
import com.example.alcocalendar.core.data.local.entity.drink_types.WineType
import com.example.alcocalendar.core.data.local.entity.relations.DrinkingSessionWithDrinkIntakes
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.time.LocalDate
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class DrinkingSessionDatabaseTest {
    private lateinit var drinkingSessionDao: DrinkingSessionDao
    private lateinit var drinkingSessionDb: DrinkingSessionDatabase
    private lateinit var drinkIntakeDao: DrinkIntakeDao

    @Before
    fun createDrinkingSessionDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        drinkingSessionDb = Room.inMemoryDatabaseBuilder(
            context, DrinkingSessionDatabase::class.java).build()
        drinkingSessionDao = drinkingSessionDb.drinkingSessionDao
        drinkIntakeDao = drinkingSessionDb.drinkIntakeDao
    }

    @After
    @Throws(IOException::class)
    fun closeDrinkingSessionDb() {
        drinkingSessionDb.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertDrinkingSessionAndGet_singleDrinkingSession() = runBlocking {
        val date = LocalDate.of(2025, 2, 9)
        val drinkingSessionInserted = DrinkingSessionEntity(date)

        drinkingSessionDao.insertDrinkingSession(drinkingSessionInserted)

        val drinkingSessionGotten = drinkIntakeDao
            .getDrinkingSessionWithDrinkIntakes(date)
            ?.drinkingSession

        assertEquals(drinkingSessionInserted, drinkingSessionGotten)
    }

    @Test
    @Throws(Exception::class)
    fun insertDrinkingSessionWithDrinkIntakesAndGet_singleDrinkingSessionWithTwoDrinkIntakes() = runBlocking {
        val date = LocalDate.of(2025, 1, 1)
        val drinkingSessionInserted = DrinkingSessionEntity(date)
        val drinkIntakeInserted1 = DrinkIntakeEntity(
            date = date,
            drinkType = BeerType.LIGHT,
            liters = 0.45,
            alcoStrength = 5.5
        )
        val drinkIntakeInserted2 = DrinkIntakeEntity(
            date = date,
            drinkType = WineType.VERMOUTH,
            liters = 0.9,
            alcoStrength = 20.5
        )

        drinkingSessionDao.insertDrinkingSession(drinkingSessionInserted)
        drinkIntakeDao.insertDrinkIntake(drinkIntakeInserted1)
        drinkIntakeDao.insertDrinkIntake(drinkIntakeInserted2)

        val drinkingSessionWithDrinkIntakesExpected = DrinkingSessionWithDrinkIntakes(
            drinkingSession = drinkingSessionInserted,
            drinkIntakes = listOf(drinkIntakeInserted1, drinkIntakeInserted2)
        )

        val drinkingSessionWithDrinkIntakesGotten = drinkIntakeDao
            .getDrinkingSessionWithDrinkIntakes(date)

        assertEquals(
            drinkingSessionWithDrinkIntakesExpected,
            drinkingSessionWithDrinkIntakesGotten
        )
    }

    @Test
    @Throws(Exception::class)
    fun insertDrinkingSessionAndGet_DrinkingSessionWithTheSameDate() = runBlocking {
        val date1 = LocalDate.of(2025, 1, 2)
        val date2 = LocalDate.of(2025, 1, 3)

        val drinkingSessionInserted1 = DrinkingSessionEntity(date1)
        val drinkingSessionInserted2 = DrinkingSessionEntity(date2)
        val drinkingSessionInserted3 = DrinkingSessionEntity(date2)

        drinkingSessionDao.insertDrinkingSession(drinkingSessionInserted1)
        drinkingSessionDao.insertDrinkingSession(drinkingSessionInserted2)
        drinkingSessionDao.insertDrinkingSession(drinkingSessionInserted3)

        val allDrinkingSessionsGotten = drinkIntakeDao.getDrinkingSessionsWithDrinkIntakes()

        assertEquals(2, allDrinkingSessionsGotten.size)
    }

    @Test
    @Throws(Exception::class)
    fun updateDrinkIntake_OneDrinkingSessionWithTwoDrinkIntakes() = runBlocking {
        val date = LocalDate.of(2005, 8, 2)

        val drinkingSessionInserted = DrinkingSessionEntity(date)
        val drinkIntakeInserted1 = DrinkIntakeEntity(
            date = date,
            drinkType = WineType.VERMOUTH,
            liters = 0.9,
            alcoStrength = 20.5
        )
        val drinkIntakeInserted2 = DrinkIntakeEntity(
            date = date,
            drinkType = BeerType.LIGHT,
            liters = 0.45,
            alcoStrength = 20.5
        )

        drinkingSessionDao.insertDrinkingSession(drinkingSessionInserted)
        drinkIntakeDao.insertDrinkIntake(drinkIntakeInserted1)
        drinkIntakeDao.insertDrinkIntake(drinkIntakeInserted2)

        val drinkIntakeUpdated = drinkIntakeDao
            .getDrinkingSessionWithDrinkIntakes(date)
            ?.drinkIntakes?.get(0)?.let {
            DrinkIntakeEntity(
                date = date,
                drinkType = WineType.RED,
                liters = 1.5,
                alcoStrength = 20.5
            )
        }
        if (drinkIntakeUpdated != null) {
            drinkIntakeDao.updateDrinkIntake(drinkIntakeUpdated)
        }

        val allDrinkIntakesGotten = drinkIntakeDao
            .getDrinkingSessionWithDrinkIntakes(date)
            ?.drinkIntakes

        if (allDrinkIntakesGotten != null) {
            assertEquals(2, allDrinkIntakesGotten.size)
        }
        allDrinkIntakesGotten?.get(0)?.let { assertEquals(1.5, it.liters, 0.001) }
        allDrinkIntakesGotten?.get(1)?.let { assertEquals(0.45, it.liters, 0.001) }
        assertEquals(WineType.RED, allDrinkIntakesGotten?.get(0)?.drinkType)
        assertEquals(BeerType.LIGHT, allDrinkIntakesGotten?.get(1)?.drinkType)
    }

    @Test
    @Throws(Exception::class)
    fun deleteDrinkIntake_OneDrinkingSessionWithOneDrinkIntake() = runBlocking {
        val date = LocalDate.of(2005, 1, 13)

        val drinkingSessionInserted = DrinkingSessionEntity(date)
        val drinkIntakeInserted = DrinkIntakeEntity(
            date = date,
            drinkType = WineType.VERMOUTH,
            liters = 0.9,
            alcoStrength = 20.5
        )

        drinkingSessionDao.insertDrinkingSession(drinkingSessionInserted)
        drinkIntakeDao.insertDrinkIntake(drinkIntakeInserted)

        val drinkIntakeToDelete = drinkIntakeDao
            .getDrinkingSessionWithDrinkIntakes(date)
            ?.drinkIntakes?.get(0)

        if (drinkIntakeToDelete != null) {
            drinkIntakeDao.deleteDrinkIntake(drinkIntakeToDelete)
        }

        val allDrinkIntakesGotten = drinkIntakeDao
            .getDrinkingSessionWithDrinkIntakes(date)
            ?.drinkIntakes

        if (allDrinkIntakesGotten != null) {
            assertEquals(0, allDrinkIntakesGotten.size)
        }
    }

    @Test
    @Throws(Exception::class)
    fun deleteDrinkingSession_OneDrinkingSessionWithOneDrinkIntake() = runBlocking {
        val date = LocalDate.of(2005, 1, 13)

        val drinkingSessionInserted = DrinkingSessionEntity(date)
        val drinkIntakeInserted = DrinkIntakeEntity(
            date = date,
            drinkType = WineType.VERMOUTH,
            liters = 0.9,
            alcoStrength = 20.5
        )

        drinkingSessionDao.insertDrinkingSession(drinkingSessionInserted)
        drinkIntakeDao.insertDrinkIntake(drinkIntakeInserted)

        drinkingSessionDao.deleteDrinkingSessionByDate(date)

        val allDrinkingSessionsGotten = drinkIntakeDao.getDrinkingSessionsWithDrinkIntakes()

        assertEquals(0, allDrinkingSessionsGotten.size)
    }
}
