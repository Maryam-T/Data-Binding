package com.marand.databinding.ui

import androidx.lifecycle.LiveData
import com.marand.databinding.model.Photo

interface PhotoListener {

    fun onLoading()
    fun onSuccess(photoResponse: LiveData<Photo>)
    fun onError(message: String)
}