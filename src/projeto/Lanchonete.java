package projeto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lanchonete {

	public static void main(String[] args){

		int qtd = 0;
		int codigo = 0;
	
		System.out.println("\tCÓDIGO \tPRODUTO \t\tPREÇO");
		System.out.println("\t1 - \tCachorro-quente \tR$ 8.50");
		System.out.println("\t2 - \tSuco Natural    \tR$ 6.00");
		System.out.println("\t3 - \tX-Tudo          \tR$ 7.99");
		System.out.println("\t4 - \tGuaraná Natural \tR$ 4.50");
		

		escolhaCodigo(codigo, qtd);
	}
	public static void escolhaCodigo(int codigo, int qtd) {
		Scanner sc = new Scanner(System.in);
		double valor = 0.0, totalAPagar = 0.0;
		qtd = 0;
		int numTentativas = 2, cont;

		try {
			System.out.println();
			System.out.println("---------------------------------");
			System.out.println("Qual o seu pedido? Escolha um código: ");
			codigo = sc.nextInt();
			if (codigo > 4) {
				System.out.println("Digite o código válido: ");
				codigo = sc.nextInt();
				for (cont = numTentativas; cont > 0; cont--) {
					System.out.println("Você tem " + cont + " tentativas: ");
					System.out.println("Digite o código válido: ");
					codigo = sc.nextInt();
				}
			}else {
				System.out.println("Qual a quantidade? ");
				qtd = sc.nextInt();

				switch (codigo) {
				case 1:
					valor += 8.50 * qtd;
					break;
				case 2:
					valor += 6.00 * qtd;
					break;
				case 3:
					valor += 7.99 * qtd;
					break;
				case 4:
					valor += 4.50 * qtd;
					break;
				}

				System.out.println("Algo a mais? Responda S ou N:");
				String resposta = sc.next();

				while (resposta.equalsIgnoreCase("s")) {

					System.out.println("Qual o seu pedido?");
					codigo = sc.nextInt();
					
					System.out.println("Qual a quantidade? ");
					qtd = sc.nextInt();

					if (codigo > 4) {
						System.out.println("Opção inválida!");
					} else {
						
						switch (codigo) {
						case 1:
							valor += 8.50 * qtd;
							break;
						case 2:
							valor += 6.00 * qtd;
							break;
						case 3:
							valor += 7.99 * qtd;
							break;
						case 4:
							valor += 4.50 * qtd;
							break;
						}

						System.out.println("Algo a mais? Responda S ou N:");
						resposta = sc.next();
					}
					totalAPagar = valor;
				}
				System.out.printf("Total a pagar: R$ %.2f ", totalAPagar);
			}
		} catch (InputMismatchException e) {
			System.out.println("O sistema aguarda por valores numéricos!");
		}finally {
			System.out.println("Programa encerrado!");
		}

		sc.close();
	}
}
