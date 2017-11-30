package inter.stmt;

import inter.expr.Expr;
import symbols.Type;

/**
 * While语句
 */
public class While extends Stmt {
    Expr expr;
    Stmt stmt;

    public While() {
        expr = null;
        stmt = null;
    }

    public void init(Expr x, Stmt s) {
        expr = x;
        stmt = s;
        if (expr.type != Type.Bool) {
            expr.error("boolean required in while");
        }
    }

    @Override
    public void gen(int b, int a) {
        after = a;      //保存标号a
        expr.jumping(0, a);
        int label = newlabel();     //用于保存stmt的标号
        emitlabel(label);
        stmt.gen(label, b);
        emit("goto L" + b);
    }
}
