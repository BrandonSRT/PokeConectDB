package com.example.pokeconectdb.views

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pokeconectdb.R
import com.example.pokeconectdb.viewmodels.CreateUserViewModel
import com.google.android.material.textfield.TextInputEditText

class CreateUserFragment : Fragment(R.layout.fragment_create_user) {
    private lateinit var nameCreateEditText: TextInputEditText
    private lateinit var lastNameCreateEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var saveButton: Button

    private lateinit var viewModel: CreateUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(CreateUserViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        nameCreateEditText = view.findViewById(R.id.nameCreateEditText)
        lastNameCreateEditText = view.findViewById(R.id.lastNameCreateEditText)
        emailEditText = view.findViewById(R.id.emailEditText)
        passwordEditText = view.findViewById(R.id.passwordEditText)
        saveButton = view.findViewById(R.id.Save_btn)

        saveButton.setOnClickListener{
            viewModel.insert(0, nameCreateEditText.text.toString(), lastNameCreateEditText.text.toString(), emailEditText.text.toString(), passwordEditText.text.toString())
        }
    }




}