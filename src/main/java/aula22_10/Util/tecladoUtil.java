package aula22_10.Util;

import java.util.Scanner;

public class tecladoUtil {

    Scanner teclado = new Scanner(System.in);
    
    public String lerString(String mensagem) {
        System.out.println(mensagem);
        return teclado.nextLine();
    }

    public Integer lerInteiro(String mensagem) {
        System.out.println(mensagem);
        return teclado.nextInt();
    }

    public String limparBuffer(){
        return teclado.nextLine();
    }
}
