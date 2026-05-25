package Sistema_de_Agendamento_Medico.Entities;

public class Paciente {
    private String cpfPaciente;
    private String  nomePaciente;
    int cpfAtual;

    public Paciente (String  cpfPaciente,String nomePaciente){
        this.cpfPaciente = cpfPaciente;
        this.nomePaciente = nomePaciente;
    }
    public boolean verificarCadastro (String entradaUsuarioCPF,String entradaUsuarioNOME) {
        boolean situacao = false;
        for (int i = 0;i < cpfPaciente.length; i++){
            if (entradaUsuarioCPF.equals(cpfPaciente[i]) && entradaUsuarioNOME.equals(nomePaciente[i])) {
                cpfAtual = i;
                situacao = true;
                break;
            }
        }
        return situacao;
    }
}
