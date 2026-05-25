package Sistema_de_Controle_de_Estacionamento.Entities;

import java.util.ArrayList;
import java.util.Random;

public class Motorista {
    private ArrayList<String> tiposVeiculos ;
    private ArrayList<String> placasVeiculos ;
    private String [] vagasOcupadas = {"1","2","4"};


    public Motorista (ArrayList<String> tiposVeiculos, ArrayList<String> placaVeiculos, String[] vagasOcupadas) {
        this.tiposVeiculos = tiposVeiculos;
        this.placasVeiculos = placaVeiculos;
        this.vagasOcupadas = vagasOcupadas;
    }


    public String horarioDeEntrada () {
        Random rand = new Random();

        int horarioHoras = rand.nextInt(24);
        int horarioMinutos = rand.nextInt(60);

        return String.format("%02d:%02d", horarioHoras, horarioMinutos);
    }

    public boolean verificadorVaga (String vaga){
        boolean verificarVaga = true;

        for (int i = 0;i < vagasOcupadas.length; i ++){
            if (vaga.equals(vagasOcupadas[i])){
                System.out.println("Vaga indisponivel");
                verificarVaga = false;
            }

        }

        return verificarVaga;
    }

    public void autenticacaoVaga (String tipoCarroUser, String placaCarroUser) {

        String msg = String.format("\n--- COMPROVANTE ---\nTipo de carro: %s\nPlaca do veiculo: %s\nHorário de entrada: %s\n",
                tipoCarroUser, placaCarroUser, this.horarioDeEntrada());

        System.out.println(msg);
    }

    public ArrayList<String> getPlacasVeiculos() {
        return placasVeiculos;
    }

    public void setPlacasVeiculos(ArrayList<String> placasVeiculos) {
        this.placasVeiculos = placasVeiculos;
    }

    public ArrayList<String> getTiposVeiculos() {
        return tiposVeiculos;
    }

    public void setTiposVeiculos(ArrayList<String> tiposVeiculos) {
        this.tiposVeiculos = tiposVeiculos;
    }

    public String[] getVagasOcupadas(String [] vagasOcupadas) {
        return vagasOcupadas;
    }

    public void setVagasOcupadas(String[] vagasOcupadas) {
        this.vagasOcupadas = vagasOcupadas;
    }
}
