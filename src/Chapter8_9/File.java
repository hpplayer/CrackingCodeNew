package Chapter8_9;

public class File {
	int id;
	int size;
	Rank rank;
	public void RankUp(){
		if(rank == Rank.LeastRecent){
			rank = Rank.MidRecent;
		}else if(rank == Rank.MidRecent){
			rank = Rank.MostRecent;
		}
		 // Most recent;
	
	}
	
	public void RankDown(){
		if(rank == Rank.MostRecent){
			rank = Rank.MidRecent;
		}else if(rank == Rank.MidRecent){
			rank = Rank.LeastRecent;
		}
		 // Most recent;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	
}
