package com.ahmet.bostanciklioglu.statussaver.ui.home.fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.ahmet.bostanciklioglu.statussaver.data.models.StatusDto
import com.ahmet.bostanciklioglu.statussaver.databinding.FragmentPhotosFragmentsBinding
import com.ahmet.bostanciklioglu.statussaver.ui.DetailScreen.activity.DetailActivity
import com.ahmet.bostanciklioglu.statussaver.ui.base.fragments.BaseFragments
import com.ahmet.bostanciklioglu.statussaver.ui.common.OnItemClick
import com.ahmet.bostanciklioglu.statussaver.ui.home.adapter.ImageStatusAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragments : BaseFragments() {
    private var _binding: FragmentPhotosFragmentsBinding? = null
    private val binding get() = _binding
    private var statusList: List<StatusDto>? = null
    private lateinit var imageStatusAdapter: ImageStatusAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPhotosFragmentsBinding.inflate(layoutInflater)
        return _binding!!.root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageStatusAdapter =
            ImageStatusAdapter(emptyList(), onItemClick) // Initialize with an empty list
        binding?.photosRecyclerView?.adapter = imageStatusAdapter
        observer()
    }

    private fun observer() {
        baseListLiveData.observe(viewLifecycleOwner) { image ->
            setUpRecyclerView(image.filter { it.fileUri.endsWith("jpg") })
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRecyclerView(value: List<StatusDto>) {
        imageStatusAdapter.submitList(value)
        imageStatusAdapter.notifyDataSetChanged()
    }

    private val onItemClick = object : OnItemClick {
        override fun onItemClick(statusDto: StatusDto) {
            DetailActivity.startDetailFragment(requireContext(), statusDto.fileUri, 1)
        }
    }
}