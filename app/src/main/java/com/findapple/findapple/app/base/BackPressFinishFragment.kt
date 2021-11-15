package com.findapple.findapple.app.base

import androidx.databinding.ViewDataBinding

abstract class BackPressFinishFragment<T : ViewDataBinding>(layoutId: Int) :
    BaseFragment<T>(layoutId) {

}