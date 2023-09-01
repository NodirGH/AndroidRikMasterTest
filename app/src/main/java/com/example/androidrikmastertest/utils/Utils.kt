package com.example.androidrikmastertest

import android.view.View

fun View.visibleIf(condition: Boolean) {
    visibility = if (condition) View.VISIBLE
    else View.GONE
}