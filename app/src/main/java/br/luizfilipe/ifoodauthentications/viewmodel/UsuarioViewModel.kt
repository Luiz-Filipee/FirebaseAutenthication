package br.luizfilipe.ifoodauthentications.viewmodel

import androidx.lifecycle.MutableLiveData
import br.luizfilipe.ifoodauthentications.data.model.Usuario
import br.luizfilipe.ifoodauthentications.data.repository.UsuarioRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// exibicao de dados na tela
class UsuarioViewModel(
    private val usuarioRepository: UsuarioRepository
) {

    // LiveData -> dado vivo
    val sucessoCadastro = MutableLiveData<Boolean>()
    val sucessoLogin = MutableLiveData<Boolean>()

    val usuarioLogado = MutableLiveData<Usuario>()

    fun cadastrar(usuario: Usuario) {
        CoroutineScope(Dispatchers.IO).launch {
            val resposta = usuarioRepository.cadastrar(usuario)
            sucessoCadastro.postValue(resposta)
        }
    }

    fun logar(usuario: Usuario) {
        CoroutineScope(Dispatchers.IO).launch {
            val resposta = usuarioRepository.logar(usuario)
            sucessoLogin.postValue( resposta )
            usuarioLogado.postValue( usuario )
        }
    }

    fun deslogar( usuario: Usuario ){
        CoroutineScope(Dispatchers.IO).launch {
            usuarioRepository.deslogar(usuario)
        }
    }

}