package com.example.pokeconectdb.views

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.pokeconectdb.R
import com.example.pokeconectdb.viewmodels.CurrentPokemonViewModel
import com.squareup.picasso.Picasso
import java.lang.Exception

class CurrentPokemonFragment: Fragment(R.layout.fragment_current_pokemon) {
    private val args: CurrentPokemonFragmentArgs by navArgs()
    private lateinit var pokeName: TextView
    private lateinit var poketype: TextView
    private lateinit var pokeImage: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var viewModel: CurrentPokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(CurrentPokemonViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokeName = view.findViewById(R.id.pokename)
        poketype = view.findViewById(R.id.poketype)
        pokeImage = view.findViewById(R.id.pokeimage)
//        progressBar = view.findViewById(R.id.progressBar)

//        searchEditText.textChanges()
//            .skipInitialValue()
//            .debounce(500, TimeUnit.MILLISECONDS)
//            .map { it.toString() }
//            .subscribe {
//                viewModel.fetchCurrentPokeData(it)
//            }
        viewModel.fetchCurrentPokeData(args.pokemon.name)

        viewModel.currentPokeLiveData.observe(viewLifecycleOwner) {
            pokeName.text = it.name
            try {
                poketype.text = it.types[0].type.name
                Picasso.get()
                    .load(it.sprites.other.official_artwork.front_default)
                    .into(pokeImage)
            } catch (e: Exception) {
                // handler
            }



        }

//        viewModel.isLoading.observe(viewLifecycleOwner) {
//            progressBar.visibility = it.mapToVisibility()
//        }
//
//        viewModel.serverError.observe(viewLifecycleOwner) {
//            Snackbar.make(searchEditText, requireContext().getString(R.string.server_error_message), Snackbar.LENGTH_LONG).show()
//        }
    }
}