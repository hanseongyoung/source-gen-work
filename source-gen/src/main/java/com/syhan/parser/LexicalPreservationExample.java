package com.syhan.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParseStart;
import com.github.javaparser.StringProvider;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter;
import com.github.javaparser.utils.Pair;

public class LexicalPreservationExample {
    //

    // TODO : see https://dzone.com/articles/implementing-lexical-preservation-for-javaparser-1


    public static void main(String[] args) {
        String code = "class A {}";

        // FIXME : deprecation
        Pair<ParseResult<CompilationUnit>, LexicalPreservingPrinter> result = LexicalPreservingPrinter.setup(
                ParseStart.COMPILATION_UNIT, new StringProvider(code));
        CompilationUnit cu = result.a.getResult().get();
        LexicalPreservingPrinter lpp = result.b;

        //
        ClassOrInterfaceDeclaration myClass = cu.getClassByName("A").get();
        myClass.setName("MyNewClassName");
        myClass.addModifier(Modifier.PUBLIC);
        cu.setPackageDeclaration("org.javaparser.lexicalpreservation.examples");

        System.out.println(lpp.print(cu));
    }
}
