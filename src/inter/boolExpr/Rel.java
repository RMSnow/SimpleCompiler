package inter.boolExpr;

import inter.expr.Expr;
import lexer.Token;
import symbols.Array;
import symbols.Type;

/**
 * 关系运算符
 */
public class Rel extends Logical {
    public Rel(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    @Override
    /**
     * 检查两个运算分量是否具有相同的类型。为简单起见，这里不允许类型强制转换
     */
    public Type check(Type p1, Type p2) {
        if (p1 instanceof Array || p2 instanceof Array) {       //不是数组类型
            return null;
        } else if (p1 == p2) {
            return Type.Bool;
        } else {
            return null;
        }
    }

    @Override
    public void jumping(int t, int f) {
        Expr a = expr1.reduce();
        Expr b = expr2.reduce();

        String test = a.toString() + " " + op.toString() + " " + b.toString();
        emitjumps(test, t, f);
    }
}
