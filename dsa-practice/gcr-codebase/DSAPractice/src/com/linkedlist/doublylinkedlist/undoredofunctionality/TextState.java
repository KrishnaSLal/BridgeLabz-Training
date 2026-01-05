package com.linkedlist.doublylinkedlist.undoredofunctionality;

class TextState {
    String content; // the text at this state
    TextState prev; // previous state (undo)
    TextState next; // next state (redo)

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}
