package settlers.catan;

public abstract class Clickable {
	public abstract int getXcord();
	public abstract int getYcord();
	public abstract int getRadius();
	public boolean isInRange(int xCord, int yCord){
		return Math.pow(
				(xCord-getXcord())*(xCord-getXcord())+
				(yCord-getYcord())*(yCord-getYcord()),.5) <= getRadius();
	}

}
