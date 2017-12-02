package inter.expr;


import lexer.Token;
import symbols.Type;

/**
 * 表达式构造
 */
public class Expr extends Node {
    public Token op;        //结点上的运算符
    public Type type;       //结点类型

    protected Expr(Token op, Type type) {
        this.op = op;
        this.type = type;
    }

    /**
     * Expr的子类通常会重新实现gen
     *
     * @return 一个"项"，该项可以成为一个三地址指令的右部
     */
    public Expr gen() {
        return this;
    }

    /**
     * 把一个表达式计算（归约）成一个单一的地址
     *
     * @return 常量/标识符/临时名字
     */
    public Expr reduce() {
        return this;
    }

    /**
     * 为布尔表达式生成跳转代码
     */

    public void jumping(int t, int f) {
        emitjumps(toString(), t, f);
    }

    public void emitjumps(String test, int t, int f) {
        if (t != 0 && f != 0) {
            emit("if " + test + " goto L" + t);
            emit("goto L" + f);
        } else if (t != 0) {
            emit("if " + test + " goto L" + t);
        } else if (f != 0) {
            emit("if false " + test + " goto L" + f);
        } else {
            return;     //不作反应，因为t和f都直接穿越
        }
    }

    public String toString() {
        return op.toString();
    }

}
