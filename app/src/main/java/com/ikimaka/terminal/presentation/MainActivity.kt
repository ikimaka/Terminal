package com.ikimaka.terminal.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ikimaka.terminal.ui.theme.TerminalTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            TerminalTheme {
                //Test()

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