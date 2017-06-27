package com.example.mars;

import java.util.Optional;

public class MarsBotNavigator {
	private MarsPosition currentPosition;
	private MarsTerrain terrain;

	public MarsBotNavigator(MarsPosition startPosition, MarsTerrain terrain) {
		this.currentPosition = startPosition;
		this.terrain = terrain;
	}

	public Optional<MarsPosition> execute(String cmd) {
		MarsPosition position = this.currentPosition;
		for (char c : cmd.toCharArray()) {
			switch (c) {
				case 'L':
					position.turnLeft();
					break;
				case 'R':
					position.turnRight();
					break;
				case 'M':
					position.move();
					break;
				default:
					return Optional.empty();
			}
		}
		if (this.terrain.isValidPosition(position)) {
			this.currentPosition = position;
			return Optional.of(this.currentPosition);
		}
		else {
			return Optional.empty();
		}		
	}
}
