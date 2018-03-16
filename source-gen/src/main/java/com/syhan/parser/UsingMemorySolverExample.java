package com.syhan.parser;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.symbolsolver.core.resolution.Context;
import com.github.javaparser.symbolsolver.javaparsermodel.contexts.CompilationUnitContext;
import com.github.javaparser.symbolsolver.model.resolution.SymbolReference;
import com.github.javaparser.symbolsolver.resolution.typesolvers.MemoryTypeSolver;

public class UsingMemorySolverExample {
    public static void main(String[] args) throws Exception {
//        CompilationUnit cu = parseSample("CompilationUnitWithImports");
//        Context context = new CompilationUnitContext(cu, typeSolver);
//        ResolvedReferenceTypeDeclaration otherClass = EasyMock.createMock(ResolvedReferenceTypeDeclaration.class);
//        EasyMock.expect(otherClass.getQualifiedName()).andReturn("com.foo.OtherClassInSamePackage");
//
//        /* Start of the relevant part */
//        MemoryTypeSolver memoryTypeSolver = new MemoryTypeSolver();
//        memoryTypeSolver.addDeclaration("com.foo.OtherClassInSamePackage", otherClass);
//        /* End of the relevant part */
//
//        EasyMock.replay(otherClass);
//        SymbolReference<TypeDeclaration> ref = context.solveType("OtherClassInSamePackage", memoryTypeSolver);
//        assertEquals(true, ref.isSolved());
//        assertEquals("com.foo.OtherClassInSamePackage", ref.getCorrespondingDeclaration().getQualifiedName());
    }
}
