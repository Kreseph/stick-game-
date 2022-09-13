import java.util.*;


class AI{

	// 
	public int total_sticks;
	public int curr_sticks;


	// bias memory
	List<Integer> bmem = new ArrayList<Integer>();

	// bias 1, 2, and 3
	List<Integer> b1 = new ArrayList<Integer>();
	List<Integer> b2 = new ArrayList<Integer>();
	List<Integer> b3 = new ArrayList<Integer>();
	
	public AI(int total_sticks){
		
		// setting the current stick ammount
		curr_sticks = total_sticks;

		for(int i = 0; i < total_sticks; i ++) {
			bmem.add(0);
			b1.add(1);
			b2.add(1);
			b3.add(1);
		}
	}

	public void reset() {

		// resetting the current stick ammount
		curr_sticks = total_sticks;

		// resetting the baises and the bais memory
		for(int i = 0; i < total_sticks; i ++) {
			bmem.set(i, 0);
			b1.set(i, 1);
			b2.set(i, 1);
			b3.set(i, 1); 
		}
		
	}

	public int choose() {

		// initalizing random obj and the number pool
		Random r = new Random();
		List<Integer> numPool = new ArrayList<Integer>();

		// adding correct number of each option to the number pool
		for (int i = 0; i < b1.get(curr_sticks - 1); i ++) {
			numPool.add(1); }
		for (int i = 0; i < b2.get(curr_sticks - 1); i ++) {
			numPool.add(2); }
		for (int i = 0; i < b3.get(curr_sticks - 1); i ++) {
			numPool.add(3); }

		// getting a random index for the number pool
		int ran = r.nextInt(numPool.size());
		int choice = numPool.get(ran);

		// update bias memory
		bmem.set(curr_sticks - 1, choice);

		curr_sticks -= choice;

		// return the choice
		return choice;
	}

	public void bias_update(boolean win) {


		// updating the three options depending on weather the game was won or not
		for (int i = 0; i < bmem.size(); i ++) {
			if (bmem.get(i) == 1) {
				if (win) { b1.set(i, b1.get(i) + 1); }
				if (!win && b1.get(i) > 0) {
					b1.set(i, b1.get(i) - 1); } }
			
			if (bmem.get(i) == 2) {
				if (win) { b2.set(i, b2.get(i) + 1); }
				if (!win && b2.get(i) > 0) {
					b2.set(i, b2.get(i) - 1); } }
			
			if (bmem.get(i) == 3) {
				if (win) { b3.set(i, b3.get(i) + 1); }
				if (!win && b3.get(i) > 0) {
					b3.set(i, b3.get(i) - 1); } }
			
		}

		// resetting the bias memory
		for (int i = 0; i < bmem.size(); i ++) { bmem.set(i, 0); }
	}
}