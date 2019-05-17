package com.example.laboroom.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.laboroom.R
import com.example.laboroom.database.entites.GithubRepo
import com.example.laboroom.database.viewmodels.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: GithubRepoViewModel
    var cont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
    }

    private fun bind(){
        viewModel = ViewModelProviders.of(this)
                   .get(GithubRepoViewModel::class.java)

        viewModel.getReposList().observe(this, Observer {
         Log.d("Repos", "-----------------------------------------------")
            for (i in 0 until it.size){
                Log.d("Repos", it[i].name)
            }
        })

        btn_action.setOnClickListener{
            viewModel.insert(GithubRepo("Repositori #" + cont))
            cont ++
        }
    }
}
