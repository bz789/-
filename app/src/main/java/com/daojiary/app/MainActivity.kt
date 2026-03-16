package com.daojiary.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.daojiary.app.data.DiaryEntry
import com.daojiary.app.ui.DiaryEditorScreen
import com.daojiary.app.ui.DiaryListScreen
import com.daojiary.app.ui.DiaryViewModel
import com.daojiary.app.ui.theme.DaojiaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaojiaryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DaojiaryNavGraph()
                }
            }
        }
    }
}

@Composable
fun DaojiaryNavGraph() {
    val navController = rememberNavController()
    val application = androidx.compose.ui.platform.LocalContext.current.applicationContext as DiaryApplication
    val viewModel: DiaryViewModel = viewModel(
        factory = DiaryViewModelFactory(application.repository)
    )

    var startDestination by remember { mutableStateOf("diary_list") }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("diary_list") {
            DiaryListScreen(
                viewModel = viewModel,
                onDiaryClick = { diary ->
                    navController.navigate("diary_editor/${diary.id}")
                },
                onAddDiary = {
                    navController.navigate("diary_editor/new")
                }
            )
        }

        composable(
            route = "diary_editor/{diaryId}",
            arguments = listOf(
                navArgument("diaryId") { type = NavType.LongType }
            )
        ) { backStackEntry ->
            val diaryId = backStackEntry.arguments?.getLong("diaryId") ?: 0L
            var diary by remember { mutableStateOf<DiaryEntry?>(null) }

            LaunchedEffect(diaryId) {
                if (diaryId != 0L) {
                    diary = viewModel.getDiaryById(diaryId)
                }
            }

            DiaryEditorScreen(
                diary = diary,
                viewModel = viewModel,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
