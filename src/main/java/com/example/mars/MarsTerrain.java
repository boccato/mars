package com.example.mars;

public class MarsTerrain {
	private int height;
	private int width;
	
	public MarsTerrain(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public boolean isValidPosition(MarsPosition position) {
		return position.getX() >= 0 && position.getX() < this.width &&
		       position.getY() >= 0 && position.getY() < this.height;
	}
}
