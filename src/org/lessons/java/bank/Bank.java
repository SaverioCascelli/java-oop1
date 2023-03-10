package org.lessons.java.bank;

import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Bank {
    public static void main(String[] args) {
        Conto conto1 = new Conto();
        Scanner scan = new Scanner(System.in);

        System.out.println("Inserisci il nome per il conto");
        String name = scan.nextLine();
        conto1.setName(name);

        boolean menuQuit = false;
        int choice;
        while (!menuQuit) {
            System.out.println("Il tuo conto:");
            System.out.println(conto1);

            System.out.println("Seleziona:");
            System.out.println("1 Per fare un deposito");
            System.out.println("2 Per prelevare");
            System.out.println("3 Per uscire");

            choice = parseInt(scan.nextLine());
            double amount;
            switch (choice) {
                case 1:
                    System.out.println("Quanto vuoi depositare?");
                    amount = parseDouble(scan.nextLine());
                    if (conto1.deposit(amount)) {
                        System.out.println("Deposito effettuato correttamente");
                    } else System.out.println("Il deposito deve essere superiore a 0");
                    break;
                case 2:
                    if (conto1.getBalance() == 0) {
                        System.out.println("***********Non hai soldi da prelevare sul conto**********");
                        break;
                    }
                    System.out.println("Quanto vuoi prelevare?");
                    System.out.println("Importo massimo: " + conto1.formattedBalance());
                    amount = parseDouble(scan.nextLine());
                    if (conto1.withdraw(amount)) {
                        System.out.println("Prelievo effettuato correttamente");
                        System.out.println("Nuovo saldo: " + conto1.formattedBalance());
                    } else System.out.println("Prelievo negato, non puoi superare il tuo saldo");
                    break;
                case 3:
                    menuQuit = true;
                    break;
                default:
                    System.out.println("******Fare una selezioni tra quelle elencate******");
            }

        }
    }
}
