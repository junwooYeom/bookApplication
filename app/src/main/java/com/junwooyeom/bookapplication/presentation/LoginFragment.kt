package com.junwooyeom.bookapplication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.junwooyeom.bookapplication.R
import com.junwooyeom.bookapplication.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private lateinit var googleSignInClient: GoogleSignInClient

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            handleSignInIntent(task)
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        val gso = GoogleSignInOptions.Builder().build()
        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        binding.btnLogin.setOnClickListener {
            resultLauncher.launch(googleSignInClient.signInIntent)
        }
    }

    private fun handleSignInIntent(task: Task<GoogleSignInAccount>) {
        try {
            if (task.isSuccessful) {
                moveToSearchFragment()
            }
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "googleOauthLogin 에 실패하였습니다", Toast.LENGTH_SHORT)
                .show()
            e.printStackTrace()
        }
    }

    private fun moveToSearchFragment() {
        findNavController().navigate(R.id.action_loginFragment_to_searchFragment)
    }
}