package com.maraloedev.myfirstcomposeapp.components.navigation.types

import android.net.Uri
import android.os.Build
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.maraloedev.myfirstcomposeapp.components.navigation.examples.model.SettingsModel
import kotlinx.serialization.json.Json

val settingsModelType = object : NavType<SettingsModel>(isNullableAllowed = true) {

    override fun put(
        bundle: SavedState,
        key: String,
        value: SettingsModel
    ) {
        bundle.putParcelable(key, value)
    }

    override fun get(
        bundle: SavedState,
        key: String
    ): SettingsModel? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, SettingsModel::class.java)
        } else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): SettingsModel {
        return Json.decodeFromString<SettingsModel>(value)
    }

    override fun serializeAsValue(value: SettingsModel): String {
        return Uri.encode(Json.encodeToString(value))
    }

}