package com.findapple.presentation.base

import androidx.databinding.ViewDataBinding

abstract class BackPressFinishFragment<T : ViewDataBinding>(layoutId: Int) :
    BaseFragment<T>(layoutId) {

}