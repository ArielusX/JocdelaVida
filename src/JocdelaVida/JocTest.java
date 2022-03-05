package JocdelaVida;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
class JocTest {

	private int [][] t1;
	private int [][] t2;
	private int files;
	private int cols;
	private boolean iguals;
	
	private static int [] [] [] ini1 = { 
										{
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
											{0,0,0,0,0,0,0,0,0}
										}
										  
								};
	private static char [] [] [] ini2 = { 
										{ {'-','-','-','-'},
										  {'*','*','-','*'},
										  {'-','-','-','-'},
										  {'*','*','-','*'}
										},
										{ {'-','*','*','*'},
										  {'*','*','-','*'}
										},
										{ {'-','-','-','-'},
										  {'*','-','-','*'},
										  {'-','-','-','-'},
										  {'*','*','*','*'}
										}
				  
								};
	
	public JocTest (int [][] t1, int [][] t2, int f, int c, boolean iguals) {
		this.t1 = t1;
		this.t2 = t2;
		this.files = f;
		this.cols = c;
		this.iguals = iguals;
	}
	
	@Parameters
	public static Collection<Object[]> numeros() {
		
		return Arrays.asList(new Object[][] {
			{ini1[0], ini2[0], 4, 4, true},
			{ini1[1], ini2[1], 2, 4, true},
			{ini1[2], ini2[2], 4, 4, false}
			
		});
	}
	
	@Test
	public void testEquals() {
		boolean res = JocTest.iguals(t1, t2, files, cols);
		assertEquals(iguals,  res);
	}
/*
	@Test
	void testInicialitzarTauler() {
		fail("Not yet implemented");
	}

	@Test
	void testNumiterar() {
		fail("Not yet implemented");
	}

	@Test
	void testIteraciones() {
		fail("Not yet implemented");
	}

	@Test
	void testIniciarvuit() {
		fail("Not yet implemented");
	}

	@Test
	void testColocarcelulas() {
		fail("Not yet implemented");
	}

	@Test
	void testColocarcelulasejemplo() {
		fail("Not yet implemented");
	}

	@Test
	void testRandomvives() {
		fail("Not yet implemented");
	}

	@Test
	void testRandom() {
		fail("Not yet implemented");
	}

	@Test
	void testDimensions() {
		fail("Not yet implemented");
	}

	@Test
	void testCelules() {
		fail("Not yet implemented");
	}
*/
}
