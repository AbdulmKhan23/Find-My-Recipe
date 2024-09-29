package com.khan.recipefinder.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khan.recipefinder.data.network.MealApiClient
import kotlinx.coroutines.launch

class RecipeViewModel:ViewModel() {
    private val _state = mutableStateOf<RecipeViewState>(RecipeViewState.Loading)
    val state: State<RecipeViewState> = _state

    fun processIntent(intent: RecipeViewIntent) {
        when (intent) {
            is RecipeViewIntent.LoadRandomRecipe -> loadRandomRecipe()
            is RecipeViewIntent.SearchRecipes -> searchRecipes(intent.query)
        }
    }

    private fun loadRandomRecipe() {
        viewModelScope.launch {
            _state.value = RecipeViewState.Loading
            try {
                _state.value = RecipeViewState.Success(
                    MealApiClient.getRandomRecipe()
                )
            } catch (e: Exception) {
                _state.value = RecipeViewState.Error(
                    e.message ?: "Error Fetching Recipe"
                )
            }
        }
    }

    private fun searchRecipes(query: String) {
        viewModelScope.launch {
            _state.value = RecipeViewState.Loading
            try {
                _state.value = RecipeViewState.Success(
                    MealApiClient.getSearchRecipe(query)
                )
            } catch (e: Exception) {
                _state.value = RecipeViewState.Error(
                    e.message ?: "Error Fetching Recipe"
                )
            }

        }
    }
}

