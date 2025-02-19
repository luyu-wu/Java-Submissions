public class power {
	private String name;
	private int strength;
	public power (String newName, int newStrength) {
		name = newName;
		strength = newStrength;
	}

	public void changeStrength(int newStrength) {
		strength = newStrength;
	}
	public int getStrength() {
		return strength;
	}
	public String getName() {
		return name;
	}
}
