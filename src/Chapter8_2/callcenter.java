package Chapter8_2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * data structure: my idea is implementing queue that represents
 * available employees in each level. so that all employee will
 * able to get the chance to answer the phone
 * 
 */
public class callcenter {
	Queue<director> dirs = new LinkedList<director>();
	Queue<manager> mangs = new LinkedList<manager>();
	Queue<respondent> resps = new LinkedList<respondent>();

	public void addq(int ID, int level) {
		//System.out.println(level);
		switch (level) {
		case 1:
			respondent temp = new respondent(ID);
			resps.add(temp);
			//System.out.println("level 1");
			break;//!!!!!!!!!!!!!!!!!!!!!!!!!dont forget break in switch!
		case 2:
			manager temp2 = new manager(ID);
			mangs.add(temp2);
			break;
		case 3:
			director temp3 = new director(ID);
			dirs.add(temp3);
			break;
		default:
			System.out.println("default");
			break;
		}
	}

	/*
	 * dispatchcall() firstly check the queue of resps with while loop, each loop
	 * removes an resp if there he/she does not need help when he/she is busy
	 * after the loop is ended, check the queue size 
	 * if queue is empty, means employees of this level does not contain anyone who is available
	 * so we need search next level 
	 * otherwise if queue is not empty, then we must have a available employee, we need just to return the ID
	 * recursive do this for employee of next levels
	 */
	public int dispatchcall() {
		while (resps.size() != 0 && resps.peek().busy) {
			if (resps.peek().needhelp) {
				//System.out.println("I enter here");
				while (mangs.size() != 0 && mangs.peek().busy) {
					if (mangs.peek().needhelp) {
						while (dirs.size() != 0 && dirs.peek().busy) {
							dirs.remove();
						}
						if (dirs.size() != 0) {
							return dirs.poll().ID;
						} else {
							return -1;// dirs empty, no one is available now
						}

					}
					mangs.remove();
				}
				if (mangs.isEmpty()) {
					while (dirs.size() != 0 && dirs.peek().busy) {
						dirs.remove();
					}
					if (dirs.size() != 0) {
						//System.out.println("I enter here");
						return dirs.poll().ID;
					} else {
						return -1;// dirs empty, no one is available now
					}

				} else {
					return mangs.poll().ID;
				}
			}
			resps.remove();
		}
		if (resps.size() == 0) {

			while (mangs.size() != 0 && mangs.peek().busy) {
				if (mangs.peek().needhelp) {
					while (dirs.size() != 0 && dirs.peek().busy) {
						dirs.remove();
					}
					if (dirs.size() != 0) {
						return dirs.poll().ID;
					} else {
						return -1;// dirs empty, no one is available now
					}

				}
				mangs.remove();
			}
			if (mangs.isEmpty()) {
				while (dirs.size() != 0 && dirs.peek().busy) {
					dirs.remove();
				}
				if (dirs.size() != 0) {
					return dirs.poll().ID;
				} else {
					return -1;// dirs empty, no one is available now
				}

			} else {
				return mangs.poll().ID;
			}
		
		} else {
			return resps.poll().ID;
		}
	}

}
