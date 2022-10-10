package com.hamid.laundry.ui.dashboard.fragments.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.hamid.laundry.R
import com.hamid.laundry.base.BaseFragment
import com.hamid.laundry.databinding.FragmentHomeBinding
import com.hamid.laundry.ui.dashboard.MainVM
import com.hamid.laundry.ui.dashboard.fragments.adopter.ListRecycleAdapter
import com.hamid.laundry.ui.dashboard.fragments.model.ModelList
import com.hamid.laundry.utils.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeScreenFragment : BaseFragment<FragmentHomeBinding, MainVM>() {

    override val viewModel: MainVM by activityViewModels()

    @Inject
    lateinit var sharedPreferenceManager: SharedPreferenceManager

    override fun setBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillRecycle()
    }

    private fun fillRecycle() {
        val listRecycleAdapter= ListRecycleAdapter(R.layout.recycle_home_list,getHomeList()){}
        binding.rvHome.adapter=listRecycleAdapter

    }

    private fun getHomeList():List<ModelList> {
        val list=ArrayList<ModelList>()
        list.add(ModelList(R.drawable.order_recycle,"ORDERS"))
        list.add(ModelList(R.drawable.work_flow,"HOW IT WORKS"))
        list.add(ModelList(R.drawable.about_us,"ABOUT US"))
        list.add(ModelList(R.drawable.contact_icon,"CONTACT US"))
        return list
    }

}