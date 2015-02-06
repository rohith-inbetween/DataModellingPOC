import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product123 {

	
	@Id
	private long id;

	public long getId () {
		return this.id;
	}
	
	public void setId (long id){
		this.id = id;
	}
	
	private int id2;

	public int getId2 () {
		return this.id2;
	}
	
	public void setId2 (int id2){
		this.id2 = id2;
	}
	
	private String name;

	public String getName () {
		return this.name;
	}
	
	public void setName (String name){
		this.name = name;
	}
}