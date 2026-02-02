package com.resumeanalyzer;

public class ResumeData {
    private String email;
    private String phone;
    private int keywordCount;
    private String fileName;

    public ResumeData(String email, String phone, int keywordCount, String fileName) {
        this.email = email;
        this.phone = phone;
        this.keywordCount = keywordCount;
        this.fileName = fileName;
    }

    public String getEmail() {
        return email;
    }

    public int getKeywordCount() {
        return keywordCount;
    }

    @Override
    public String toString() {
        return "ResumeData{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", keywordCount=" + keywordCount +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
