package Chapter8_9;

import java.util.ArrayList;

public class Memory {
	int size = 100;
	// HashMap<Rank, ArrayList<Block>> blocks = new HashMap<Rank,
	// ArrayList<Block>>();
	// ArrayList<Block> high = new ArrayList<Block>();
	// ArrayList<Block> mid = new ArrayList<Block>();
	// ArrayList<Block> low = new ArrayList<Block>();
	ArrayList<Block> blocks = new ArrayList<Block>();

	public Memory() {
		// blocks.put(Rank.LeastRecent, low);
		// blocks.put(Rank.MidRecent, mid);
		// blocks.put(Rank.MostRecent, high);
	}

	public File searchFile(int id) {
		for (Block b : blocks) {
			File temp = b.searchFile(id);
			if (temp != null) {
				return temp;
			}

		}
		return null;
		/*
		 * File temp = null; for(Block b: blocks.get(Rank.LeastRecent)){ temp =
		 * b.searchFile(id); if(temp != null){ return temp; } } for(Block b:
		 * blocks.get(Rank.MidRecent)){ temp = b.searchFile(id); if(temp !=
		 * null){ return temp; } } for(Block b: blocks.get(Rank.MostRecent)){
		 * temp = b.searchFile(id); if(temp != null){ return temp; } } return
		 * null;
		 */
	}

	public boolean insertFull(File file) {
		file.RankUp();
		for(Block b: blocks){
			if(b.removeFile()){
				b.saveFile(file);
				return true;
			}
		}
		return false;
	}

	public boolean full() {
		if(blocks.size() <= size){
			return true;
		}
		return false;
		/*
		if (high.size() + mid.size() + low.size() <= size) {
			return true;
		}
		return false;
		*/
	}
}
