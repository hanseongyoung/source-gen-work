package com.syhan.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;

public class ParsingOptionExample {
    private static final String FILE_PATH = "source-gen/src/main/java/com/github/javaparser/ReversePolishNotation.java";

    public static void main(String[] args) throws Exception {
        ParserConfiguration parserConfiguration = new ParserConfiguration()
                .setAttributeComments(false);
        JavaParser.setStaticConfiguration(parserConfiguration);

        CompilationUnit cu = JavaParser.parse(new FileInputStream(FILE_PATH));
        System.out.println(cu.toString());
    }
}
