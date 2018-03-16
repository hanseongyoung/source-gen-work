package com.syhan.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparser.Navigator;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;

public class UsingJavaSymbolSolverExample {
    //
    public static void main(String[] args) throws Exception {
        TypeSolver typeSolver = getMyTypeSolver();
        CompilationUnit cu = JavaParser.parse(getSampleCode());

        // Get the FieldDeclaration
        FieldDeclaration fieldDeclaration = Navigator.findNodeOfGivenClass(cu, FieldDeclaration.class);

        // A FieldDeclaration could contain many variables: get the first one and get its JavaParser type
        ResolvedType fieldType = JavaParserFacade.get(typeSolver).convertToUsage(
                fieldDeclaration.getVariables().get(0).getType(), fieldDeclaration);
        System.out.println("Field type: " + fieldType.asReferenceType().getQualifiedName());
    }

    private static TypeSolver getMyTypeSolver() throws Exception {
        TypeSolver myTypeSolver = new CombinedTypeSolver(
                new ReflectionTypeSolver(),
                JarTypeSolver.getJarTypeSolver("jars/library1.jar"),
                JarTypeSolver.getJarTypeSolver("jars/library2.jar"),
                JarTypeSolver.getJarTypeSolver("jars/library3.jar"),
                new JavaParserTypeSolver(new File("src/main/java")),
                new JavaParserTypeSolver(new File("generated_code"))
        );
        return myTypeSolver;
    }

    private static String getSampleCode() {
        return "package pack.b; import pack.a.*; class Foo { Bar bar; }";
    }
}
