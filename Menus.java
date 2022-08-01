package OperacaoLavaJato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menus {

    List<Cliente> lavagem = new ArrayList<>();
    private int index;
    private int vagas = 0;

    Scanner menu = new Scanner(System.in);

    public void menuPrincipal() {
        System.out.println("   Menu Principal   ");
        System.out.println("____________________");
        System.out.println("| 1 - Clientes     |");
        System.out.println("| 2 - Funcionários |");
        System.out.println("| 3 - Sair         |");
        System.out.println("|__________________|");

        System.out.println("Escolha um menu");
        int menuEscolhido = menu.nextInt();
        System.out.println("");

        switch (menuEscolhido) {
            case 1:
                menuClientes();
                break;
            case 2:
                menuFuncionarios();
                break;
            case 3:
                System.out.println("Volte sempre!");
                return;

            default:
                System.out.println("Opção Inválida! Tente novamente.");
        }
    }

    public void menuClientes() {
        System.out.println("       Menu Clientes");
        System.out.println("_____________________________");
        System.out.println("| 1 - Agendar Lavagem       |");
        System.out.println("| 2 - Consultar Lavagem     |");
        System.out.println("| 3 - Cancelar Lavagem      |");
        System.out.println("| 4 - Tabela de Preços      |");
        System.out.println("| 5 - Voltar                |");
        System.out.println("|___________________________|");

        System.out.println("Escolha um menu");
        int menuEscolhido = menu.nextInt();
        System.out.println("");

        switch (menuEscolhido) {
            case 1:
                agendarLavagem();
                break;
            case 2:
                consultarLavagem();
                break;
            case 3:
                cancelarLavagem();
                break;
            case 4:
                tabelaPrecos(false);
                break;
            case 5:
                System.out.println("\nVolte Sempre!\n");
                this.menuPrincipal();
                break;
            default:
                System.out.println("\nOpção Inválida! Tente novamente.\n");
        }
    }

    public void menuFuncionarios() {
        System.out.println("     Menu Funcionários");
        System.out.println("_____________________________");
        System.out.println("| 1 - Consultar Lavagens    |");
        System.out.println("| 2 - Consultar Clientes    |");
        System.out.println("| 3 - Controle de Pagamentos|");
        System.out.println("| 4 - Vagas disponíveis     |");
        System.out.println("| 5 - Alterar dados         |");
        System.out.println("| 6 - Voltar                |");
        System.out.println("|___________________________|");

        System.out.println("Escolha um menu: ");
        int menuEscolhido = menu.nextInt();
        System.out.println("");

        switch (menuEscolhido) {
            case 1:
                consultandoLavagens();
                break;
            case 2:
                consultandoClientes();
                break;
            case 3:
                controlePagamentos();
                break;
            case 4:
                vagas();
                break;
            case 5:
                alterarDados();
                break;
            case 6:
                System.out.println("\nBom Trabalho!\n");
                menuPrincipal();
                break;
            default:
                System.out.println("\nOpção Inválida! Tente novamente.\n");
        }
    }

    public void agendarLavagem() {
        if (vagas == 3) {
            System.out.println("Sem vagas disponíveis para hoje. Tente novamente amanhã!");
            System.out.println("");
            this.menuClientes();
            return;
        } else {
            vagas++;
        }

        Cliente c = new Cliente();
        Scanner input = new Scanner(System.in);
        String inputVeiculoEscolhido;

        System.out.println("Area de agendamento");

        System.out.println("Informe seu nome: ");
        c.setNome(input.next());

        System.out.println("Informe seu telefone: ");
        c.setTelefone(input.next());

        System.out.println("Informe a placa do veículo: ");
        c.setPlaca(input.next());
        System.out.println("");

        tabelaPrecos(true);

        System.out.println("");
        System.out.println("Informe o tipo de veículo: ");
        System.out.println("____________________");
        System.out.println("| 1 - Carro pequeno|");
        System.out.println("| 2 - Carro grande |");
        System.out.println("| 3 - Moto         |");
        System.out.println("| 4 - Caminhão     |");
        System.out.println("|__________________|");

        inputVeiculoEscolhido = input.next();

        switch (inputVeiculoEscolhido) {
            case "1":
                c.setVeiculo("Carro Pequeno");
                c.setPreco(25);
                break;
            case "2":
                c.setVeiculo("Carro Grande");
                c.setPreco(35);
                break;
            case "3":
                c.setVeiculo("Moto");
                c.setPreco(20);
                break;
            case "4":
                c.setVeiculo("Caminhão");
                c.setPreco(90);
                break;
            default:
                System.out.println("Opção Inválida!");
                System.out.println("");
                this.menuClientes();
        }
        c.setStatusCancelado(false);
        c.setAgendamento(true);
        c.setStatusLavagem("aguardando");
        System.out.println("\nAgendamento confirmado!");
        System.out.println("Informações da lavagem:");
        System.out.println("Veículo selecionado para lavagem: " + c.getVeiculo());
        System.out.println("Lavagem do veículo de placa: " + c.getPlaca());
        System.out.println("Valor a ser pago R$ " + c.getPreco());
        System.out.println("");
        lavagem.add(c);
        this.menuClientes();
    }

    public void consultarLavagem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual é a placa do veículo?");
        String placa = input.next();

        if (placaEncontrada(placa) == false) {
            System.out.println("Veículo não encontrado.");
            System.out.println("");
            this.menuClientes();
        } else {
            Cliente c = lavagem.get(index);
            System.out.println("Status da Lavagem: " + c.getStatusLavagem());
            System.out.println("");
            this.menuClientes();
            return;
        }
    }

    public void cancelarLavagem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual é a placa do veículo?");
        String placa = input.next();

        if (placaEncontrada(placa) == false) {
            System.out.println("Veículo não encontrado.");
            System.out.println("");
            this.menuClientes();
        } else {
            Cliente c = lavagem.get(index);
            if (c.isStatusCancelado() == true) {
                System.out.println("Veículo não encontrado.");
                System.out.println("");
                this.menuClientes();
            }

            System.out.println("Deseja prosseguir com o cancelamento?");
            System.out.println("1 - sim | 2 - não");
            int opcao = input.nextInt();

            if (opcao == 1) {
                c.setStatusCancelado(true);
                System.out.println("Lavagem cancelada.");
                c.setAgendamento(false);
                c.setStatusLavagem("Lavagem foi cancelada pelo cliente.");
            } else {
                System.out.println("Lavagem não cancelada.");
            }

            System.out.println("");
            this.menuClientes();
        }
    }

    public void tabelaPrecos(boolean ehAgendamento) {
        System.out.println("Preços:");
        System.out.println("Carro pequeno: R$ 25");
        System.out.println("Carro grande: R$ 35");
        System.out.println("Moto: R$ 20");
        System.out.println("Caminhão: R$ 90");
        System.out.println("");

        if (ehAgendamento == false) {
            this.menuClientes();
        }
    }

    public void consultandoLavagens() {
        for (Cliente c : lavagem) {
            if (c.isAgendamento() == true) {
                System.out.println("Nome: " + c.getNome());
                System.out.println("Telefone: " + c.getTelefone());
                System.out.println("Carro: " + c.getVeiculo());
                System.out.println("Placa: " + c.getPlaca());
                System.out.println("Preço Lavagem: " + c.getPreco());
                System.out.println("Status Lavagem: " + c.getStatusLavagem());
                if (c.isStatusPagamento() == true) {
                    System.out.println("Status de pagamento: Pago.");
                } else {
                    System.out.println("Status de pagamento: Não pago.");
                }
                System.out.println("_________________________________________________");
            }
        }

        System.out.println("");
        menuFuncionarios();
    }

    public void consultandoClientes() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual é a placa do veículo?");
        String placa = input.next();
        if (placaEncontrada(placa) == false) {
            System.out.println("Cliente não encontrado.");
            System.out.println("");
            this.menuFuncionarios();
        } else {
            Cliente c = lavagem.get(index);
            System.out.println("Nome: " + c.getNome());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Carro: " + c.getVeiculo());
            System.out.println("Placa: " + c.getPlaca());
            System.out.println("Preço Lavagem: " + c.getPreco());
            System.out.println("Status Lavagem: " + c.getStatusLavagem());
            if (c.isStatusPagamento() == true) {
                System.out.println("Status de pagamento: Pago.");
            } else {
                System.out.println("Status de pagamento: Não pago.");
            }
            System.out.println("");
            menuFuncionarios();
        }
    }

    public boolean placaEncontrada(String placa) {
        for (int i = 0; i < lavagem.size(); i++) {
            Cliente c = lavagem.get(i);
            if (placa.equals(c.getPlaca())) {
                index = i;
                return true;
            }
        }
        return false;
    }

    public void menuStatusLavagem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1 - Aguardando Lavagem");
        System.out.println("2 - Pronto"); 
        System.out.println("3 - Cancelado");
        System.out.println("4 - Voltar");
        int op = input.nextInt();
        switch (op) {
            case 1:
                lavagem.get(index).setStatusLavagem("aguardando");
                System.out.println("Status de lavagem alterado para aguardando.");
                System.out.println("");
                break;
            case 2:
                lavagem.get(index).setStatusLavagem("pronto");
                System.out.println("Status de lavagem alterado para pronto.");
                System.out.println("");
                break;
            case 3:
                lavagem.get(index).setStatusLavagem("cancelado");
                System.out.println("A Lavagem foi cancelada.");
                System.out.println("");
                break;
            case 4:
                menuFuncionarios();
                break;
            default:

                System.out.println("Opção inválida!");
                menuFuncionarios();
        }
        menuFuncionarios();
    }

    public void menuStatusPagamento() {
        Scanner input = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("Status Pagamento");
        System.out.println("1 - Pago");
        System.out.println("2 - Não pago");
        System.out.println("3 - Voltar");
        int op2 = input.nextInt();
        switch (op2) {
            case 1:
                System.out.println("Pago.");
                lavagem.get(index).setStatusPagamento(true);
                menuFuncionarios();
                break;
            case 2:
                System.out.println("Não pago.");
                lavagem.get(index).setStatusPagamento(false);
                menuFuncionarios();
                break;
            case 3:
                menuFuncionarios();
                break;
            default:
                System.out.println("Opção inválida!");
                menuFuncionarios();
        }
    }

    public void alterarDados() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual é a placa do veículo?");
        String placa = input.next();
        if (placaEncontrada(placa) == false) {
            System.out.println("Cliente não encontrado.");
            menuFuncionarios();
        } else {
            System.out.println("______________________");
            System.out.println("|1 - Status lavagem  |");
            System.out.println("|2 - Status pagamento|");
            System.out.println("|3 - Voltar          |");
            System.out.println("|____________________|");
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    menuStatusLavagem();
                    break;
                case 2:
                    menuStatusPagamento();
                    break;
                case 3:
                    menuFuncionarios();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    menuFuncionarios();
            }
        }
    }

    public void controlePagamentos() {
        int soma = 0;
        for (Cliente c : lavagem) {
            if (c.isStatusPagamento() == true) {
                soma += c.getPreco();
            }
        }
        System.out.println("Total arrecadado no dia: " + soma);
        System.out.println("");
        menuFuncionarios();
    }

    public void vagas() {
        int soma = 0;
        for (Cliente c : lavagem) {
            if (c.isAgendamento() == true) {
                soma++;
            }
        }
        System.out.println("Total de vagas disponíveis: " + (3 - soma));
        System.out.println("");
        menuFuncionarios();
    }
}

    