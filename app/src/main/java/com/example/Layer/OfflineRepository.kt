package com.example.Layer

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineItemsRepository @Inject constructor(private val itemDao: ItemDao,private val userDao: UserDao) : ItemsRepository {
    override suspend fun insertuser(user: User) =userDao.insert(user)
    override fun findUsersBornOnDate(): Flow<List<User>> = userDao.findUsersBornOnDate()
    override fun getnumber(): Flow<List<NameCount>> = itemDao.getnumber()

    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    override suspend fun updateItem(item: Item) = itemDao.update(item)
}

