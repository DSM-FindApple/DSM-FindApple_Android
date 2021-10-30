package com.findapple.findapple.presentation.features.auth

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findapple.findapple.presentation.R
import com.findapple.findapple.presentation.databinding.ItemWelcomeAuthBinding

class AuthAdapter : RecyclerView.Adapter<AuthAdapter.AuthViewHolder>() {

    inner class AuthViewHolder(private val binding: ItemWelcomeAuthBinding, context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        private val iconBasic = context.resources.getDrawable(R.drawable.ic_fineapple_basic)
        private val iconSmile = context.resources.getDrawable(R.drawable.ic_fineapple_smile)
        private val iconKingWang = context.resources.getDrawable(R.drawable.img_fineapple_kingwangjjang)
        private val iconLove = context.resources.getDrawable(R.drawable.ic_fineapple_love)


        fun bind(position: Int) {
            when (position) {
                0 -> {
                    setViewPager(
                        iconBasic, "파인애플왕국에 오신 여러분 환영합니다!" +
                                "\n" +
                                "파인애플왕국에서는 잃어버린 물건을 찾을 수 있어요"
                    )
                }
                1 -> {
                    setViewPager(
                        iconSmile, "물론 \n" +
                                "주운 잃어버린 물건도 찾아줄 수 있답니다!\n" +
                                "\n" +
                                "주인에게 잃어버린 물건을 찾아주고\n" +
                                "이달의 습득왕을 노려보세요!"
                    )
                }
                2 -> {
                    setViewPager(
                        iconKingWang, "많이 찾아주면 킹왕짱 습득왕이 될 수 있어요!\n" +
                                "\n" +
                                "킹왕짱 습득왕이 되면 상상도못한 보상이?!"
                    )
                }
                3 -> {
                    setViewPager(iconLove, "그럼 잃어버린 물건을 찾으러 떠나볼까요?")
                }
            }
        }

        private fun setViewPager(icon: Drawable, text: String) {
            binding.run {
                welcomeIconIv.setImageDrawable(icon)
                welcomeTv.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthViewHolder {
        val binding =
            ItemWelcomeAuthBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AuthViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: AuthViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = 4
}