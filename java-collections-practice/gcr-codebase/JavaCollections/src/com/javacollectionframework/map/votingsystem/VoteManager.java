package com.javacollectionframework.map.votingsystem;

import java.util.*;

public class VoteManager {
    private Map<String, Integer> hashMapVotes = new HashMap<>();       // Candidate -> votes (fast updates)
    private Map<String, Integer> linkedHashMapVotes = new LinkedHashMap<>(); // Maintain vote insertion order
    private Map<String, Integer> treeMapVotes = new TreeMap<>();       // Sorted by candidate name

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        hashMapVotes.put(candidate, hashMapVotes.getOrDefault(candidate, 0) + 1);
        linkedHashMapVotes.put(candidate, linkedHashMapVotes.getOrDefault(candidate, 0) + 1);
        treeMapVotes.put(candidate, treeMapVotes.getOrDefault(candidate, 0) + 1);
        System.out.println("Vote casted for " + candidate);
    }

    // Display votes in insertion order
    public void displayVotesInOrder() {
        System.out.println("Votes in order of casting (LinkedHashMap):");
        linkedHashMapVotes.forEach((candidate, votes) -> 
            System.out.println(candidate + " -> " + votes + " votes"));
    }

    // Display votes sorted by candidate name
    public void displayVotesSorted() {
        System.out.println("Votes sorted by candidate name (TreeMap):");
        treeMapVotes.forEach((candidate, votes) ->
            System.out.println(candidate + " -> " + votes + " votes"));
    }

    // Get total votes for a candidate
    public int getVotesForCandidate(String candidate) {
        return hashMapVotes.getOrDefault(candidate, 0);
    }

    // Display all candidates and votes
    public void displayAllVotes() {
        System.out.println("All votes (HashMap):");
        hashMapVotes.forEach((candidate, votes) ->
            System.out.println(candidate + " -> " + votes + " votes"));
    }
}
