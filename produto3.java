import java.util.Scanner;

class PRODUTO {
    int numeroProduto;
    double preco;

    public PRODUTO(int numeroProduto, double preco) {
        this.numeroProduto = numeroProduto;
        this.preco = preco;
    }

    // Calcula o desconto do produto
    public double calcularDesconto() {
        if (preco > 100) {
            return preco * 0.15;
        } else {
            return preco * 0.05;
        }
    }
}

class CLIENTE {
    int numeroCliente;
    String nome;
    char sexo;

    public CLIENTE(int numeroCliente, String nome, char sexo) {
        this.numeroCliente = numeroCliente;
        this.nome = nome;
        this.sexo = sexo;
    }

    // Calcula o desconto adicional
    public double calcularDescontoAdicional(double precoComDesconto) {
        if (sexo == 'F' || sexo == 'f') {
            return precoComDesconto * 0.05;
        } else {
            return 0;
        }
    }
}

class COMPRA {
    int numeroProduto;
    int numeroCliente;
    int quantidade;
    double valorTotal;

    public COMPRA(int numeroProduto, int numeroCliente, int quantidade) {
        this.numeroProduto = numeroProduto;
        this.numeroCliente = numeroCliente;
        this.quantidade = quantidade;
    }

    // Calcula o valor total da compra
    public void calcularValorTotal(double precoFinal) {
        valorTotal = quantidade * precoFinal;
    }
}

public class produto3 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // =========================
        // CADASTRO DOS PRODUTOS
        // =========================

        PRODUTO[] produtos = new PRODUTO[3];

        for (int i = 0; i < 3; i++) {

            System.out.println("\n--- Cadastro do Produto " + (i + 1) + " ---");

            System.out.print("Número do produto: ");
            int numero = entrada.nextInt();

            double preco;

            do {
                System.out.print("Preço do produto: R$ ");
                preco = entrada.nextDouble();

                if (preco < 20 || preco > 350) {
                    System.out.println("Preço inválido! Digite entre R$ 20,00 e R$ 350,00.");
                }

            } while (preco < 20 || preco > 350);

            produtos[i] = new PRODUTO(numero, preco);
        }

        // =========================
        // CADASTRO DOS CLIENTES
        // =========================

        CLIENTE[] clientes = new CLIENTE[3];

        for (int i = 0; i < 3; i++) {

            System.out.println("\n--- Cadastro do Cliente " + (i + 1) + " ---");

            System.out.print("Número do cliente: ");
            int numero = entrada.nextInt();

            entrada.nextLine();

            System.out.print("Nome do cliente: ");
            String nome = entrada.nextLine();

            char sexo;

            do {
                System.out.print("Sexo (M/F): ");
                sexo = entrada.next().charAt(0);

                if (sexo != 'M' && sexo != 'm' &&
                        sexo != 'F' && sexo != 'f') {

                    System.out.println("Sexo inválido! Digite M ou F.");
                }

            } while (sexo != 'M' && sexo != 'm' &&
                    sexo != 'F' && sexo != 'f');

            clientes[i] = new CLIENTE(numero, nome, sexo);
        }

        // =========================
        // CADASTRO DA COMPRA
        // =========================

        System.out.println("\n========== COMPRA ==========");

        System.out.print("Número do produto: ");
        int numeroProduto = entrada.nextInt();

        System.out.print("Número do cliente: ");
        int numeroCliente = entrada.nextInt();

        System.out.print("Quantidade: ");
        int quantidade = entrada.nextInt();

        // Procurar o produto
        PRODUTO produtoEscolhido = null;

        for (int i = 0; i < 3; i++) {
            if (produtos[i].numeroProduto == numeroProduto) {
                produtoEscolhido = produtos[i];
            }
        }

        // Procurar o cliente
        CLIENTE clienteEscolhido = null;

        for (int i = 0; i < 3; i++) {
            if (clientes[i].numeroCliente == numeroCliente) {
                clienteEscolhido = clientes[i];
            }
        }

        // =========================
        // CÁLCULOS
        // =========================

        double desconto = produtoEscolhido.calcularDesconto();

        // Preço depois do desconto do produto
        double precoComDesconto = produtoEscolhido.preco - desconto;

        // Desconto adicional do cliente
        double descontoAdicional = clienteEscolhido.calcularDescontoAdicional(precoComDesconto);

        // Preço final
        double precoFinal = precoComDesconto - descontoAdicional;

        // Criar compra
        COMPRA compra = new COMPRA(
                numeroProduto,
                numeroCliente,
                quantidade);

        compra.calcularValorTotal(precoFinal);

        // =========================
        // MOSTRAR RESULTADO
        // =========================

        System.out.println("\n========== RESULTADO ==========");

        System.out.println("Cliente: " + clienteEscolhido.nome);
        System.out.println("Produto: " + produtoEscolhido.numeroProduto);

        System.out.printf("Preço original: R$ %.2f%n",
                produtoEscolhido.preco);

        System.out.printf("Desconto do produto: R$ %.2f%n",
                desconto);

        System.out.printf("Desconto adicional: R$ %.2f%n",
                descontoAdicional);

        System.out.printf("Preço final por unidade: R$ %.2f%n",
                precoFinal);

        System.out.println("Quantidade: " + quantidade);

        System.out.printf("VALOR TOTAL: R$ %.2f%n",
                compra.valorTotal);

        entrada.close();
    }
}