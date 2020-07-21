package com.tommy.shen.permossionhelper.strategy

import android.content.Context
import com.tommy.shen.permossionhelper.R

class OppoNavigateStrategy(context: Context) : NavigateStrategy(context) {

    companion object {
        val autoStartStrategy: List<Pair<String, String>> = listOf(
            Pair(
                "com.color.safecenter",
                "com.color.safecenter.permission.startup.StartupAppListActivity"
            ),
            Pair(
                "com.coloros.safecenter",
                "com.coloros.safecenter.permission.startup.StartupAppListActivity"
            ),
            Pair(
                "com.coloros.safecenter",
                "com.coloros.safecenter.permission.startupapp.StartupAppListActivity"
            ),
            Pair(
                "com.coloros.safecenter",
                "com.coloros.safecenter.startupapp.StartupAppListActivity"
            ),
            Pair(
                "com.coloros.safecenter",
                "com.coloros.privacypermissionsentry.PermissionTopActivity"
            ),
            Pair(
                "com.coloros.safecenter",
                "com.coloros.safecenter.newrequest.SecurityScanActivity"
            )
        )
        val powerSavingStrategy: List<Pair<String, String>> = listOf(
            Pair(
                "com.coloros.oppoguardelf",
                "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity"
            ),
            Pair(
                "com.coloros.oppoguardelf",
                "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity"
            ),
            Pair("com.coloros.oppoguardelf", "com.coloros.oppoguardelf.MonitoredPkgActivity")
        )
        val permissionManagerStrategy: List<Pair<String, String>> = listOf(
            Pair(
                "com.coloros.securitypermission",
                "com.coloros.securitypermission.permission.singlepage.PermissionTabActivity"
            ),
            Pair(
                "com.coloros.safecenter",
                "com.coloros.safecenter.permission.singlepage.PermissionSinglePageActivity"
            )
        )
    }

    override fun autoStartStrategy(): List<Pair<String, String>> = autoStartStrategy

    override fun powerSavingStrategy(): List<Pair<String, String>> = powerSavingStrategy

    override fun permissionManagerStrategy(): List<Pair<String, String>> = permissionManagerStrategy

    override fun autoStartTipId(): Int = R.string.auto_start_tip_oppo

    override fun sleepTipId(): Int = R.string.auto_start_tip_oppo
}