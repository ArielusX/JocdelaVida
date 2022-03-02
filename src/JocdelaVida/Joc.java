package JocdelaVida;

import java.util.Scanner;

public class Joc {
	
	//es demanaran les dimensions (files i columnes) del tauler (que hauran de ser entre 4 i 10)
	//tauler mida definida, tot mort
	//sorteix cel vives
	//num aleatoris celula
	
	
	static Scanner source = new Scanner (System.in);
	
	public static void inicialitzarTauler() {
			
		int[] dimension=dimensions();
		
		int [][]taula=new int[dimension[0]][dimension[1]];
		
		taula=iniciarvuit(dimension,taula);
		
		int vives=randomvives(dimension);		
		
		//Coloca les cel·lules aleatoriament
		taula=colocarcelulas(dimension,vives,taula);
		
		//Coloca les cel·lules en posicions determinades
		//taula=colocarcelulasejemplo(dimension,taula);

		int iterar=numiterar();
		
		taula=iteraciones(iterar,taula,dimension);
		
		print(dimension, taula);

	}
	public static int numiterar() {
		System.out.println("Introduce el numero de iteraciones: ");
		int n=0;
		try {
				n=source.nextInt();

		}catch(Exception e){
			System.out.println("Valor incorrecto");
		}
		return n;
	}
	
	public static int[][] iteraciones(int iterar,int[][]taula, int []dimension) {
		for(int i=0;i<iterar;i++) {
			taula=celules(dimension,taula);
			print(dimension,taula);
		}
		return taula;
	}
	
	public static int [][] iniciarvuit(int[]dimension, int[][]taula){
		for (int i = 0; i < dimension[0]; i++) {
			for (int j = 0; j < dimension[1]; j++) { 
				
				taula[i][j] = 0;
	
			}
		}
		return taula;
	}
	
	public static int[][] colocarcelulas(int[] dim, int vives, int[][]taula) {
	
		for(int i=0;i<vives;i++) {
			int ran=random(dim);
			
			int fila=(ran/dim[1]);
			int col=(ran%dim[1]);
			if(taula[fila][col] ==0) {
				taula[fila][col] = 1;
			}else {
				i--;
			}
		}
		return taula;
	}
	
	public static int[][] colocarcelulasejemplo(int[] dim, int[][]taula) {
		
		taula[0][4]=1;
		taula[1][4]=1;
		taula[2][4]=1;
		
		taula[4][0]=1;
		taula[4][1]=1;
		taula[4][2]=1;
		
		taula[6][4]=1;
		taula[7][4]=1;
		taula[8][4]=1;
		
		taula[4][6]=1;
		taula[4][7]=1;
		taula[4][8]=1;
		
		return taula;
	}
	
	public static int randomvives(int[] dim) {
		int max=dim[0]*dim[1];
		int ran=(int)Math.floor(Math.random()*((max/2)+1 - max/4) + max/4);
		return ran;
		
	}
	
	public static int random(int[] dim) {
		int max=dim[0]*dim[1];
		int ran=(int)Math.floor(Math.random()*(max));
		return ran;
		
	}
	
	public static int[] dimensions() {
		int t =0;
		int[] xy =new int [2];
		
		while(t<2) {
			int n=0;
			if(t==0) {
				System.out.println("Introduce el numero de filas del tablero");
			}else if(t==1){
				System.out.println("Introduce el numero de columnas del tablero");
			}
			try {
				boolean valid=false;
				while(!valid) {
					n=source.nextInt();
					if(n<4 || n>101) {
						System.out.println("El numero debe estar entre el 4 y el 10");
					}else {
						xy[t]=n;
						t++;
						valid=true;
					}
					
				}

				
			}catch(Exception e){
				System.out.println("Valor incorrecto");
			}
		}
		System.out.println("Las dimensiones del tablero son: "+xy[0]+" por "+xy[1]);
		return xy;
	}
	
	public static int[][] celules(int[] dim, int[][]taula) {

		int vecinas =0;
		
		int [][]taulaaux=new int [dim[0]][dim[1]];
		
		for (int i = 0; i < dim[0]; i++) {
			for (int j = 0; j < dim[1]; j++) { 
				vecinas =0;
				for (int n = -1; n < 2; n++) {
					for (int  m= -1; m < 2; m++) {
						if(n+i>=0 &&n+i<dim[0] && m+j>=0 && m+j<dim[1]&& !(n==0 && m==0)) {

							if(taula[i+n][j+m]==1) {
								vecinas++;
							}
						}
					}	
				}
				if(taula[i][j]==0) {
					if(vecinas==3) {
						taulaaux[i][j]=1;
					}else {
						taulaaux[i][j]=0;
					}
				}else if(taula[i][j]==1) {
					if(vecinas==3 || vecinas==2) {
						taulaaux[i][j]=1;
					}else {
						taulaaux[i][j]=0;
					}
				}
			}
		}
		taula=taulaaux.clone();
		return taula;
	}
		
	public static int print(int []xy, int[][]taula) {
		int fila=0;
		int col=0;
		int res=0;
		System.out.println();
		for(int i=0;i<=xy[1];i++) {
			if(i==0) {
				System.out.print("  ");
			}else {
				System.out.print((col)+" ");
			}
			
			col++;
		}
		
		for (int i = 0; i < xy[0]; i++) {
			for (int j = 0; j < xy[1]; j++) { 
				if(fila!=i || (i==0 && j==0)) {
					
					if(i!=0) {
						fila++;
						System.out.println();
						System.out.print((fila+1)+" ");
					}else {
						System.out.println();
						System.out.print((fila+1)+" ");
					}
					
				}
			
				if(taula[i][j]==1) {
					System.out.print("O ");
					res=1;
				}else if(taula[i][j]==0){
					System.out.print("  ");
				}else {
					System.out.print(taula[i][j]+" ");
				}
			}
		}
		return res;
	}
}

