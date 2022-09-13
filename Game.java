import java.util.*;


class Game {

	public int total_sticks;
	private int curr_sticks;

	
	



	public Game(int total_sticks) {
		System.out.println(total_sticks);
		AI a = new AI(total_sticks);

		System.out.println(a.b1);
		System.out.println(a.b2);
		System.out.println(a.b3 + "\n");

		a.choose();
		a.bias_update(true);
		
		System.out.println(a.b1);
		System.out.println(a.b2);
		System.out.println(a.b3 + "\n");


		a.choose();
		a.bias_update(true);
		
		System.out.println(a.b1);
		System.out.println(a.b2);
		System.out.println(a.b3 + "\n");
		
	}
}