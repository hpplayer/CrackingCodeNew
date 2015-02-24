package Chapter8_9;


public class Block{
	private int id;
	private final int size = 10;
	private int currentSize;
	private File[] fileAry = new File[size];
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean full(){
		return this.currentSize < size? true : false;
		
	}
	
	public File searchFile(int id) {
		for (File f: fileAry){
			if(f.getId() == id){
				return f;
			}
		}
		return null;
	}
	
	public boolean removeFile(){
		for(File f: fileAry){
			if(f.getRank() == Rank.LeastRecent){
				f = null;
				currentSize --;
				return true;
			}
		}
		for(File f: fileAry){
			if(f.getRank() == Rank.MidRecent){
				f = null;
				currentSize --;
				return true;
			}
		}
		fileAry[0] = null; // we are removing file wso it is ok to just remove first element
		return true;
	}
	
	public void handleInsert(){
		for(File f: fileAry){
			if(f != null){
				f.RankDown();
			}
		}
	}
	public boolean saveFile(File file) {
		if (currentSize == size) return false;
		handleInsert();
		for(File f: fileAry){
			if(f == null){
				f = file;
				currentSize++;
				return true;
			}
		}
		return false;
	}
	
}
