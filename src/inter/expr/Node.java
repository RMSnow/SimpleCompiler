package inter.expr;

import lexer.Lexer;

/**
 * 抽象语法树的结点
 */
public class Node {
    /**
     * 生成三地址代码
     */

    static int labels = 0;
    int lexline = 0;        //保存了本结点对应的构造在源程序中的行号

    protected Node() {
        lexline = Lexer.line;

        //TODO: 中间代码生成过程中构造新结点时跟踪行号
    }

    public void error(String s) {
        throw new Error("near line " + lexline + ": " + s);
    }

    public int newlabel() {
        return ++labels;
    }

    public void emitlabel(int i) {
        System.out.print("L" + i + ":");
    }

    public void emit(String s) {
        System.out.println("\t" + s);
    }


}
