package com.findapple.findapple.presentation.base

import androidx.databinding.ViewDataBinding

abstract class BackPressFinishFragment<T: ViewDataBinding>(private val layoutId: Int): BaseFragment<T>(layoutId) {

}