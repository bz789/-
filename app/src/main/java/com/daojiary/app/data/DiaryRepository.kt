package com.daojiary.app.data

import kotlinx.coroutines.flow.Flow

class DiaryRepository(private val diaryDao: DiaryDao) {
    fun getAllDiaries(): Flow<List<DiaryEntry>> = diaryDao.getAllDiaries()

    suspend fun getDiaryById(id: Long): DiaryEntry? = diaryDao.getDiaryById(id)

    suspend fun insertDiary(diary: DiaryEntry): Long = diaryDao.insertDiary(diary)

    suspend fun updateDiary(diary: DiaryEntry) = diaryDao.updateDiary(diary)

    suspend fun deleteDiary(diary: DiaryEntry) = diaryDao.deleteDiary(diary)

    suspend fun deleteDiaryById(id: Long) = diaryDao.deleteDiaryById(id)
}
