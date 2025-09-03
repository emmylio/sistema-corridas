package app;

import java.util.ArrayList;
import java.util.Scanner;

import model.CentralDeInformacoes;
import model.Corrida;
import model.Passageiro;
import model.Sexo;

public class Main {
    public static <Persistencia> void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persistencia persistencia = new Persistencia();

        // Recupera a central salva no XML ou cria uma nova
        CentralDeInformacoes central = persistencia.recuperarCentral("central.xml");

        String opcao = "";
        while (!opcao.equalsIgnoreCase("S")) {
            System.out.println("\nMenu:");
            System.out.println("1 - Novo passageiro");
            System.out.println("2 - Listar todos os passageiros");
            System.out.println("3 - Exibir informações de um passageiro específico");
            System.out.println("4 - Nova corrida");
            System.out.println("5 - Listar todas as corridas");
            System.out.println("6 - Listar corridas de um passageiro");
            System.out.println("S - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Sexo (MASCULINO/FEMININO): ");
                    Sexo sexo = Sexo.valueOf(sc.nextLine().toUpperCase());

                    System.out.print("Data de nascimento (yyyy-MM-dd): ");
                    String data = sc.nextLine(); // depois pode converter p/ Date

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Passageiro novo = new Passageiro(nome, sexo, dataNascimento, email);
                    if (central.adicionarPassageiro(novo)) {
                        persistencia.salvarCentral(central, "central.xml");
                        System.out.println("Passageiro cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: Passageiro já existe ou é menor de 18 anos.");
                    }
                    break;

                case "2":
                    for (Passageiro p : central.getTodosOsPassageiros()) {
                        System.out.println(p);
                    }
                    break;

                case "3":
                    System.out.print("Email do passageiro: ");
                    String emailBusca = sc.nextLine();
                    Passageiro encontrado = central.recuperarPassageiroPeloEmail(emailBusca);
                    if (encontrado == null) {
                        System.out.println("Passageiro não encontrado.");
                    } else {
                        System.out.println(encontrado);
                    }
                    break;

                case "4":
                    System.out.print("Email do passageiro: ");
                    String emailP = sc.nextLine();
                    Passageiro passageiro = central.recuperarPassageiroPeloEmail(emailP);
                    if (passageiro == null) {
                        System.out.println("Passageiro não encontrado.");
                    } else {
                        System.out.print("Endereço de partida: ");
                        String partida = sc.nextLine();
                        System.out.print("Endereço de destino: ");
                        String destino = sc.nextLine();

                        Corrida corrida = new Corrida(partida, destino, passageiro);
                        if (central.adicionarCorrida(corrida)) {
                            persistencia.salvarCentral(central, "central.xml");
                            System.out.println("Corrida cadastrada!");
                        } else {
                            System.out.println("Erro: Corrida já cadastrada.");
                        }
                    }
                    break;

                case "5":
                    for (Corrida c : central.getTodasAsCorridas()) {
                        System.out.println(c);
                    }
                    break;

                case "6":
                    System.out.print("Email do passageiro: ");
                    String emailC = sc.nextLine();
                    ArrayList<Corrida> lista = central.recuperarCorridasDeUmPassageiro(emailC);
                    if (lista == null) {
                        System.out.println("Passageiro não encontrado.");
                    } else if (lista.isEmpty()) {
                        System.out.println("Nenhuma corrida encontrada.");
                    } else {
                        for (Corrida c : lista) {
                            System.out.println(c);
                        }
                    }
                    break;

                case "S":
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
