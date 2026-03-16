package com.daojiary.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daojiary.app.data.DiaryRepository
import com.daojiary.app.ui.DiaryViewModel

class DiaryViewModelFactory(
    private val repository: DiaryRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiaryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DiaryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
