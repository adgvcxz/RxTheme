package com.adgvcxz.rxtheme.extensions

import android.R
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.support.design.widget.FloatingActionButton
import android.support.v4.graphics.ColorUtils
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.SwitchCompat
import android.widget.ProgressBar
import android.widget.TextView

/**
 * zhaowei
 * Created by zhaowei on 2017/7/23.
 */
fun FloatingActionButton.setAccentColor(color: Int) {
    backgroundTintList = ColorStateList(arrayOf(intArrayOf()), intArrayOf(color))
}

fun ProgressBar.setAccentColor(color: Int) {
    indeterminateDrawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY)
}

fun SwipeRefreshLayout.setAccentColor(color: Int) {
    setColorSchemeColors(color)
}

fun TextView.setAccentColor(color: Int) {
    setTextColor(color)
}

fun SwitchCompat.setAccentColor(color: Int) {
    val states = arrayOf(intArrayOf(R.attr.state_checked))
    val trackColors = intArrayOf(ColorUtils.setAlphaComponent(color, 80))
    DrawableCompat.setTintList(DrawableCompat.wrap(trackDrawable), ColorStateList(states, trackColors))
}