package com.hamid.laundry.ui.dashboard.fragments.adopter

import android.content.res.ColorStateList
import android.view.View
import com.bumptech.glide.Glide
import com.hamid.laundry.R
import com.hamid.laundry.databinding.RecycleHomeListBinding
import com.hamid.laundry.ui.dashboard.fragments.model.ModelList
import com.hamid.laundry.utils.WrapperRecyclerAdapter
import com.hamid.laundry.utils.setCustomBackground


class ListRecycleAdapter(layoutId: Int, data: List<ModelList>, callBak: (ModelList) -> Unit):
    WrapperRecyclerAdapter<ModelList, ModelList>(layoutId,data,callBak){
    override fun setDataToView(itemView: View, item: ModelList,position:Int ,itemClickListener: (ModelList) -> Unit) {
        val binding=RecycleHomeListBinding.bind(itemView)
        binding.title.setText(item.title)
        Glide.with(itemView.context).load(item.leftDrawable).into(binding.leftImage)
        val primaryColor= itemView.context.resources.getColor(R.color.colorPrimary)
        val secondaryColor= itemView.context.resources.getColor(R.color.colorPrimaryDark)
        binding.root.setOnClickListener {
            itemClickListener(item)
        }
        if (position==0){
            binding.setColors(primaryColor,secondaryColor)
            return
        }
        if (position%2==0){
            binding.setColors(primaryColor,secondaryColor)
            return
        }else{
            binding.setColors(secondaryColor,primaryColor)
            return
        }
    }
    fun RecycleHomeListBinding.setColors(primary: Int, secondary:Int){
         this.rootCard.setCustomBackground(primary)
         this.rightImage.imageTintList= ColorStateList.valueOf(primary)
         this.rightBackground.setCustomBackground(secondary)
         this.title.setTextColor(ColorStateList.valueOf(secondary))
    }
}