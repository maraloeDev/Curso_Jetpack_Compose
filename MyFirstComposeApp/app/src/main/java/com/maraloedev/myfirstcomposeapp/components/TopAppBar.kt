@file:OptIn(ExperimentalMaterial3Api::class)

package com.maraloedev.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.maraloedev.myfirstcomposeapp.R

@Composable
fun MyTopAppBar(modifier: Modifier = Modifier, onNavSelected: () -> Unit) {

    TopAppBar(
        title = { Text(text = "My App") },
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable { onNavSelected() },
                painter = painterResource(R.drawable.ic_info),
                contentDescription = null
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = null
            )
            Icon(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = null,
                tint = Color.Yellow
            )
            Icon(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = null
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.Magenta,
            actionIconContentColor = Color.Red
        )
    )

}