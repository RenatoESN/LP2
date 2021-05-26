#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

typedef struct Rect {
	int x, y
    int w, h;
} Rect;

Rect* NewRect (void) {
	Rect* this = malloc(sizeof(Rect));
	this->x = 0;
	this->y = 0;
	this->w = 20;
	this->h = 10;
}

void DragRect (Rect* this, int dx, int dy) {
	this->x += dx;
	this->y += dy;
}

void PrintRect (Rect* this) {
	printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n", this->w, this->h, this->x, this->y);
}