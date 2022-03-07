package JocdelaVida;

import java.util.Scanner;
/**
 * <h2>clase Joc, clase que contiene el juego de la vida en su totalidad </h2>
 * 
 * @version 1
 * @author Lucas Lugo
 * @since 05-03-2022
 */
public class Joc {

	static Scanner source = new Scanner (System.in);
    /**
     * Método principal del programa, que distribuye las funciones del programa
     * @param args recibe argumentos en entrada (No utilizado)
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		int [][]taula=null;
		int[] dimension=null;
		do{
			boolean correcte=false;
			System.out.println();
			System.out.println("Bienvenido al juego de la vida");

			System.out.println("Presiona el numero correspondiente a la opción que deseas");
			System.out.println("	INICIALIZAR TABLERO: Presiona 1");
			System.out.println("	VISUALIZAR TABLERO: Presiona 2");
			System.out.println("	ITERAR: Presiona 3");
			System.out.println("	SALIR: Presiona 0");
			
		do {
			try {
				//String Player=null;
				n=source.nextInt();
				source.nextLine();
				

				if(n>=0 && n<5) {
					switch(n) {
	
					case 1:
							dimension=dimensions();
							taula =inicialitzarTauler(dimension);
							break;
					case 2:	
							if(taula!=null) {
								print(dimension,taula);
							}else {
								System.out.println("La tabla aún no está inicializada");
							}
							break;
					case 3:
							int iterar=numiterar();
							taula=jugar(taula, dimension,iterar);
							
					
					}
					correcte=true;
				}else {
					System.out.println("El valor introducido no corresponde a ninguna opción del programa");
			}
	
			}catch(Exception e){
				System.out.println("Introduciste cualquier otra cosa, ¡lee las instrucciones!");
				source.nextLine();
			}
		}while(!correcte);
		}while(n!=0);
		System.out.println("Gracias por jugar");
	}
    /**
     * Método que ejecuta la partida
     * @param dimension Recibe las dimensiones del tablero en forma de vector de enteros
     * @param taula Recibe la tabla vacia
     * @return Devuelve la tabla inicializada
     * 
     */
	public static int[][] jugar(int[][] taula, int[]dimension,int iterar){
		
		taula=iteraciones(iterar,taula,dimension);
		
		return taula;
	}	
    /**
     * Método que inicia el tablero
     * @param dimension Recibe las dimensiones del tablero en forma de vector de enteros
     * @return Devuelve la tabla inicializada
     */
	public static int[][] inicialitzarTauler(int[] dimension) {
		
		int [][]taula=new int[dimension[0]][dimension[1]];
		
		taula=iniciarvuit(dimension,taula);
		
		//int vives=randomvives(dimension);		
		
		//Coloca les cel·lules aleatoriament
		//taula=colocarcelulas(dimension,vives,taula);
		
		//Coloca les cel·lules en posicions determinades
		taula=colocarcelulasejemplo(dimension,taula);

		return taula;

	}
    /**
     * Método que pide al usuario el numero de iteraciones
     * @return Devuelve el valor introducido por teclado
     */
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
    /**
     * Método que itera los cambios a la tabla el numero de veces determinado anteriormente
     * @param iterar Recibe el numero de iteraciones que debe llevar a cabo
     * @param taula Recibe la tabla en forma de matriz
     * @param dimension Recibe las dimensiones del tablero en forma de vector de enteros
     * @return Devuelve la tabla modificada
     */
	public static int[][] iteraciones(int iterar,int[][]taula, int []dimension) {
		for(int i=0;i<iterar;i++) {
			taula=celules(dimension,taula);
			print(dimension,taula);
		}
		return taula;
	}
    /**
     * Método que establece el tablero vacio
     * @param taula Recibe la tabla en su estado inicial en forma de matriz
     * @param dimension Recibe las dimensiones del tablero en forma de vector de enteros
     * @return Devuelve la tabla modificada
     */
	public static int [][] iniciarvuit(int[]dimension, int[][]taula){
		for (int i = 0; i < dimension[0]; i++) {
			for (int j = 0; j < dimension[1]; j++) { 
				
				taula[i][j] = 0;
	
			}
		}
		return taula;
	}
    /**
     * Método que coloca las celulas en posiciones aleatorias
     * @param taula Recibe la tabla en su estado inicial en forma de matriz
     * @param dim Recibe las dimensiones del tablero en forma de vector de enteros
     * @param vives Recibe el numero de celulas vivas que debe colocar
     * @return Devuelve la tabla modificada
     */
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
    /**
     * Método que coloca las celulas en posiciones determinadas por el autor
     * @param taula Recibe la tabla en su estado inicial en forma de matriz
     * @param dim Recibe las dimensiones del tablero en forma de vector de enteros
     * @return Devuelve la tabla modificada
     */
	public static int[][] colocarcelulasejemplo(int[] dim, int[][]taula) {
		
		int [][]taulaini={
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,1,0},
			{0,1,0,0,0,0,0,1,0},
			{0,1,0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,0,0}
		};
		
		taula=taulaini;

		return taula;
	}
    /**
     * Método que develve un numero aleatorio (entre 2 valores) de celulas vivas inicial
     * @param dim Recibe las dimensiones del tablero en forma de vector de enteros
     * @return Devuelve el valor introducido por teclado
     */
	public static int randomvives(int[] dim) {
		int max=dim[0]*dim[1];
		int ran=(int)Math.floor(Math.random()*((max/2)+1 - max/4) + max/4);
		return ran;
		
	}
    /**
     * Método que devuelve un numero random que determina la posicion de las celulas
     * @param dim Recibe las dimensiones del tablero en forma de vector de enteros
     * @return Devuelve el valor introducido por teclado
     */
	public static int random(int[] dim) {
		int max=dim[0]*dim[1];
		int ran=(int)Math.floor(Math.random()*(max));
		return ran;
		
	}
    /**
     * Método que pide al usuario las dimensiones del tablero
     * @return Devuelve los valores introducidos por teclado en forma de vector
     */
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
		System.out.println("Las dimensiones del tablero son: "+xy[0]+" por "+xy[1]);
		return xy;
	}
    /**
     * Método que lleva a cabo los cambios de estado del tablero
     * @param taula Recibe la tabla en su estado inicial en forma de matriz
     * @param dim Recibe las dimensiones del tablero en forma de vector de enteros
     * @return Devuelve la tabla modificada
     */
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
    /**
     * Método que imprime por consola el estado actual de la tabla.
     * @param taula Recibe la tabla en su estado inicial en forma de matriz
     * @param xy Recibe las dimensiones del tablero en forma de vector de enteros
     */
	public static void print(int []xy, int[][]taula) {
		int fila=0;
		int col=0;
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
				}else if(taula[i][j]==0){
					System.out.print("  ");
				}else {
					System.out.print(taula[i][j]+" ");
				}
			}
		}
	}
}

