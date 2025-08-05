package com.maraloedev.myfirstcomposeapp.components.navigation

import com.maraloedev.myfirstcomposeapp.components.navigation.examples.model.SettingsModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String)

@Serializable
data class Settings(val settingsModel: SettingsModel)