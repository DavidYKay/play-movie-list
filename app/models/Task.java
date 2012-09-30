package models;

import java.util.*;

import play.db.ebean.*;
// This gives us the @Id and @Entity annotations which let us save the object to the database
import javax.persistence.*;

import static play.data.validation.Constraints.*;

@Entity
public class Task extends play.db.ebean.Model {

  @Id
  public Long id;
  @Required
  public String label;

  public static Model.Finder<Long,Task> find = new Model.Finder(
      Long.class, Task.class
      );

  public static List<Task> all() {
    return find.all();
  }

  public static void create(Task task) {
    task.save();
  }

  public static void delete(Long id) {
    find.ref(id).delete();
  }

}
