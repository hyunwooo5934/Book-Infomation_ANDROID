package com.example.book.util.view.commonView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun CommonDialog(showYn : Boolean){

    val showDaiog = remember { mutableStateOf(showYn) }

    Dialog(onDismissRequest = { /*TODO*/ },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        if(showYn) {
            Surface(
                modifier = Modifier
                    .width(300.dp)
                    .wrapContentHeight(),
                shape = RoundedCornerShape(CornerSize(10.dp)),
                color = Color.White
            ) {
                Column {
                    verticalSpacer(heightSize = 12)

                    Text(
                        text = "test message",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize()
                            .padding(vertical = 8.dp),
                        fontSize =  16.sp
                    )

                    verticalSpacer(heightSize = 12)

                    Button(onClick = {  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp), shape = RoundedCornerShape(24.dp)) {
                        Text(text = "OK", fontSize = 16.sp)
                    }

                    verticalSpacer(heightSize = 12)

                }
            }
        }
    }
}

@Composable
fun DialogContent(){
    Column {
        verticalSpacer(heightSize = 12)

        Text(
            text = "test message",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .padding(vertical = 8.dp),
            fontSize =  16.sp
        )

        verticalSpacer(heightSize = 12)

        Button(onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), shape = RoundedCornerShape(24.dp)) {
            Text(text = "OK", fontSize = 16.sp)
        }

        verticalSpacer(heightSize = 12)

    }
}