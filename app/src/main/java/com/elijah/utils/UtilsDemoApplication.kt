package com.elijah.utils

import android.app.Application
import com.elijah.utilskt.LogUtil
import com.elijah.utilskt.Utils

/**
 * Describe : UtilsDemoApplication
 */
class UtilsDemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        LogUtil.setIsLog(true)
    }

}