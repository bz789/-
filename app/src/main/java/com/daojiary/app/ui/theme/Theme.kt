package com.daojiary.app.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Notion-style dark colors
private val DarkColorScheme = darkColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF191919),
    onPrimary = androidx.compose.ui.graphics.Color(0xFFE5E5E5),
    secondary = androidx.compose.ui.graphics.Color(0xFF2F2F2F),
    onSecondary = androidx.compose.ui.graphics.Color(0xFFE5E5E5),
    tertiary = androidx.compose.ui.graphics.Color(0xFF4A4A4A),
    background = androidx.compose.ui.graphics.Color(0xFF191919),
    onBackground = androidx.compose.ui.graphics.Color(0xFFE5E5E5),
    surface = androidx.compose.ui.graphics.Color(0xFF202020),
    onSurface = androidx.compose.ui.graphics.Color(0xFFE5E5E5),
    outline = androidx.compose.ui.graphics.Color(0xFF4A4A4A),
    outlineVariant = androidx.compose.ui.graphics.Color(0xFF3A3A3A),
)

@Composable
fun DaojiaryTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else DarkColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
