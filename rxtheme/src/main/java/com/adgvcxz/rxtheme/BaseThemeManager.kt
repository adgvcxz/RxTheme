package com.adgvcxz.rxtheme

import android.support.design.widget.FloatingActionButton
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.SwitchCompat
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.adgvcxz.rxtheme.extensions.setAccentColor
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject


/**
 * zhaowei
 * Created by zhaowei on 2017/7/10.
 */

open class BaseThemeManager<T : BaseTheme>(initTheme: T) {

    var theme: T = initTheme
        set(value) {
            field = value
            manager.onNext(value)
        }

    private val manager: Subject<T> by lazy {
        BehaviorSubject.create<T>().toSerialized()
    }

    fun colorPrimary(vararg views: View): Disposable {
        return manager
                .map { it.colorPrimary }
                .toThemeObservable(views)
                .subscribe(themeBackground())
    }

    fun accentColor(vararg views: View): Disposable {
        return manager.map { it.accentColor }
                .distinctUntilChanged()
                .toThemeObservable(views)
                .subscribe {
                    it.first.forEach { view ->
                        when(view) {
                            is TextView -> view.setAccentColor(it.second)
                            is ProgressBar -> view.setAccentColor(it.second)
                            is FloatingActionButton -> view.setAccentColor(it.second)
                            is SwipeRefreshLayout -> view.setAccentColor(it.second)
                            is SwitchCompat -> view.setAccentColor(it.second)
                        }
                    }
                }
    }
}