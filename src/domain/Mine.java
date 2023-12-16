package domain;

import java.io.Serializable;

public class Mine extends Casillas implements Serializable {
    private boolean explotado = false;
    public Mine(int x, int y) {
        super(x, y);
        type = 'M';

    }
    public void explotar(Jugador jugador,Casillas[][] casillas) {
            for (int i = getX() - 1; i <= getX() + 1; i++) {
                for (int j = getY() - 1; j <= getY() + 1; j++) {
                    if (i >= 0 && i < casillas.length && j >= 0 && j < casillas[0].length) {
                        casillas[i][j].setFicha(' '); // Eliminar la piedra en el espacio 3x3
                    }
                }
            }
            explotado = true;
    }

}
