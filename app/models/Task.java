package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

import javax.persistence.*;

import java.util.*;

@Entity
public class Task extends Model {
	@Id
	public Integer id;

	@Required(message="必須入力です")
	@MinLength(2)
	@MaxLength(100)
	public String name;

	public Date period;

	public static Finder<Integer, Task> find=new Finder<Integer, Task>(
		Integer.class, Task.class
	);
}
