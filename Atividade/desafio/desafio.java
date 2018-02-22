import java.util.*;

public class desafio {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
			System.out.print("Informe um número decimal: ");
			int n = input.nextInt();
			 while (n >= 1){
            int binario = n % 2;
            System.out.println(binario);
            n = n / 2 ;
        }
	}
}
