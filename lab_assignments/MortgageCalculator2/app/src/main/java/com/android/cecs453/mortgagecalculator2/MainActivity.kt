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

    // Create a companion object to share data between Main and Data activities.
    // it is to make the mortgage instance variable public and static
    companion object
    {
        val mortgage = Mortgage()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pf.getPrefernces(mortgage)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    // On start, update the GUI when the user changes a value
    override fun onStart() {
        super.onStart()
        updateView()
    }

    // Update the text fields in the main activity based on the mortgage instance
    fun updateView() {
        binding.amount.setText(mortgage.getAmount().toString())
        binding.years.setText(mortgage.getYears().toString())
        binding.rate.setText(mortgage.getRate().toString())
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