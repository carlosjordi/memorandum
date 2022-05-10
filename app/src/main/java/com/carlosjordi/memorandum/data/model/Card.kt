package com.carlosjordi.memorandum.data.model

import androidx.annotation.DrawableRes

data class Card(
    @DrawableRes val frontImage: Int,
    @DrawableRes val backImage: Int,
    val isFaceUp: Boolean = false,
    val isInteractive: Boolean = true,
    val pairFound: Boolean = false
)
