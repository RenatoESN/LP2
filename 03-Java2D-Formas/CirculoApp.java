class Circulo{
    int x, y;
    int raio;
    Circulo (int posx, int posy, int raio){
        this.x = posx;
        this.y = posy;
        this.raio = raio;
    }
    void print(){
        System.out.println("Circulo na posicao %d e %d e de raio %d", this.x, this.y, this.raio);
    }
}
