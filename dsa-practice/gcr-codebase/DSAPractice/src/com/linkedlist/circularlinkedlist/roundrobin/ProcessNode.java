package com.linkedlist.circularlinkedlist.roundrobin;

class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    ProcessNode next;

    ProcessNode(int pid, int bt, int pr) {
        this.processId = pid;
        this.burstTime = bt;
        this.remainingTime = bt;
        this.priority = pr;
        this.next = null;
    }
}
