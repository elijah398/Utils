package com.elijah.utils

import android.os.Build
import android.os.Bundle
import android.os.Looper
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.elijah.utils.databinding.ActivityMainBinding
import com.elijah.utilskt.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnLog.setOnClickListener {
            LogUtil.d(getString(R.string.large_text))
        }

        val set = HashSet<String>()
        val array = arrayListOf("1", "2", "3")
        for (i in array.indices) {
            println(array[i])
            set.add("-----" + array[i])
        }

        mBinding.btnStrSet.setOnClickListener {
            SpUtil.setStringSet("testStringSet", set)
        }

        mBinding.btnStrSet2.setOnClickListener {
            val stringSet = SpUtil.getStringSet("testStringSet")
            LogUtil.i(stringSet.toString())
        }

        mBinding.btnDisplay.setOnClickListener {
            LogUtil.i("" + DisplayUtil.getStatusBarHeight() + "---" + DisplayUtil.getScreenHeight())
            LogUtil.i("" + DisplayUtil.getActionBarHeight() + "---" + DisplayUtil.getNavBarHeight())
        }

        mBinding.btnSim.setOnClickListener {
            ToastUtil.show(if (Utils.hasSim()) "有sim卡" else "无sim卡")
        }

        mBinding.btnThread.setOnClickListener {
            LogUtil.d("" + mainLooper.isCurrentThread)
            LogUtil.d("" + Looper.myLooper()!!.isCurrentThread)
            val b = mainLooper == Looper.myLooper()
            LogUtil.d("" + b)
            thread {
                ToastUtil.show("213")
            }
        }
    }
}
