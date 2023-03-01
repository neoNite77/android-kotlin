package com.android.cecs453.mortgagecalculator

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
class Prefs (context1: Context) {
    private var context: Context? = context1
    private var amount:Float=200000.0f
    private var years: Int =15
    private var rate: Float =0.035f
    fun setPreferences(mort: Mortgage) {
        var s: SharedPreferences? =
            context!!.getSharedPreferences("Mortgage", Context.MODE_PRIVATE)
        var editor = s?.edit()
        if (editor != null) {
            editor.putFloat(Mortgage.PREFERENCE_AMOUNT, mort.getAmount())
        }
        if (editor != null) {
            editor.putInt(Mortgage.PREFERENCE_YEARS, mort.getYears())
        }
//        if (editor != null) {
//            editor.putFloat(Mortgage.PREFERENCE_RATE, mort.getRate())
//        }
        editor?.putFloat(Mortgage.PREFERENCE_RATE, mort.getRate())
        editor?.commit()
    }
    fun getPreferences(mort: Mortgage)
    {
        var s: SharedPreferences? =  PreferenceManager.getDefaultSharedPreferences(context)
        //var s: SharedPreferences? =
        if (s != null) {
            mort.setYears(s.getInt(Mortgage.PREFERENCE_YEARS, 30))
            mort.setAmount(s.getFloat(Mortgage.PREFERENCE_AMOUNT, 100000.0f))
            mort.setRate(s.getFloat(Mortgage.PREFERENCE_RATE, 0.035f))
        }
    }
}
