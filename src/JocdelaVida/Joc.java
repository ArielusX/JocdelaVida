package JocdelaVida;

import java.util.Scanner;

public class Joc {
	
	//es demanaran les dimensions (files i columnes) del tauler (que hauran de ser entre 4 i 10)
	//tauler mida definida, tot mort
	//sorteix cel vives
	//num aleatoris celula
	
	static int [][]taula=null;
	static int [][]taulavis=null;
	
	static Scanner source = new Scanner (System.in);
	
	public static void inicialitzarTauler() {
			
		/*for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) { 
				
				taula[i][j] = 0;
				taulavis[i][j] = 0;
			}
		}*/
		int[] dimension=dimensions();
		System.out.println("Las dimensiones del tablero son: "+dimension[0]+" por "+dimension[1]);
	}
	public static int[] dimensions() {
		System.out.println("HEY");
		int t =0;
		int[] xy =new int [2];
		
		while(t<2) {
			int n=0;
			
			try {
				n=source.nextInt();
				xy[t]=n;
				t++;
				
			}catch(Exception e){
				System.out.println("Valor incorrecto");
			}
		}
		
		return xy;
	}
	
	
	
	
}

