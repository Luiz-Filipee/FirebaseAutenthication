package br.luizfilipe.ifoodauthentications.data.repository

import org.junit.Assert.*

import org.junit.Test

class UsuarioRepositoryTest {

    @Test
    fun listar() {
        val usuarioRepository = UsuarioRepository()
        val lista = usuarioRepository.listar()
        val retorno = lista.isNotEmpty()
        assert( retorno )
    }

    @Test
    fun verificaUsuarioLogado() {
        val usuarioRepository = UsuarioRepository()
        val retorno = usuarioRepository.verificaUsuarioLogado()
        assert( retorno )
    }
}