package com.example.Layer

import kotlinx.coroutines.flow.Flow

interface ItemsRepository {
    suspend fun insertuser(user: User)
    fun findUsersBornOnDate():Flow<List<User>>
    fun getnumber():Flow<List<NameCount>>

    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: Item)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: Item)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(item: Item)
}


