package br.luizfilipe.ifoodauthentications.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.luizfilipe.ifoodauthentications.data.model.Usuario
import br.luizfilipe.ifoodauthentications.data.repository.UsuarioRepository
import br.luizfilipe.ifoodauthentications.databinding.ActivityMainBinding
import br.luizfilipe.ifoodauthentications.extensions.vaiPara
import br.luizfilipe.ifoodauthentications.viewmodel.UsuarioViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        usuarioViewModel = UsuarioViewModel(
            UsuarioRepository() // injetando repository
        )

        inicializaBotoes();
        inicializarObservaveis();
    }

    private fun inicializarObservaveis() {

        usuarioViewModel.sucessoCadastro.observe(this) { sucesso ->
            if (sucesso) {
                Toast.makeText(
                    this,
                    "Sucess Register",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Error Register",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        usuarioViewModel.sucessoLogin.observe(this) { sucesso ->
            if (sucesso) {
                Toast.makeText(this, "Sucess Login", Toast.LENGTH_SHORT).show()
                vaiPara(PerfilUserAcitivity::class.java)
            } else {
                Toast.makeText(this, "Error Login", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun inicializaBotoes() {
        binding.buttonCadastro.setOnClickListener {

            val email = binding.inputcampoemail.text.toString()
            val senha = binding.inputcamposenha.text.toString()
            val usuario = Usuario(email, senha)
            usuarioViewModel.cadastrar(usuario)

        }

        binding.buttonLogin.setOnClickListener {

            val emailLogin = binding.inputcampoemail.text.toString()
            val senhaLogin = binding.inputcamposenha.text.toString()
            val usuario = Usuario(emailLogin, senhaLogin)
            usuarioViewModel.logar(usuario)

        }


    }

}