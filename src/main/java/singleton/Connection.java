package singleton;

import java.util.Scanner;

public class Connection {
    // Ao criar uma instância em uma variável estática, a JVM garante que o código seja thread safe
    private static Connection connection = new Connection();
    private Scanner sc = new Scanner(System.in);

    private Connection() {
    }

    public static Connection getInstance() {
        return connection;
    }

    public boolean Authentication() {
        System.out.print("Insira o seu usuário: ");
        String usuario = sc.nextLine();
        System.out.print("Insira sua senha: ");
        String senha = sc.nextLine();
        if (usuario.equals("admin") && senha.equals("admin")) {
            System.out.println("Autenticado com sucesso.");
            return true;
        } else {
            showUnauthorizedMessage();
            return false;
        }
    }

    private void showUnauthorizedMessage() {
        System.out.println("Usuário ou senha incorretos. Até a próxima.");
    }
}
