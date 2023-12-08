package com.example.firs_app.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.firs_app.R

sealed class NavigationItems(
    val titleResId: Int,
    val icon: ImageVector

) {
    object News : NavigationItems(
        titleResId = R.string.navigation_item_main,
        icon = Icons.Outlined.Newspaper
    )

    object Favorite : NavigationItems(
        titleResId = R.string.navigation_item_favorite,
        icon = Icons.Outlined.Favorite
    )
    object Profile:NavigationItems(titleResId = R.string.navigation_item_profile,
        icon = Icons.Outlined.AccountCircle)

}