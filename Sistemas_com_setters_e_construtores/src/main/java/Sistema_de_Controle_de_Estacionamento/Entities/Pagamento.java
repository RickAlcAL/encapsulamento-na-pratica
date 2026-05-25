package Sistema_de_Controle_de_Estacionamento.Entities;

public class Pagamento {
    public int valorPorHora = 10;
    public int acimaDoPorHora = 15;

    public String calculoEstacionamento (int tempoEstacionado) {
        String msg = "";
        int valorFinal;

        if (tempoEstacionado <= 1) {
            valorFinal = tempoEstacionado * valorPorHora;
            msg = "Você ficou no total: " + tempoEstacionado + " hora(s)" +
                    "\nO valor ficou: R$ " + valorFinal;
        } else {
            valorFinal = tempoEstacionado * acimaDoPorHora;
            msg = "Você ficou no total: " + tempoEstacionado + " horas" +
                    "\nO valor ficou: R$ " + valorFinal;
        }
        return msg;
    }
}