package com.example.mars;

public class MarsPosition {
	private int x;
	private int y;
	private char dir;
	
	public MarsPosition(int x, int y, char dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public char getDir() {
		return this.dir;
	}

	public String toString() {
		return String.format("(%d, %d, %c)", x, y, dir);
	}

	public void turnLeft() {
		switch(this.dir) {
			case 'N':
				this.dir = 'W';
				break;
			case 'S':
				this.dir = 'E';
				break;
			case 'E':
				this.dir = 'N';
				break;
			case 'W':
				this.dir = 'S';
				break;
		}
	}

	public void turnRight() {
		switch(this.dir) {
			case 'N':
				this.dir = 'E';
				break;
			case 'S':
				this.dir = 'W';
				break;
			case 'E':
				this.dir = 'S';
				break;
			case 'W':
				this.dir = 'N';
				break;
		}
	}

	public void move() {
		switch(this.dir) {
			case 'N':
				this.y++;
				break;
			case 'S':
				this.y--;
				break;
			case 'E':
				this.x++;
				break;
			case 'W':
				this.x--;
				break;
		}
	}
}
