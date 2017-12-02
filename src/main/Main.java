package main;


import lexer.Lexer;
import parser.Parser;

import java.io.IOException;

/**
 * 程序入口
 */
public class Main {
    /**
     * main创建了一个词法分析器和一个语法分析器，然后调用语法分析器中的方法program
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Lexer lexer = new Lexer();
        Parser parser = new Parser(lexer);
        parser.program();
        System.out.write('\n');
    }
}
