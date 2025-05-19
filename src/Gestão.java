import java.util.Scanner;

public class Gestão {
    Scanner sc = new Scanner(System.in);
    Vagas[] Estacionamento = new Vagas[100];
    float tarifa;
    float hora;
    private int totalVagas = 0;

    public void menuGestao() {
        int opcao;
        do {
            System.out.println("\n=== Menu Gestão ===");
            System.out.println("1 - Adicionar vaga");
            System.out.println("2 - Alterar tarifas");
            System.out.println("3 - Listar vagas");
            System.out.println("4 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch(opcao) {
                case 1:
                    adicionarVagas();
                    break;
                case 2:
                    alterarTarifa();
                    break;
                case 3:
                    listarVagas();
                    break;
            }
        } while(opcao != 4);
    }

    public void adicionarVagas() {
        System.out.print("Número da vaga: ");
        int numero = sc.nextInt();
        System.out.print("Tipo (moto/carro/utilitário): ");
        Veiculo.Tipo tipo = Veiculo.Tipo.valueOf(sc.next().toLowerCase());
        
        if(totalVagas < Estacionamento.length) {
            Estacionamento[totalVagas++] = new Vagas(numero, tipo, false, null);
            System.out.println("Vaga adicionada!");
        } else {
            System.out.println("Limite de vagas atingido!");
        }
    }

    public void alterarTarifa() {
        System.out.print("Nova tarifa base: ");
        tarifa = sc.nextFloat();
        System.out.print("Tarifa por hora adicional: ");
        hora = sc.nextFloat();
        System.out.println("Tarifas atualizadas!");
    }

    public void listarVagas() {
        System.out.println("\n=== Vagas ===");
        for(int i = 0; i < Estacionamento.length; i++) {
            Vagas v = Estacionamento[i];
            if(v != null) {
                String status = v.ocupado ? "Ocupada" : "Livre";
                System.out.printf("Vaga %d - %s - %s%n", v.numero, v.tipoVaga, status);
            }
        }
    }
}