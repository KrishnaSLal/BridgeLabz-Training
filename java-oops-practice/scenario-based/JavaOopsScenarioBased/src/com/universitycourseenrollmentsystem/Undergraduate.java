package com.universitycourseenrollmentsystem;

class Undergraduate extends Student {

    public Undergraduate(int id, String name) {
        super(id, name);
    }

    @Override
    public String getTranscript() {
        return "[UG] " + super.getTranscript();
    }
}
