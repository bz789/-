package com.daojiary.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daojiary.app.data.DiaryEntry
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiaryEditorScreen(
    diary: DiaryEntry?,
    viewModel: DiaryViewModel,
    onBack: () -> Unit
) {
    var title by remember { mutableStateOf(TextFieldValue(diary?.title ?: "")) }
    var event by remember { mutableStateOf(TextFieldValue(diary?.event ?: "") }
    var reaction by remember { mutableStateOf(TextFieldValue(diary?.reaction ?: "") }
    var desired by remember { mutableStateOf(TextFieldValue(diary?.desired ?: "") }
    var fear by remember { mutableStateOf(TextFieldValue(diary?.fear ?: "") }
    var reason by remember { mutableStateOf(TextFieldValue(diary?.reason ?: "") }
    var mainStone by remember { mutableStateOf(TextFieldValue(diary?.mainStone ?: "") }
    var futureChoice by remember { mutableStateOf(TextFieldValue(diary?.futureChoice ?: "") }

    val isEditing = diary != null

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (isEditing) "编辑日记" else "新建日记",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "返回")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            val updatedDiary = if (isEditing) {
                                diary.copy(
                                    title = title.text,
                                    event = event.text,
                                    reaction = reaction.text,
                                    desired = desired.text,
                                    fear = fear.text,
                                    reason = reason.text,
                                    mainStone = mainStone.text,
                                    futureChoice = futureChoice.text,
                                    updatedAt = System.currentTimeMillis()
                                )
                            } else {
                                DiaryEntry(
                                    title = title.text,
                                    event = event.text,
                                    reaction = reaction.text,
                                    desired = desired.text,
                                    fear = fear.text,
                                    reason = reason.text,
                                    mainStone = mainStone.text,
                                    futureChoice = futureChoice.text
                                )
                            }
                            viewModel.saveDiary(updatedDiary)
                            onBack()
                        }
                    ) {
                        Icon(Icons.Default.Check, contentDescription = "保存")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 标题
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                placeholder = { Text("日记标题") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.titleLarge,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = MaterialTheme.colorScheme.outline,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant,
                    unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                ),
                shape = RoundedCornerShape(8.dp)
            )

            // 日期
            val dateFormat = SimpleDateFormat("yyyy年MM月dd日 HH:mm", Locale.getDefault())
            Text(
                text = dateFormat.format(Date(if (isEditing) diary!!.createdAt else System.currentTimeMillis())),
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
            )

            Divider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
                thickness = 1.dp
            )

            // 道痕模板问题
            TemplateQuestion(
                question = "今天最起波澜的一件事是什么",
                answer = event,
                onAnswerChange = { event = it },
                icon = "🌊"
            )

            TemplateQuestion(
                question = "当时我的第一反应是什么",
                answer = reaction,
                onAnswerChange = { reaction = it },
                icon = "💭"
            )

            TemplateQuestion(
                question = "我其实想得到什么",
                answer = desired,
                onAnswerChange = { desired = it },
                icon = "🎯"
            )

            TemplateQuestion(
                question = "我其实在害怕什么",
                answer = fear,
                onAnswerChange = { fear = it },
                icon = "😰"
            )

            TemplateQuestion(
                question = "我给自己找了什么理由",
                answer = reason,
                onAnswerChange = { reason = it },
                icon = "🤔"
            )

            TemplateQuestion(
                question = "今天捞出来的主石头是什么",
                answer = mainStone,
                onAnswerChange = { mainStone = it },
                icon = "💎"
            )

            TemplateQuestion(
                question = "如果明天再遇到同样的事，我准备怎么选",
                answer = futureChoice,
                onAnswerChange = { futureChoice = it },
                icon = "🚀"
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TemplateQuestion(
    question: String,
    answer: TextFieldValue,
    onAnswerChange: (TextFieldValue) -> Unit,
    icon: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = icon,
                    fontSize = 20.sp
                )
                Text(
                    text = question,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = answer,
                onValueChange = onAnswerChange,
                placeholder = {
                    Text(
                        "写下你的思考...",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodyMedium,
                minLines = 2,
                maxLines = 10,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    focusedIndicatorColor = MaterialTheme.colorScheme.outline,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant
                ),
                shape = RoundedCornerShape(8.dp)
            )
        }
    }
}
