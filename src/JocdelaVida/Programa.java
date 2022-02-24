package JocdelaVida;

import java.util.Scanner;

public class Programa {
	
	static Scanner source = new Scanner (System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		do{
			boolean correcte=false;
			String jugadores[]=null;
			System.out.println("Bienvenido al juego del colgado");

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
	
					case 1://Ola
							break;
					case 2://Ola
							break;
					case 3:
						//Ola
							break;
					case 4://Ola
					
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

}
