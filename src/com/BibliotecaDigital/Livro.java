package com.BibliotecaDigital;

import java.io.Serializable;

/**
 * Classe que representa um livro dentro do sistema da biblioteca.
 *
 * Implementa Serializable para permitir a persistência em arquivos
 * e Comparable para possibilitar ordenação de livros pelo título.
 */
public class Livro implements Serializable, Comparable<Livro> {

    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean emprestado;

    /**
     * Construtor da classe Livro.
     *
     * @param titulo título do livro
     * @param autor autor do livro
     * @param anoPublicacao ano de publicação
     */
    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.emprestado = false;
    }

    /**
     * Retorna o título do livro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Verifica se o livro está emprestado.
     */
    public boolean isEmprestado() {
        return emprestado;
    }

    /**
     * Define o status de empréstimo do livro.
     */
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    /**
     * Permite comparar livros pelo título.
     */
    @Override
    public int compareTo(Livro outro) {
        return this.titulo.compareToIgnoreCase(outro.titulo);
    }

    /**
     * Representação textual do livro.
     */
    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + anoPublicacao + ")" +
                (emprestado ? " [Emprestado]" : " [Disponível]");
    }
}