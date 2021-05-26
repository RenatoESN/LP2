#include <stdlib.h>
#include "rect.h"

void main (void) {
    Rect* retangulo1 = NewRect();
    PrintRect(retangulo1);

    Rect* retangulo2 = NewRect();
    DragRect(retangulo2, 10,100);
    PrintRect(retangulo2);

    free(retangulo1);
    free(retangulo2);
}