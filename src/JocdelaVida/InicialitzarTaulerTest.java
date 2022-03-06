package JocdelaVida;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class InicialitzarTaulerTest {

	private int [] dim;
	private int [][] ini;
	
	private static int [] [] [] iniciat = { 
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
			}

};
	private static int [][] dimensiones = { 
			
			{9,9}
	};
	public InicialitzarTaulerTest  (int[][]ini,int [] dimensions) {
		this.ini=ini;
		this.dim =dimensions;
	}
	@Parameters
	public static Collection<Object[]> numeros() {
		
		return Arrays.asList(new Object[][] {
			{iniciat[0], dimensiones[0]}
			
		});
	}
	@Test
	public void testInicialitzarTauler() {
		int [][] res = Joc.inicialitzarTauler(dim);
		assertArrayEquals(ini, res);
	}

}
