package Sistema_de_Agendamento_Medico.Entities;

public class Paciente {
    private String  cpfPaciente ;
    private String  nomePaciente;

    public Paciente (String cpfPaciente, String nomePaciente){
        this.cpfPaciente = cpfPaciente;
        this.nomePaciente = nomePaciente;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }
}
