import java.util.Scanner;

class ALUNO {
    int codigo;
    String nome;

    public ALUNO(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
}

class DISCIPLINA {
    int codigo;
    String nome;
    int cargaHoraria;

    public DISCIPLINA(int codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    // Média normal
    public double calcularMedia(double n1, double n2, double n3, double n4) {
        return (n1 + n2 + n3 + n4) / 4;
    }
}

class DISCIPLINAPRATICA extends DISCIPLINA {
    int cargaPratica;

    public DISCIPLINAPRATICA(int codigo, String nome, int cargaHoraria,
            int cargaPratica) {

        super(codigo, nome, cargaHoraria);
        this.cargaPratica = cargaPratica;
    }

    // Média ponderada
    public double calcularMedia(double n1, double n2, double n3, double n4) {
        return (n1 + n2 * 2 + n3 + n4 * 2) / 6;
    }
}

class MATRICULA {
    int anoLetivo;
    int serie;

    ALUNO aluno;
    DISCIPLINA disciplina;

    double nota1Bim;
    double nota2Bim;
    double nota3Bim;
    double nota4Bim;

    public MATRICULA(int anoLetivo, int serie, ALUNO aluno,
            DISCIPLINA disciplina) {

        this.anoLetivo = anoLetivo;
        this.serie = serie;
        this.aluno = aluno;
        this.disciplina = disciplina;

        // Notas começam com zero
        nota1Bim = 0;
        nota2Bim = 0;
        nota3Bim = 0;
        nota4Bim = 0;
    }

    public double calcularMedia() {
        return disciplina.calcularMedia(
                nota1Bim,
                nota2Bim,
                nota3Bim,
                nota4Bim);
    }
}

public class Matricula4 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // =========================
        // VETORES
        // =========================

        ALUNO[] alunos = new ALUNO[10];

        // Um único vetor para disciplinas normais e práticas
        DISCIPLINA[] disciplinas = new DISCIPLINA[5];

        MATRICULA[] matriculas = new MATRICULA[30];

        int qtdAlunos = 0;
        int qtdDisciplinas = 0;
        int qtdMatriculas = 0;

        int opcao;

        // =========================
        // MENU
        // =========================

