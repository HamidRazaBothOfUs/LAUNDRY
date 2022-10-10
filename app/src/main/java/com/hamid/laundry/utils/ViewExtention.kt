package com.hamid.laundry.utils

import com.google.android.material.card.MaterialCardView


fun LoadingDialog?.showLocal(){
    try {
        this?.show()
    }catch (e:Exception){
        e.printStackTrace()
    }
}
fun LoadingDialog?.hideLocal(){
    try {
        this?.dismiss()
    }catch (e:Exception){
        e.printStackTrace()
    }
}

fun MaterialCardView.setCustomBackground(color:Int){
    this.setCardBackgroundColor(color)
}