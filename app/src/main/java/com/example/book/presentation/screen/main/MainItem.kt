package com.example.book.presentation.screen.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.book.R
import com.example.domain.model.bookModel
import com.skydoves.landscapist.glide.GlideImage
import java.net.URLEncoder
import kotlin.text.Charsets.UTF_8


@Composable
fun Mainitem(navController: NavController, item : bookModel){

    itemView(item = item,modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(10.dp).clickable {
            val link = URLEncoder.encode(item.link, UTF_8.toString())
            navController.navigate("detail_screen/$link")
        }
    )
}



@Composable
fun itemView(
    item : bookModel,
    modifier: Modifier
){
    Card (
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        border = BorderStroke(1.dp,MaterialTheme.colorScheme.primary),
        colors = CardDefaults.cardColors(colorResource(id = R.color.white))
    ){
        Row{
            GlideImage(
                imageModel = item.image,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(8.dp)
                    .size(84.dp)
                    .clip(RoundedCornerShape(CornerSize(16.dp)))
            )

            Column (
                modifier = Modifier.padding(8.dp)
            ){
                Row {
                    Text(text = stringResource(id = R.string.main_List_item_1))
                    Text(text = item.title, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }

                Row {
                    Text(text = stringResource(id = R.string.main_List_item_2))
                    Text(text = item.author, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }

                Row {
                    Text(text = stringResource(id = R.string.main_List_item_3))
                    Text(text = item.publisher, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }

                Row {
                    Text(text = stringResource(id = R.string.main_List_item_4))
                    Text(text = item.discount, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
            }
        }
    }
}



class provider : PreviewParameterProvider<bookModel> {
    override val values = sequenceOf(bookModel(
        title = "테스트1",
        link = "https://search.shopping.naver.com/book/catalog/32466680473",
        image = "https://shopping-phinf.pstatic.net/main_3246668/32466680473.20230926085113.jpg",
        author = "아무개",
        discount = "13000",
        publisher = "테스트 출판사",
        pubdate = "20240101",
        isbn = "9788984314238",
        description = "11"
    ))
}

