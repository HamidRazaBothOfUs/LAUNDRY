package com.hamid.laundry.ui.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.hamid.laundry.base.BaseActivity
import com.hamid.laundry.databinding.ActivityMainBinding
import com.hamid.laundry.utils.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainVM>(), MainContracts {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    @Inject
    lateinit var sharedPreferenceManager: SharedPreferenceManager

    
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        viewModel.viewInteractor = this
        viewModel.setData()
    }

    override val viewModel: MainVM by viewModels()

    @Override
    override fun setBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initiate() {
        binding.navigation.itemIconTintList = null

    }

    override fun showLoading() {
        showLoader()
    }

    override fun hideLoading() {
        hideLoader()
    }

}