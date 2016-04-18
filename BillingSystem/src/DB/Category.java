package DB;

public class Category {
	private int id;
	private String name;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		description = desc;
	}
public void print(){
	System.out.println("ID:" +this.getId());
	System.out.println("Name:" +this.getName());
	System.out.println("Name:" +this.getDesc());
	
}
}
