package com.hamid.laundry.utils


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