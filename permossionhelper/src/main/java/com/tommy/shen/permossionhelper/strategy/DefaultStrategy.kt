package com.tommy.shen.permossionhelper.strategy

import android.content.Context

class DefaultStrategy(context: Context) : NavigateStrategy(context) {

    override fun autoStartStrategy(): List<Pair<String, String>> = emptyList()

    override fun powerSavingStrategy(): List<Pair<String, String>> = emptyList()

    override fun permissionManagerStrategy(): List<Pair<String, String>> = emptyList()
}