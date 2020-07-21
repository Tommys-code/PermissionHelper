package com.tommy.shen.permossionhelper.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.text.TextUtils

fun hasPackage(context: Context, list: List<Pair<String, String>>): Boolean {
    for ((first) in list) {
        if (hasPackage(first, context)) {
            return true
        }
    }
    return false
}

fun openPackageAct(context: Context, list: List<Pair<String, String>>): Boolean {
    var i = 0
    while (i < list.size) {
        try {
            openPackageAct(context, list[i].first, list[i].second)
            return true
        } catch (unused: Throwable) {
            i++
        }
    }
    val hashSet: HashSet<String> = HashSet()
    for ((first) in list) {
        hashSet.add(first)
    }
    for (str in hashSet) {
        try {
            openAct(str, context)
            return true
        } catch (unused2: Throwable) {
        }
    }
    return false
}

fun hasPackage(str: String, context: Context): Boolean {
    val packageInfo: PackageInfo?
    packageInfo = try {
        context.packageManager.getPackageInfo(str, 0)
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }
    return packageInfo != null
}

fun openPackageAct(context: Context, str: String, str1: String) {
    var str2 = str1
    if (TextUtils.isEmpty(str2)) {
        openAct(str, context)
        return
    }
    if (str2[0] == '.') {
        str2 = str + str2
    }
    val intent = Intent("android.intent.action.VIEW")
    intent.setClassName(str, str2)
    if (context !is Activity) {
        intent.flags = FLAG_ACTIVITY_NEW_TASK
    }
    context.startActivity(intent)
}

fun openAct(str: String?, context: Context) {
    val launchIntentForPackage = context.packageManager.getLaunchIntentForPackage(str!!)
    if (launchIntentForPackage != null) {
        if (context !is Activity) {
            launchIntentForPackage.addFlags(FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(launchIntentForPackage)
    }
}


