package com.adgvcxz.rxtheme

import android.view.View
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject


/**
 * zhaowei
 * Created by zhaowei on 2017/7/10.
 */

class BaseThemeManager<T : BaseTheme>(initTheme: T) {

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
}