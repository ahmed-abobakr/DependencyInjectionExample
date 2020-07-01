package com.example.dependencyinjectionexample.base

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class APIHelper @Inject constructor(val context: Context) {
}