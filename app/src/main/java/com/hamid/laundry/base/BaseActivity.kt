package com.hamid.laundry.base

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.hamid.laundry.R
import com.hamid.laundry.utils.*
import java.util.*


abstract class BaseActivity<B : ViewBinding, VM : ViewModel> : AppCompatActivity() {

    protected lateinit var binding: B

//    protected val viewModel: VM by lazy { ViewModelProvider(this).get(getViewModelClass()) }
    protected abstract val viewModel: VM

    var restart = false

  /*  abstract fun sharePref() :SharedPreferenceManager*/


    lateinit var loadingDialog: LoadingDialog
    abstract fun setBinding(layoutInflater: LayoutInflater): B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setBinding(layoutInflater)
        setContentView(binding.root)
        loadingDialog= LoadingDialog(this, R.style.DialogLoadingTheme)
    }

    fun showLoader(){
       loadingDialog.showLocal()
    }

    fun hideLoader(){
       loadingDialog.hideLocal()
    }



  private fun updateResources(context: Context, language: String) : Locale {
        try {
            Configuration(context.resources.configuration).run {
                Locale.setDefault(Locale(language).also { locale ->
                    return locale
                })
            }
        }catch (e: Exception){
            Log.e("BaseActivity", e.printStackTrace().toString())
            return Locale.US
        }
    }


    override fun onResume() {
        super.onResume()
        if (restart){
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }
    }
    fun showSnackBar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }



    override fun onDestroy() {
        super.onDestroy()
    }
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, Locale.getDefault().language));
    }



}