package com.example.book.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.domain.model.bestSellerModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomeRecommandItem(
    bestSeller : bestSellerModel
){
    Card (
        modifier = Modifier
            .width(100.dp)
            .wrapContentHeight()
            .padding(10.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ){
        Column(
            modifier = Modifier.padding(vertical = 10.dp)
        ){
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
            ){
                GlideImage(
                    imageModel = "https://www.bookprice.co.kr" + bestSeller.boolImgUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(84.dp)
                        .clip(RoundedCornerShape(CornerSize(16.dp)))
                )

            }

            Text(text = bestSeller.bookName, modifier = Modifier.padding(start = 5.dp),  maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(text = "4.5", modifier = Modifier.padding(start = 5.dp))
        }
    }

}