package com.khan.recipefinder.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khan.recipefinder.data.model.Meal
import java.lang.reflect.Modifier

@Composable
fun SuccessComponent(recipes: List<Meal>, onSearchClicked: (String) -> Unit){
        Column(){
            Text(
                text = "Recipe Finder",
                fontWeight = FontWeight(900),
                fontSize = 32.sp,
                fontFamily = FontFamily.Cursive,
                modifier = androidx.compose.ui.Modifier.padding(8.dp)
            )
            SearchComponent(onSearchClicked)
            RecipeList(recipes = recipes)
        }
}