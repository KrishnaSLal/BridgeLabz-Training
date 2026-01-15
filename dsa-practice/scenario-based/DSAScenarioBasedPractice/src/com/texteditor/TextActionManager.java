package com.texteditor;

import java.util.Stack;

public class TextActionManager {

    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    public void saveState(String text) {
        undoStack.push(text);
        redoStack.clear();
    }

    public String undo(String currentText) {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return currentText;
        }
        redoStack.push(currentText);
        return undoStack.pop();
    }

    public String redo(String currentText) {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return currentText;
        }
        undoStack.push(currentText);
        return redoStack.pop();
    }
}
