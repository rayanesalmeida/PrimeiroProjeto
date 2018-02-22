import java.util.Scanner;

public class prog_10 {
	public static void main(String args[]) {
		int op;
		Scanner input = new Scanner(System.in);
		System.out.printf("Digite a opcao: ");
		op = input.nextInt();
		for(int x = 1; x <= op; x++){
			System.out.println("op vale " + op + " e x vale " + x);
			}
	}
}