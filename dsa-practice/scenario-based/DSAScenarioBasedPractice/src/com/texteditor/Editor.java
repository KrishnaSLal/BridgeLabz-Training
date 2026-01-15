package com.texteditor;

public class Editor {

    private String text = "";
    private TextActionManager actionManager;

    public Editor(TextActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public void insertText(String newText) {
        actionManager.saveState(text);
        text = text + newText;
    }

    public void deleteText(int n) {
        if (n > text.length()) {
            System.out.println("Invalid delete count!");
            return;
        }
        actionManager.saveState(text);
        text = text.substring(0, text.length() - n);
    }

    public String undo() {
        text = actionManager.undo(text);
        return text;
    }

    public String redo() {
        text = actionManager.redo(text);
        return text;
    }

    public String getText() {
        return text;
    }
}
