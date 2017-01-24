private final int ALICE_COLOUR = 200;
private final int ALICE_SPEED  = 15;

private Patroller alice;

void setup() {
  size(1000, 500);
  background(255);
  alice = new Patroller(10, 10, ALICE_COLOUR, ALICE_SPEED);
}

void draw() {
  background(255);
  alice.checkIfHasReached();
  alice.move();
  alice.display();
}