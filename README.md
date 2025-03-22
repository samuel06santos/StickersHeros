# Stickers Heroes

## Descrição:
O **Stickers Heroes** permite gerenciar uma lista de super-heróis, incluindo adicionar, remover, atualizar e listar heróis. A interface gráfica é construída usando [Java Swing](https://docs.oracle.com/javase/8/docs/technotes/guides/swing/index.html) e [JavaFX](https://openjfx.io/).

## Desenvolvedores (Integrantes):

- | [João Samuel Dias Santos](https://github.com/samuel06santos) | [Kim Lima de Lima](https://github.com/kimlimalima) |
    |-------------------------------------------------------------|----------------------------------------------------------|
  | ![Foto do Perfil](https://github.com/samuel06santos.png) | ![Foto do Perfil](https://github.com/kimlimalima.png) |

## [Video Demonstrativo (YouTube)](https://youtu.be/SXmKnh9Gsqk?si=SsAst5-52I8_I0mj):
[![Video Demonstrativo](https://img.youtube.com/vi/SXmKnh9Gsqk/0.jpg)](https://youtu.be/SXmKnh9Gsqk?si=SsAst5-52I8_I0mj)

## Como Rodar a Aplicação:

### Pré-requisitos:
- Java JDK 17 ou superior
- JavaFX SDK 21.0.6
- Biblioteca Gson 2.8.9

### Passos para Executar:
1. Clone o repositório:
    ```sh
    git clone https://github.com/samuel06santos/StickersHeros.git
    cd StickersHeros
    ```

2. Abra o projeto na sua IDE.

3. Configure o SDK do Java e o caminho do JavaFX:

4. Adicione a biblioteca Gson ao projeto:

5. Configure o `module-info.java`:
    ```java
    module StickersHeros {
        requires javafx.controls;
        requires javafx.fxml;
        requires javafx.media;
        requires javafx.swing;
        requires com.google.gson;

        exports views;
        opens models to com.google.gson;
    }
    ```

6. Execute a aplicação:
    - Navegue até a classe `main.Main` e execute o método `main`.

## Estrutura do Projeto:
- `src/main`: Contém a classe principal para iniciar a aplicação.
- `src/views`: Contém a interface gráfica da aplicação.
- `src/models`: Contém as classes de modelo, incluindo `SuperHero` e `SuperHeroManager`.
- `src/controllers`: Contém as classes de controle para gerenciar a lógica da aplicação.

## Funcionalidades:
- Adicionar um novo herói
- Remover um herói existente
- Atualizar informações de um herói
- Listar todos os heróis
- Navegar entre os heróis
- Exibir imagem e vídeo do herói