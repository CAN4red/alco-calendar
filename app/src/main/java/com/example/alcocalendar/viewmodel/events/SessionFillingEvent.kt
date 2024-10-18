package com.example.alcocalendar.viewmodel.events

import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.db.entities.intakes.OtherDrink
import com.example.alcocalendar.db.entities.intakes.Spirits
import com.example.alcocalendar.db.entities.intakes.Wine

sealed interface SessionFillingEvent {
    data class AddBeerDrink(val beer: Beer) : SessionFillingEvent
    data class AddWineDrink(val wine: Wine) : SessionFillingEvent
    data class AddSpiritsDrink(val spirits: Spirits) : SessionFillingEvent
    data class AddOtherDrink(val otherDrink: OtherDrink) : SessionFillingEvent
    data object ConfirmSession : SessionFillingEvent
}