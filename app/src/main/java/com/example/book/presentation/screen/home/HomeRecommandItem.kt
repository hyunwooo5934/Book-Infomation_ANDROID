package com.example.book.presentation.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.book.R

@Composable
fun HomeRecommandItem(title : String){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ){
        Column(
            modifier = Modifier.padding(vertical = 10.dp)
        ){
            Box (
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
                    .background(Color.Blue)

            ){
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    )
            }

            Text(text = "테스트 제작", modifier = Modifier.padding(start = 5.dp))
            Text(text = "4.5", modifier = Modifier.padding(start = 5.dp))
        }
    }

}