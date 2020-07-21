package com.tommy.shen.permossionhelper.util

import android.os.Build
import java.util.*

fun getManufacturerType(): ManufacturerType {
    return when (Build.BRAND.toLowerCase(Locale.ROOT)) {
        "huawei", "honor" -> ManufacturerType.HUAWEI
        "vivo" -> ManufacturerType.VIVO
        "oppo" -> ManufacturerType.OPPO
        "xiaomi" -> ManufacturerType.XIAOMI
        "meizu" -> ManufacturerType.MEIZU
        "samsung" -> ManufacturerType.SAMSUNG
        "smartisan" -> ManufacturerType.SMARTISAN
        "leeco","letv" -> ManufacturerType.LETV
        "lenovo" -> ManufacturerType.LENOVO
        "coolpad" -> ManufacturerType.COOLPAD
        "zte" -> ManufacturerType.ZTE
        "oneplus" -> ManufacturerType.ONEPLUS
        else -> ManufacturerType.OTHERS
    }
}
