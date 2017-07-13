package com.adgvcxz.rxtheme.sample

import android.graphics.Color
import com.adgvcxz.rxtheme.BaseTheme

/**
 * zhaowei
 * Created by zhaowei on 2017/7/13.
 */
class SimpleTheme(colorPrimary: Int,
                  colorPrimaryDark: Int,
                  accentColor: Int,
                  primaryTextColor: Int,
                  secondTextColor: Int,
                  dividerColor: Int) : BaseTheme() {

    init {
        this.colorPrimary = colorPrimary
        this.colorPrimaryDark = colorPrimaryDark
        this.accentColor = accentColor
        this.primaryTextColor = primaryTextColor
        this.secondTextColor = secondTextColor
        this.dividerColor = dividerColor
    }

}

val dayTheme = SimpleTheme(
        colorPrimary = Color.parseColor("#3F51B5"),
        colorPrimaryDark = Color.parseColor("#303F9F"),
        accentColor = Color.parseColor("#FF4081"),
        primaryTextColor = Color.parseColor("#212121"),
        secondTextColor = Color.parseColor("#757575"),
        dividerColor = Color.parseColor("#BDBDBD")
)
val nightTheme = SimpleTheme(
        colorPrimary = Color.parseColor("#333333"),
        colorPrimaryDark = Color.parseColor("#303F9F"),
        accentColor = Color.parseColor("#FF4081"),
        primaryTextColor = Color.parseColor("#212121"),
        secondTextColor = Color.parseColor("#757575"),
        dividerColor = Color.parseColor("#BDBDBD")
)