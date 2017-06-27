package com.example.mars;

import java.util.Optional;

/*
O terreno deverá ser iniciado com 5x5 posições;
O robô inicia na coordenada (0,0,N);
Deverá ser possível enviar um comando para o Robô que me retorne a posição final dele;
O Robô não pode se movimentar para fora da área especificada;
Não deve guardar estado do robô para consulta posterior;
*/

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
