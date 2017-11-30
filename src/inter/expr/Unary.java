package inter.expr;

import lexer.Token;
import symbols.Type;

/**
 * 单目运算符
 */
public class Unary extends Op {
    public Expr expr;

    public Unary(Token tok, Expr x) {       //处理单目减法，对!的处理见Not
        super(tok, null);
        expr = x;
        type = Type.max(Type.Int, expr.type);
        if (type == null) {
            error("type error");
        }
    }

    @Override
    public Expr gen() {
        return new Unary(op, expr.reduce());
    }

    public String toString() {
        return op.toString() + " " + expr.toString();
    }
}
