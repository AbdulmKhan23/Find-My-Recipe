package com.khan.recipefinder.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import java.lang.reflect.Modifier

@Composable
fun ErrorComponent(message:String, onRefreshedClicked: () -> Unit){
    Column(
        modifier = androidx.compose.ui.Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Error Loading Recipe")
        Button(onClick = onRefreshedClicked){
            Text(text = "Refresh")
        }
    }
}