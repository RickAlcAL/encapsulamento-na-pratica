# 🚀 Sistemas em Java: Construtores e Setters (POO)

Este repositório reúne 4 sistemas práticos desenvolvidos em **Java** com o objetivo de aplicar e consolidar os pilares da **Programação Orientada a Objetos (POO)**. O foco principal do projeto é demonstrar o uso correto de **Construtores** (para inicialização obrigatória e segura de objetos) e **Setters** (para a manipulação controlada de atributos via encapsulamento).

---

## 🧠 Conceitos de POO Aplicados

Garantir a integridade dos dados dentro de um sistema é fundamental. Nestes projetos, explorei:

* **Construtores:** Garantes que os objetos nasçam com os dados mínimos necessários para sua existência e consistência no sistema.
* **Métodos Setters:** Utilizados para atualizar atributos privados de forma controlada, aplicando regras de negócio e validações antes de alterar o estado do objeto.
* **Encapsulamento:** Proteção do estado interno das classes, mantendo os atributos como `private` e expondo o acesso apenas por métodos públicos seguros.

---

## 💻 Sistemas Inclusos no Repositório

O repositório está dividido em 4 aplicações independentes:

1. **🏥 Atendimento Médico:** Gerenciamento de consultas e pacientes. O construtor garante o registro inicial do paciente, enquanto os *setters* validam alterações no status do atendimento ou sintomas.
2. **📚 Controle de Biblioteca:** Cadastro de livros e empréstimos. Utiliza construtores para registrar títulos e *setters* com validações para atualizar a disponibilidade do acervo.
3. **🛒 Sistema de Compras:** Simulação de carrinho e pedidos. Os construtores inicializam os itens com preços base, e os *setters* gerenciam quantidades, impedindo valores negativos ou nulos.
4. **🚗 Controle de Estacionamento:** Registro de entrada e saída de veículos. O construtor armazena a placa e horário de entrada, e os *setters* controlam a saída para o cálculo exato da tarifa.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java
* **Paradigma:** Orientação a Objetos (POO)
* **Arquitetura:** Divisão em classes de modelo (Entities/Models) e execução (Main).

---
