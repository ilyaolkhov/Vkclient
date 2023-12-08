package com.example.firs_app.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Repeat
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.firs_app.domain.FeedPost
import com.example.firs_app.domain.StatisticItem
import com.example.firs_app.domain.StatisticType


@Composable
fun PostCard(
    onStatisticItemClickListener: (StatisticItem) -> Unit,

    modifier: Modifier= Modifier,
    feedPost: FeedPost

) {
    Card( modifier= modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            HeaderPost(feedPost)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .background(Color.Transparent),
                text = feedPost.conteneText
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier.height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = feedPost.imageFeed),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.height(8.dp))
            StaticPost(
                onItemClickListener = onStatisticItemClickListener,
                statistics = feedPost.statistics)
        }


    }
}

@Composable
fun StaticPost(
    statistics: List<StatisticItem>,
    onItemClickListener: (StatisticItem) -> Unit
) {
        Row () {
            Row (Modifier.weight(1f, true),
                horizontalArrangement = Arrangement.SpaceBetween,
                ){
                val likesItem = statistics.getItemByType(StatisticType.LIKES)
                val sharesItem = statistics.getItemByType(StatisticType.SHARED)
                val commentsItem = statistics.getItemByType(StatisticType.COMMENTS)
                IconWithText( onItemClickListener = {
                    onItemClickListener(likesItem)
                },
                    text = likesItem.count.toString(),
                    iconResId = Icons.Outlined.FavoriteBorder,
                    colorIcon = MaterialTheme.colorScheme.onSecondary
                )
                IconWithText(
                    onItemClickListener ={
                        onItemClickListener(sharesItem)
                    },
                    text = sharesItem.count.toString(),
                    iconResId = Icons.Outlined.Repeat,
                    colorIcon = MaterialTheme.colorScheme.onSecondary
                )
                IconWithText(
                    onItemClickListener={onItemClickListener(commentsItem)},
                    text = commentsItem.count.toString(),
                    iconResId = Icons.Outlined.Comment,
                    colorIcon = MaterialTheme.colorScheme.onSecondary
                )
            }
            Row(Modifier.weight(1f, true),
                horizontalArrangement = Arrangement.End) {
                val viewItem = statistics.getItemByType(StatisticType.VIEWS)
                IconWithText(
                    onItemClickListener={onItemClickListener(viewItem)},
                    text = viewItem.count.toString(),
                    iconResId = Icons.Outlined.Visibility, colorIcon = MaterialTheme.colorScheme.onSecondary)
            }

        }
    }

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem{
    return this.find { it.type == type }?: throw IllegalArgumentException()
}



@Composable
private fun IconWithText(
    text: String,
    iconResId: ImageVector,
    colorIcon: Color,
    onItemClickListener: ()-> Unit

) {
    Row(modifier = Modifier.clickable {onItemClickListener()}) {
        Icon(imageVector = iconResId, contentDescription = "", tint = colorIcon)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = text, color = MaterialTheme.colorScheme.onSecondary)
    }

}


@Composable
fun HeaderPost(
    feedPost: FeedPost
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(70.dp), painter = painterResource(id = feedPost.avatarPublick
            ), contentDescription = ""
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(Modifier.weight(1f)) {
            Text(text = feedPost.namePublick, color = MaterialTheme.colorScheme.onPrimary)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = feedPost.dateFeed, color = MaterialTheme.colorScheme.onSecondary)

        }

        Icon(
            imageVector = Icons.Outlined.MoreVert,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSecondary
        )

    }
}


