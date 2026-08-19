import java.util.Scanner;

public class carro1 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String[] placa = new String[5];
        int[] anoFabricacao = new int[5];

        System.out.print("Digite o ano atual: ");
        int anoAtual = entrada.nextInt();

        for (int i = 0; i < 5; i++) {

            System.out.println("\n--- Cadastro do carro " + (i + 1) + " ---");

            System.out.print("Digite a placa: ");
            placa[i] = entrada.next();

            System.out.print("Digite o ano de fabricação: ");
            anoFabricacao[i] = entrada.nextInt();
        }

        System.out.println("          RESULTADOS");

        double totalImpostos = 0;
        int carrosIsentos = 0;

        for (int i = 0; i < 5; i++) {

            int idade = anoAtual - anoFabricacao[i];

            double imposto;

            if (idade >= 10) {
                imposto = 0;
            } else {

                imposto = 500 - (idade * 100);

                if (imposto < 100) {
                    imposto = 100;
                }
            }

            System.out.println("\nCarro " + (i + 1) + ":");
            System.out.println("  Placa: " + placa[i]);
            System.out.println("  Ano de fabricação: " + anoFabricacao[i]);
            System.out.println("  Idade: " + idade + " anos");
            System.out.printf("  Imposto: R$ %.2f\n", imposto);

            totalImpostos = totalImpostos + imposto;

            if (imposto == 0) {
                carrosIsentos = carrosIsentos + 1;
            }
        }

        System.out.println("\n-----------------------------------------");
        System.out.printf(
                "TOTAL DE IMPOSTOS A PAGAR: R$ %.2f\n",
                totalImpostos);

        System.out.println(
                "CARROS QUE NÃO PAGAM IMPOSTO: " + carrosIsentos);

        entrada.close();
    }
}