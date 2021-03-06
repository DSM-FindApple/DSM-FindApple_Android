package com.findapple.findapple.app.features.chat.dialog

import android.os.Bundle
import android.view.View
import com.findapple.findapple.R
import com.findapple.findapple.app.base.BaseDialog
import com.findapple.findapple.app.features.chat.detail.ChatDetailFragment
import com.findapple.findapple.app.features.chat.detail.viewmodel.ChatDetailViewModel
import com.findapple.findapple.app.features.chat.viewmodel.ChattingViewModel
import com.findapple.findapple.databinding.DialogDatePickerBinding
import java.time.LocalDate

class DatePickerDialog(private val chattingViewModel: ChatDetailViewModel, private val chatDetailFragment: ChatDetailFragment) : BaseDialog<DialogDatePickerBinding>(R.layout.dialog_date_picker) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentTime = LocalDate.now()
        binding.run {
            dpYearNp.run {
                maxValue = currentTime.year + 1
                minValue = currentTime.year
                value = currentTime.year
            }

            dpMonthNp.run {
                maxValue = 12
                minValue = 1
                value = currentTime.monthValue
            }

            dpDayNp.run {
                maxValue = 31
                minValue = 1
                value = currentTime.dayOfMonth
            }

            dpCompleteTv.setOnClickListener {
                dismiss()
                chattingViewModel.selectedDateTime.value = "${dpYearNp.value}-${String.format("%02d", dpMonthNp.value)}-${String.format("%02d", dpDayNp.value)}"
                chatDetailFragment.showTimePickerDialog()
            }

            dpCancelTv.setOnClickListener {
                dismiss()
            }
        }
    }
}