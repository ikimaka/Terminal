package com.ikimaka.terminal.presentation

import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import kotlinx.parcelize.Parcelize

@Composable
fun Test() {

    var testData by rememberSaveable(saver = TestData.Saver) {
        mutableStateOf(TestData(number = 0, text = "text"))
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { testData = testData.copy(number = testData.number + 1) },
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Text: $testData")
    }
}

data class TestData(val number: Int, val text: String) {


    companion object {


        val Saver: Saver<MutableState<TestData>, Any> = listSaver(
            save = {
                val testData = it.value
                listOf(testData.number, testData.text)
            },
            restore = {
                val testData = TestData(
                    number = it[0] as Int,
                    text = it[1] as String
                )
                mutableStateOf(testData)
            }
        )

//        val Saver: Saver<MutableState<TestData>, Int> = Saver(
//            save = {
//                it.value.number
//            },
//            restore = {
//                mutableStateOf(TestData(it))
//            }
//        )
    }
}

//@Parcelize
//data class TestData(val number: Int): Parcelable