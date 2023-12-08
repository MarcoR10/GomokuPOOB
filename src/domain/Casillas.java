package domain;

public class Casillas {
    protected int x,y;
    protected char ficha,type;
    public Casillas(int x, int y) {
        this.x = x;
        this.y = y;
        ficha = ' ';
        type = 'N';
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setFicha(char Ficha){
        this.ficha = Ficha;
    }
    public char getFicha(){
        return ficha;
    }
    public char getType(){
        return type;
    }
}
