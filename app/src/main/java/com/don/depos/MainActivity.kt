package com.don.depos

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    companion object {
        const val MULTIPLIER = 0.8
        const val DAY_IN_YEAR = 365
        const val DAY_IN_MONTH = 30
    }

    var interestInMonth = 0.0
    var amountDeposit = 0.0
    var interestInYear = 0.0
    var ratePerYear = 0.0

    var targetInvestment = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            doCount()
        }
    }

    private fun doCount() {
        amountDeposit = etBaseInvestment.text.toString().toDouble()
        ratePerYear = etRatePerYear.text.toString().toDouble()
        targetInvestment = etInvestmentTarget.text.toString().toDouble()

        interestInMonth =
            (amountDeposit * ratePerYear / 100 * DAY_IN_MONTH * MULTIPLIER) / DAY_IN_YEAR

        interestInYear = interestInMonth * 12

        val decimalFormat = DecimalFormat("#.##")

        val totalMoney = amountDeposit + interestInYear
        Log.wtf("IIM", "$interestInMonth /Month")
        Log.wtf("IIY", "$interestInYear /Year")
        Log.wtf("TM", "$totalMoney /Year")

        if (targetInvestment != 0.0) {
            var a = 0.0
            a = (targetInvestment * 100) / (ratePerYear*100 + 100)
//            tvInitialMoney.text = "${a} / Month"
            tvInitialMoney.text = "${decimalFormat.format(a*12)}/ Tahun"
        }


        tvInterestMonth.text = interestInMonth.toString()
        tvInterestInYear.text = interestInYear.toString()


    }

}
