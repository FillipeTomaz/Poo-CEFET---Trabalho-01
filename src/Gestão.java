import java.util.Scanner;

public class Gestão {

    Scanner sc = new Scanner(System.in);


    int a = 10;
    Vagas[] Estacionamento = new Vagas[a];
    float tarifa;
    float hora;

    public void adicionarVagas() {
        
            System.out.println("Digite o número da vaga: ");
            int numero = sc.nextInt();
            System.out.println("Digite o tipo do veiculo: ");
            Veiculo.Tipo tipo = Veiculo.Tipo.valueOf(sc.next().toLowerCase());
            System.out.println("Digite o estado da vaga: ");
            boolean ocupado = false;
            Veiculo veiculo = null;

            
            Estacionamento[a-1] = new Vagas(numero, tipo, ocupado, veiculo);
            System.out.println("Vaga adicionada com sucesso!");
            a++; 
    }

    public float alterarTarifa(float tarifa) {
        System.out.println("Valor fixo da tarifa: ");
        tarifa = sc.nextFloat();
        System.out.println("Valor adicional da tarifa por hora(após 4 horas): ");
        hora = sc.nextFloat();
        System.out.println("Valor da tarifa alterado com sucesso!");
        return tarifa;

    }

    


}
