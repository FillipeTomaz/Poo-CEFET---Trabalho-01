import java.util.Scanner;

public class Atendimento {
    Scanner sc = new Scanner(System.in);

    public Veiculo adcioniarVeiculo(String placa, String modelo, String cor, String marca, Veiculo.Tipo tipo) {
        System.out.println("Digite a placa do veiculo: ");
        placa = sc.next();
        System.out.println("Digite o modelo do veiculo: ");
        modelo = sc.next();
        System.out.println("Digite a cor do veiculo: ");
        cor = sc.next();
        System.out.println("Digite a marca do veiculo: ");
        marca = sc.next();
        System.out.println("Digite o tipo do veiculo: ");
        tipo = Veiculo.Tipo.valueOf(sc.next().toLowerCase());
        Veiculo veiculo = new Veiculo(placa, modelo, cor, marca, tipo);
        return veiculo;
    }

    public void fluxo(){
        fluxo


    }

    public void fluxoEntrada(Veiculo veiculo, Vagas vaga) {
       
    }


    public void fluxoSaida(Veiculo veiculo, Vagas vaga) {
        
    }
    
}
