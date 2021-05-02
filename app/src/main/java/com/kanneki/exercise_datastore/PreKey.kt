package com.kanneki.exercise_datastore

import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow

object PreKey {
    val KEY_COUNTER = intPreferencesKey("key_counter")

}