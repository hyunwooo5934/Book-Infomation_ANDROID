package com.example.book.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun floatingButton(){

    var isExpanded = remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.End) {
        if (isExpanded.value) {
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(20.dp)
            ) {
                FabItem(
                    title = "세부항목2",
                    icon = Icons.Default.LocationOn,
                    onClicked = { /* ... */ }
                )
                Spacer(modifier = Modifier.height(20.dp))
                FabItem(
                    title = "세부항목1",
                    icon = Icons.Default.AddCircle,
                    onClicked = { /* ... */ }
                )
            }
        }


        Spacer(modifier = Modifier.height(15.dp))
        FloatingActionButton(
            onClick = { isExpanded.value = !isExpanded.value },
            shape = CircleShape,
            containerColor = if (isExpanded.value) Color.Red else Color.White
        ) {
            Icon(
                imageVector = if (isExpanded.value) Icons.Default.Close else Icons.Default.Add,
                contentDescription = "This is Expand Button"
            )
        }
    }


}




@Composable
fun FabItem(title: String, icon: ImageVector, onClicked: () -> Unit) {
    Row(modifier = Modifier.clickable {
        onClicked()
    }, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = "FabItem Icon"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(title)
    }
}

