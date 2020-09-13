package com.marand.databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.marand.databinding.R
import com.marand.databinding.databinding.ActivityPhotoBinding
import com.marand.databinding.model.Photo
import com.marand.databinding.util.hide
import com.marand.databinding.util.show
import com.marand.databinding.util.showToast
import kotlinx.android.synthetic.main.activity_photo.*

class PhotoActivity : AppCompatActivity(), PhotoListener {

    lateinit var photoBinding: ActivityPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        photoBinding = DataBindingUtil.setContentView(this, R.layout.activity_photo)
        val photoViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(PhotoViewModel::class.java)

        photoBinding.photoViewModel = photoViewModel
        photoViewModel.photoListener = this
    }

// ---------------------------------------------------------------------------------------------------------------------

    override fun onLoading() {
        progress_bar.show()
    }

    override fun onSuccess(photoResponse: LiveData<Photo>) {
        photoResponse.observe(this, Observer {
                progress_bar.hide()
                if (it != null) {
                    photoBinding.photoModel = it
                    showToast(getString(R.string.success))
                } else{
                    showToast(getString(R.string.error))
                }
            })
    }

    override fun onError(message: String) {
        progress_bar.hide()
        showToast(message)
    }
}
