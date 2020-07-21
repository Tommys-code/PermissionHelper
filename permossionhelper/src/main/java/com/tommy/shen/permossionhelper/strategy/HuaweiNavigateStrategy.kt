package com.tommy.shen.permossionhelper.strategy

import android.content.Context
import com.tommy.shen.permossionhelper.R

class HuaweiNavigateStrategy(context: Context) : NavigateStrategy(context) {

    companion object {
        val autoStartStrategy: List<Pair<String, String>> = listOf(
            Pair("com.huawei.systemmanager", ".startupmgr.ui.StartupNormalAppListActivity"),
            Pair("com.huawei.systemmanager", ".optimize.bootstart.BootStartActivity"),
            Pair("com.huawei.systemmanager", ".startupmgr.ui.StartupAwakedAppListActivity"),
            Pair("com.huawei.systemmanager", ".appcontrol.activity.StartupAppControlActivity")
        )
        val powerSavingStrategy: List<Pair<String, String>> = listOf(
            Pair("com.huawei.systemmanager", ".power.ui.HwPowerManagerActivity"),
            Pair("com.huawei.systemmanager", ".optimize.process.ProtectActivity")
        )
        val permissionManagerStrategy: List<Pair<String, String>> =
            listOf(Pair("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"))
    }

    override fun autoStartStrategy(): List<Pair<String, String>> = autoStartStrategy

    override fun powerSavingStrategy(): List<Pair<String, String>> = powerSavingStrategy

    override fun permissionManagerStrategy(): List<Pair<String, String>> = permissionManagerStrategy

    override fun autoStartTipId(): Int = R.string.auto_start_tip_huawei

    override fun sleepTipId(): Int = R.string.sleep_tip_huawei
}