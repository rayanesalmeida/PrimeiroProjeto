import java.util.*;

public class ex_3 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		int num = r.nextInt(10) + 1;
		int tentativas = 0;
		while(tentativas < 3){
			System.out.print("Informe um número: ");
			int n = input.nextInt();
			if (n == num){
				System.out.print("Acertou!\n ");
				break;			
			}	
			else{
				System.out.print("Errou!\n ");
				tentativas++;			
			}	
		}
	}
}
