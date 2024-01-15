package com.example.icb0007_uf1_pr01_miguelnunezramon1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [ContactEntity::class],
    version = 2
)

abstract class AppDataBase: RoomDatabase() {
    abstract fun ContactDAO(): ContactDAO

    companion object{
        private var INSTANCE: AppDataBase? = null

        //@OptIn(InternalCoroutinesApi::class) Esto en los vídeos no sale, por lo tanto he escogido otro tipo de synchronized, aunque en los videos no sale kotlin.synchronized...
        fun getInstance(context: Context): AppDataBase? {
            if (INSTANCE == null){
                kotlin.synchronized(AppDataBase::class){ // Que es eso de kotlin.synchronized?
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java, "contacts.db"
                    ).fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }

}