package com.daojiary.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diaries")
data class DiaryEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String = "",
    val event: String = "",           // 今天最起波澜的一件事是什么
    val reaction: String = "",         // 当时我的第一反应是什么
    val desired: String = "",          // 我其实想得到什么
    val fear: String = "",             // 我其实在害怕什么
    val reason: String = "",           // 我给自己找了什么理由
    val mainStone: String = "",        // 今天捞出来的主石头是什么
    val futureChoice: String = "",     // 如果明天再遇到同样的事，我准备怎么选
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
