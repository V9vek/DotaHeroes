package com.vivek.dotaheroes.presentation.hero_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vivek.dotaheroes.databinding.HeroListRvItemBinding
import com.vivek.dotaheroes.domain.model.Hero
import com.vivek.dotaheroes.domain.model.calculateProWinRate
import com.vivek.dotaheroes.domain.model.getHeroAttributeImage
import com.vivek.dotaheroes.util.getProWinRateTextColor
import com.vivek.dotaheroes.util.loadImage
import com.vivek.dotaheroes.util.loadImageFromDrawables

class HeroListAdapter(
    private val onItemClickListener: ((Int) -> Unit)
) : ListAdapter<Hero, HeroListAdapter.ViewHolder>(DiffCall()) {

    // onItemClickListener
    /*
    private var onItemClickListener: ((Int) -> Unit)? = null
    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }
    */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HeroListRvItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(
            binding = binding,
            onItemClickListener = onItemClickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.setItemClick(item.id)
    }

    inner class ViewHolder(
        private val binding: HeroListRvItemBinding,
        private val onItemClickListener: ((Int) -> Unit)
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setItemClick(heroId: Int) {
            binding.root.setOnClickListener {
                this.onItemClickListener(heroId)
            }
        }

        fun bind(hero: Hero) {
            binding.apply {
                tvHeroName.text = hero.localizedName
                tvHeroAttribute.text = hero.primaryAttribute.uiValue

                val proWinRate = hero.calculateProWinRate()
                tvHeroPercentage.text = proWinRate
                tvHeroPercentage.setTextColor(getProWinRateTextColor(proWinRate))

                ivHeroImage.loadImage(imgUrl = hero.img)

                ivHeroAttribute.loadImageFromDrawables(
                    id = hero.getHeroAttributeImage(),
                )

                // onItemClickListener
                /*
                root.setOnClickListener {
                    onItemClickListener?.let { it(hero.id) }
                }
                */
            }
        }
    }

    // Diff Callback
    class DiffCall : DiffUtil.ItemCallback<Hero>() {
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem == newItem
        }
    }
}





























