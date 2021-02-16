public class Token {

    private final String lexeme;
    private final int line;
    private final int column;

    public Token(String lexema, String type, int linea, int columna) {
        this.lexeme = lexema;
        this.type = type;
        this.line = linea;
        this.column = columna;
    }

    public Token(int fila, int columna) {
        this(null, null,fila, columna);
    }


    public String getLexeme() {
        return lexeme;
    }

    public String getType() {
        return type;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

}
