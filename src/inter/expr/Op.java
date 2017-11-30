package inter.expr;


import lexer.Token;
import symbols.Type;

/**
 * 运算符基类，包括算术运算符的子类Arith、单目运算符的子类Unary和数组访问的子类Access
 */
public class Op extends Expr {
    public Op(Token tok, Type p) {
        super(tok, p);
    }

    @Override
    public Expr reduce() {
        Expr x = gen();
        Temp t = new Temp(type);
        emit(t.toString() + " = " + x.toString());
        return t;
    }
}
