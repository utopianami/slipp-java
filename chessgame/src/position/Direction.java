package position;

public enum Direction {
	NORTH(0, 1),
	NORTHEAST(1, 1),
	EAST(1, 0),
	SOUTHEAST(1, -1),
	SOUTH(0, -1),
	SOUTHWEST(-1, -1),
	WEST(-1, 0),
	NORTHWEST(-1, 1);
	
	private int xDegree;
	private int yDegree;

	private Direction(int xDegree, int yDegree) {
		this.xDegree = xDegree;
		this.yDegree = yDegree;
	}
	
	public int getXDegree() {
		return xDegree;
	}
	
	public int getYDegree() {
		return yDegree;
	}
}
