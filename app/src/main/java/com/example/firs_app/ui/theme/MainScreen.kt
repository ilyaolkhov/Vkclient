@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.firs_app.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.util.copy
import com.example.firs_app.MainViewModel
import com.example.firs_app.domain.FeedPost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState",)
@Composable
fun MainScreen(viewModel: MainViewModel) {

    Scaffold(bottomBar = {
        NavigationBar {
            var selectedItemPosition = remember{mutableStateOf(0)}
            val items = listOf(
                NavigationItems.News, NavigationItems.Favorite, NavigationItems.Profile
            )
            items.forEachIndexed { index, items ->
                NavigationBarItem(selected = selectedItemPosition.value == index ,
                    onClick = { selectedItemPosition.value = index},
                    icon = {
                    Icon(items.icon, contentDescription = "")
                },
                    label = { Text(text = stringResource(id = items.titleResId)) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                        unselectedTextColor = MaterialTheme.colorScheme.onSecondary

                    )

                )
            }
        }
    }) {
        val feedPost = viewModel.feedPost.observeAsState(FeedPost())
        PostCard(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            feedPost = feedPost.value,

            onStatisticItemClickListener = {
                viewModel.updateCount(it)
            }
        )




    }
}

