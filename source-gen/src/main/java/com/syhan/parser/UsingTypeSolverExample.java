package com.syhan.parser;

import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

public class UsingTypeSolverExample {
    public static void main(String[] args) {
        TypeSolver typeSolver = new ReflectionTypeSolver();

        showReferenceTypeDeclaration(typeSolver.solveType("java.lang.Object"));
        showReferenceTypeDeclaration(typeSolver.solveType("java.lang.String"));
        showReferenceTypeDeclaration(typeSolver.solveType("java.util.List"));
    }

    private static void showReferenceTypeDeclaration(ResolvedReferenceTypeDeclaration referenceTypeDeclaration) {
        //
        System.out.println(String.format("== %s ==", referenceTypeDeclaration.getQualifiedName()));
        System.out.println("  fields: ");
        referenceTypeDeclaration.getAllFields()
                .forEach(f -> System.out.println(String.format("    %s %s", f.getType(), f.getName())));
        System.out.println("  methods: ");
        referenceTypeDeclaration.getAllMethods()
                .forEach(m -> System.out.println(String.format("    %s", m.getQualifiedSignature())));
        System.out.println();
    }
}
