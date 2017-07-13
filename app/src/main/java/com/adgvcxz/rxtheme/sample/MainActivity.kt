package com.adgvcxz.rxtheme.sample

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

/**
 * zhaowei
 * Created by zhaowei on 2017/7/10.
 */
class MainActivity: AppCompatActivity() {

    val disposables: CompositeDisposable by lazy { CompositeDisposable() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        disposables.add(ThemeManager.instance.colorPrimary(toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_theme, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.theme -> {
                AlertDialog.Builder(this)
                        .setTitle("Theme")
                        .setItems(arrayOf("Day", "Night")) { _ , index ->
                            if (index == 0) {
                                ThemeManager.instance.theme = dayTheme
                            } else {
                                ThemeManager.instance.theme = nightTheme
                            }
                        }.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}