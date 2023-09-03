package com.example.wikipedia.data

data class ItemPost(
     val imgUrl: String,
     val txtTitle: String,
     val txtSubtitle: String,
     val txtDetail: String,
     //for trend fragment
     val idTrend: Boolean,
     val insight: String
)