package com.example.applifecyclesample

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// 画面が回転しても内容が消えないようにする
class MainViewModel : ViewModel() {
    private val _textStateFlow = MutableStateFlow("")
    // ここでTextField内の文字列を保持
    val textStateFlow: StateFlow<String> = _textStateFlow.asStateFlow()

    fun onTextChange(text: String) {
        _textStateFlow.update { text }
    }
}