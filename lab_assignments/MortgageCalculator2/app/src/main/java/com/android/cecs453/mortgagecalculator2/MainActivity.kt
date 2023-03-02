package com.android.cecs453.mortgagecalculator2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.cecs453.mortgagecalculator2.databinding.ActivityDataBinding
import com.android.cecs453.mortgagecalculator2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val pf : Prefs = Prefs(this)
    private val mortgage = Mortgage()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    // On start, update the GUI when the page loads
    override fun onStart() {
        super.onStart()
        updateView()
    }

    // Update the text fields in the main activity based on the mortgage instance
    fun updateView() {
        pf.getPreferences(mortgage)
        binding.amount.setText(mortgage.getFormattedAmount().toString())
        binding.years.setText(mortgage.getYears().toString())
        binding.rate.setText((mortgage.getRate() * 100).toString() + "%")
        binding.payment.setText(mortgage.formattedMonthlyPayment())
        binding.total.setText(mortgage.formattedTotalPayment())
    }

    // When the user clicks on the modify data button, then transition to the data activity
    fun modifyData(view: View) {
        val myIntent = Intent(this, DataActivity::class.java)
        this.startActivity(myIntent)
        overridePendingTransition(R.anim.slide_from_left, 0);
    }
}