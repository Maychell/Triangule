import java.util.Objects;

class Circle {
	private int xPos;
	private int yPos;

	public Circle(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	public int getXPos() {
		return xPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}

	public int getYPos() {
		return this.yPos;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() != getClass()) return false;

		final Circle myCircle = (Circle) obj;
		return myCircle.getXPos() == getXPos() &&
			 		 myCircle.getYPos() == getYPos();
	}

	@Override
  public int hashCode() {
  	return Objects.hash(xPos, yPos);
  }
}