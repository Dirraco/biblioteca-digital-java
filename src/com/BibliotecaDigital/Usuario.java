package com.BibliotecaDigital;

import java.io.Serializable;

/**
 * Classe que representa um usuário da biblioteca.
 *
 * Implementa Serializable para permitir que os dados
 * sejam salvos em arquivos.
 */
public class Usuario implements Serializable {

    private String nome;
    private String email;

    /**
     * Construtor da classe Usuario.
     *
     * @param nome nome do usuário
     * @param email email do usuário
     */
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    /**
     * Retorna o email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Representação textual do usuário.
     */
    @Override
    public String toString() {
        return nome + " - " + email;
    }
}