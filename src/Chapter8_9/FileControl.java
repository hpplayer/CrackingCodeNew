package Chapter8_9;

public class FileControl {
	Memory currentMem;
	
	public FileControl(Memory mem){
		this.currentMem = mem;
	}
	
	public boolean full(){
		return currentMem.full();
	}
	
	public File retrieve(int id){
		File temp = currentMem.searchFile(id);
		if(temp != null)
				return temp;
		return null;
	}
	
	public boolean insertFile(File file){
		return currentMem.insertFull(file);
	}
}
