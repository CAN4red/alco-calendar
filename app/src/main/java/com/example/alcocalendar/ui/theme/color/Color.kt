package com.example.alcocalendar.ui.theme.color

import androidx.compose.ui.graphics.Color

val LightBackground = Color(0xFFFFFFFF)
val LightSurface= Color(0xFFEFF5F1)
val LightPrimary = Color(0xFF4EBF6C)
val LightSecondary = Color(0xFFBF4EA1)

val DarkBackground = Color(0xFF181818)
val DarkSurface= Color(0xFF3D3D3F)
val DarkPrimary = Color(0xFF4EBF6C)
val DarkSecondary = Color(0xFFBF4EA1)

interface Pallet {
    val GreenDrunkLow: Color
    val GreenDrunkMedium: Color
    val GreenDrunkHigh: Color
    val GreenDrunkHard: Color
}

object LightSessionPallet: Pallet {
    override val GreenDrunkLow = Color(0xFFB5E4BE)
    override val GreenDrunkMedium = Color(0xFF9BD9A9)
    override val GreenDrunkHigh = Color(0xFF71CA86)
    override val GreenDrunkHard = Color(0xFF4EBF6C)
}

object DarkSessionPallet:Pallet {
    override val GreenDrunkLow = Color(0xFF004717)
    override val GreenDrunkMedium = Color(0xFF00571C)
    override val GreenDrunkHigh = Color(0xFF006725)
    override val GreenDrunkHard = Color(0xFF128639)
}
