import java.util.Scanner;

public class prog_6 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int idade;
		System.out.printf("Digite sua idade: ");
		idade = input.nextInt();
		if(idade < 18) {
			System.out.println("Não permitido");		
		}
		else{
			System.out.println("Permitido");		
		}	
	}
}