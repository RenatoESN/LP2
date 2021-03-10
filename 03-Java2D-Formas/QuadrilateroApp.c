typedef struct
{
    int posx, posy;
    int largura;
    int altura;
} Quad;
void print (Quad* fig){
    printf("Quadrilatero de dimensões %d e %d. Na posicao %d e %d\n", fig->largura, fig->altura, fig->posx, fig->posy)
}