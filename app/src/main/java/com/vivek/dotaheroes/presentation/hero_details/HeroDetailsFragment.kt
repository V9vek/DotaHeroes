package com.vivek.dotaheroes.presentation.hero_details

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.vivek.dotaheroes.R
import com.vivek.dotaheroes.databinding.FragmentHeroDetailsBinding
import com.vivek.dotaheroes.domain.model.maxAttackDmg
import com.vivek.dotaheroes.domain.model.minAttackDmg
import com.vivek.dotaheroes.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroDetailsFragment : Fragment(R.layout.fragment_hero_details) {

    private lateinit var binding: FragmentHeroDetailsBinding

    private val viewModel by viewModels<HeroDetailsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeroDetailsBinding.bind(view)

        collectUIState()
        collectUIEvents()
    }

    private fun collectUIState() = viewLifecycleOwner.lifecycleScope.launchWhenStarted {
        viewModel.uiState.collect { state ->
            binding.apply {
                pbLoading.isVisible = state.isLoading
                if (!state.isLoading) {
                    state.hero?.let { hero ->
                        ivHeroImage.loadImage(imgUrl = hero.img)
                        ivHeroIcon.loadImage(imgUrl = hero.icon)
                        tvHeroName.text = hero.localizedName
                        layoutType.tvHeroAttack.text = hero.attackType.uiValue
                        layoutType.tvHeroAttribute.text = hero.primaryAttribute.uiValue
                        layoutType.ivHeroAttribute.loadImageFromDrawables(
                            id = getHeroAttributeImage(
                                hero.primaryAttribute
                            )
                        )
                        layoutType.ivHeroAttack.loadImageFromDrawables(
                            id = getHeroAttackImage(hero.attackType)
                        )
                        // Base Stats
                        tvStrengthStats.text = "${hero.baseStr} + ${hero.strGain}"
                        tvAgilityStats.text = "${hero.baseAgi} + ${hero.agiGain}"
                        tvIntelligenceStats.text = "${hero.baseInt} + ${hero.intGain}"
                        tvHealthStats.text = "${getHeroHealth(hero.baseHealth, hero.baseStr)}"
                        tvAttackRangeStats.text = "${hero.attackRange}"
                        tvProjectileStats.text = "${hero.projectileSpeed}"
                        tvMoveSpeedStats.text = "${hero.moveSpeed}"
                        tvAttackDmgStats.text = "${hero.minAttackDmg()} - ${hero.maxAttackDmg()}"
                    }
                }
            }
        }
    }

    private fun collectUIEvents() = viewLifecycleOwner.lifecycleScope.launchWhenStarted {
        viewModel.events.collect { event ->
            when (event) {
                is HeroDetailsEvent.ShowToast -> {
                    Snackbar.make(
                        binding.root,
                        event.message,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}




































