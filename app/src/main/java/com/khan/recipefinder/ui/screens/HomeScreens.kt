package com.khan.recipefinder.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import com.khan.recipefinder.ui.components.ErrorComponent
import com.khan.recipefinder.ui.components.LoadingComponent
import com.khan.recipefinder.ui.components.SuccessComponent
import com.khan.recipefinder.ui.viewmodel.RecipeViewIntent
import com.khan.recipefinder.ui.viewmodel.RecipeViewModel
import com.khan.recipefinder.ui.viewmodel.RecipeViewState

@Composable
fun HomeScreen(recipeViewModel: RecipeViewModel){
    val state by recipeViewModel.state
    when (state)
    {
        is RecipeViewState.Loading -> LoadingComponent()
        is RecipeViewState.Success ->{
            val recipes = (state as RecipeViewState.Success).recipes
            SuccessComponent(recipes=recipes, onSearchClicked = {query ->
                recipeViewModel.processIntent(RecipeViewIntent.SearchRecipes(query))
            })
        }

        is RecipeViewState.Error -> {
            val message = (state as RecipeViewState.Error).message
            ErrorComponent(message = message){
                recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
            }
        }
    }

    LaunchedEffect(Unit) {
        recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
    }
}