package com.maraloedev.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MyLists(modifier: Modifier = Modifier, onItemClick: (String) -> Unit) {

    val names = listOf(
        "Eduardo",
        "Mario",
        "Carlos",
        "Eduardo",
        "Mario",
        "Carlos",
        "Eduardo",
        "Mario",
        "Carlos",
        "Eduardo",
        "Mario",
        "Carlos",
        "Eduardo",
        "Mario",
        "Carlos"
    )
    LazyRow {
        items(names, key = { myValue -> myValue }) { myValue ->
            Text(
                myValue, modifier = modifier
                    .padding(24.dp)
                    .clickable { onItemClick(myValue) })
        }

    }
}

@Composable
fun MyAdvancedList(modifier: Modifier = Modifier) {
    var items by remember { mutableStateOf(List(100) { "Item número $it" }) }

    LazyColumn {
        item {
            Button({
                items = items.toMutableList().apply { add(0, "Hola") }
            }) {
                Text(text = "Añadir items")
            }
        }
        itemsIndexed(items, key = { _, item -> item }) { index, item ->
            Row {
                Text(item + "indice:$index")
                Spacer(Modifier.weight(1f))
                TextButton(
                    onClick =
                        { items = items.toMutableList().apply { remove(item) } }) { Text("Borrar") }
                Spacer(Modifier.width(24.dp))
            }
        }
    }

}

@Composable
fun ScrollList(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 5 }

    }
    Box(Modifier.fillMaxSize()) {
        LazyColumn {
            items(100) {
                Text(
                    text = "Item: $it", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }

        if (showButton) {
            FloatingActionButton({
                scope.launch {
                    listState.animateScrollToItem(0)
                    //listState.scrollToItem(0) sin animaccion
                }
            }) { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
        }
    }

}