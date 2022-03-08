package JocdelaVida;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IterarTest {
	private int num;
	private int [] dim;
	private int [][] ini;
	private int [][] fin;
	
	private static int [] [] [] inicial = { 
			{
				{1,1,0,1},
				{1,1,0,0},
				{1,0,1,0},
				{0,1,0,0},
				{0,0,1,0}
			},
			{ 
				{0,0,1,0,0,1,0,0,1},
				{0,1,1,1,1,0,1,0,1},
				{0,1,0,1,0,0,0,1,0},
				{0,0,0,1,0,1,0,1,1},
				{1,1,0,0,1,1,0,1,0},
				{1,0,1,0,0,1,1,1,0},
				{0,1,0,0,0,0,0,1,1}
			
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
				{0,0,0,0,0,0,1,1,1},
				{0,0,0,0,0,0,0,0,0}

			
			},
			{ 
				{0,0,0,0,0,0,0},
				{0,1,1,1,0,0,0},
				{0,1,0,0,0,0,0},
				{0,1,0,0,0,0,0}

			
			},
			{ 
			
				{0,0,0,1},
				{1,0,0,0},
				{0,0,0,0},
				{1,0,1,0},
				{0,0,0,0},
				{1,0,0,0},
				{0,0,0,1},
				{0,1,0,0}
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
				{0,1,0,0,0,0,0},
				{0,1,0,0,1,1,0},
				{0,1,0,0,1,1,0},
				{0,0,0,0,0,0,0}
			},
			{ 
				{1,0,1,0,0,0,0,0,1},
				{0,0,0,1,0,1,0,0,0},
				{0,0,0,0,0,0,0,1,0},
				{0,1,0,1,0,1,0,0,0}
			}

};
	private static int [] [] [] sortida = { 
			{
				{0,0,1,0},
				{0,0,1,1},
				{0,0,0,0},
				{0,0,1,1},
				{0,0,1,0}
			},
			{ 
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1},
				{0,0,0,0,0,0,0,1,1},
				{0,0,0,0,0,0,0,0,0},
				{0,1,1,0,0,0,0,0,0},
				{0,1,1,0,0,0,1,1,0},
				{0,0,0,0,0,0,1,1,0}
			
			},
			{ 	
				{0,0,0,0},
				{0,0,0,0},
				{0,1,1,1},
				{0,0,0,0}
				
			},
			{ 
				{0,0,1,1,0,0,0,0,0},
				{0,0,1,1,0,0,0,1,0},
				{0,0,0,0,0,0,0,1,0},
				{0,0,0,0,0,0,0,1,0}

			
			},
			{ 
				{0,1,1,0,0,0,0},
				{1,0,0,1,0,0,0},
				{1,0,1,0,0,0,0},
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
				{0,0,0,0,0,0,0},
				{1,1,1,0,1,1,0},
				{0,0,0,0,1,1,0},
				{0,0,0,0,0,0,0}
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
	
	public IterarTest(int iterar,int[][]taula1, int[][]taula2,int []dimension) {
		this.num=iterar;
		this.ini=taula1;
		this.fin=taula2;
		this.dim =dimension;
		
	}
	@Parameters
	public static Collection<Object[]> numeros() {
		
		return Arrays.asList(new Object[][] {
			{5, inicial[0],sortida[0] ,dimensiones[0]},
			{50,inicial[1],sortida[1] ,dimensiones[1]},
			{20,inicial[2],sortida[2] ,dimensiones[2]},
			{11,inicial[3],sortida[3] ,dimensiones[3]},
			{20,inicial[4],sortida[4] ,dimensiones[4]},
			{20,inicial[5],sortida[5] ,dimensiones[5]},
			{50,inicial[6],sortida[6] ,dimensiones[6]},
			{1, inicial[7],sortida[7] ,dimensiones[7]},
			{10,inicial[8],sortida[8] ,dimensiones[8]},
			
		});
	}
	@Test
	public void testIterar() {

		int [][] res = Joc.iteraciones(num,ini,dim);
		assertArrayEquals(fin, res);
		
	}

}