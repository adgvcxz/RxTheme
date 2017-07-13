package com.adgvcxz.rxtheme.sample

import com.adgvcxz.rxtheme.BaseThemeManager

/**
 * zhaowei
 * Created by zhaowei on 2017/7/13.
 */
class ThemeManager : BaseThemeManager<SimpleTheme>(dayTheme) {
    private object Holder {
        val Instance = ThemeManager()
    }

    companion object {
        val instance: ThemeManager by lazy {
            Holder.Instance
        }
    }
}