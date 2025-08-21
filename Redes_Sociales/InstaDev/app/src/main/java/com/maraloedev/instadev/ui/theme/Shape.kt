package com.maraloedev.instadev.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val shapes = Shapes(
    extraSmall = RoundedCornerShape(10), // Se usa para los pequeños items (CheckBox)
    small = RoundedCornerShape(10), // Se usa para Button. TextButton...
    medium = RoundedCornerShape(12.dp),// Se usan para dialogos, cards...
    large = RoundedCornerShape(25), // Se ussa para hacer subvistas
    extraLarge = RoundedCornerShape(32.dp)) // Se usa para el FAB(Floating Action Button)