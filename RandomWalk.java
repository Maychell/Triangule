import java.util.Random;

class RandomWalk extends Triangule {
  private final int MIN_RANDOM              = 1;
  private final int MAX_RANDOM              = 7;
  private final int CHANGE_NOTHING          = 1;
  private final int TURN_RIGHT 	            = 2;
  private final int TURN_LEFT               = 3;
  private final int VERTICAL_HORIENTATION   = 4;
  private final int HORIZONTAL_HORIENTATION = 5;
  private final int FORWARDS_DIRECTION      = 6;
  private final int BACKWARDS_DIRECTION     = 7;

  public RandomWalk(int width, int height, int colour, int speed) {
    super(width, height, colour, speed);

    setHorientation(VERTICAL);
    setDirection(FORWARDS);
  }

  public void move() {
    moveRamdomly();

    if(isForwards())
      moveForwards();
    else
      moveBackwards();
  }

  private void moveRamdomly() {
  	int movement_id = generateRandom();

  	switch(movement_id) {
  		case TURN_RIGHT:
  			turnRight();
  			break;
  		case TURN_LEFT:
  			turnLeft();
  			break;
  		case VERTICAL_HORIENTATION:
  			setHorientation(VERTICAL);
  			break;
  		case HORIZONTAL_HORIENTATION:
  			setHorientation(HORIZONTAL);
  			break;
  		case FORWARDS_DIRECTION:
  			setDirection(FORWARDS);
  			break;
  		case BACKWARDS_DIRECTION:
  			setDirection(BACKWARDS);
  			break;
  	}

    checkIfHasReached();
  }

  private int generateRandom() {
    Random rand = new Random();
    return rand.nextInt(MAX_RANDOM) + MIN_RANDOM;
  }

  public void checkIfHasReached() {
    if(hasReachedMaxHeight() || hasReachedMinHeight() || hasReachedMinWidth() || hasReachedMaxWidth()) {
    	if(isForwards())
      	setDirection(BACKWARDS);
      else
      	setDirection(FORWARDS);
    }
  }
}
