package Sistema_de_Agendamento_Medico.Entities;

import java.util.Scanner;

public class MenuUsuario {


    public void menuConsulta () {
        Consulta consulta = new Consulta();
        Paciente paciente = new Paciente();
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n--- SISTEMA DE AGENDAMENTO ---");
            System.out.println("1. Agendar Consulta");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1){
                System.out.println("Digite seu nome");
                String nomeUsuario = sc.nextLine();
                System.out.println("Digite seu CPF");
                String cpfUsuario = sc.nextLine();
                boolean verificar = paciente.verificarCadastro(cpfUsuario,nomeUsuario);
                if (paciente.verificarCadastro(cpfUsuario,nomeUsuario)){
                    if (verificar){
                        System.out.println("Usuario encontrado");
                        System.out.println("Digite a especialidade");
                        for (String especial: consulta.especialidadeMedico){
                            System.out.println(especial);
                        }
                        String especialidade = sc.nextLine();
                        System.out.println("Digite o horario que deseja");
                        for (int horarioVer : consulta.horarios){
                            System.out.println(horarioVer);
                        }
                        int horarioEscolha = sc.nextInt();
                        boolean verificarMedico = consulta.verificadorConsulta(horarioEscolha,especialidade);

                        if (verificarMedico){
                            System.out.println("Consulta agendada !!!\n" + especialidade + " as " + horarioEscolha + " horas");
                        }else {
                            System.out.println("Não foi possivel tente novamente");
                        }
                    }
                }else {
                    System.out.println("Usuario não encontrado");
                }
            }
        }while (opcao != 2);

    }
}
