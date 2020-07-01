package com.example.dependencyinjectionexample.login.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.dependencyinjectionexample.App
import com.example.dependencyinjectionexample.main.MainActivity
import com.example.dependencyinjectionexample.R
import com.example.dependencyinjectionexample.base.APIHelper
import com.example.dependencyinjectionexample.base.DBHelper
import com.example.dependencyinjectionexample.login.data.LoginDataManagerImpl
import com.example.dependencyinjectionexample.login.data.local.LoginDbHelper
import com.example.dependencyinjectionexample.login.data.remote.LoginAPIHelper
import com.example.dependencyinjectionexample.login.di.DaggerLoginComponent
import com.example.dependencyinjectionexample.login.di.LoginModule
import com.example.dependencyinjectionexample.login.viewmodels.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerLoginComponent.builder()
            .applicationComponent((application as App).applicationComponent)
            .build().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)





        viewModel.userLiveData.observe(this, Observer { user ->
            if(user == null){
                Toast.makeText(this, "Invalid Login Credentials", Toast.LENGTH_LONG).show()
            }else {
                startActivity(Intent(this, MainActivity::class.java))
            }
        })

        loginBtn.setOnClickListener {
            viewModel.login(editUserName.text.toString(), editPassword.text.toString())
        }
    }
}