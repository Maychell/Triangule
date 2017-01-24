private final int ALICE_COLOUR = 200;
private final int ALICE_SPEED  = 15;

private Patroller alice;

void setup() {
  size(1000, 500);
  background(255);
  alice = new Patroller(20, 30, ALICE_COLOUR, ALICE_SPEED);
}

void draw() {
  background(255);
  alice.checkIfHasReached();
  alice.drawCircle();
  alice.move();
  alice.display();
}