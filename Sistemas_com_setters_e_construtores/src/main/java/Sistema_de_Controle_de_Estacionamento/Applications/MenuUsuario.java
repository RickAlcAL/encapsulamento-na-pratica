package Sistema_de_Controle_de_Estacionamento.Applications;

import Sistema_de_Controle_de_Estacionamento.Entities.Motorista;
import Sistema_de_Controle_de_Estacionamento.Entities.Pagamento;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUsuario {
    public void menu () {
        Pagamento pagar = new Pagamento();
        ArrayList<String> listaTipos = new ArrayList<>();
        ArrayList<String> listaPlacas = new ArrayList<>();
        String [] vagasOcupadasUser = new String[3];
        Scanner sc = new Scanner(System.in);
        Motorista motor = new Motorista(listaTipos, listaPlacas,vagasOcupadasUser);
        int opcao;
        boolean continuarNoMenu = true;

        do {
            System.out.println("Insira o tipo do seu veiculo: ");
            String tipoVeiculo = sc.nextLine();
            listaTipos.add(tipoVeiculo);
            motor.setTiposVeiculos(listaTipos);
            System.out.println("Insira a placa do seu veiculo: ");
            String placaVeiculo = sc.nextLine();
            listaPlacas.add(placaVeiculo);
            motor.setPlacasVeiculos(listaPlacas);

            System.out.println("\n=== SISTEMA DE ESTACIONAMENTO ===");
            System.out.println("Motorista cadastrado\nTipo do veiculo: " +motor.getTiposVeiculos());
            System.out.println("Placa do veiculo: " + motor.getPlacasVeiculos());
            System.out.println("Insira a vaga desejada (ex: 1, 2): ");
            int vagaDesejada = sc.nextInt();
            if (vagaDesejada <= 0){
                System.out.println("Digite uma vaga correa");
            }
            String alteradorNumero = String.valueOf(vagaDesejada);
            boolean vagaOcupada = false;
            for (int i = 0; i < vagasOcupadasUser.length; i ++){
                if (alteradorNumero.equals(vagasOcupadasUser[i])){
                    vagaOcupada =  true;
                    break;
                }
            }
            motor.setVagasOcupadas(vagasOcupadasUser);
            boolean vagaDisponivel = motor.verificadorVaga(String.valueOf(vagaDesejada));
                if (vagaDisponivel) {
                    System.out.println("Insira o tempo (em horas) que o veículo ficou estacionado: ");
                    int tempoEstacionado = sc.nextInt();
                    sc.nextLine();

                    String resumoPagamento = pagar.calculoEstacionamento(tempoEstacionado);
                    System.out.println("\n" + resumoPagamento);

                    System.out.println("\nSelecione a forma de pagamento:");
                    System.out.println("1 - Cartão de Crédito (Simular Recusado)");
                    System.out.println("2 - Cartão de Débito");
                    System.out.println("3 - Pix");
                    System.out.println("4 - Dinheiro");
                    System.out.print("Opção: ");

                    opcao = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\n--- Processando Pagamento ---");

                    if (opcao == 1) {
                        System.out.println("Pagamento não autorizado.");
                        continuarNoMenu = false;
                    } else if (opcao >= 2 && opcao <= 4) {
                        System.out.println("Liberando a saída...");
                        System.out.println("Registrando o pagamento no sistema...");
                        System.out.println("Saída liberada.");
                        continuarNoMenu = false;
                    } else {
                        System.out.println("Opção inválida! Tente novamente.");
                    }

            } else {
                System.out.println("Por favor, escolha outra vaga.");
            }

        } while (continuarNoMenu);

        sc.close();
        System.out.println("\n=== Fim do Programa ===");
    }
}
