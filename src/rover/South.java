package rover;

public class South extends Direction {

	@Override
	String getCompassPoint(){
		return "S";
	}

	@Override
	Direction turnRight() {
		return new West();
	}

	@Override
	Direction turnLeft() {
		return new East();
	}

	@Override
	Point goForward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();

		if (onBottomEdgeOfGrid(y)) y = wrapToTopEdgeOfGrid(y, planet);
		else y = moveDownOnGrid(y);
		
		if(planet.hasObstacleAt(new Point(x,y))) return goBackward(new Point(x,y), planet);
		
		return new Point(x, y);
	}

	@Override
	Point goBackward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();

		if(onTopEdgeOfGrid(y, planet)) y = wrapToBottomEdgeOfGrid(y);
		else y = moveUpOnGrid(y);
		if(planet.hasObstacleAt(new Point(x,y))) return goForward(new Point(x,y), planet);
		return new Point(x, y);
	}
}