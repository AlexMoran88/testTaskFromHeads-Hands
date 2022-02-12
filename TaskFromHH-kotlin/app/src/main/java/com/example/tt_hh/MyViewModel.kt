package com.example.tt_hh

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    var n: Int by mutableStateOf(readAgeFromDatabase())
        private set
    var showTextFlag : Boolean by mutableStateOf(false)
        private set

    fun switchShowTextFlag(){
        showTextFlag = true
    }

    fun onNChange(newN: Int) {
        n = newN
    }

    private fun readAgeFromDatabase(): Int {
        // TODO: Real implementation
        return 0
    }

}

