package com.android.cecs453.mortgagecalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.cecs453.mortgagecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val pf : Prefs = Prefs(this)

    // Shared references
    val mortgage : Mortgage = Mortgage()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pf.getPreferences(mortgage)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //modifyData(binding.root)
    }

    fun modifyData( v : View? ) {
        overridePendingTransition(R.anim.slide_from_left, 0)
    }

}
