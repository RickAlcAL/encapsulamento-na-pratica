package Sistema_de_Agendamento_Medico.Entities;

import java.util.Scanner;

public class Consulta {
    public String [] especialidadeMedico = {"Ortopedista","Dermatologista","Pediatra"};
    public int [] horarios = {13,15,17};

    public boolean verificadorConsulta (int entradaHorario,String entradaEspecialidade) {
        boolean situacaoConsulta = false;
        boolean temMedico = false;

        for (int i = 0; i < especialidadeMedico.length; i ++){
            if (entradaEspecialidade.equals(especialidadeMedico[i]) && entradaHorario == horarios[i]){
                temMedico = true;
                break;
            }
        }

        if (temMedico){
            situacaoConsulta = true;
        }else {
            System.out.println("Consulta não disponivel");
        }
        return situacaoConsulta;
    }
}
