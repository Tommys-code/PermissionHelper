package com.tommy.shen.permossionhelper.strategy

import android.content.Context
import com.tommy.shen.permossionhelper.R

class XiaomiNavigateStrategy(context: Context) : NavigateStrategy(context) {

    companion object {
        val autoStartStrategy: List<Pair<String, String>> = listOf(
            Pair(
                "com.miui.securitycenter",
                "com.miui.permcenter.autostart.AutoStartManagementActivity"
            )
        )
        val powerSavingStrategy: List<Pair<String, String>> = listOf(
            Pair(
                "com.miui.powerkeeper",
                "com.miui.powerkeeper.ui.HiddenAppsContainerManagementActivity"
            ),
            Pair("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity")
        )
        val permissionManagerStrategy: List<Pair<String, String>> = listOf(
            Pair("com.miui.securitycenter", "com.miui.appmanager.AppManagerMainActivity"),
            Pair(
                "com.miui.securitycenter",
                "com.miui.permcenter.permissions.AppPermissionsEditorActivity"
            ),
            Pair("com.miui.securitycenter", "com.miui.securityscan.MainActivity")
        )
    }

    override fun autoStartStrategy(): List<Pair<String, String>> = autoStartStrategy

    override fun powerSavingStrategy(): List<Pair<String, String>> = powerSavingStrategy

    override fun permissionManagerStrategy(): List<Pair<String, String>> = permissionManagerStrategy

    override fun autoStartTipId(): Int = R.string.auto_start_tip_xiaomi

    override fun sleepTipId(): Int = R.string.sleep_tip_xiaomi
}