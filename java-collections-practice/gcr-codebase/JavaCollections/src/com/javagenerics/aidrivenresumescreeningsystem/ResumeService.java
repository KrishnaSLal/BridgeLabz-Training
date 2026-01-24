package com.javagenerics.aidrivenresumescreeningsystem;

public class ResumeService {
   public static <T extends JobRole> Resume<T> generateResume(String candidateName, T role) {

	        if (candidateName == null || candidateName.trim().isEmpty()) {
	            throw new IllegalArgumentException("Candidate name cannot be empty!");
	        }

	        return new Resume<>(candidateName, role);
	 }
}
