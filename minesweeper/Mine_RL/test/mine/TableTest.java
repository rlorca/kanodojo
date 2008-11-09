package mine;

import junit.framework.Assert;

import org.junit.Test;


public class TableTest {

	@Test
	public void test1() throws Exception {
		
		char[][] contents = {{'*', '.', '.', '.'}, 
							 {'.', '.', '.', '.'}, 
							 {'.', '*', '.', '.'},
							 {'.', '.', '.', '.'}};
		
		int[][] expectations = {{'*',1,0,0},
								{2,2,1,0},
								{1,'*',1,0},
								{1,1,1,0}};
		
		int[][] result = getResult(4, 4, contents);		
			
		check(expectations, result);
	}

	private int[][] getResult(int i, int j, char[][] contents) {
					
		return FieldCalculator.buildResult(new TableInput(contents));
	}

	@Test
	public void test2() throws Exception {
		
		char[][] contents = {{'*', '*', '.', '.', '.'}, 
							 {'.', '.', '.', '.', '.'}, 
							 {'.', '*', '.', '.', '.'}};
		
				
		int[][] expectations = {{'*', '*', 1, 0, 0},
								{ 3, 3, 2, 0, 0},
								{ 1, '*', 1, 0, 0}};
		
		int[][] result = getResult(3, 5, contents);
			
		check(expectations, result);
	}
	
	
	private void check(int[][] expectations, int[][] result) {
		
		for(int y = 0; y < expectations.length; y++) {
			
			for(int x = 0; x < expectations[0].length; x++) {
				Assert.assertEquals("Error processing " + y + "," + x , expectations[y][x], result[y][x]);
			}
			
		}
	}
	
	@Test
	public void TestInput() {
	
		char[][] contents = {{'*', '*', '.', '.', '.'}, 
				 			 {'.', '.', '.', '.', '.'}, 
				 			 {'.', '*', '.', '.', '.'}};
		
		TableInput input = new TableInput(contents);
		
		Assert.assertTrue(input.hasMineAt(0, 0));
		Assert.assertFalse(input.hasMineAt(1, 0));
		Assert.assertFalse(input.hasMineAt(0, 999));
		Assert.assertFalse(input.hasMineAt(0, -1));
	}
	

	
}
