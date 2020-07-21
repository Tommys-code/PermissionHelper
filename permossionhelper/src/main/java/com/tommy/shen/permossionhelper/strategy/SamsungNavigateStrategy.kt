package com.tommy.shen.permossionhelper.strategy

import android.content.Context
import com.tommy.shen.permossionhelper.R

class SamsungNavigateStrategy(context: Context) : NavigateStrategy(context) {

    companion object {
        val autoStartStrategy: List<Pair<String, String>> = listOf(
            Pair(
                "com.samsung.android.sm_cn",
                "com.samsung.android.sm.ui.cstyleboard.SmartManagerDashBoardActivity"
            ),
            Pair(
                "com.samsung.android.sm_cn",
                "com.samsung.android.sm.ui.appmanagement.AppManagementActivity"
            ),
            Pair(
                "com.samsung.android.sm_cn",
                "com.samsung.android.sm.ui.ram.AutoRunActivity"
            ),
            Pair(
                "com.samsung.android.sm",
                "com.samsung.android.sm.app.dashboard.SmartManagerDashBoardActivity"
            )
        )
        val powerSavingStrategy: List<Pair<String, String>> = listOf(
            Pair(
                "com.samsung.android.sm_cn",
                "com.samsung.android.sm.battery.ui.BatteryActivity"
            ),
            Pair(
                "com.samsung.android.sm_cn",
                "com.samsung.android.sm.ui.battery.AppSleepListActivity_dim"
            ),
            Pair(
                "com.samsung.android.sm_cn",
                "com.samsung.android.sm.ui.battery.BatteryActivity"
            ),
            Pair(
                "com.samsung.android.lool",
                "com.samsung.android.sm.ui.battery.AppSleepListActivity"
            ),
            Pair(
                "com.samsung.android.lool",
                "com.samsung.android.sm.ui.battery.BatteryActivity"
            )
        )
        val permissionManagerStrategy: List<Pair<String, String>> = emptyList()
    }

    override fun autoStartStrategy(): List<Pair<String, String>> = autoStartStrategy

    override fun powerSavingStrategy(): List<Pair<String, String>> = powerSavingStrategy

    override fun permissionManagerStrategy(): List<Pair<String, String>> = permissionManagerStrategy

    override fun autoStartTipId(): Int = R.string.auto_start_tip_samsung_cn

    override fun sleepTipId(): Int = R.string.sleep_tip_samsung_cn
}