import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		Objeto lista=new Objeto();
		int stop;
		
		do {
			stop=Integer.parseInt(JOptionPane.showInputDialog("Informe a opcao "+
					"\n 1 - Insert "+
					"\n 2 - Imprime "+
					"\n 3 - Status Arvore "+
					"\n 4 -  Copia Arvore"
					));
			switch(stop) {
			case 1:
				lista.insert();break;
			case 2:
				lista.imprime();break;
			case 3:
				lista.StatusArvore();break;
			case 4:
				lista.copiaArvore();break;
			
			}
		}while(stop!=5);

	}

}
