package br.luizfilipe.ifoodauthentications.data.repository

import br.luizfilipe.ifoodauthentications.data.model.Usuario

interface InterfaceRepository {

    suspend fun cadastrar(usuario: Usuario) : Boolean

    suspend fun logar(usuario: Usuario) : Boolean

    suspend fun deslogar(usuario: Usuario)
}