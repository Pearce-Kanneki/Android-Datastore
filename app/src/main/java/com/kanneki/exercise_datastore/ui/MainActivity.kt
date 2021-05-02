package com.kanneki.exercise_datastore.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import com.kanneki.exercise_datastore.PreKey
import com.kanneki.exercise_datastore.R
import com.kanneki.exercise_datastore.dataStore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch(Dispatchers.Main) {
            viewModel.search(this@MainActivity)
                    .flowOn(Dispatchers.IO)
                    .collect {
                        textview.text = "Count: $it"
                    }
        }

        button.setOnClickListener {
            GlobalScope.launch {
                viewModel.incrementCounter(this@MainActivity)

            }
        }
    }
}