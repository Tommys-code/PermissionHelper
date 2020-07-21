package com.tommy.shen.permossionhelper.strategy

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import com.tommy.shen.permossionhelper.R
import com.tommy.shen.permossionhelper.util.hasPackage
import com.tommy.shen.permossionhelper.util.openPackageAct

abstract class NavigateStrategy(private val context: Context) {

    abstract fun autoStartStrategy(): List<Pair<String, String>>//c
    abstract fun permissionManagerStrategy(): List<Pair<String, String>>//d
    abstract fun powerSavingStrategy(): List<Pair<String, String>>//e


    fun autoStartTip(): String {
        return context.getString(autoStartTipId(), getAppName())
    }

    open fun autoStartTipId() = R.string.auto_start_tip_default

    fun sleepTip(): String {
        return context.getString(sleepTipId(), getAppName())
    }

    private fun getAppName(): String = context.getString(R.string.app_name)

    open fun sleepTipId() = R.string.auto_start_tip_default

    open fun hasPackage(): Boolean {
        return hasAutoStartPackage() || hasPowerSavingPackage()
    }

    fun hasAutoStartPackage(): Boolean {
        return hasPackage(context, autoStartStrategy())
    }

    open fun hasPowerSavingPackage(): Boolean {
        return Build.VERSION.SDK_INT >= 23 || hasPackage(context, powerSavingStrategy())
    }

    private fun openDefaultSetting(): Boolean {
        return try {
            val intent = Intent("android.settings.APPLICATION_DETAILS_SETTINGS")
            intent.data = Uri.fromParts("package", context.packageName, null)
            if (context !is Activity) {
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
            true
        } catch (unused: Exception) {
            false
        }
    }

    //l
    fun openAutoStartSettings(): Boolean {
        return openPackageAct(context, autoStartStrategy())
    }

    //m
    open fun openSettingAct(): Boolean {
        if (permissionManagerStrategy().isEmpty()) {
            return openDefaultSetting()
        }
        return if (openPackageAct(context, permissionManagerStrategy())) {
            true
        } else openDefaultSetting()
    }

    //n
    open fun openPowerSavingSettings(): Boolean {
        val b: Boolean = openPackageAct(context, powerSavingStrategy())
        return if (b || Build.VERSION.SDK_INT < 23) b else openDefaultSetting()
    }

}