package symbols;

import inter.expr.Id;
import lexer.Token;

import java.util.Hashtable;

/**
 * 符号表
 */
public class Env {
    protected Env prev;
    private Hashtable table;

    public Env(Env n) {
        table = new Hashtable();
        prev = n;
    }

    public void put(Token w, Id i) {
        table.put(w, i);
    }

    public Id get(Token w) {
        for (Env e = this; e != null; e = e.prev) {
            Id found = (Id) (e.table.get(w));
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}
