package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val NodariaColorScheme = darkColorScheme(
    primary = NodariaLime,
    onPrimary = NodariaBg,
    primaryContainer = NodariaSurfaceVariant,
    onPrimaryContainer = NodariaLime,
    secondary = NodariaCyan,
    onSecondary = NodariaBg,
    secondaryContainer = NodariaSurfaceElevated,
    onSecondaryContainer = NodariaCyan,
    tertiary = NodariaStatusGreen,
    background = NodariaBg,
    onBackground = NodariaTextPrimary,
    surface = NodariaSurface,
    onSurface = NodariaTextPrimary,
    surfaceVariant = NodariaSurfaceVariant,
    onSurfaceVariant = NodariaTextSecondary,
    outline = NodariaBorder,
    outlineVariant = NodariaBorderActive
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = NodariaColorScheme,
        typography = Typography,
        content = content
    )
}
