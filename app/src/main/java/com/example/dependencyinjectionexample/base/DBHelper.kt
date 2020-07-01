package com.example.dependencyinjectionexample.base

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DBHelper @Inject constructor (context: Context, dbName: String, dbVersion: Int):
    SQLiteOpenHelper(context, dbName, null, dbVersion) {

    companion object{
        const val USER_TABLE_NAME = "users"
        const val USER_COLUMN_USER_NAME = "user_name"
        const val USER_COLUMN_USER_PASSWORD = "user_password"
        const val USER_COLUMN_USER_ACCESS_TOKEN = "access_token"
    }


    override fun onCreate(db: SQLiteDatabase) {
        tableCreateStatements(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $USER_TABLE_NAME")
        onCreate(db)
    }

    private fun tableCreateStatements(db: SQLiteDatabase){
        try {
            db.execSQL(
                ("CREATE TABLE IF NOT EXISTS "
                        + USER_TABLE_NAME) + "("
                        + USER_COLUMN_USER_NAME + " VARCHAR(20), "
                        + USER_COLUMN_USER_PASSWORD + " VARCHAR(50), "
                        + USER_COLUMN_USER_ACCESS_TOKEN + " VARCHAR(50), "
            )
        } catch (e: SQLException){
            e.printStackTrace()
        }
    }
}