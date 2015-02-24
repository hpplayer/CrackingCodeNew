package Chapter8_9_sol2;

public abstract class Entry {
	protected Directory parent;
	protected long created;
	protected long lastUpdated;
	protected long lastAccessed;
	protected String name;

	public Entry(String n, Directory p){
		name = n;
		parent = p;
		created = System.currentTimeMillis();
	}

	public boolean delete(){
		if(parent == null){
			return false;
		}
		return parent.deleteEntry(this);
	}
	
	public abstract int size();
	
	public String getFullPath(){
		if(parent == null){
			return name;
		}else{
			return parent.getFullPath() + "/" + name; //recursion here!
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreated() {
		return created;
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

	public long getLastAccessed() {
		return lastAccessed;
	}
	

}
