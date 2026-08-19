import java.util.Scanner;

class Funcionario {
    private int numeroFuncionario;
    private String nomeFuncionario, cargo;
    private double salario;

    public Funcionario(int n, String nome, String cargo, double salario) {
        this.numeroFuncionario = n;
        this.nomeFuncionario = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setNumeroFuncionario(int n) {
        numeroFuncionario = n;
    }

    public void setNomeFuncionario(String n) {
        nomeFuncionario = n;
    }

    public void setCargo(String c) {
        cargo = c;
    }

    public void setSalario(double s) {
        salario = s;
    }
}

class Dependente {
    private Funcionario funcionario;
    private String nomeDependente;

    public Dependente(Funcionario f, String nome) {
        funcionario = f;
        nomeDependente = nome;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getNomeDependente() {
        return nomeDependente;
    }

    public void setFuncionario(Funcionario f) {
        funcionario = f;
    }

    public void setNomeDependente(String n) {
        nomeDependente = n;
    }
}

public class funcionario5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Funcionario[] f = new Funcionario[10];
        Dependente[] d = new Dependente[30];
        int qf = 0, qd = 0, op;

        do {
            System.out.println("\n1-Cadastrar  2-Bônus  3-Excluir  4-Alterar  0-Sair");
            op = s.nextInt();

            if (op == 1) {
                System.out.print("Código: ");
                int n = s.nextInt();
                boolean existe = false;
                for (int i = 0; i < qf; i++)
                    if (f[i].getNumeroFuncionario() == n)
                        existe = true;

                if (existe)
                    System.out.println("Código já existe!");
                else if (qf == 10)
                    System.out.println("Vetor cheio!");
                else {
                    s.nextLine();
                    System.out.print("Nome: ");
                    String nome = s.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = s.nextLine();
                    System.out.print("Salário: ");
                    double sal = s.nextDouble();

                    f[qf] = new Funcionario(n, nome, cargo, sal);
                    Funcionario fun = f[qf++];

                    System.out.print("Quantidade de dependentes: ");
                    int qtd = s.nextInt();

                    if (qd + qtd > 30)
                        System.out.println("Espaço insuficiente!");
                    else {
                        for (int i = 0; i < qtd; i++) {
                            s.nextLine();
                            System.out.print("Nome do dependente: ");
                            d[qd++] = new Dependente(fun, s.nextLine());
                        }
                    }
                }
            }

            else if (op == 2) {
                for (int i = 0; i < qf; i++) {
                    int qtd = 0;
                    for (int j = 0; j < qd; j++)
                        if (d[j].getFuncionario() == f[i])
                            qtd++;

                    System.out.printf("%s - %d dependentes - Bônus: R$ %.2f%n",
                            f[i].getNomeFuncionario(), qtd,
                            f[i].getSalario() * qtd * 0.02);
                }
            }

            else if (op == 3) {
                System.out.print("Código: ");
                int n = s.nextInt();
                int pos = -1;

                for (int i = 0; i < qf; i++)
                    if (f[i].getNumeroFuncionario() == n)
                        pos = i;

                if (pos == -1)
                    System.out.println("Funcionário Inexistente");
                else {
                    Funcionario fun = f[pos];

                    for (int i = 0; i < qd;)
                        if (d[i].getFuncionario() == fun) {
                            d[i] = d[--qd];
                        } else
                            i++;

                    f[pos] = f[--qf];
                    System.out.println("Funcionário excluído!");
                }
            }

            else if (op == 4) {
                System.out.print("Código: ");
                int n = s.nextInt();
                Funcionario fun = null;

                for (int i = 0; i < qf; i++)
                    if (f[i].getNumeroFuncionario() == n)
                        fun = f[i];

                if (fun == null)
                    System.out.println("Funcionário Inexistente");
                else {
                    System.out.print("Novo salário: ");
                    fun.setSalario(s.nextDouble());
                }
            }

        } while (op != 0);

        s.close();
    }
}