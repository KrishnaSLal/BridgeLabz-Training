package com.universitycourseenrollmentsystem;

class Postgraduate extends Student {

    public Postgraduate(int id, String name, String elective) {
        super(id, name, elective);
    }

    @Override
    public String getTranscript() {
        return "[PG] " + super.getTranscript();
    }
}
