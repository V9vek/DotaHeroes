package com.vivek.dotaheroes.presentation.hero_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vivek.dotaheroes.databinding.HeroListRvItemBinding
import com.vivek.dotaheroes.domain.model.Hero
import com.vivek.dotaheroes.util.*

class HeroListAdapter : ListAdapter<Hero, HeroListAdapter.ViewHolder>(DiffCall()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HeroListRvItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    // onItemClickListener
    private var onItemClickListener: ((Int) -> Unit)? = null
    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }

    inner class ViewHolder(
        private val binding: HeroListRvItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(hero: Hero) {
            binding.apply {
                tvHeroName.text = hero.localizedName
                tvHeroAttribute.text = hero.primaryAttribute.uiValue

                val proWinRate = calculateProWinRate(
                    proWins = hero.proWins,
                    proPick = hero.proPick
                )
                tvHeroPercentage.text = proWinRate
                tvHeroPercentage.setTextColor(getProWinRateTextColor(proWinRate))

                ivHeroImage.loadImage(imgUrl = hero.img)

                ivHeroAttribute.loadImageFromDrawables(id = getHeroAttributeImage(heroAttribute = hero.primaryAttribute))

                // onItemClickListener
                root.setOnClickListener {
                    onItemClickListener?.let { it(hero.id) }
                }
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





























