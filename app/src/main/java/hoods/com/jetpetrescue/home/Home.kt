package hoods.com.jetpetrescue.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.components.PetInfoItem
import hoods.com.jetpetrescue.components.TopBar
import hoods.com.jetpetrescue.data.DummyPetDataSource

@Composable
fun Home(onSwitchClick: () -> Unit, onPetClick: (Int) -> Unit) {
//    val scrollState = rememberScrollState()
//    val item = 1..20
//    Column(modifier = Modifier.verticalScroll(scrollState)) {
//        item.forEach {
//            Text(text = it.toString(), modifier = Modifier.padding(16.dp))
//        }
//    }
    val petList = DummyPetDataSource.dogList
    Scaffold(
        topBar = {
            TopBar {
                onSwitchClick()
            }
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            itemsIndexed(petList) { index, pet ->
                PetInfoItem(pet = pet) {
                    onPetClick(index)
                }
            }
        }
    }
}

@Preview
@Composable
fun PrevItem() {
    Home(onSwitchClick = {}){

    }
}