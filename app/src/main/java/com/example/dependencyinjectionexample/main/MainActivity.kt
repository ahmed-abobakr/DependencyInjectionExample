package com.example.dependencyinjectionexample.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dependencyinjectionexample.R
import com.example.dependencyinjectionexample.news_list.views.NewsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.anchor, NewsListFragment())
                .commit();
        }
    }
}