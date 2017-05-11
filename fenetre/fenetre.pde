

void setup(){

  size(480,480);
  background(100,100,100);
}

void draw(){
  drawLinesOriz();
  drawLinesVert();
}

void drawLinesOriz(){
  int x1 = 0;
  int y1 = 0;
  int x2 = width;
  int y2 = 0;
  for (int i=0; i<12; i++){
    line(x1,y1+40,x2,y2+40);
    y1 += 40;
    y2 += 40;
    stroke(255);
  }
}

void drawLinesVert(){
  int x1 = 0;
  int y1 = 0;
  int x2 = 0;
  int y2 = height;
  for (int i=0; i<12; i++){
    line(x1,y1,x2,y2);
    x1 += 40;
    x2 += 40;
    stroke(255);
  }
}
