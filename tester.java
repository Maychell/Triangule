Patroller t;

void setup() {
  size(1000, 500);
  background(255);
  t = new Patroller(10, 10, 200, 15);
}

void draw() {
  background(255);
  t.checkIfHasReached();
  t.move();
  t.display();
}