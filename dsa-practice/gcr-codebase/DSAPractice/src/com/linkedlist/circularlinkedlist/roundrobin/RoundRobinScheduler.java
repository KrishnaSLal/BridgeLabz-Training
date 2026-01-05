package com.linkedlist.circularlinkedlist.roundrobin;

class RoundRobinScheduler {

    private ProcessNode head = null;

    // Add process at end
    public void addProcess(int pid, int bt, int pr) {
        ProcessNode newNode = new ProcessNode(pid, bt, pr);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Remove process by PID
    private void removeProcess(int pid) {
        if (head == null) return;

        ProcessNode temp = head, prev = null;

        do {
            if (temp.processId == pid) {
                if (temp == head) {
                    ProcessNode last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Display circular queue
    public void displayQueue() {
        if (head == null) {
            System.out.println("No processes.");
            return;
        }
        ProcessNode temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print("P" + temp.processId + "(" + temp.remainingTime + ") ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Round Robin Scheduling Simulation
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        ProcessNode temp = head;
        int totalProcesses = 0;
        int totalTime = 0;

        // Count processes for avg calculation
        ProcessNode t = head;
        do { totalProcesses++; t = t.next; } while (t != head);

        int[] waitingTime = new int[totalProcesses];
        int[] turnAroundTime = new int[totalProcesses];
        int index = 0;

        System.out.println("\n--- Round Robin Simulation ---");
        while (head != null) {
            displayQueue();
            if (temp.remainingTime <= timeQuantum) {
                totalTime += temp.remainingTime;
                turnAroundTime[index] = totalTime;
                waitingTime[index] = totalTime - temp.burstTime;
                int pidToRemove = temp.processId;
                temp = temp.next;
                removeProcess(pidToRemove);
                index++;
            } else {
                totalTime += timeQuantum;
                temp.remainingTime -= timeQuantum;
                temp = temp.next;
            }

            if (head == null) break; // all done
        }

        // Calculate average times
        double avgWT = 0, avgTAT = 0;
        for (int i = 0; i < totalProcesses; i++) {
            avgWT += waitingTime[i];
            avgTAT += turnAroundTime[i];
        }
        avgWT /= totalProcesses;
        avgTAT /= totalProcesses;

        System.out.println("\nAverage Waiting Time = " + avgWT);
        System.out.println("Average Turnaround Time = " + avgTAT);
    }
}
