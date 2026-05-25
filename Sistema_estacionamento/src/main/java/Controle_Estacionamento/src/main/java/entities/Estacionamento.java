package entities;

import java.util.ArrayList;

public class Estacionamento {
    private boolean[] vagas= {true, true, true, true, true};
    private ArrayList<Veiculo> veiculosEstacionados = new ArrayList<>();
    private ArrayList<Integer> vagaOcupada = new ArrayList<>();

    public boolean[] getVagas() {
        return vagas;
    }

    // Metodo que exibe as vagas não ocupadas
    public String exibirVagas() {
        String vagasDisponiveis= "Vagas disponíveis:";

        for (int i = 0; i < vagas.length; i++) {
            if(vagas[i]) {
                vagasDisponiveis += "\nvaga " + i;
            }
        }

        return vagasDisponiveis;
    }

    // Metodo que verifica se uma vaga esta ocupada
    public boolean verificarVaga (int vaga) {
        boolean vagaLiberada= false;

        if (vagas[vaga]) {
            vagaLiberada= true;
        }

        return vagaLiberada;
    }

    // Metodo para registrar uma vaga como ocupada
    public void ocuparVaga(int vaga, Veiculo veiculo) {
        vagas[vaga]= false;
        veiculosEstacionados.add(veiculo);
        vagaOcupada.add(vaga);
    }

    // metodo para registrar a liberação de uma vaga
    public void desocuparVaga(int vaga) {
        vagas[vaga]= true;
    }

    // Metodo para verificar a existencia de um veiculo
    public boolean verificarVeiculo(String placaInput, String tipoInput) {
        for (Veiculo v : veiculosEstacionados) {
            if (v.getPlaca().equals(placaInput) && v.getTipo().equals(tipoInput)) {
                return true;
            }
        }
        return false;
    }

    // Metodo para retirar um veiculo de uma vaga
    public void retirarVeiculo(String placaInput, String tipoInput) {
        for (int i = 0; i < veiculosEstacionados.size(); i++) {
            Veiculo v = veiculosEstacionados.get(i);

            if (v.getPlaca().equals(placaInput) && v.getTipo().equals(tipoInput)) {
                int vagaLiberada = vagaOcupada.get(i);
                desocuparVaga(vagaLiberada); // Altera o estado da vaga para true
                veiculosEstacionados.remove(i);
                vagaOcupada.remove(i);
                break;
            }
        }
    }
}