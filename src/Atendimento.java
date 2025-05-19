import java.util.Scanner;

public class Atendimento {
    Scanner sc = new Scanner(System.in);
    private static final int MAX_VEICULOS = 100;
    private Veiculo[] veiculos = new Veiculo[MAX_VEICULOS];
    private int totalVeiculos = 0;

    public void fluxo() {
        System.out.println("\n=== Módulo de Atendimento ===");
        System.out.println("1 - Entrada de veículo");
        System.out.println("2 - Saída de veículo");
        System.out.print("Escolha: ");
        int opcao = sc.nextInt();
        
        switch(opcao) {
            case 1:
                registrarEntrada();
                break;
            case 2:
                registrarSaida();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void registrarEntrada() {
        System.out.print("Digite a placa: ");
        String placa = sc.next().toUpperCase();
        
        if(buscarVeiculo(placa) == null) {
            System.out.println("Veículo não cadastrado. Cadastre agora:");
            Veiculo novo = adicionarVeiculo();
            if(novo != null) {
                alocarVaga(novo);
            }
        } else {
            alocarVaga(buscarVeiculo(placa));
        }
    }

    private Veiculo adicionarVeiculo() {
        System.out.print("Modelo: ");
        String modelo = sc.next();
        System.out.print("Cor: ");
        String cor = sc.next();
        System.out.print("Marca: ");
        String marca = sc.next();
        System.out.print("Tipo (moto/carro/utilitário): ");
        Veiculo.Tipo tipo = Veiculo.Tipo.valueOf(sc.next().toLowerCase());
        System.out.print("Placa: ");
        String placa = sc.next().toUpperCase();

        if(totalVeiculos < MAX_VEICULOS) {
            Veiculo novo = new Veiculo(placa, modelo, cor, marca, tipo);
            veiculos[totalVeiculos++] = novo;
            return novo;
        }
        System.out.println("Limite de veículos atingido!");
        return null;
    }

    private void alocarVaga(Veiculo veiculo) {
        for(int i = 0; i < App.gestao.Estacionamento.length; i++) {
            Vagas v = App.gestao.Estacionamento[i];
            if(v != null && !v.ocupado && v.tipoVaga == veiculo.tipo) {
                v.ocupado = true;
                v.veiculo = veiculo;
                System.out.println("Vaga " + v.numero + " alocada!");
                return;
            }
        }
        System.out.println("Nenhuma vaga disponível para este tipo!");
    }

    private void registrarSaida() {
        System.out.print("Digite a placa: ");
        String placa = sc.next().toUpperCase();
        Veiculo v = buscarVeiculo(placa);
        
        if(v != null) {
            calcularTarifa(v);
            liberarVaga(v);
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }

    private void calcularTarifa(Veiculo v) {
        System.out.println("Tarifa calculada para " + v.placa);
    }

    private void liberarVaga(Veiculo v) {
        for(int i = 0; i < App.gestao.Estacionamento.length; i++) {
            Vagas vaga = App.gestao.Estacionamento[i];
            if(vaga != null && vaga.veiculo == v) {
                vaga.ocupado = false;
                vaga.veiculo = null;
                System.out.println("Vaga liberada!");
                return;
            }
        }
    }

    private Veiculo buscarVeiculo(String placa) {
        for(int i = 0; i < totalVeiculos; i++) {
            if(veiculos[i].placa.equals(placa)) {
                return veiculos[i];
            }
        }
        return null;
    }
}