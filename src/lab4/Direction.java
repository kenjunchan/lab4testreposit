package lab4;


public enum Direction {

	NORTH("north",4),
	NORTHEAST("northeast",0),
	EAST("east",5),
	SOUTHEAST("southeast",2),
	SOUTH("south",6),
	SOUTHWEST("southwest",3),
	WEST("west",7),
	NORTHWEST("northwest",1);
	
	private String name = null;
	private int num;
	private Direction(String s, int n){
		name = s;
		num = n;
	}
	public String getName() {
		return name;
	}
	public int getNum() {
		return num;
	}
	
	//returns the string equivalent to the associated integer value
	public static String getStrEquiv(int n) {
		switch(n) {
		case 0:
			return "northeast";
		case 1:
			return "northwest";
		case 2:
			return "southeast";
		case 3:
			return "southwest";
		case 4:
			return "north";
		case 5:
			return "east";
		case 6:
			return "south";
		case 7:
			return "west";
		default:
			return "southeast"; 
		}
	}
}
