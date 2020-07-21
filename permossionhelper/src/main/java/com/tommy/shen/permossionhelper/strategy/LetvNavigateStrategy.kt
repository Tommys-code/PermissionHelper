package com.tommy.shen.permossionhelper.strategy

import android.content.Context
import com.tommy.shen.permossionhelper.R

class LetvNavigateStrategy(context: Context) : NavigateStrategy(context) {

    companion object {
        val autoStartStrategy: List<Pair<String, String>> = listOf(
            Pair("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")
        )
        val powerSavingStrategy: List<Pair<String, String>> = listOf(
            Pair(
                "com.letv.android.letvsafe",
                "com.letv.android.letvsafe.BackgroundAppManageActivity"
            )
        )
        val permissionManagerStrategy: List<Pair<String, String>> = emptyList()
    }

    override fun autoStartStrategy(): List<Pair<String, String>> = autoStartStrategy

    override fun powerSavingStrategy(): List<Pair<String, String>> = powerSavingStrategy

    override fun permissionManagerStrategy(): List<Pair<String, String>> = permissionManagerStrategy

    override fun autoStartTipId(): Int = R.string.auto_start_tip_letv

    override fun sleepTipId(): Int = R.string.sleep_tip_letv
}