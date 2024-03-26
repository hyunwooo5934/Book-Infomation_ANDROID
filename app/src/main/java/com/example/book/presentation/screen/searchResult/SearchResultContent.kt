package com.example.book.presentation.screen.searchResult

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.navigation.NavHostController
import com.example.book.R
import com.example.domain.model.bookModel

@Composable
fun SearchResultContent(navHostController: NavHostController, dataList: List<bookModel>?, focusable: Boolean = false) {
//    if(focusable){
//        Log.e("MainContent","$focusable, SearchList")
//        SearchList(focusable)
//    } else {
//        Log.e("MainContent","$focusable, MainList")
//        MainList(dataList = dataList)
//    }

    SearchList(navHostController = navHostController, dataList = dataList)

}

@Composable
fun SearchList(
    navHostController: NavHostController,
    @PreviewParameter(dataProvider::class) dataList : List<bookModel>?) {

    Column (
        modifier = Modifier.background(colorResource(id = R.color.white)
        )
    ) {
        var listState = rememberLazyListState()
        LazyColumn(state =  listState){
            dataList?.let {
                itemsIndexed(dataList!!){ index, item ->
                    // item compose 연결
                    Mainitem(navController = navHostController, item = item)
                }
            }
        }
    }
}


//@Composable
//fun SearchList(focusable : Boolean){
//    if(focusable) {
//        Column {
//            Text(text = "검색어1")
//            Text(text = "검색어2")
//            Text(text = "검색어3")
//            Text(text = "검색어4")
//            Text(text = "검색어5")
//        }
//    }
//}


class dataProvider : PreviewParameterProvider<List<bookModel>> {
    override val values = sequenceOf(
        listOf( bookModel(
        title = "테스트1",
        link = "https://search.shopping.naver.com/book/catalog/32466680473",
        image = "https://shopping-phinf.pstatic.net/main_3246668/32466680473.20230926085113.jpg",
        author = "아무개",
        discount = "13000",
        publisher = "테스트 출판사",
        pubdate = "20240101",
        isbn = "9788984314238",
        description = "11"
    )))
}


class focusProvider : PreviewParameterProvider<Boolean> {
    override val values = sequenceOf(true)
}

