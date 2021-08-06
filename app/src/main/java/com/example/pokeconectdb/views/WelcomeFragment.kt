package com.example.pokeconectdb.views

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pokeconectdb.R

class WelcomeFragment: Fragment(R.layout.fragment_welcome) {
    private lateinit var start_btn : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        start_btn = view.findViewById(R.id.start_btn)

        start_btn.setOnClickListener{

            val action = WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment()
            findNavController().navigate(action)



        }
    }

}