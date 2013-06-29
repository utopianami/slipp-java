package pieces;

public class Piece {
	public static final String COLOR_WHITE = "white";
	public static final String COLOR_BLACK = "black";
	public static final String COLOR_EMPTY = "";
	
	public static final char SYMBOL_PAWN = 'p';
	public static final char SYMBOL_ROOK = 'r';
	public static final char SYMBOL_KNIGHT = 'n';
	public static final char SYMBOL_BISHOP = 'b';
	public static final char SYMBOL_QUEEN = 'q';
	public static final char SYMBOL_KING = 'k';
	public static final char SYMBOL_EMPTY = '.';
	
	private String color;
	private char symbol;

	private Piece(String color, char symbol) {
		this.color = color;
		this.symbol = symbol;
	}

	String getColor() {
		return this.color;
	}
	
	public char getSymbol() {
		if (COLOR_BLACK.equals(color)) {
			return Character.toUpperCase(this.symbol);
		}
		return symbol;
	}

	public static Piece create(String color, char symbol) {
		return new Piece(color, symbol);
	}
}