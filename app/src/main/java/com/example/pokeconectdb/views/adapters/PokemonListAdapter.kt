package com.example.pokeconectdb.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeconectdb.R
import com.example.pokeconectdb.views.models.PokemonModelList
import com.squareup.picasso.Picasso

class PokemonListAdapter(val onItemClicked: ((PokemonModelList) -> (Unit))? = null) : RecyclerView.Adapter<PokemonListAdapter.PokeViewHolder>() {
    var pokeList: List<PokemonModelList> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class PokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameTextView: TextView = itemView.findViewById(R.id.PokenametextView)
        private var pokemonImageView: ImageView = itemView.findViewById(R.id.PokemonimageView)

        fun bind(model: PokemonModelList) {
            itemView.setOnClickListener { onItemClicked?.invoke(model) }

            nameTextView.text = model.name
//            Glide.with(itemView.context).load(model.imageUrl).transform(CircleCrop()).into(pokemonImageView)
            Picasso.get().load(model.imageUrl).into(pokemonImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val holderView = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon_cell, parent, false)
        return PokeViewHolder(holderView)
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        holder.bind(pokeList[position])
    }

    override fun getItemCount(): Int = pokeList.size
}