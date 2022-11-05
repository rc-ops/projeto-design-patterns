import facade.AccManagement;
import singleton.Connection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = Connection.getInstance();
        //Connection connection1 = Connection.getInstance();

        // Memory addresses

        //System.out.println(connection);
        //System.out.println(connection1);

        if (connection.Authentication()) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Por favor insira o número da sua conta: ");
            String numeroConta = sc.next();
            System.out.print("Agora insira o código de segurança: ");
            int codigo = sc.nextInt();
            AccManagement accManagement = new AccManagement(numeroConta, codigo);

            if (accManagement.isAuthorized()) {
                System.out.println("Antes do saque: ");
                accManagement.verSaldo();
                System.out.println("Realizando saque...");
                accManagement.retirarDinheiro(200);
                accManagement.verSaldo();

                System.out.println("Realizando um depósito...");
                accManagement.depositarDinheiro(200);
                accManagement.verSaldo();
            }
            else {
                accManagement.showUnauthorizedMessage();
            }
        }
    }
}
