package com.example.the30daysofbreakfastideasapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Breakfast(
    @StringRes val dayRes: Int,
    @StringRes val nameRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int,
)
