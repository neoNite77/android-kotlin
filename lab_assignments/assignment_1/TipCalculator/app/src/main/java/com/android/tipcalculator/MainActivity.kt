package com.android.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var  tipCalc: TipCalculator
    private lateinit var calculateButton: Button
    lateinit var button: Button
    lateinit var amountBill: EditText
    lateinit var amountTip: EditText
    lateinit var amountTipView: TextView
    lateinit var amountTotalView: TextView
    var money = NumberFormat.getCurrencyInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        amountBill = findViewById(R.id.amount_bill)
        amountTip = findViewById(R.id.amount_tip_percent)
        amountTipView = findViewById(R.id.amount_tip)
        amountTotalView = findViewById(R.id.amount_total)
        calculateButton = findViewById(R.id.button_calculator)
        calculateButton.setOnClickListener { view: View ->
            calculate()
        }

    }
    fun calculate() {
        tipCalc= TipCalculator()
        val billString: String = amountBill.getText().toString()
        val tipString: String = amountTip.getText().toString()
        try {
            // convert billString and tipString to floats
            val billAmount = billString.toFloat()
            val tipPercent = tipString.toFloat()
            // update the Model
            tipCalc.bill= billAmount
            tipCalc.tip= (tipPercent * 0.01f)
            // tipCalc.bill=billAmount
            // ask Model to calculate tip and total amounts
            val tip = tipCalc.tipAmount()
            val total = tipCalc.totalAmount()
            // update the View with formatted tip and total amounts
            amountTipView.text = money.format(tip.toDouble())
            amountTotalView.text = money.format(total.toDouble())

        } catch (nfe: NumberFormatException) {
            // pop up an alert view here
        }
    }
}
