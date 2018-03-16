package com.syhan.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.util.List;
import java.util.stream.Collectors;

public class CommentReportExample {
    private static final String FILE_PATH = "source-gen/src/main/java/com/github/javaparser/ReversePolishNotation.java";

    public static void main(String[] args) throws Exception {
        CompilationUnit cu = JavaParser.parse(new FileInputStream(FILE_PATH));

//        List<Comment> comments = cu.getAllContainedComments();
//        comments.forEach(System.out::println);

        List<CommentReportEntry> comments = cu.getAllContainedComments().stream()
                .map(p -> new CommentReportEntry(p.getClass().getSimpleName(), p.getContent(), p.getRange().get().begin.line, !p.getCommentedNode().isPresent()))
                .collect(Collectors.toList());
        comments.forEach(System.out::println);
    }

    private static class CommentReportEntry {
        private String type;
        private String text;
        private int lineNumber;
        private boolean isOrphan;
        CommentReportEntry(String type, String text, int lineNumber, boolean isOrphan) {
            this.type = type;
            this.text = text;
            this.lineNumber = lineNumber;
            this.isOrphan = isOrphan; }
        @Override
        public String toString() {
            return lineNumber + "|" + type + "|" + isOrphan + "|" +
                    text.replaceAll("\\n", "").trim();
        }
    }
}
