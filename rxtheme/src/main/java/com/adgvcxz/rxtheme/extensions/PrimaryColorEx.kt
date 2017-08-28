package com.adgvcxz.rxtheme.extensions

import android.os.Build
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.widget.EdgeEffect
import android.widget.ScrollView

/**
 * zhaowei
 * Created by zhaowei on 2017/8/2.
 */
fun RecyclerView.setPrimaryColor(color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        try {
            val clazz = RecyclerView::class.java
            for (name in arrayOf("ensureTopGlow", "ensureBottomGlow")) {
                val method = clazz.getDeclaredMethod(name)
                method.isAccessible = true
                method.invoke(this)
            }
            for (name in arrayOf("mTopGlow", "mBottomGlow")) {
                val field = clazz.getDeclaredField(name)
                field.isAccessible = true
                val edge = field.get(this) // android.support.v4.widget.EdgeEffectCompat
                val fEdgeEffect = edge.javaClass.getDeclaredField("mEdgeEffect")
                fEdgeEffect.isAccessible = true
                (fEdgeEffect.get(edge) as EdgeEffect).color = color
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun ScrollView.setPrimaryColor(color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val edgeEffectTop = EdgeEffect(this.context)
        edgeEffectTop.color = color

        val edgeEffectBottom = EdgeEffect(this.context)
        edgeEffectBottom.color = color

        try {
            val f1 = ScrollView::class.java.getDeclaredField("mEdgeGlowTop")
            f1.isAccessible = true
            f1.set(this, edgeEffectTop)

            val f2 = ScrollView::class.java.getDeclaredField("mEdgeGlowBottom")
            f2.isAccessible = true
            f2.set(this, edgeEffectBottom)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun ViewPager.setPrimaryColor(color: Int) {
    try {
        val clazz = ViewPager::class.java
        for (name in arrayOf("mLeftEdge", "mRightEdge")) {
            val field = clazz.getDeclaredField(name)
            field.isAccessible = true
            val edge = field.get(this)
            val fEdgeEffect = edge.javaClass.getDeclaredField("mEdgeEffect")
            fEdgeEffect.isAccessible = true
            (fEdgeEffect.get(edge) as EdgeEffect).color = color
        }
    } catch (ignored: Exception) {
    }
}