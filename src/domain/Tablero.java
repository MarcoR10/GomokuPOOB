package domain;
import java.util.Random;
public class Tablero {
    private Casillas[][] casillas;
    private int Longitud,Altura;
    private boolean Fespecial,Cespecial;
    public Tablero(int Longitud,int Altura,boolean FichaE,boolean CasillasE){
        this.Longitud = Longitud;
        this.Altura = Altura;
        Fespecial = FichaE;
        Cespecial = CasillasE;
        casillas = new Casillas[Longitud][Altura];
        inicial();
    }
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
    public void setCasilla(int x,int y,Casillas casilla){
        casillas[x][y] = casilla;
    }

    public Casillas getCasilla(int x, int y){
        return casillas[x][y];
    }

    public void colocarFicha(int x,int y,char ficha){
        casillas[x][y].setFicha(ficha);
    }

    public int getLongitud(){
        return Longitud;
    }

    public int getAltura(){
        return Altura;
    }

    public Casillas[][] getCasillas(){
        return casillas;
    }

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
