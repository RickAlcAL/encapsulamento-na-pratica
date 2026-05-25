# Atendimento_medico
Sistema em Java para gerenciamento de agendamentos médicos. Permite a validação de cadastros de pacientes (via CPF/Nome) e a verificação de disponibilidade de horários por especialidade médica, evitando conflitos de agenda no console.
# 🏥 Sistema de Agendamento Médico

Sistema baseado em console desenvolvido em Java para otimizar o fluxo de marcação de consultas em clínicas ou hospitais. O software valida a existência do cadastro do paciente e garante a consistência da agenda médica, impedindo choques de horários.

## 🚀 Funcionalidades Chave

* **Menu Interativo:** Navegação simples via console utilizando estruturas de repetição (`do-while`).
* **Autenticação de Paciente:** Verificação segura de dados (Nome e CPF) em arrays paralelos.
* **Agendamento Inteligente:** Validação combinada (`&&`) que impede a reserva de uma especialidade em horários indisponíveis.
* **Tratamento de Dados:** Entrada de CPF via `String` para evitar estouro de memória (`InputMismatchException`) e preservar zeros à esquerda.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 11 ou superior)
* **Entrada de Dados:** `java.util.Scanner`

## 📦 Estrutura do Projeto

O projeto está organizado no pacote `Sistema_de_Agendamento_Medico.Entities`:

* `MenuUsuario.java`: Gerencia a interface de texto, coleta de inputs e fluxo principal.
* `Paciente.java`: Contém a lógica de busca e validação cadastral.
* `Consulta.java`: Armazena os horários e especialidades, além de validar a disponibilidade da vaga.

## 🔧 Como Executar

1. Clone o repositório:
   ```bash
   git clone [https://github.com/seu-usuario/nome-do-repositorio.git](https://github.com/seu-usuario/nome-do-repositorio.git)
