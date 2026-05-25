package Sistema_de_Agendamento_Medico.Applications;



import Sistema_de_Agendamento_Medico.Entities.Consulta;
import Sistema_de_Agendamento_Medico.Entities.Medico;
import Sistema_de_Agendamento_Medico.Entities.Paciente;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Consulta clinica = new Consulta();

    // Menu para iniciar login ou sair do sistema
    public void menuInicial() {
        char resp;

        do {
            System.out.println(
                    "========================================="+
                            "\nDigite a opção que deseja"+
                            "\n1- Marcar consulta"+
                            "\n2- Sair"+
                            "\n========================================="
            );
            resp= sc.next().charAt(0);

            if (resp=='1') {
                login();
            }
            else if (resp=='2') {
                System.out.println("fechando o programa");
            }
            else
                System.out.println("Digite uma resposta válida!");

        } while (resp!='2');
    }

    // Menu que contem o processo completo de login
    public void login() {
        System.out.println("Digite seu CPF: ");
        sc.nextLine();
        String cpf= sc.nextLine();
        System.out.println("Digite seu nome: ");
        String nome= sc.nextLine();

        if (!clinica.verificadorCadastro(cpf, nome)) {
            System.out.println("Paciente não cadastrado!");
            return;
        }

        menuMarcacao();
    }

    // Menu que contem o processo completo para marcar consultas e exibir a consulta marcada
    public void menuMarcacao() {
        System.out.println("Digite a especialidade do médico que deseja se consultar: ");
        String especialidade= sc.nextLine();

        if (!clinica.verificarEspecialidade(especialidade)) {
            System.out.println("Não possuímos médicos com esta especialidade, tente novamente!");
            return;
        }

        Medico medico = clinica.getMedicoAtual();
        System.out.println(
                "=========================================\n"+
                        "Digite o número correspondente ao horário você desejaria marcar\n"+
                        medico.exibicaoHorario()
        );
        int horario= sc.nextInt();

        System.out.println(medico.agendamentoHorario(horario-1));
    }
}