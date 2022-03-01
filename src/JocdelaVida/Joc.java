package JocdelaVida;

import java.util.Scanner;

public class Joc {
	
	//es demanaran les dimensions (files i columnes) del tauler (que hauran de ser entre 4 i 10)
	//tauler mida definida, tot mort
	//sorteix cel vives
	//num aleatoris celula
	
	static int [][]taula=null;
	
	static Scanner source = new Scanner (System.in);
	
	public static void inicialitzarTauler() {
			
		int[] dimension=dimensions();
		
		taula=new int[dimension[0]][dimension[1]];

		
		for (int i = 0; i < dimension[0]; i++) {
		for (int j = 0; j < dimension[1]; j++) { 
			
			taula[i][j] = 0;

		}
		}
		
		int vives=randomvives(dimension);
		System.out.println(vives);
		
		colocarcelulas(dimension,vives);
		
		//random(dimension);
		System.out.println("Las dimensiones del tablero son: "+dimension[0]+" por "+dimension[1]);
		
		print(dimension);
		for(int i=0;i<100;i++) {
			celules(dimension);
			print(dimension);
		}
		
		
		
	}
	public static void colocarcelulas(int[] dim, int vives) {
	
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
		System.out.println("HEY");
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
					if(n<4 || n>10) {
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
		
		return xy;
	}
	
	public static void celules(int[] dim) {

		int vecinas =0;
		
		for (int i = 0; i < dim[0]; i++) {
			for (int j = 0; j < dim[1]; j++) { 
				vecinas =0;
				for (int n = -1; n < 2; n++) {
					for (int  m= -1; m < 2; m++) {
						if(n+i>=0 &&n+i<dim[0] && m+j>=0 && m+j<dim[1]&& (i!=0 && j!=0)) {
							if(taula[i+n][j+m]==1) {
								vecinas++;

							}
						}
						
					}	
				}
			
				if(taula[i][j]==0) {
					if(vecinas==3) {
						taula[i][j]=1;
					}else {
						taula[i][j]=0;
					}
				}else if(taula[i][j]==1) {
					if(vecinas==3 || vecinas==2) {
						taula[i][j]=1;
					}else {
						taula[i][j]=0;
					}
				}
			}
		}
	}
		
	
	public static int print(int []xy) {
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

