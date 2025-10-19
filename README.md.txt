# 💰 Cofrinho de Moedas

Projeto desenvolvido em Java com o objetivo de simular um **cofrinho virtual**, permitindo ao usuário **adicionar, remover e listar moedas**, além de consultar o **total convertido em reais** e visualizar um **histórico de operações** realizadas.

---

## 🚀 Funcionalidades

* **Adicionar moedas** de diferentes tipos (Real, Dólar, Euro)
* **Remover moedas**, total ou parcialmente
* **Listar todas as moedas** armazenadas no cofrinho
* **Calcular o total em Reais**, convertendo as moedas com base em taxas definidas
* **Consultar histórico** de todas as operações realizadas

---

## 🧩 Estrutura do Projeto

```
📂 Cofrinho/
 ┣ 📂 src/app/         → Código-fonte principal (.java)
 ┣ 📂 bin/app/         → Arquivos compilados (.class)
 ┣ 📜 README.md
```

> 🗒️ **Obs.:** A pasta `bin/` é criada automaticamente durante a compilação.
> Se for abrir o projeto em outro computador, ela será recriada ao compilar novamente.

---

## ⚙️ Como Executar

### 🖥️ No **VS Code**

1. Certifique-se de ter o **Java 17 ou superior** instalado.
2. Abra a pasta do projeto no VS Code.
3. Vá até `src/app/Principal.java`.
4. Clique em **Run** ou use o atalho `Ctrl + F5` para executar.

### 🧠 No **Eclipse**

1. Importe o projeto como **Java Project existente**.
2. Verifique se o build path está apontando para o **JavaSE-17**.
3. Execute o arquivo `Principal.java`.

---

## 💡 Conceitos Aplicados

O projeto faz uso dos principais conceitos de **Programação Orientada a Objetos (POO)**:

* **Abstração**: a classe `Moeda` define o comportamento genérico das moedas.
* **Herança**: classes `Real`, `Dolar` e `Euro` herdam de `Moeda`.
* **Polimorfismo**: operações genéricas tratam diferentes moedas de forma uniforme.
* **Encapsulamento**: controle de acesso aos atributos e métodos de forma organizada.

---

## 🧮 Conversões Utilizadas (exemplo)

* **1 Dólar = 4,98 Reais**
* **1 Euro = 5,36 Reais**

---

🧠 *Projeto desenvolvido para fins de estudo em Programação Orientada a Objetos.*
