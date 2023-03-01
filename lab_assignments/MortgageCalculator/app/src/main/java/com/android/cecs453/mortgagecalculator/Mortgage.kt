package com.android.cecs453.mortgagecalculator

import java.text.DecimalFormat
class Mortgage(){
    val MONEY: DecimalFormat = DecimalFormat("$#,##0.00")
    val m: MainActivity = MainActivity()
    companion object
    {
        const val PREFERENCE_AMOUNT = "amount"
        const val PREFERENCE_YEARS = "years"
        const val PREFERENCE_RATE = "rate"
        const val TAG = "MyActivity"
    }
    private var amount:Float=200000.0f
    private var years: Int =15
    private var rate: Float =0.035f

    fun Mortgage() {
    }

    fun setAmount(newAmount: Float) {
        if (newAmount >= 0) amount = newAmount
    }
    fun setYears(newYears: Int) {
        if (newYears >= 0) years = newYears
    }
    fun setRate(newRate: Float) {
        if (newRate >= 0) rate = newRate
    }
    fun getAmount(): Float {
        return amount
    }
    fun getFormattedAmount(): String? {
        return MONEY.format(amount)
    }
    fun getYears(): Int {
        return years
    }
    fun getRate(): Float {
        return rate
    }
    fun monthlyPayment(): Float {
        val mRate = rate / 12 // monthly interest rate
        val temp = Math.pow((1 / (1 + mRate)).toDouble(), (years *
                12).toDouble())
        return amount * mRate / (1 - temp).toFloat()
    }
    fun formattedMonthlyPayment(): String? {
        if(amount ==0.0f)
            return "$0.0"
        else
            return MONEY.format(monthlyPayment())
    }
    fun totalPayment(): Float {
        return monthlyPayment() * years * 12
    }
    fun formattedTotalPayment(): String? {
        if(amount ==0.0f)
            return "$0.0"
        else
            return MONEY.format(totalPayment())
    }
}