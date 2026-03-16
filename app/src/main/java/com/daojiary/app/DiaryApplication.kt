package com.daojiary.app

import android.app.Application
import com.daojiary.app.data.AppDatabase
import com.daojiary.app.data.DiaryRepository

class DiaryApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { DiaryRepository(database.diaryDao()) }
}
