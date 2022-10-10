package com.hamid.laundry.ui.dashboard

import com.hamid.laundry.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM  @Inject
constructor() : BaseViewModel<MainContracts>() {
    fun setData(){
        viewInteractor?.initiate()

    }


}