package lexer;

public class Token {

    private final String lexeme;
    private final int line;
    private final int column;

    public Token(String lexeme, int line, int column) {
        this.lexeme = lexeme;
        this.line = line;
        this.column = column;
    }

    public Token(int fila, int columna) {
        this(null,fila, columna);
    }


    public String getLexeme() {
        return lexeme;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

}
