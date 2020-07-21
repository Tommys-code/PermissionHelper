package com.tommy.shen.permossionhelper.strategy

import android.content.Context
import com.tommy.shen.permossionhelper.R

class MeizuNavigateStrategy(context: Context) : NavigateStrategy(context) {

    companion object {
        val autoStartStrategy: List<Pair<String, String>> = listOf(
            Pair("com.meizu.safe", ".permission.SmartBGActivity"),
            Pair("com.meizu.safe", ".permission.PermissionMainActivity"),
            Pair("com.meizu.safe", ".security.HomeActivity")
        )
        val powerSavingStrategy: List<Pair<String, String>> = listOf(
            Pair("com.meizu.safe", ".powerui.PowerAppPermissionActivity")
        )
        val permissionManagerStrategy: List<Pair<String, String>> = listOf(
            Pair("com.meizu.safe", ".permission.AppPermissionActivity"),
            Pair("com.meizu.safe", ".permission.PermissionMainActivity"),
            Pair("com.meizu.safe", ".SecurityMainActivity")
        )
    }

    override fun autoStartStrategy(): List<Pair<String, String>> = autoStartStrategy

    override fun powerSavingStrategy(): List<Pair<String, String>> = powerSavingStrategy

    override fun permissionManagerStrategy(): List<Pair<String, String>> = permissionManagerStrategy

    override fun autoStartTipId(): Int = R.string.auto_start_tip_meizu

    override fun sleepTipId(): Int = R.string.sleep_tip_meizu
}