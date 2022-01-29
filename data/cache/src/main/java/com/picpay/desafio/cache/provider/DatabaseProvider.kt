package com.picpay.desafio.cache.provider

import android.content.Context
import androidx.room.Room
import com.picpay.desafio.cache.database.ContactDatabase

/**
 * Provider used to provide a instance of the database.
 *
 * @param context the application context
 */
internal class DatabaseProvider(private val context: Context) {

    internal val database: ContactDatabase = buildDatabase()

    private fun buildDatabase(): ContactDatabase =
        Room.databaseBuilder(context, ContactDatabase::class.java, "contact_database")
            .fallbackToDestructiveMigration()
            .build()
}
