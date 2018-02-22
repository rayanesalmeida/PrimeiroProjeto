import java.util.Scanner;

public class prog_8 {
	public static void main(String args[]) {
		int op;
		Scanner input = new Scanner(System.in);
		System.out.printf("Digite a opcao: ");
		op = input.nextInt();
		while (op <= 3){
			System.out.println("op vale " + op);
			op++;		
		}
	   
	}
}