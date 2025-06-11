# Sistema de Controle de Ônibus

Este é um projeto acadêmico desenvolvido por estudantes da Universidade Positivo, com o objetivo de simular um sistema de gerenciamento de uma empresa de ônibus. O sistema foi construído utilizando Java puro e segue o padrão arquitetural MVC (Model-View-Controller).

## Informações Gerais

O sistema permite realizar o controle de passageiros, motoristas, ônibus, passagens e viagens. Todas as informações são persistidas por meio de arquivos `.txt`, garantindo que os dados não sejam perdidos entre execuções. Além disso, um arquivo de log (`log.txt`) registra operações importantes para fins de histórico e auditoria.

## Estrutura do Projeto

projeto/
├── bin/                   # Arquivos compilados  
├── src/  
│   ├── controller/        # Controllers com operações CRUD  
│   ├── dados/             # Arquivos .txt utilizados como base de dados  
│   ├── model/             # Classes de modelo (Cliente, Motorista, etc.)  
│   ├── util/              # Utilitários (persistência e logging)  
│   ├── view/              # Interface textual com o usuário  
│   └── Main.java          # Classe principal  
├── .gitignore             # Arquivos ignorados pelo Git  
└── README.md              # Este arquivo  

## Informações sobre as Classes e suas Relações

- As classes seguem o padrão MVC:
  - **Model**: contém as entidades principais como `Cliente`, `Motorista`, `Onibus`, `Passagem` e `Viagem`.
  - **View**: interage com o usuário por meio de menus em texto, como `MenuPrincipal.java` e `ClienteView.java`.
  - **Controller**: executa a lógica de negócio, com um CRUD para cada entidade (ex: `ClienteController.java`).

- **Relações entre classes**:
  - **Associação**: As classes `Passagem` e `Viagem` possuem referências para outras entidades (por exemplo, `Cliente`, `Motorista`, `Onibus`), representando que uma instância se relaciona com outra.
  - **Composição**: As listas de objetos dentro de cada controller são compostas diretamente, por exemplo, uma `ViagemController` possui uma lista de `Viagem`.
  - **Agregação**: A relação entre as views e os controllers representa agregação, pois as views utilizam os controllers sem que estes dependam diretamente delas.

## Funcionalidades

- CRUD completo para:
  - Clientes
  - Motoristas
  - Ônibus
  - Passagens
  - Viagens
- Persistência de dados em arquivos `.txt`
- Registro de ações em arquivo de log
- Organização em camadas (MVC) com boa separação de responsabilidades

## Como Executar o Projeto

1. Compile todos os arquivos da pasta `src`:
   ```bash
   javac -d bin src/**/*.java
   ```

2. Execute a aplicação:
   ```bash
   java -cp bin Main
   ```

3. A aplicação será executada via terminal, apresentando um menu principal para acesso às funcionalidades.

## Logger

Todas as ações importantes do sistema (como criação, edição e exclusão de dados) são registradas no arquivo `log.txt`, por meio da classe `Logger.java`, garantindo controle e histórico das operações realizadas.

## Armazenamento com Arquivos .txt

Os dados da aplicação são armazenados em arquivos `.txt` localizados em `src/dados/`. Isso permite que as informações sejam mantidas mesmo após o encerramento do programa. São utilizados os seguintes arquivos:

- `clientes.txt`
- `motoristas.txt`
- `onibus.txt`
- `passagens.txt`
- `viagens.txt`
- `log.txt`

A leitura e escrita são feitas através das classes `ArquivoTXT` e `ArquivoPersistente`, com auxílio dos métodos `fromString()` implementados em cada classe de modelo.

## Uso do ChatGPT

Durante o desenvolvimento, a IA ChatGPT foi utilizada como ferramenta de apoio técnico e pedagógico. A IA auxiliou nas seguintes atividades:

- Criação do arquivo `.gitignore` para organização do repositório
- Implementação das classes de persistência e logging
- Escrita dos métodos `fromString()` para facilitar a leitura dos dados
- Estruturação dos controllers com lógica CRUD
- Organização do projeto segundo o padrão MVC
- Ajuda na criação deste arquivo `README.md`

O uso da IA contribuiu para acelerar o desenvolvimento, promover o aprendizado e garantir uma melhor organização do código.

## Referências e Recursos

- Exemplos e orientações fornecidas pelo professor em aula
- Documentação oficial da linguagem Java
- Respostas e sugestões geradas com auxílio da IA ChatGPT
