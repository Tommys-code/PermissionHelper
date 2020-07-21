package com.tommy.shen.demo

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.tommy.shen.demo.databinding.ActPermissionSettingBinding
import com.tommy.shen.permossionhelper.PermissionHelper

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActPermissionSettingBinding
    private val permissionHelper by lazy { PermissionHelper.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.act_permission_setting)
        binding.onClick = this

        binding.isIgnoringBatteryOptimizations =
            permissionHelper.isIgnoringBatteryOptimizations(this)

        binding.tvBackgroundTip.text = permissionHelper.autoStartTip()
        binding.tvSleepTip.text = permissionHelper.sleepTip()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRequireIgnoreBatteryOpt -> {
                if (binding.isIgnoringBatteryOptimizations == true)
                    Toast.makeText(this, "电池优化已关闭", Toast.LENGTH_SHORT).show()
                else addWhite()
            }
            R.id.btnBackground -> if (!permissionHelper.openAutoStartSettings()) openFailed()
            R.id.btnSleep -> if (!permissionHelper.openPowerSavingSettings()) openFailed()
        }
    }

    @SuppressLint("BatteryLife")
    private fun addWhite() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                val intent = Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)
                intent.data = Uri.parse("package:" + this.packageName)
                startActivityForResult(intent, 100)
            } catch (e: Exception) {
                openFailed()
                e.printStackTrace()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) binding.isIgnoringBatteryOptimizations =
            permissionHelper.isIgnoringBatteryOptimizations(this)
    }

    private fun openFailed() {
        Toast.makeText(this, R.string.rt_open_quick_settings_failed_tip, Toast.LENGTH_SHORT).show()
    }
}