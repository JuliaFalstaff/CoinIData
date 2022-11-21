package com.jfalstaff.currencycryptoapp.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CoinInfoDbModel::class], version = 6, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {

        private var instance: AppDatabase? = null
        private const val DB_NAME = "crypto.db"
        private val LOCK = Any()

        fun getInstance(application: Application): AppDatabase {
            instance?.let {
                return it
            }
            synchronized(LOCK) {
                instance?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                instance = db
                return db
            }
        }
    }

    abstract fun coinPriceInfoDao(): CoinInfoDao
}