package com.BibliotecaDigital;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar toda a lógica da biblioteca.
 *
 * Controla livros, usuários, empréstimos e persistência de dados.
 */
public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> historico = new ArrayList<>();

    /**
     * Cadastra um novo livro na biblioteca.
     */
    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    /**
     * Cadastra um novo usuário no sistema.
     */
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Busca um livro pelo título utilizando Stream API.
     */
    public Livro buscarLivro(String titulo) {

        return livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    /**
     * Realiza o empréstimo de um livro.
     *
     * @throws LivroIndisponivelException caso o livro já esteja emprestado
     */
    public void emprestarLivro(String titulo, String usuarioEmail) throws LivroIndisponivelException {

        Livro livro = buscarLivro(titulo);

        Usuario usuario = usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(usuarioEmail))
                .findFirst()
                .orElse(null);

        if (livro != null && usuario != null) {

            if (livro.isEmprestado()) {
                throw new LivroIndisponivelException("Livro já está emprestado.");
            }

            livro.setEmprestado(true);

            // registra no histórico
            Emprestimo emprestimo = new Emprestimo(livro, usuario);
            historico.add(emprestimo);

            System.out.println("Livro emprestado com sucesso.");

        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    /**
     * Realiza a devolução de um livro.
     */
    public void devolverLivro(String titulo) {

        Livro livro = buscarLivro(titulo);

        if (livro != null) {
            livro.setEmprestado(false);
        }

    }

    /**
     * Lista todos os livros cadastrados.
     */
    public void listarLivros(){
        livros.forEach(System.out::println);
    }

    /**
     * Salva os dados da biblioteca em arquivo.
     */
    public void salvarDados() {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("biblioteca.dat"));

            oos.writeObject(livros);
            oos.writeObject(usuarios);

            oos.close();

            System.out.println("Dados salvos com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao salvar dados.");
        }

    }

    /**
     * Lista somente livros disponíveis para empréstimo.
     */
    public void listarLivrosDisponiveis() {

        livros.stream()
                .filter(l -> !l.isEmprestado())
                .forEach(System.out::println);

    }

    /**
     * Lista somente livros que estão emprestados.
     */
    public void listarLivrosEmprestados() {

        livros.stream()
                .filter(Livro::isEmprestado)
                .forEach(System.out::println);

    }

    /**
     * Exibe todo o histórico de empréstimos realizados no sistema.
     */
    public void listarHistorico() {

        if (historico.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }

        historico.forEach(System.out::println);

    }

    /**
     * Carrega os dados previamente salvos.
     */
    public void carregarDados() {

        try {

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("biblioteca.dat"));

            livros = (List<Livro>) ois.readObject();
            usuarios = (List<Usuario>) ois.readObject();

            ois.close();

            System.out.println("Dados carregados.");

        } catch (Exception e) {
            System.out.println("Nenhum dado salvo encontrado.");
        }

    }
}