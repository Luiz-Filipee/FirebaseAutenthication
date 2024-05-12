package br.luizfilipe.ifoodauthentications.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.luizfilipe.ifoodauthentications.data.repository.UsuarioRepository
import br.luizfilipe.ifoodauthentications.databinding.ActivityPerfilUserAcitivityBinding
import br.luizfilipe.ifoodauthentications.viewmodel.UsuarioViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PerfilUserAcitivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPerfilUserAcitivityBinding.inflate(layoutInflater)
    }

    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        usuarioViewModel = UsuarioViewModel(
            UsuarioRepository()
        )

        inicializaCampos()

        val user = Firebase.auth.currentUser
        user?.let { usuario ->
            binding.emailUser.text = usuario.email
        }
    }

    private fun inicializaCampos() {
        binding.btnLogout.setOnClickListener {
           Firebase.auth.signOut().apply {
               finish()
           }
        }
    }
}