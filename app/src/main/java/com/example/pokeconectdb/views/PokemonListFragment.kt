package com.example.pokeconectdb.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeconectdb.R
import com.example.pokeconectdb.viewmodels.PokemonListViewModel
import com.example.pokeconectdb.views.adapters.PokemonListAdapter
import com.example.pokeconectdb.views.models.PokemonModelList

class PokemonListFragment :Fragment(R.layout.fragment_pokemon_list){
    private lateinit var pokeRecyclerView: RecyclerView
    private lateinit var viewModel: PokemonListViewModel

    // TODO 10: Declaramos el adapter de usuarios
    private val adapter = PokemonListAdapter(){ PokemonModelList->
        val action= PokemonListFragmentDirections.actionPokemonListFragmentToCurrentPokemonFragment(PokemonModelList)
        findNavController().navigate(action)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PokemonListViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokeRecyclerView = view.findViewById(R.id.PokeListRecycler)
        pokeRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        pokeRecyclerView.adapter = adapter


        viewModel.fetchPokeListData()


        getDummyPokeList()
    }

    private fun getDummyPokeList()  {
        val example= mutableListOf<PokemonModelList>()
        var num = 1

        viewModel.currentPokeLiveData.observe(viewLifecycleOwner) {

            for (x in it.results){

                var idpoke = x.url.split("/")

                example.add(PokemonModelList(x.name, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$num.png"))
                num += 1
            }
            adapter.pokeList =example

        }


    }

}