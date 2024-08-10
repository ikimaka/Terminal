package com.ikimaka.terminal.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ikimaka.terminal.ui.theme.TerminalTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            TerminalTheme {
                val viewModel: TerminalViewModel = viewModel()
                val screenState = viewModel.state.collectAsState()

                when (val currentState = screenState.value) {

                    is TerminalScreenState.Initial -> { }

                    is TerminalScreenState.Content -> {
                        Terminal(bars = currentState.barList)
                    }

                }

            }
        }
    }
}