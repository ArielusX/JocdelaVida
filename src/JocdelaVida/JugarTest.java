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
		
	private static int [] [] [] entrada = { 
			{
				{0,0,0,0},
				{1,1,0,0},
				{0,0,0,0},
				{1,1,0,0},
				{1,1,0,0}
			},
			{ 
				{0,1,0,0,1,1,1,0,0},
				{0,0,1,0,1,1,0,0,1},
				{0,0,0,0,1,0,0,0,0},
				{1,1,1,1,1,1,1,0,1},
				{0,0,1,0,1,0,1,1,1},
				{0,0,0,0,0,1,0,0,1},
				{0,0,0,0,0,0,0,0,0}
			
			},
			{ 	
				{0,0,0,0},
				{0,0,1,0},
				{0,0,1,0},
				{0,0,1,0}
				
			},
			{ 
				{0,0,1,1,0,0,0,0,0},
				{0,0,1,1,0,0,0,1,0},
				{0,0,0,0,0,0,0,0,0},
				{1,0,0,0,0,0,1,0,0}

			
			},
			{ 
				{0,0,0,0,0,0,0},
				{0,1,1,1,0,0,0},
				{0,1,0,0,0,0,0},
				{0,1,0,0,0,0,0}

			
			},
			{ 
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
			
			},
			{ 
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,1,0},
				{0,1,0,1},
				{0,0,1,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
			
			},
			{ 
				{0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0},
				{0,0,1,0,0,0,0},
				{0,0,1,0,0,1,1},
				{0,0,0,0,0,1,1}
			},
			{ 
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}
			}
		};
	private static int [] [] [] sortida = { 
			{
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{1,1,0,0},
				{1,1,0,0}
			},
			{ 
				{0,0,0,1,1,0,1,0,0},
				{0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,1,1,0},
				{0,1,1,0,0,0,1,0,1},
				{0,0,1,0,0,0,0,0,1},
				{0,0,0,0,0,1,1,0,1},
				{0,0,0,0,0,0,0,0,0}
			
			},
			{ 	
				{0,0,0,0},
				{0,0,0,0},
				{0,1,1,1},
				{0,0,0,0}
				
			},
			{ 
				{0,0,1,1,0,0,0,0,0},
				{0,0,1,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}

			
			},
			{ 
				{0,0,1,0,0,0,0},
				{0,1,1,0,0,0,0},
				{1,1,0,0,0,0,0},
				{0,0,0,0,0,0,0}

			
			},
			{ 
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
			
			},
			{ 
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,1,0},
				{0,1,0,1},
				{0,0,1,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
			
			},
			{ 
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0},
				{0,1,1,1,0,0,0},
				{0,0,0,0,0,1,1},
				{0,0,0,0,0,1,1}
			},
			{ 
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}
			}
		};

	private static int [][] dimensiones = { 
		
			{5,4},
			{7,9},
			{4,4},
			{4,9},
			{4,7},
			{8,4},
			{9,4},
			{5,7},
			{4,9}
	};
	
	public JugarTest (int [][] taula1, int[] dimensions, int [][] taula2) {
		this.t1 = taula1;
		this.dim =dimensions;
		this.t2= taula2;
		
	}
	@Parameters
	public static Collection<Object[]> numeros() {
		
		return Arrays.asList(new Object[][] {
			{entrada[0], dimensiones[0],sortida[0]},
			{entrada[1], dimensiones[1],sortida[1]},
			{entrada[2], dimensiones[2],sortida[2]},
			{entrada[3], dimensiones[3],sortida[3]},
			{entrada[4], dimensiones[4],sortida[4]},
			{entrada[5], dimensiones[5],sortida[5]},
			{entrada[6], dimensiones[6],sortida[6]},
			{entrada[7], dimensiones[7],sortida[7]},
			{entrada[8], dimensiones[8],sortida[8]}
			
		});
	}
	@Test
	public void testCelules() {
		
		int [][] res = Joc.celules(dim,t1);
		assertArrayEquals(t2, res);
	}
}
