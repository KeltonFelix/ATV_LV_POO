import java.util.Scanner;

class Pessoa {

    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public int idadeEmMeses() {
        return 12 * idade;
    }

    public int idadeEm2050() {
        int anoAtual = 2026;
        return idade + (2050 - anoAtual);
    }

    public class Main {
        public static void main(String[] args) {

            Scanner entrada = new Scanner(System.in);

            System.out.println("Digite seu nome: ");
            String nome = entrada.nextLine();

            System.out.println("Digite a idade: ");
            int idade = entrada.nextInt();

            Pessoa pessoa = new Pessoa(nome, idade);

            System.out.println("\n Nome: " + pessoa.nome);
            System.out.println("idade em meses : " + pessoa.idadeEmMeses());
            System.out.println("Idade em 2050: " + pessoa.idadeEm2050());

            entrada.close();

        }
    }
}
