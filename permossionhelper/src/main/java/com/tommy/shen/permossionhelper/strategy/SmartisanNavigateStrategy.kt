package com.tommy.shen.permossionhelper.strategy

import android.content.Context
import com.tommy.shen.permossionhelper.R

class SmartisanNavigateStrategy(context: Context) : NavigateStrategy(context) {

    companion object {
        val autoStartStrategy: List<Pair<String, String>> = listOf(
            Pair("com.smartisanos.security", "com.smartisanos.security.MainActivity"),
            Pair("com.smartisanos.security", "com.smartisanos.security.PackagesOverview")
        )
        val powerSavingStrategy: List<Pair<String, String>> = listOf(
            Pair(
                "com.android.settings",
                "com.android.settings.fuelgauge.appBatteryUseOptimization.AppBatteryUseOptimizationActivity"
            ),
            Pair(
                "com.android.settings",
                "com.android.settings.fuelgauge.appBatteryUseOptimization.BatteryUseOptimizationActivity"
            ),
            Pair(
                "com.android.settings",
                "com.android.settings.fuelgauge.PowerUsageSummaryActivity"
            )
        )
        val permissionManagerStrategy: List<Pair<String, String>> = emptyList()
    }

    override fun autoStartStrategy(): List<Pair<String, String>> = autoStartStrategy

    override fun powerSavingStrategy(): List<Pair<String, String>> = powerSavingStrategy

    override fun permissionManagerStrategy(): List<Pair<String, String>> = permissionManagerStrategy

    override fun autoStartTipId(): Int = R.string.auto_start_tip_smartisan

}