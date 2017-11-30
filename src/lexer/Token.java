package lexer;

/**
 * 词法单元基类
 */
public class Token {
    public final int tag;

    public Token(int t) {
        tag = t;
    }

    public String toString() {
        return "" + (char) tag;
    }
}
