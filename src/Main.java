import com.BibliotecaDigital.Biblioteca;
import com.BibliotecaDigital.Livro;
import com.BibliotecaDigital.LivroIndisponivelException;
import com.BibliotecaDigital.Usuario;

import java.util.Scanner;

/**
 * Classe principal responsável por iniciar o sistema da Biblioteca Digital.
 * Aqui ocorre toda a interação com o usuário via terminal.
 */
public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Carrega dados salvos anteriormente
        biblioteca.carregarDados();

        int opcao = 0;

        while (opcao != 9) {

            System.out.println("\n=== BIBLIOTECA DIGITAL ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Cadastrar usuário");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Listar livros disponíveis");
            System.out.println("7 - Listar livros emprestados");
            System.out.println("8 - Ver histórico de empréstimos");
            System.out.println("9 - Salvar e sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    Livro livro = new Livro(titulo, autor, ano);
                    biblioteca.cadastrarLivro(livro);

                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:

                    biblioteca.listarLivros();
                    break;

                case 3:

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Usuario usuario = new Usuario(nome, email);
                    biblioteca.cadastrarUsuario(usuario);

                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 4:

                    System.out.print("Título do livro: ");
                    String tituloEmprestimo = scanner.nextLine();

                    System.out.print("Email do usuário: ");
                    String emailUsuario = scanner.nextLine();

                    try {

                        biblioteca.emprestarLivro(tituloEmprestimo, emailUsuario);

                    } catch (LivroIndisponivelException e) {

                        System.out.println(e.getMessage());

                    }

                    break;

                case 5:

                    System.out.print("Título do livro: ");
                    String tituloDevolucao = scanner.nextLine();

                    biblioteca.devolverLivro(tituloDevolucao);

                    System.out.println("Livro devolvido.");
                    break;

                case 6:

                    biblioteca.listarLivrosDisponiveis();
                    break;

                case 7:

                    biblioteca.listarLivrosEmprestados();
                    break;

                case 8:

                    biblioteca.listarHistorico();
                    break;

                case 9:

                    biblioteca.salvarDados();
                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");

            }

        }

        scanner.close();

    }

}