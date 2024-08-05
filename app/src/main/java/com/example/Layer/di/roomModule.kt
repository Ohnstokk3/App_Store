package com.example.Layer.di


import android.content.Context
import androidx.room.Room
import com.example.Layer.AppDatabase
import com.example.Layer.InventoryDatabase
import com.example.Layer.ItemDao
import com.example.Layer.ItemsRepository
import com.example.Layer.OfflineItemsRepository
import com.example.Layer.UserDao
import dagger.Binds
import dagger.Module
import dagger.Provides

import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object roomModule {

    @Provides
    fun providelayerApp(@ApplicationContext context: Context):InventoryDatabase {

       return  Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                /**
                 * Setting this option in your app's database builder means that Room
                 * permanently deletes all data from the tables in your database when it
                 * attempts to perform a migration with no defined migration path.
                 */
                .fallbackToDestructiveMigration()
                .build()


    }
    @Provides
    fun provideApp(@ApplicationContext context: Context):AppDatabase {


         return Room.databaseBuilder(context, AppDatabase::class.java, "item_database")
                /**
                 * Setting this option in your app's database builder means that Room
                 * permanently deletes all data from the tables in your database when it
                 * attempts to perform a migration with no defined migration path.
                 */
                .fallbackToDestructiveMigration()
                .build()

        }

    @Provides
    @Singleton
    fun provideDao(inventoryDatabase: InventoryDatabase):ItemDao {
        return inventoryDatabase.itemDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    }
@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindFruitRepository(impl: OfflineItemsRepository) : ItemsRepository
}






