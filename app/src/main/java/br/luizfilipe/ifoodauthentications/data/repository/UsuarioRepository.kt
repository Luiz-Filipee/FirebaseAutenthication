package br.luizfilipe.ifoodauthentications.data.repository

import br.luizfilipe.ifoodauthentications.data.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

// operacoes no banco de dados
class UsuarioRepository : InterfaceRepository {

    private val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }

    override suspend fun cadastrar( usuario: Usuario ) : Boolean {
        return autenticacao.createUserWithEmailAndPassword(
            usuario.email, usuario.senha
        ).await() != null
    }

    override suspend fun logar( usuario: Usuario ) : Boolean{
        return autenticacao.signInWithEmailAndPassword(
            usuario.email, usuario.senha
        ).await() != null
    }

    override suspend fun deslogar(usuario: Usuario) {
        return autenticacao.signOut()
    }

    fun listar() : List<String> {
        return listOf("Luiz", " Filipe")
    }

    fun verificaUsuarioLogado() : FirebaseUser? {
        val user = Firebase.auth.currentUser
        return user
    }
}