package com.example.alcocalendar.ui.addsession.viewmodel

import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.db.entities.intakes.OtherDrink
import com.example.alcocalendar.db.entities.intakes.Spirits
import com.example.alcocalendar.db.entities.intakes.Wine
import java.time.LocalDate

sealed interface FillingSessionEvent {
    data class InitNewSession(val date: LocalDate) : FillingSessionEvent
    data class AddBeerDrink(val beer: Beer) : FillingSessionEvent
    data class AddWineDrink(val wine: Wine) : FillingSessionEvent
    data class AddSpiritsDrink(val spirits: Spirits) : FillingSessionEvent
    data class AddOtherDrink(val otherDrink: OtherDrink) : FillingSessionEvent
    data object ConfirmSession : FillingSessionEvent
    data object DismissSession : FillingSessionEvent
}