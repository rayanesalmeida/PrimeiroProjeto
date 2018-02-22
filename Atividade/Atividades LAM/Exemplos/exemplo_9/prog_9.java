import java.util.Scanner;

public class prog_9 {
	public static void main(String args[]) {
		int op;
		Scanner input = new Scanner(System.in);
		System.out.printf("Digite a opcao: ");
		op = input.nextInt();
		do{
			System.out.println("op vale " + op);
			op++;			
      }while(op <= 3);
   }
}
