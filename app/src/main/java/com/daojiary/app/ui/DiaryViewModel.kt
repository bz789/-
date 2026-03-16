package com.daojiary.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daojiary.app.data.DiaryEntry
import com.daojiary.app.data.DiaryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DiaryViewModel(private val repository: DiaryRepository) : ViewModel() {

    val diaries = repository.getAllDiaries()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    private val _currentDiary = MutableStateFlow<DiaryEntry?>(null)
    val currentDiary = _currentDiary.asStateFlow()

    fun loadDiary(id: Long) {
        viewModelScope.launch {
            _currentDiary.value = repository.getDiaryById(id)
        }
    }

    fun saveDiary(diary: DiaryEntry) {
        viewModelScope.launch {
            if (diary.id == 0L) {
                repository.insertDiary(diary)
            } else {
                repository.updateDiary(diary)
            }
        }
    }

    fun deleteDiary(diary: DiaryEntry) {
        viewModelScope.launch {
            repository.deleteDiary(diary)
        }
    }

    fun setCurrentDiary(diary: DiaryEntry?) {
        _currentDiary.value = diary
    }
}
