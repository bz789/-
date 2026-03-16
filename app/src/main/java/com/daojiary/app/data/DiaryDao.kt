package com.daojiary.app.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DiaryDao {
    @Query("SELECT * FROM diaries ORDER BY createdAt DESC")
    fun getAllDiaries(): Flow<List<DiaryEntry>>

    @Query("SELECT * FROM diaries WHERE id = :diaryId")
    suspend fun getDiaryById(diaryId: Long): DiaryEntry?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiary(diary: DiaryEntry): Long

    @Update
    suspend fun updateDiary(diary: DiaryEntry)

    @Delete
    suspend fun deleteDiary(diary: DiaryEntry)

    @Query("DELETE FROM diaries WHERE id = :diaryId")
    suspend fun deleteDiaryById(diaryId: Long)
}
