typedef struct Rect;
Rect* NewRect (void);
void DragRect (Rect* this, int dx, int dy);
void PrintRect (Rect* this);