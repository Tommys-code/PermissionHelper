package com.tommy.shen.permossionhelper.strategy

import android.content.Context
import com.tommy.shen.permossionhelper.R

class ZteNavigateStrategy(context: Context) : NavigateStrategy(context) {

    companion object {
        val autoStartStrategy: List<Pair<String, String>> = listOf(
            Pair("com.zte.powersavemode", "com.zte.powersavemode.autorun.AppAutoRunManager")
        )
        val powerSavingStrategy: List<Pair<String, String>> = emptyList()
        val permissionManagerStrategy: List<Pair<String, String>> = emptyList()
    }

    override fun autoStartStrategy(): List<Pair<String, String>> = autoStartStrategy

    override fun powerSavingStrategy(): List<Pair<String, String>> = powerSavingStrategy

    override fun permissionManagerStrategy(): List<Pair<String, String>> = permissionManagerStrategy

    override fun autoStartTipId(): Int = R.string.auto_start_tip_zte

}