        do {

            System.out.println("\n========== SECRETARIA ESCOLAR ==========");
            System.out.println("1 - Cadastrar disciplina");
            System.out.println("2 - Cadastrar aluno");
            System.out.println("3 - Matricular aluno");
            System.out.println("4 - Lançar nota");
            System.out.println("5 - Mostrar boletim");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            // ==================================================
            // 1 - CADASTRAR DISCIPLINA
            // ==================================================

            if (opcao == 1) {

                if (qtdDisciplinas >= 5) {

                    System.out.println("Limite de 5 disciplinas atingido!");

                } else {

                    System.out.println("\n--- CADASTRO DE DISCIPLINA ---");

                    System.out.print("Código: ");
                    int codigo = entrada.nextInt();

                    // Verificar código único
                    boolean existe = false;

                    for (int i = 0; i < qtdDisciplinas; i++) {

                        if (disciplinas[i].codigo == codigo) {
                            existe = true;
                        }
                    }

                    if (existe) {

                        System.out.println("Código já cadastrado!");

                    } else {

                        entrada.nextLine();

                        System.out.print("Nome: ");
                        String nome = entrada.nextLine();

                        System.out.print("Carga horária geral: ");
                        int cargaHoraria = entrada.nextInt();

                        System.out.print("É prática? (1-Sim / 2-Não): ");
                        int pratica = entrada.nextInt();

                        if (pratica == 1) {

                            System.out.print("Carga horária prática: ");
                            int cargaPratica = entrada.nextInt();

                            disciplinas[qtdDisciplinas] = new DISCIPLINAPRATICA(
                                    codigo,
                                    nome,
                                    cargaHoraria,
                                    cargaPratica);

                        } else {

                            disciplinas[qtdDisciplinas] = new DISCIPLINA(
                                    codigo,
                                    nome,
                                    cargaHoraria);
                        }

                        qtdDisciplinas++;

                        System.out.println("Disciplina cadastrada!");
                    }
                }
            }

            // ==================================================
            // 2 - CADASTRAR ALUNO
            // ==================================================

            else if (opcao == 2) {

                if (qtdAlunos >= 10) {

                    System.out.println("Limite de 10 alunos atingido!");

                } else {

                    System.out.println("\n--- CADASTRO DE ALUNO ---");

                    System.out.print("Código: ");
                    int codigo = entrada.nextInt();

                    // Verificar código único
                    boolean existe = false;

                    for (int i = 0; i < qtdAlunos; i++) {

                        if (alunos[i].codigo == codigo) {
                            existe = true;
                        }
                    }

                    if (existe) {

                        System.out.println("Código já cadastrado!");

                    } else {

                        entrada.nextLine();

                        System.out.print("Nome: ");
                        String nome = entrada.nextLine();

                        alunos[qtdAlunos] = new ALUNO(codigo, nome);

                        qtdAlunos++;

                        System.out.println("Aluno cadastrado!");
                    }
                }
            }

            // ==================================================
            // 3 - MATRICULAR ALUNO
            // ==================================================

            else if (opcao == 3) {

                if (qtdMatriculas >= 30) {

                    System.out.println("Limite de 30 matrículas atingido!");

                } else {

                    System.out.println("\n--- MATRÍCULA ---");

                    System.out.print("Código do aluno: ");
                    int codigoAluno = entrada.nextInt();

                    System.out.print("Código da disciplina: ");
                    int codigoDisciplina = entrada.nextInt();

                    System.out.print("Ano letivo: ");
                    int ano = entrada.nextInt();

                    System.out.print("Série: ");
                    int serie = entrada.nextInt();

                    ALUNO alunoEncontrado = null;
                    DISCIPLINA disciplinaEncontrada = null;

                    // Procurar aluno
                    for (int i = 0; i < qtdAlunos; i++) {

                        if (alunos[i].codigo == codigoAluno) {
                            alunoEncontrado = alunos[i];
                        }
                    }

                    // Procurar disciplina
                    for (int i = 0; i < qtdDisciplinas; i++) {

                        if (disciplinas[i].codigo == codigoDisciplina) {
                            disciplinaEncontrada = disciplinas[i];
                        }
                    }

                    if (alunoEncontrado == null) {

                        System.out.println("Aluno não encontrado!");

                    } else if (disciplinaEncontrada == null) {

                        System.out.println("Disciplina não encontrada!");

                    } else {

                        // Verificar matrícula repetida
                        boolean repetida = false;

                        for (int i = 0; i < qtdMatriculas; i++) {

                            if (matriculas[i].aluno.codigo == codigoAluno &&
                                    matriculas[i].disciplina.codigo == codigoDisciplina &&
                                    matriculas[i].anoLetivo == ano) {

                                repetida = true;
                            }
                        }

                        if (repetida) {

                            System.out.println(
                                    "Aluno já matriculado nessa disciplina neste ano!");

                        } else {

                            matriculas[qtdMatriculas] = new MATRICULA(
                                    ano,
                                    serie,
                                    alunoEncontrado,
                                    disciplinaEncontrada);

                            qtdMatriculas++;

                            System.out.println("Matrícula realizada!");
                        }
                    }
                }
            }

            // ==================================================
            // 4 - LANÇAR NOTA
            // ==================================================

            else if (opcao == 4) {

                System.out.println("\n--- LANÇAMENTO DE NOTA ---");

                System.out.print("Código do aluno: ");
                int codigoAluno = entrada.nextInt();

                System.out.print("Código da disciplina: ");
                int codigoDisciplina = entrada.nextInt();

                System.out.print("Ano: ");
                int ano = entrada.nextInt();

                System.out.print("Bimestre (1 a 4): ");
                int bimestre = entrada.nextInt();

                MATRICULA matriculaEncontrada = null;

                // Procurar matrícula
                for (int i = 0; i < qtdMatriculas; i++) {

                    if (matriculas[i].aluno.codigo == codigoAluno &&
                            matriculas[i].disciplina.codigo == codigoDisciplina &&
                            matriculas[i].anoLetivo == ano) {

                        matriculaEncontrada = matriculas[i];
                    }
                }

                if (matriculaEncontrada == null) {

                    System.out.println("Matrícula Inválida.");

                } else if (bimestre < 1 || bimestre > 4) {

                    System.out.println("Bimestre inválido!");

                } else {

                    double nota;

                    do {

                        System.out.print("Nota: ");
                        nota = entrada.nextDouble();

                        if (nota < 0 || nota > 10) {
                            System.out.println(
                                    "Nota inválida! Digite entre 0 e 10.");
                        }

                    } while (nota < 0 || nota > 10);

                    if (bimestre == 1) {

                        matriculaEncontrada.nota1Bim = nota;

                    } else if (bimestre == 2) {

                        matriculaEncontrada.nota2Bim = nota;

                    } else if (bimestre == 3) {

                        matriculaEncontrada.nota3Bim = nota;

                    } else {

                        matriculaEncontrada.nota4Bim = nota;
                    }

                    System.out.println("Nota lançada!");
                }
            }

            // ==================================================
            // 5 - MOSTRAR BOLETIM
            // ==================================================

            else if (opcao == 5) {

                System.out.println("\n--- BOLETIM ---");

                System.out.print("Código do aluno: ");
                int codigoAluno = entrada.nextInt();

                System.out.print("Ano: ");
                int ano = entrada.nextInt();

                boolean encontrou = false;

                for (int i = 0; i < qtdMatriculas; i++) {

                    MATRICULA m = matriculas[i];

                    if (m.aluno.codigo == codigoAluno &&
                            m.anoLetivo == ano) {

                        if (!encontrou) {

                            System.out.println("\n================ BOLETIM ================");
                            System.out.println("Código: " + m.aluno.codigo);
                            System.out.println("Nome: " + m.aluno.nome);
                            System.out.println("Ano: " + m.anoLetivo);
                            System.out.println("Série: " + m.serie);

                            System.out.println(
                                    "\nDisciplina\tCH\tCH Prática\t1º\t2º\t3º\t4º\tMédia");

                            encontrou = true;
                        }

                        int cargaPratica = 0;

                        // Verifica se a disciplina é prática
                        if (m.disciplina instanceof DISCIPLINAPRATICA) {

                            DISCIPLINAPRATICA pratica = (DISCIPLINAPRATICA) m.disciplina;

                            cargaPratica = pratica.cargaPratica;
                        }

                        System.out.printf(
                                "%-15s\t%d\t%d\t\t%.1f\t%.1f\t%.1f\t%.1f\t%.2f%n",
                                m.disciplina.nome,
                                m.disciplina.cargaHoraria,
                                cargaPratica,
                                m.nota1Bim,
                                m.nota2Bim,
                                m.nota3Bim,
                                m.nota4Bim,
                                m.calcularMedia());
                    }
                }

                if (!encontrou) {

                    System.out.println("Matrícula Inválida.");
                }
            }

            // ==================================================
            // OPÇÃO INVÁLIDA
            // ==================================================

            else if (opcao != 0) {

                System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    }
}