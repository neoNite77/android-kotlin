package com.android.tipcalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.android.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tipCalc= TipCalculator(0.0f,0.0f)
    var money = NumberFormat.getCurrencyInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.amountBill.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) { calculate() }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }
        })
        //YOUR CODE TO FOR THE TEXT CHANGE HANDLING EVENT FOR TIP PERCENTAGE INPUT
        binding.amountTipPercent.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                calculate()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })

    }
    fun calculate() {
        var billAmount: Float =0.0f
        var billTip: Float = 0.0f
        val  amountBill1 = binding.amountBill
        val stringBillAmount = amountBill1.text.toString()
        if (stringBillAmount.isEmpty())
            billAmount = 0.0f
        else
            billAmount = stringBillAmount.toFloat()
        tipCalc.bill=billAmount
        val amountTip1 = binding.amountTipPercent
        //YOUR CODE TO DETERMINE THE AMOUNT OF TIP, AMOUNT TOTAL AND DISPLAY
        //THEM IN THE TEXTBOX
        val stringTipAmount = amountTip1.text.toString()
        if (stringTipAmount.isEmpty())
            billTip = 0.0f
        else
            billTip = 0.01f * stringTipAmount.toFloat()
        tipCalc.tip=billTip
        //Determine the amount of tip and convert it to string
        val amountTip: String = money.format(tipCalc.tipAmount()).toString()

        //Determine the total and convert it to string
        val amountTotal: String = money.format(tipCalc.totalAmount()).toString()

        //Display the amount of tip and convert it to string
        binding.amountTip.setText(amountTip)
        binding.amountTotal.setText(amountTotal)

    }
}
