package inter.boolExpr;

import inter.expr.Expr;
import lexer.Token;

/**
 * 逻辑运算符Not
 */
public class Not extends Logical {
    public Not(Token tok, Expr x2) {
        super(tok, x2, x2);
    }

    @Override
    public void jumping(int t, int f) {
        expr2.jumping(f, t);
    }

    public String toString() {
        return op.toString() + " " + expr2.toString();
    }
}
