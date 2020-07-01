package com.example.dependencyinjectionexample.login.data.local

import android.content.ContentValues
import com.example.dependencyinjectionexample.base.DBHelper
import com.example.dependencyinjectionexample.login.data.models.User
import javax.inject.Inject

class LoginDbHelper @Inject constructor(val dbHelper: DBHelper):
    LoginLocalDS {


    override fun insertUser(user: User): Long {
        val contentValues = ContentValues()
        contentValues.put(DBHelper.USER_COLUMN_USER_NAME, user.name)
        contentValues.put(DBHelper.USER_COLUMN_USER_PASSWORD, user.password)
        contentValues.put(DBHelper.USER_COLUMN_USER_ACCESS_TOKEN, user.accessToken)
        return dbHelper.readableDatabase.insert(DBHelper.USER_TABLE_NAME, null, contentValues)
    }


}