package com.ahmet.bostanciklioglu.statussaver.ui.common

import com.ahmet.bostanciklioglu.statussaver.data.models.StatusDto

interface OnItemClick {
    fun onItemClick(statusDto: StatusDto)
}