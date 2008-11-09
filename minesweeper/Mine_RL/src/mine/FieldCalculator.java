package mine;

/**
 * Responsible for:
 *  - iterate through input
 *  - instantiate resulting table
 *  - calculate value of each cell
 * 
 * @author RLorca
 *
 */
public class FieldCalculator {

	private final TableInput input;
	
	public static int[][] buildResult(TableInput input) {
	
		return new FieldCalculator(input).calcField();
	}
	
	
	private FieldCalculator(TableInput input) {
		
		this.input = input;
	}
	
	
	/**
	 * Iterates through all cells
	 */
	private int[][] calcField() {
		
		final int[][] result = new int[input.lineCount()][input.colCount()];
		
		for (int i = 0; i < input.lineCount(); i++) {
			
			for (int j = 0; j < input.colCount(); j++) {
				
				result[i][j] = calcCell(i, j);
			}
		}
		
		return result;
	}
	
	/**
	 * Calculates the value of a single cell 
	 */
	private int calcCell(int y, int x) {
		
		if(input.hasMineAt(y, x)) {
			return '*';
		}
		
		int sum = 0;
		
		//scan adjacent lines
		for(int i = -1; i <= 1; i++) {
			
			//scan adjacent columns
			for(int j = -1; j <= 1; j++) {
				
				if(input.hasMineAt(y + i, x + j)) {
					sum++;
				}
			}
		}
		
		return sum;
	}
}
