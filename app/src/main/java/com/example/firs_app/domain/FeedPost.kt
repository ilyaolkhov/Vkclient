package com.example.firs_app.domain

import com.example.firs_app.R

data class FeedPost (
    val namePublick: String = "name",
    val dateFeed: String = "15:55",
    val avatarPublick: Int = R.drawable.avatar,
    val imageFeed: Int = R.drawable.avatar,
    val conteneText: String = "Кот Шрёдингера — мысленный эксперимент, предложенный одним из создателей квантовой механики Эрвином Шрёдингером в 1935 году при обсуждении физического смысла волновой",
    var statistics: List<StatisticItem>  = listOf(
        StatisticItem(
        type = StatisticType.LIKES,
        127
        ),
        StatisticItem(
            type = StatisticType.SHARED,
            75
        ),
        StatisticItem(
            type = StatisticType.COMMENTS,
            357
        ),
        StatisticItem(
            type = StatisticType.VIEWS,
            909
        ),

    )

)

