package com.gamerzone;

public class Scores {

	private int id;
	private int score;

	public Scores(int id, int score) {
		this.id = id;
		this.score = score;
	}

	public int getId() {
		return id;
	}
	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "ID: " + id + "| Score: " + score;
	}
}
