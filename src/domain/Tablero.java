package domain;
import java.io.Serializable;
import java.util.Random;

/**
 * La clase Tablero representa el tablero de juego para un juego específico.
 * Contiene métodos para inicializar, modificar y visualizar el tablero.
 */
public class Tablero implements Serializable {
    private Casillas[][] casillas;
    private int Longitud,Altura;
    private boolean Fespecial,Cespecial;

    /**
     * Constructor de la clase Tablero que inicializa el tablero con dimensiones dadas y características especiales.
     * @param Longitud El ancho del tablero.
     * @param Altura La altura del tablero.
     * @param FichaE Booleano que indica si existen fichas especiales.
     * @param CasillasE Booleano que indica si existen casillas especiales.
     */
    public Tablero(int Longitud,int Altura,boolean FichaE,boolean CasillasE){
        this.Longitud = Longitud;
        this.Altura = Altura;
        Fespecial = FichaE;
        Cespecial = CasillasE;
        casillas = new Casillas[Longitud][Altura];
        inicial();
    }

    /**
     * Método privado que inicializa el tablero, creando e inicializando cada casilla.
     */
    private void inicial() {
        for(int i = 0; i < Longitud; i++){
            for(int y = 0; y < Altura; y++){
                Casillas casilla = new Casillas(i, y);
                casillas[i][y] = casilla;
            }
        }
        if(Cespecial){
            generarCasillasEspeciales(100);
        }
    }

    /**
     * Asigna una casilla específica en una posición dada en el tablero.
     * @param x La coordenada X de la casilla en el tablero.
     * @param y La coordenada Y de la casilla en el tablero.
     * @param casilla La casilla a asignar en la posición dada.
     */
    public void setCasilla(int x,int y,Casillas casilla){
        casillas[x][y] = casilla;
    }

    /**
     * Obtiene la casilla en una posición específica del tablero.
     * @param x La coordenada X de la casilla en el tablero.
     * @param y La coordenada Y de la casilla en el tablero.
     * @return La casilla en la posición dada.
     */
    public Casillas getCasilla(int x, int y){
        return casillas[x][y];
    }


    /**
     * Coloca una ficha en una casilla específica del tablero.
     * @param x La coordenada X de la casilla en el tablero.
     * @param y La coordenada Y de la casilla en el tablero.
     * @param ficha El carácter de la ficha a colocar en la casilla.
     */
    public void colocarFicha(int x,int y,char ficha){
        casillas[x][y].setFicha(ficha);
    }

    /**
     * Obtiene la longitud (ancho) del tablero.
     * @return La longitud del tablero.
     */
    public int getLongitud(){
        return Longitud;
    }

    /**
     * Obtiene la altura del tablero.
     * @return La altura del tablero.
     */
    public int getAltura(){
        return Altura;
    }

    /**
     * Obtiene todas las casillas del tablero.
     * @return La matriz de casillas que representa el tablero.
     */
    public Casillas[][] getCasillas(){
        return casillas;
    }

    /**
     * Reinicia todas las casillas del tablero.
     * Si hay casillas especiales, las recrea; de lo contrario, solo limpia las fichas.
     */
    public void reiniciarTablero() {
        for (int i = 0; i < Longitud; i++) {
            for (int j = 0; j < Altura; j++) {
                if (casillas[i][j] instanceof Casillas) {
                    casillas[i][j].setFicha(' ');
                } else {
                    // Si es una casilla especial, crear una nueva instancia en lugar de reiniciarla
                    if (casillas[i][j] instanceof Mine) {
                        casillas[i][j] = new Mine(i, j);
                    } else if (casillas[i][j] instanceof Teleport) {
                        casillas[i][j] = new Teleport(i, j);
                    } else if (casillas[i][j] instanceof Golden) {
                        casillas[i][j] = new Golden(i, j);
                    }
                }
            }
        }
    }

    /**
     * Genera un número determinado de casillas especiales aleatorias en el tablero.
     * @param cantidadBloqueadas La cantidad de casillas especiales a generar.
     */
    public void generarCasillasEspeciales(int cantidadBloqueadas) {
        Random random = new Random();
        int contador = 0;
        while (contador < cantidadBloqueadas) {
            int x = random.nextInt(Longitud);
            int y = random.nextInt(Altura);
            int z = random.nextInt(3)+1;
            switch(z) {
                case 1:
                    if (!(casillas[x][y] instanceof Mine)) {
                        casillas[x][y] = new Mine(x, y);
                        contador++;
                    }
                    break;
                case 2:
                    if (!(casillas[x][y] instanceof Teleport)) {
                        casillas[x][y] = new Teleport(x, y);
                        contador++;
                    }
                    break;
                case 3:
                    if (!(casillas[x][y] instanceof Golden)) {
                        casillas[x][y] = new Golden(x, y);
                        contador++;
                    }
                    break;
                default:
                    if (!(casillas[x][y] instanceof Casillas)) {
                        casillas[x][y] = new Casillas(x, y);
                        contador++;
                    }
                    break;
            }
        }
    }


    /**
     * Imprime el tablero actual en la consola, mostrando las fichas y los tipos de las casillas.
     */
    public void imprimirTablero() {
        System.out.print("   ");
        for (int i = 0; i < Longitud; i++) {
            System.out.print(i  + "  ");
        }
        System.out.println();

        for (int i = 0; i < Longitud; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < Altura; j++) {
                System.out.print(casillas[i][j].getFicha() + " | ");
                //System.out.print(casillas[i][j].getType()+ " | ");
            }
            System.out.println();
        }
        for (int i = 0; i < Longitud; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < Altura; j++) {
                //System.out.print(casillas[i][j].getFicha() + " | ");
                System.out.print(casillas[i][j].getType()+ " | ");
            }
            System.out.println();
        }
    }
}
