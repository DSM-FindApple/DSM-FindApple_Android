package com.findapple.findapple.app.features.chat.dialog

import android.os.Bundle
import android.view.View
import com.findapple.findapple.R
import com.findapple.findapple.app.base.BaseDialog
import com.findapple.findapple.app.features.chat.detail.ChatDetailFragment
import com.findapple.findapple.app.features.chat.detail.viewmodel.ChatDetailViewModel
import com.findapple.findapple.databinding.DialogTimePickerBinding
import java.time.LocalDateTime

class TimePickerDialog(
    private val chatDetailViewModel: ChatDetailViewModel,
    private val chatDetailFragment: ChatDetailFragment
) : BaseDialog<DialogTimePickerBinding>(R.layout.dialog_time_picker) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentTime = LocalDateTime.now()
        binding.run {
            dpTimeNp.run {
                maxValue = 23
                minValue = 0
                value = currentTime.hour
            }

            dpMinuteNp.run {
                maxValue = 59
                minValue = 0
                value = currentTime.minute
            }

            dpCompleteTv.setOnClickListener {
                val date = chatDetailViewModel.selectedDateTime.value
                chatDetailViewModel.selectedDateTime.value =
                    date + "T${String.format("%02d", dpTimeNp.value)}:${
                        String.format(
                            "%02d",
                            dpMinuteNp.value
                        )
                    }"
                chatDetailFragment.finishSelectDate(
                    chatDetailFragment.chatRoomId,
                    chatDetailViewModel.selectedDateTime.value ?: "",
                    chatDetailFragment.targetId
                )
                dismiss()
            }

            dpCancelTv.setOnClickListener {
                dismiss()
            }
        }
    }
}