package inter.stmt;

import inter.expr.Node;

/**
 * 语句构造的基类
 */
public class Stmt extends Node {
    public static Stmt Null = new Stmt();
    public static Stmt Enclosing = Stmt.Null;       //用于break语句
    int after = 0;      //保存语句的下一条指令的标号

    public Stmt() {
    }

    /**
     * 三地址码的生成
     *
     * @param b 语句开始处的标号
     * @param a 语句下一条指令的标号
     */
    public void gen(int b, int a) {
    }
}
