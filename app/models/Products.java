package models;

import play.db.ebean.Model;
import javax.persistence.*;

@Entity
public class Products extends Model{
	@Id
	public Integer id;
	public String name;
	public Integer price;

}
