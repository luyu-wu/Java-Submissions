public class main {
	public static void main(String[] args) {
		power newPower = new power("Invisibility", 200);

		superhero Hero = new superhero("我的妈呀！！",newPower);

		System.out.println(Hero);
		System.out.println(Hero.getPower().getStrength());		
		System.out.println(Hero.getCreations());


		superhero Hero2 = new superhero("我的妈呀！！",newPower);

		System.out.println(Hero2);
		System.out.println(Hero2.getPower().getStrength());		
		System.out.println(Hero2.getCreations());

	}
}
