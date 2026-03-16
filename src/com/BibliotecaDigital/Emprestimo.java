package com.BibliotecaDigital;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Classe que representa o registro de um empréstimo realizado na biblioteca.
 *
 * Armazena qual livro foi emprestado, qual usuário realizou o empréstimo
 * e a data/hora em que a operação ocorreu.
 */
public class Emprestimo implements Serializable {

    private Livro livro;
    private Usuario usuario;
    private LocalDateTime dataHora;

    /**
     * Construtor da classe Emprestimo.
     *
     * @param livro livro emprestado
     * @param usuario usuário que realizou o empréstimo
     */
    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataHora = LocalDateTime.now(); // registra automaticamente data e hora
    }

    /**
     * Representação textual do empréstimo.
     */
    @Override
    public String toString() {
        return "Livro: " + livro.getTitulo() +
                " | Usuário: " + usuario +
                " | Data: " + dataHora;
    }
}
