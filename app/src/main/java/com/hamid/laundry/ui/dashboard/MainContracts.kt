package com.hamid.laundry.ui.dashboard

import com.hamid.laundry.base.ViewInteractor


interface MainContracts : ViewInteractor {
    fun initiate()
    fun showLoading()
    fun hideLoading()
}