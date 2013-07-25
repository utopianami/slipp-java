package pieces;

import java.util.ArrayList;

/**
 * @author javajigi
 *
 */
public class Position {
	private static final char COLUMN_START_CHAR = 'a';
	
	private static final int COLUMN_SIZE = 8;
	private static final int ROW_SIZE = 8;

	private int x;
	private int y;

	public Position(String position) {
		// 에러 상태에 대한 처리 필요함.
		this.x = generateColumnIndex(position.charAt(0));
		this.y = Integer.parseInt(position.substring(1)) - 1;
	}

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int generateColumnIndex(char columnIndex) {
		int target = Character.getNumericValue(columnIndex);
		int source = Character.getNumericValue(COLUMN_START_CHAR);
		return target - source;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	Position moveNorthOne() {
		return new Position(this.x, this.y + 1);
	}

	Position moveSouthOne() {
		return new Position(this.x, this.y - 1);
	}

	Position moveEastOne() {
		return new Position(this.x + 1, this.y);
	}

	Position moveWestOne() {
		return new Position(this.x - 1, this.y);
	}
	
	Position moveNorthEastOne() {
		return moveNorthOne().moveEastOne();
	}
	
	Position moveNorthWestOne() {
		return moveNorthOne().moveWestOne();
	}
	
	Position moveSouthWestOne() {
		return moveSouthOne().moveWestOne();
	}
	
	Position moveSouthEastOne() {
		return moveSouthOne().moveEastOne();
	}
	
	ArrayList<Position> findsNorthPosition() {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = moveNorthOne();
		while(currentPosition.isValid()) {
			positions.add(currentPosition);
			currentPosition = currentPosition.moveNorthOne();
		}
		
		return positions;
	}
	
	ArrayList<Position> findsSouthPosition() {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = moveSouthOne();
		while(currentPosition.isValid()) {
			positions.add(currentPosition);
			currentPosition = currentPosition.moveSouthOne();
		}
		
		return positions;
	}
	
	ArrayList<Position> findsEastPosition() {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = moveEastOne();
		while(currentPosition.isValid()) {
			positions.add(currentPosition);
			currentPosition = currentPosition.moveEastOne();
		}
		
		return positions;
	}
	
	ArrayList<Position> findsWestPosition() {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = moveWestOne();
		while(currentPosition.isValid()) {
			positions.add(currentPosition);
			currentPosition = currentPosition.moveWestOne();
		}
		
		return positions;
	}

	boolean isValid() {
		if ( y < 0 || y >= ROW_SIZE) {
			return false;
		}
		
		if ( x < 0 || x >= COLUMN_SIZE) {
			return false;
		}
		
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
}
