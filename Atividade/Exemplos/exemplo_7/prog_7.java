import java.util.Scanner;

public class prog_7 {
	public static void main(String args[]) {
		int op;
		Scanner input = new Scanner(System.in);
		System.out.printf("Digite a opcao: ");
		op = input.nextInt();
		switch(op){
			case 1:
				System.out.println("Opção 1");
				break;
			case 2:
				System.out.println("Opção 2");
				break;	
			case 3:
				System.out.println("Opção 3");
				break;
			default:
				System.out.println("Opção INVÁLIDA");	
		}
	   
	}
}