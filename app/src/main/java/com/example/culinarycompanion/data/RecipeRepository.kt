package com.example.culinarycompanion.data

import kotlinx.coroutines.flow.Flow

class RecipeRepository(private val dao: RecipeDao) {

    fun getAllRecipes(): Flow<List<Recipe>> =
        dao.getAll()

    fun getRecipeById(id: Long): Flow<Recipe> =
        dao.getById(id)

    fun getRecipesByCategory(category: String): Flow<List<Recipe>> =
        dao.getByCategory(category)

    suspend fun insert(recipe: Recipe) =
        dao.insert(recipe)

    suspend fun update(recipe: Recipe) =
        dao.update(recipe)

    suspend fun delete(recipe: Recipe) =
        dao.delete(recipe)

    /**
     * Returns only the recipes marked as favorite.
     */
    fun getFavorites(): Flow<List<Recipe>> =
        dao.getFavorites()

    /**
     * Toggles the favorite flag for the given recipe ID.
     */
    suspend fun setFavorite(id: Long, fav: Boolean) =
        dao.setFavorite(id, fav)
}