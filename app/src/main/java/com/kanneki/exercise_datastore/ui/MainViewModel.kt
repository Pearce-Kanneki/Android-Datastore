package com.kanneki.exercise_datastore.ui

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import com.kanneki.exercise_datastore.PreKey
import com.kanneki.exercise_datastore.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainViewModel : ViewModel() {

    fun search(context: Context): Flow<Int>{

        return context.dataStore.data.map {
            it[PreKey.KEY_COUNTER] ?: 0
        }
    }

    suspend fun incrementCounter(context: Context){
        context.dataStore.edit { settings ->

            val currentCounterValue = settings[PreKey.KEY_COUNTER] ?: 0
            settings[PreKey.KEY_COUNTER] = currentCounterValue + 1
        }
    }
}