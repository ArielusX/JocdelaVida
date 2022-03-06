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
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,1,0,0,0,0,0,1,0},
				{0,1,0,0,0,0,0,1,0},
				{0,1,0,0,0,0,0,1,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0}
			},
			{ 
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,1,0,0,0,0,0,1,0},
				{0,1,0,0,0,0,0,1,0},
				{0,1,0,0,0,0,0,1,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,1,1,1,0,0,0},
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
				{0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,1,0,0,0,0,0,1,0},
				{0,1,0,0,0,0,0,1,0},
				{0,1,0,0,0,0,0,1,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0}
			},
			{ 
				{0,0,0,0,1,0,0,0,0},
				{0,0,0,0,1,0,0,0,0},
				{0,0,0,0,1,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{1,1,1,0,0,0,1,1,1},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,1,0,0,0,0},
				{0,0,0,0,1,0,0,0,0},
				{0,0,0,0,1,0,0,0,0}
			
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
	
	public IterarTest(int iterar,int[][]taula1, int[][]taula2,int []dimension) {
		this.num=iterar;
		this.ini=taula1;
		this.fin=taula2;
		this.dim =dimension;
		
	}
	@Parameters
	public static Collection<Object[]> numeros() {
		
		return Arrays.asList(new Object[][] {
			{2, inicial[0],sortida[0],dimensiones[0]},
			{1,inicial[1],sortida[1] ,dimensiones[1]},
			{20,inicial[2],sortida[2] ,dimensiones[2]}
			
		});
	}
	@Test
	public void testIterar() {

		int [][] res = Joc.iteraciones(num,ini,dim);
		assertArrayEquals(fin, res);
		
	}

}