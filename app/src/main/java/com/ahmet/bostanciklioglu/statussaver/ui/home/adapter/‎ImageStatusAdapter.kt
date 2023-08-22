package com.ahmet.bostanciklioglu.statussaver.ui.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmet.bostanciklioglu.statussaver.data.models.StatusDto
import com.ahmet.bostanciklioglu.statussaver.ui.common.OnItemClick
import com.ahmet.bostanciklioglu.statussaver.ui.home.viewHolder.ImageStatusViewHolder

class ImageStatusAdapter(
    private var imageStatusList: List<StatusDto>,
    private val onItemClick: OnItemClick,
    private val isPhotoImage: Boolean = false,
) :
    RecyclerView.Adapter<ImageStatusViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageStatusViewHolder {
        return ImageStatusViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return imageStatusList.size
    }

    override fun onBindViewHolder(holder: ImageStatusViewHolder, position: Int) {
        holder.bind(imageStatusList[position], onItemClick, isPhotoImage)
    }

    fun submitList(newList: List<StatusDto>) {
        imageStatusList = newList
        notifyDataSetChanged()
    }
}