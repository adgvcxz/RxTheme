package com.adgvcxz.rxtheme

import android.view.View
import io.reactivex.Observable
import io.reactivex.functions.Consumer

/**
 * zhaowei
 * Created by zhaowei on 2017/7/10.
 */

fun View.background(): Consumer<Int> {
    return Consumer { this.setBackgroundColor(it) }
}

fun themeBackground(): Consumer<Pair<Array<out View>, Int>> {
    return Consumer {
        it.first.forEach { view -> view.setBackgroundColor(it.second) }
    }
}

fun <T> Observable<T>.toThemeObservable(views: Array<out View>): Observable<Pair<Array<out View>, T>> {
    return this.distinctUntilChanged()
            .map { views.to(it) }
}