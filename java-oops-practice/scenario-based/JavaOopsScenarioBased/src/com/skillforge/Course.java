package com.skillforge;

class Course {

    private String title;
    private Instructor instructor;
    private double rating;
    private String[] modules;
    private String[] reviews;   // read-only data

    // Constructor with default modules
    public Course(String title, Instructor instructor) {
        this(title, instructor, new String[]{"Introduction", "Basics", "Final Project"});
    }

    // Constructor with custom modules
    public Course(String title, Instructor instructor, String[] modules) {
        this.title = title;
        this.instructor = instructor;
        this.modules = modules;
        this.reviews = new String[]{"Great course!", "Very helpful"};
        this.rating = 0.0;
    }

    protected void calculateRating(int totalScore, int reviewers) {
        rating = (double) totalScore / reviewers;  // protected logic
    }

    public double getRating() {
        return rating;
    }

    public String[] getModules() {
        return modules;
    }

    public String[] getReviews() {
        return reviews;   // read-only exposure
    }

    public String getTitle() {
        return title;
    }
}
