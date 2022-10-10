package com.hamid.laundry.base

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.hamid.laundry.utils.autoCleared
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<B : ViewBinding, VM : ViewModel> : Fragment() {

    protected var binding: B by autoCleared()

    //    protected val viewModel: VM by lazy { ViewModelProvider(this).get(getViewModelClass()) }
    protected abstract val viewModel: VM

     var PERMISSION_REQUEST_CODE = 100;

    abstract fun setBinding(layoutInflater: LayoutInflater, container: ViewGroup?): B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = setBinding(layoutInflater, container)
        activity?.let {
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu()
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showSnackBar(message: String?) {
        Snackbar.make(binding.root, message.toString(), Snackbar.LENGTH_LONG).show()
    }




}