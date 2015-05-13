package models;

import play.db.ebean.Model;
import javax.persistence.*;
import java.util.*;

@Entity
public class Task extends Model {
	@Id
	public Integer id;
	public String name;
	public Date period;
}
