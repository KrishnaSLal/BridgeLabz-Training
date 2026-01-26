package com.javastreams.pipedstreams;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;
    private String message;

    public WriterThread(PipedOutputStream pos, String message) {
        this.pos = pos;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            pos.write(message.getBytes());
            pos.close();
        } catch (IOException e) {
            System.out.println("Writer Thread Error");
            e.printStackTrace();
        }
    }
}