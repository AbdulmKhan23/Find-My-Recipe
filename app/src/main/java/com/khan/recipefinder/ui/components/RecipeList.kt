package com.khan.recipefinder.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.khan.recipefinder.data.model.Meal
import java.lang.reflect.Modifier


@Composable
fun RecipeList(recipes: List<Meal>){
    LazyColumn(
        modifier = androidx.compose.ui.Modifier.fillMaxSize().background(Color.White)
    ) {
        items(recipes) {
            RecipeListItem(it)
        }


    }

}