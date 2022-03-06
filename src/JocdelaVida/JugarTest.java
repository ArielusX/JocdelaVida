package JocdelaVida;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JugarTest {

	private int [][] t1;
	private int [][] t2;
	private int [] dim;
	private int it;
		
	private static int [] [] [] entrada = { 
										{
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0}
										},
										{ 
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0}
										
										},
										{ 	
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0}
										}
										  
								};
	private static int [] [] [] sortida = { 
										{
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0}
										},
										{ 
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0}
										
										},
										{ 	
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0}
										}
				  
								};

	private static int [][] dimensiones = { 
		
			{9,9},
			{9,9},
			{9,9}
	};
	
	public JugarTest (int [][] taula1, int[] dimensions, int [][] taula2, int it) {
		this.t1 = taula1;
		this.t2= taula2;
		this.dim =dimensions;
		this.it= it;
	}
	@Parameters
	public static Collection<Object[]> numeros() {
		
		return Arrays.asList(new Object[][] {
			{entrada[0], dimensiones[0],sortida[0],3},
			{entrada[1], dimensiones[1],sortida[1],3},
			{entrada[2], dimensiones[2],sortida[2],3}
			
		});
	}
	@Test
	public void testJugar() {
		
		int [][] res = Joc.jugar(t1,dim,it);
		assertArrayEquals(t2, res);
	}
}
