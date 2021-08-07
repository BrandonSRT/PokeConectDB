package com.example.pokeconectdb.views

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Patterns
import android.view.View
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pokeconectdb.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var login_btn: Button
    private lateinit var signup_btn: Button
    private lateinit var prueba_btn: Button
    private lateinit var emailTextInputLayoutLogin: TextInputLayout
    private lateinit var passwTextInputLayoutLogin: TextInputLayout
    var emailValid = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailEditText = view.findViewById(R.id.emailEditText)
        passwordEditText = view.findViewById(R.id.passwordEditText)
        login_btn = view.findViewById(R.id.btnLogin)
        login_btn.isEnabled=false
        signup_btn = view.findViewById(R.id.btnSignUp)
        emailTextInputLayoutLogin = view.findViewById(R.id.textInputLayoutEmailLogin)
        passwTextInputLayoutLogin = view.findViewById(R.id.textInputLayoutPasswLogin)
        prueba_btn = view.findViewById(R.id.prueba)


        fun botonhabilitar() {
            login_btn.isEnabled =
                (emailEditText.text.toString() != "" && emailValid && passwordEditText.text.toString() != "")

        }

        fun validacion(email: String) {

            if (Patterns.EMAIL_ADDRESS.matcher(email)
                    .matches()
            ) {
                emailTextInputLayoutLogin.error = null
                emailValid = true
                botonhabilitar()

            } else {
                emailValid = false
                botonhabilitar()
                emailTextInputLayoutLogin.error = "Ingresar Email valido"
            }
        }

        emailEditText.addTextChangedListener {

            Handler(Looper.getMainLooper()).postDelayed({
                if (emailEditText.text.toString().isEmpty()) {
                    emailTextInputLayoutLogin.error = "Email requerido"
                }
            }, 100)

            Handler(Looper.getMainLooper()).postDelayed({
                if (emailEditText.text.toString().isNotEmpty()) {
                    validacion(emailEditText.text.toString())
                }
            }, 500)
        }

        passwordEditText.addTextChangedListener {
            passwTextInputLayoutLogin.error =
                if (passwordEditText.text.toString().isEmpty()) " Password requerido" else null
            botonhabilitar()
        }

        passwordEditText.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) else botonhabilitar()
        }






        login_btn.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToMainFragment2()
            findNavController().navigate(action)
        }

        signup_btn.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToCreateAccountNavGraph()
            findNavController().navigate(action)
        }

     //   prueba_btn.setOnClickListener{
     //       val action = LoginFragmentDirections.actionLoginFragmentToPokeList2Fragment()
     //       findNavController().navigate(action)
     //   }

    }
}