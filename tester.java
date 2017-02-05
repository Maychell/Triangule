private final int ALICE_COLOUR = 200;
private final int ALICE_SPEED  = 10;
private final int BOB_COLOUR   = 10;
private final int BOB_SPEED    = 20;

private Triangule alice, bob;

void setup() {
  size(1000, 500);
  background(255);
  alice = new Patroller(30, 20, ALICE_COLOUR, ALICE_SPEED);
  bob   = new RandomWalk(30, 20, BOB_COLOUR, BOB_SPEED);
}

void draw() {
  background(255);
  bob.move();
  bob.display();

  alice.move();
  alice.display();
}