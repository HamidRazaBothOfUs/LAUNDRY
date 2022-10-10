package com.hamid.laundry.utils

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.StyleRes
import com.hamid.laundry.R



class LoadingDialog constructor(context: Context, @StyleRes themeResId: Int) :
    Dialog(context, themeResId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)

    }


}