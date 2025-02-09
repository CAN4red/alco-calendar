package com.example.alcocalendar.data.local.database

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.alcocalendar.data.local.dao.DrinkingSessionDao
import com.example.alcocalendar.data.local.entities.DrinkIntakeEntity
import com.example.alcocalendar.data.local.entities.DrinkingSessionEntity
import com.example.alcocalendar.data.local.entities.drink_types.BeerType
import com.example.alcocalendar.data.local.entities.drink_types.WineType
import com.example.alcocalendar.data.local.entities.relations.DrinkingSessionWithDrinkIntakes
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

    @Before
    fun createDrinkingSessionDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        drinkingSessionDb = Room.inMemoryDatabaseBuilder(
            context, DrinkingSessionDatabase::class.java).build()
        drinkingSessionDao = drinkingSessionDb.drinkingSessionDao
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

        val drinkingSessionGotten = drinkingSessionDao
            .getDrinkingSessionWithDrinkIntakes(date)
            .drinkingSessionEntity

        assertEquals(drinkingSessionInserted, drinkingSessionGotten)
    }

    @Test
    @Throws(Exception::class)
    fun insertDrinkingSessionWithDrinkIntakesAndGet_singleDrinkingSessionWithTwoDrinkIntakes() = runBlocking {
        val date = LocalDate.of(2025, 1, 1)
        val drinkingSessionInserted = DrinkingSessionEntity(date)
        val drinkIntakeInserted1 = DrinkIntakeEntity(
            drinkIntakeId = 1,
            date = date,
            drinkType = BeerType.LIGHT,
            liters = 0.45,
            alcoStrength = 5.5
        )
        val drinkIntakeInserted2 = DrinkIntakeEntity(
            drinkIntakeId = 2,
            date = date,
            drinkType = WineType.VERMOUTH,
            liters = 0.9,
            alcoStrength = 20.5
        )

        drinkingSessionDao.insertDrinkingSession(drinkingSessionInserted)
        drinkingSessionDao.insertDrinkIntake(drinkIntakeInserted1)
        drinkingSessionDao.insertDrinkIntake(drinkIntakeInserted2)

        val drinkingSessionWithDrinkIntakesExpected = DrinkingSessionWithDrinkIntakes(
            drinkingSessionEntity = drinkingSessionInserted,
            drinkIntakes = listOf(drinkIntakeInserted1, drinkIntakeInserted2)
        )

        val drinkingSessionWithDrinkIntakesGotten = drinkingSessionDao
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

        val allDrinkingSessionsGotten = drinkingSessionDao.getDrinkingSessionsWithDrinkIntakes()

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
        drinkingSessionDao.insertDrinkIntake(drinkIntakeInserted1)
        drinkingSessionDao.insertDrinkIntake(drinkIntakeInserted2)

        val drinkIntakeUpdated = DrinkIntakeEntity(
            drinkIntakeId = drinkingSessionDao
                .getDrinkingSessionWithDrinkIntakes(date)
                .drinkIntakes[0]
                .drinkIntakeId,
            date = date,
            drinkType = WineType.RED,
            liters = 1.5,
            alcoStrength = 20.5
        )
        drinkingSessionDao.updateDrinkIntake(drinkIntakeUpdated)

        val allDrinkIntakesGotten = drinkingSessionDao
            .getDrinkingSessionWithDrinkIntakes(date)
            .drinkIntakes

        assertEquals(2, allDrinkIntakesGotten.size)
        assertEquals(1.5, allDrinkIntakesGotten[0].liters, 0.001)
        assertEquals(0.45, allDrinkIntakesGotten[1].liters, 0.001)
        assertEquals(WineType.RED, allDrinkIntakesGotten[0].drinkType)
        assertEquals(BeerType.LIGHT, allDrinkIntakesGotten[1].drinkType)
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
        drinkingSessionDao.insertDrinkIntake(drinkIntakeInserted)

        val drinkIntakeIdToDelete = drinkingSessionDao
            .getDrinkingSessionWithDrinkIntakes(date)
            .drinkIntakes[0]
            .drinkIntakeId

        drinkingSessionDao.deleteDrinkIntakeById(drinkIntakeIdToDelete)

        val allDrinkIntakesGotten = drinkingSessionDao
            .getDrinkingSessionWithDrinkIntakes(date)
            .drinkIntakes

        assertEquals(0, allDrinkIntakesGotten.size)
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
        drinkingSessionDao.insertDrinkIntake(drinkIntakeInserted)

        drinkingSessionDao.deleteDrinkingSessionByDate(date)

        val allDrinkingSessionsGotten = drinkingSessionDao.getDrinkingSessionsWithDrinkIntakes()

        assertEquals(0, allDrinkingSessionsGotten.size)
    }
}
