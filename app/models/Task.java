package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;

import java.util.*;

@Entity
public class Task extends Model {
	@Id
	public Integer id;
	@Required
	public String name;
	public Date period;

	public static Finder<Integer, Task> find=new Finder<Integer, Task>(
		Integer.class, Task.class
	);
}
