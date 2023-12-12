package com.example.steamsaleapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat;

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

/**
 * Composable function to apply theme for the SteamSaleApp.
 * 
 * @param darkTheme A Boolean flag indicating if the dark theme should be applied. Defaults to system theme settings.
 * @param dynamicColor A Boolean flag to enable dynamic coloring on Android 12 and above. Defaults to true.
 * @param content The content of the UI that will be wrapped in this theme.
 */
@Composable
fun SteamSaleAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // Determine the appropriate color scheme based on the provided flags and system capabilities.
    val colorScheme = getColorScheme(darkTheme, dynamicColor)
    val view = LocalView.current
    
    // Apply system UI changes if not in preview mode.
    if (!view.isInEditMode) {
       updateSystemUi(view, colorScheme, darkTheme)
    }

    // Apply the Material theme with the selected color scheme and predefined typography.
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

/**
 * Determines the color scheme based on the dark theme preference and availability of dynamic colors.
 * 
 * @param darkTheme Indicates whether the dark theme is preferred.
 * @param dynamicColor Indicates whether to use dynamic color (available on Android 12+).
 * @return The chosen ColorScheme.
 */
@Composable
private fun getColorScheme(darkTheme: Boolean, dynamicColor: Boolean): ColorScheme {
    val context = LocalContext.current
    return when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
}

/**
 * Updates the system UI elements like status bar color and icon theme to match the app's theme.
 * 
 * @param view The current view context.
 * @param colorScheme The color scheme being applied to the app.
 * @param darkTheme Indicates whether the dark theme is applied.
 */
private fun updateSystemUi(view: View, colorScheme: ColorScheme, darkTheme: Boolean) {
    SideEffect {
        val window = (view.context as Activity).window

        // Set the status bar color to match the primary color of the theme
        window.statusBarColor = colorScheme.primary.toArgb()

        //Adjust the appearance of status bar icons based on the theme.
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }
}
