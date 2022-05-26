package com.vivek.dotaheroes.presentation.hero_list

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.vivek.dotaheroes.R
import com.vivek.dotaheroes.databinding.FragmentHeroListBinding
import com.vivek.dotaheroes.presentation.hero_list.adapter.HeroListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroListFragment : Fragment(R.layout.fragment_hero_list) {

    private lateinit var binding: FragmentHeroListBinding

    private val viewModel by viewModels<HeroListViewModel>()

    private val heroListAdapter = HeroListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeroListBinding.bind(view)

        initRecyclerView()
        collectUIState()
        collectUIEvents()
    }

    private fun collectUIState() = viewLifecycleOwner.lifecycleScope.launchWhenStarted {
        viewModel.uiState.collect { state ->
            binding.apply {
                pbLoading.isVisible = state.isLoading
                if (!state.isLoading) {
                    heroListAdapter.submitList(state.heroes)
                }
            }
        }
    }

    private fun collectUIEvents() = viewLifecycleOwner.lifecycleScope.launchWhenStarted {
        viewModel.events.collect { event ->
            when (event) {
                is HeroListEvent.ShowToast -> {
                    Snackbar.make(
                        binding.root,
                        event.message,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                is HeroListEvent.NavigateToHeroDetailsScreen -> {
                    navigateToHeroDetailsScreen(heroId = event.heroId)
                }
            }
        }
    }

    private fun initRecyclerView() {
        binding.rvHeroesList.apply {
            adapter = heroListAdapter
            setHasFixedSize(false)
        }

        heroListAdapter.setOnItemClickListener { heroId ->
            viewModel.onTriggerEvent(HeroListEvent.NavigateToHeroDetailsScreen(heroId = heroId))
        }
    }

    private fun navigateToHeroDetailsScreen(heroId: Int) {
        val action = HeroListFragmentDirections.actionHeroListFragmentToHeroDetailsFragment(
            heroId = heroId
        )
        findNavController().navigate(action)
    }
}





























