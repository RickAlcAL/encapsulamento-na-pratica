package applications;

import entities.Aluno;
import entities.Biblioteca;
import entities.Livro;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Biblioteca biblioteca= new Biblioteca();

    // Menu principal da biblioteca
    public void menuPrincipal() {
        char resp;

        do {
            System.out.println(
                    "==============================="+
                            "\nDigite a opção que gostaria de realizar"+
                            "\n[1]- Pegar livro emprestado"+
                            "\n[2]- Sair"+
                            "\n==============================="
            );
            resp = sc.next().charAt(0);

            if (resp == '1') {
                System.out.println("Informe o número de matricula do aluno:");
                int matricula = sc.nextInt();
                if (biblioteca.verificarMatricula(matricula)) {

                    Aluno aluno= biblioteca.getAlunoAtual();

                    if (!aluno.verificarMultas()) {

                        if (!aluno.verificarEmprestimos()) {
                            menuEmprestimo(aluno);
                        }
                        else
                            System.out.println("Limite de emprestimos atingido");

                    }
                    else
                        System.out.println("Emprestimo bloqueado por multa");

                }
                else
                    System.out.println("Aluno não encontrado!");

            }
            else if (resp == '2') {
                System.out.println("Fechando o  sistema...");
            }
            else
                System.out.println("Digite uma opção válida!");

        } while(resp!='2');

        sc.close();
    }

    // Menu de realização e confirmação de emprestimos
    private void menuEmprestimo(Aluno aluno) {
        System.out.println("Informe o código do livro:");
        int codLivro = sc.nextInt();

        if (biblioteca.verificarLivro(codLivro)) {
            Livro livro= biblioteca.getLivroAtual();

            if (livro.verificarDisponivel()) {
                char confirmacao;

                do {
                    System.out.println(
                            "===============================" +
                                    "\nVocê deseja pegar este livro emprestado?:" +
                                    "\n" + livro.resumoLivro() +
                                    "\n[1]- Sim" +
                                    "\n[2]- Não" +
                                    "\n==============================="
                    );
                    confirmacao = sc.next().charAt(0);

                    if (confirmacao == '1') {
                        System.out.println("Emprestimo realizado com sucesso!");
                        aluno.adicionarEmprestimo();
                        livro.tirarDisponibilidade();
                    }
                    else if (confirmacao == '2') {
                        System.out.println("Emprestimo cancelado!");
                    }
                    else
                        System.out.println("Opção inválida, tente novamente.");

                } while (confirmacao != '1' && confirmacao != '2');
            } else
                System.out.println("Livro indisponível no momento.");

        } else
            System.out.println("Livro não encontrado!");

    }
}
