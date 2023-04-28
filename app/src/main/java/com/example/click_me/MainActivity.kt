package com.example.click_me

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.click_me.viewModels.MainViewModel
import com.example.click_me.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
//    fun loading(isLoading:Boolean){
//        if (isLoading){
//            binding.progressBarLayout.visibility = View.VISIBLE
//        }else{
//            binding.progressBarLayout.visibility = View.GONE
//        }
//    }

}