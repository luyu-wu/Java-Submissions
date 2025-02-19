
public class superhero {
	private String name;
	private power Power;
	static int creations = 0;
	
	
	public superhero(String newName, power newPower){
		Power = newPower;
		name = newName;
		creations ++;
	}

	public String getName(){
		return name;
	}
	public void changePower(power newPower){
		Power = newPower;
	}
	public power getPower(){
		return Power;
	}
	static public int getCreations(){
		return creations;
	}

	public void setStrength(int newStrength) {
		Power.changeStrength(newStrength);
	}
}
