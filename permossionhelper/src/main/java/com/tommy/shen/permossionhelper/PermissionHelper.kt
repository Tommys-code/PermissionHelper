package com.tommy.shen.permossionhelper

import android.content.Context
import android.os.Build
import android.os.PowerManager
import com.tommy.shen.permossionhelper.util.ManufacturerType
import com.tommy.shen.permossionhelper.util.getManufacturerType
import com.tommy.shen.permossionhelper.strategy.*

class PermissionHelper private constructor(private val context: Context) {

    private var navigateStrategy: NavigateStrategy

    init {
        type = getManufacturerType()
        navigateStrategy = getNavigateStrategy(context, type)
    }

    companion object {
        private lateinit var type: ManufacturerType

        @Volatile
        private var instance: PermissionHelper? = null

        fun getInstance(context: Context): PermissionHelper {
            if (instance == null) {
                synchronized(PermissionHelper::class.java) {
                    if (instance == null) {
                        instance = PermissionHelper(context.applicationContext)
                    }
                }
            }
            return instance!!
        }

        fun getNavigateStrategy(context: Context, type: ManufacturerType): NavigateStrategy {
            return when (type) {
                ManufacturerType.HUAWEI -> HuaweiNavigateStrategy(context)
                ManufacturerType.COOLPAD -> CoolpadNavigateStrategy(context)
                ManufacturerType.LENOVO -> LenovoNavigateStrategy(context)
                ManufacturerType.LETV -> LetvNavigateStrategy(context)
                ManufacturerType.MEIZU -> MeizuNavigateStrategy(context)
                ManufacturerType.OPPO -> OppoNavigateStrategy(context)
                ManufacturerType.SAMSUNG -> SamsungNavigateStrategy(context)
                ManufacturerType.SMARTISAN -> SmartisanNavigateStrategy(context)
                ManufacturerType.VIVO -> VivoNavigateStrategy(context)
                ManufacturerType.XIAOMI -> XiaomiNavigateStrategy(context)
                ManufacturerType.ZTE -> ZteNavigateStrategy(context)
                else -> DefaultStrategy(context)
            }
        }
    }

    //打开自启动
    fun openAutoStartSettings(): Boolean {
        return this.navigateStrategy.openAutoStartSettings()
    }

    //打开设置页面
    fun openSettingAct(): Boolean {
        return this.navigateStrategy.openSettingAct()
    }

    //打开电池管理
    fun openPowerSavingSettings(): Boolean {
        return this.navigateStrategy.openPowerSavingSettings()
    }

    //自启动提示
    fun autoStartTip(): String {
        return this.navigateStrategy.autoStartTip()
    }

    //电池管理提示
    fun sleepTip(): String {
        return this.navigateStrategy.sleepTip()
    }

    //是否能跳转
    fun canOpenAct(): Boolean {
        return this.navigateStrategy.hasPackage()
    }

    fun hasAutoStartPackage(): Boolean {
        return this.navigateStrategy.hasAutoStartPackage()
    }

    fun hasPowerSavingPackage(): Boolean {
        return this.navigateStrategy.hasPowerSavingPackage()
    }

    fun isPowerSaveMode(): Boolean {
        val powerManager = this.context.getSystemService(Context.POWER_SERVICE) as PowerManager
        return powerManager.isPowerSaveMode
    }

    fun isIgnoringBatteryOptimizations(context: Context): Boolean {
        //应用是否在 白名单中
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val packageManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
            return packageManager.isIgnoringBatteryOptimizations(context.packageName)
        }
        return true
    }

}