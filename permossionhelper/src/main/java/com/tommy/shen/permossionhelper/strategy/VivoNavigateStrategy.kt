package com.tommy.shen.permossionhelper.strategy

import android.content.Context
import com.tommy.shen.permossionhelper.R

class VivoNavigateStrategy(context: Context) : NavigateStrategy(context) {

    companion object {
        val autoStartStrategy: List<Pair<String, String>> = listOf(
            Pair("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager"),
            Pair(
                "com.vivo.permissionmanager",
                "com.vivo.permissionmanager.activity.PurviewTabActivity"
            )
        )
        val powerSavingStrategy: List<Pair<String, String>> = listOf(
            Pair(
                "com.vivo.abe",
                "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"
            )
        )
        val permissionManagerStrategy: List<Pair<String, String>> = listOf(
            Pair("com.iqoo.secure", "com.iqoo.secure.MainActivity")
        )
    }

    override fun autoStartStrategy(): List<Pair<String, String>> = autoStartStrategy

    override fun powerSavingStrategy(): List<Pair<String, String>> = powerSavingStrategy

    override fun permissionManagerStrategy(): List<Pair<String, String>> = permissionManagerStrategy

    override fun autoStartTipId(): Int = R.string.auto_start_tip_vivo

    override fun sleepTipId(): Int = R.string.sleep_tip_vivo
}