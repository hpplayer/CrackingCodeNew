package Chapter8_2_sol2;

public class Call {
	//three elements involve a call
	private Rank rank;
	
	private Caller caller;
	
	private Employee handler;
	
	/*call default hanlder is responder */
	public Call(Caller c){
		rank = Rank.Responder;
		caller = c;
	}
	
	public void setHandler(Employee e){
		handler = e;
	}
	
	public Rank incrementRank(){
		if(rank == Rank.Responder){
			rank = Rank.Manager;
		}else if (rank == Rank.Manager){
			rank = Rank.Director;
		}
		return rank;
	}
	public Rank getRank(){
		return rank;
	}
	public void setRank(Rank r){
		rank = r;
	}
	
	public void reply(String msg){
		System.out.println(msg);
	}
	public void disconnect(){
		reply("thank you for calling");
	}
	
	/* test purpose
	public static void main(String[] args){
		System.out.println(Rank.Manager.getValue());
	}
	*/
}
