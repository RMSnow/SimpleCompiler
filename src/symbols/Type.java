package symbols;

import lexer.Tag;
import lexer.Word;

/**
 * 基本类型
 */
public class Type extends Word {
    public static final Type
            Int = new Type("int", Tag.BASIC, 4),
            Float = new Type("float", Tag.BASIC, 8),
            Char = new Type("char", Tag.BASIC, 1),
            Bool = new Type("bool", Tag.BASIC, 1);
    public int width = 0;       //用于存储分配

    public Type(String s, int tag, int w) {
        super(s, tag);
        width = w;
    }

    /**
     * 在数字类型Char/Int/Float之间可以进行类型转换
     *
     * @param p
     * @return
     */
    public static boolean numeric(Type p) {
        if (p == Type.Char || p == Type.Int || p == Type.Float) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 当一个算术运算符应用于两个数字类型时，结果类型是这两个类型的max值
     *
     * @param p1
     * @param p2
     * @return
     */
    public static Type max(Type p1, Type p2) {
        if (!numeric(p1) || !numeric(p2)) {
            return null;
        } else if (p1 == Type.Float || p2 == Type.Float) {
            return Type.Float;
        } else if (p1 == Type.Int || p2 == Type.Int) {
            return Type.Int;
        } else {
            return Type.Char;
        }
    }
}
