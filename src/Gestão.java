import java.util.Scanner;


public class Gestão {
    Scanner sc = new Scanner(System.in);


    int a = 10;
    Vagas[] Estacionamento = new Vagas[a];
    float hora;
    float fixa;
    float tarifa;
        

    public void adicionarVaga(){
        int numero = a;
        System.out.println("Tipo do veiculo: ");
        String temp = sc.nextLine();
        Veiculo.Tipo tipoVaga = Veiculo.Tipo.valueOf(temp.toLowerCase());
        boolean ocupado = false;
        Veiculo veiculo = null;

        Vagas v = new Vagas(numero, tipoVaga, ocupado, veiculo);

        Estacionamento[a-1] = v;
        a++;

    }

    public void alterarTarifa(){
        
        System.out.println("Preço Fixo: ");
        fixa = sc.nextFloat();
        System.out.println("Preço após 4 horas: ");
        hora = sc.nextFloat();

        

    }


}
