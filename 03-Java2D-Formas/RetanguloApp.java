class Retangulo{
    int x, y;
    int largura, altura;
    Retangulo (int posx, int posy, int largura, int altura){
        this.x = posx;
        this.y = posy;
        this.largura = largura;
        this.altura = altura;
    }
    int area(){
        int space;
        int b = this.largura;
        int h = this.altura;
        space = b * h;
        return space;
    }
    void drag(int dx, int dy){
        this.x = this.x + dx;
        this.y =this.y + dy;        
    }
}

