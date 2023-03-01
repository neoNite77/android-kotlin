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

    companion object
    {
        val mortgage = Mortgage()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pf.getPrefernces(Mortgage())
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        updateView()
    }

    fun updateView() {
        binding.amount.setText(mortgage.getAmount().toString())
        binding.years.setText(mortgage.getYears().toString())
        binding.rate.setText(mortgage.getRate().toString())
        binding.payment.setText(mortgage.formattedMonthlyPayment())
        binding.total.setText(mortgage.formattedTotalPayment())
    }
    fun modifyData(view: View) {
        val myIntent = Intent(this, DataActivity::class.java)
        this.startActivity(myIntent)
        overridePendingTransition(R.anim.slide_from_left, 0);
    }
}