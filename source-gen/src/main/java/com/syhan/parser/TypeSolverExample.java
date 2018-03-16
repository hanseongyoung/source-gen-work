package com.syhan.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.symbolsolver.javaparser.Navigator;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;

public class TypeSolverExample {

    static String readMyExample() {
        return "class Foo { private String a; void aMethod() { float a; while(true) { int a; a = a + 1; } } }";
    }

    public static void main(String[] args) {
        TypeSolver typeSolver = new CombinedTypeSolver();
        String code = readMyExample();
        CompilationUnit cu = JavaParser.parse(code);
        AssignExpr assignExpr = Navigator.findNodeOfGivenClass(cu, AssignExpr.class);

        System.out.println(String.format("Type of %s is %s",
              assignExpr, JavaParserFacade.get(typeSolver).getType(assignExpr)));
    }
}
