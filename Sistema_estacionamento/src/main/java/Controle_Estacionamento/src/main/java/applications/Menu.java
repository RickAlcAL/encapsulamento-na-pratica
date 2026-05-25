package applications;

import entities.Estacionamento;
import entities.Veiculo;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Estacionamento estacionamento= new Estacionamento();

    // Menu de opções do sistema
    public void menuPrincipal() {
        char opcao;

        do {
            System.out.println(
                    "============================\n" +
                            "Selecione a opção que deseja:\n" +
                            "1- Estacionar veículo\n" +
                            "2- Retirar veículo\n" +
                            "3- Sair\n"+
                            "============================"
            );
            opcao = sc.next().charAt(0);
            sc.nextLine(); // Limpar buffer

            if(opcao=='1'){
                menuEstacionar();
            }
            else if (opcao=='2') {
                menuRetirar();
            }
            else if (opcao=='3') {
                System.out.println("Fechando o sistema...");
            }
            else
                System.out.println("Digite uma opção válida!");

        } while (opcao!='3');
    }

    // Menu para registrar the estacionamento de um carro
    private void menuEstacionar() {
        System.out.println("Placa: ");
        String placa= sc.nextLine();
        String tipo;
        do {
            System.out.println("Tipo (carro/moto): ");
            tipo = sc.nextLine();
        } while (!tipo.equalsIgnoreCase("carro") && !tipo.equalsIgnoreCase("moto"));

        if (estacionamento.verificarVeiculo(placa, tipo)) {
            System.out.println("O veículo ja está estacionado!");
            return;
        }

        System.out.println(estacionamento.exibirVagas());

        boolean exito= false;
        do {
            System.out.println("Digite o numero vaga que quer ocupar: ");
            int vaga = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            if (vaga < 0 || vaga > estacionamento.getVagas().length-1) {
                System.out.println("Digite uma vaga válida");
            }
            else {

                if (!estacionamento.verificarVaga(vaga)) {
                    System.out.println("Vaga ocupada, escolha outra vaga");
                }
                else {
                    Veiculo novoVeiculo = new Veiculo(placa, tipo);
                    estacionamento.ocuparVaga(vaga, novoVeiculo);

                    System.out.println("O veículo está estacionado na vaga: " + vaga);
                    exito= true;
                }
            }
        } while (!exito);
    }

    // Menu para registrar a retirada de um carro
    private void menuRetirar() {
        System.out.println("Digite os dados do veículo a ser retirado: ");
        System.out.println("Placa: ");
        String placa= sc.nextLine();
        String tipo;
        do {
            System.out.println("Tipo (carro/moto): ");
            tipo = sc.nextLine();
        } while (!tipo.equalsIgnoreCase("carro") && !tipo.equalsIgnoreCase("moto"));

        if(!estacionamento.verificarVeiculo(placa, tipo)) {
            System.out.println("Veículo não encontrado!");
        }
        else {
            estacionamento.retirarVeiculo(placa, tipo);
            System.out.println("Veículo retirado com sucesso!");
        }

    }
}