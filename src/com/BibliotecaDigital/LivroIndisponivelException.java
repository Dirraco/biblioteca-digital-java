package com.BibliotecaDigital;

/**
 * Exceção personalizada lançada quando um livro
 * que já está emprestado tenta ser emprestado novamente.
 */
public class LivroIndisponivelException extends Exception {

    /**
     * Construtor da exceção.
     *
     * @param mensagem mensagem de erro exibida ao usuário
     */
    public LivroIndisponivelException(String mensagem) {
        super(mensagem);
    }

}