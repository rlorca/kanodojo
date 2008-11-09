package mine;

/**
 *	Just an abstraction on input. 
 * 
 */
public class TableInput {

	private final char[][] contents;
	private final int lines;
	private final int cols;

	
	public TableInput(char[][] contents) {
		
		this.contents = contents;
		this.lines = contents.length;
		this.cols = contents[0].length;
	}

	public int lineCount() {
		return this.lines;
	}
	
	public int colCount() {
		return this.cols;
	}

	/**
	 * Verifies if a mine exists or not in a given position.
	 * 
	 * Verification on invalid positions will return false.
	 */
	public boolean hasMineAt(int y, int x) {
		
		if((y < 0) || (y >= lines)) {
			return false;
		}
		
		if((x < 0) || (x >= cols)) {
			return false;
		}
		
		return contents[y][x] == '*';
	}
}
