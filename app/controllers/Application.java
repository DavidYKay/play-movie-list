package controllers;

import play.*;
import play.data.*;
import play.mvc.*;

import views.html.*;
import models.Task;

public class Application extends Controller {

  static Form<Task> taskForm = form(Task.class);

  public static Result index() {
    // Welcome page boilerplate
    // return ok(index.render("Your new application is ready."));

    // Redirect to the task list screen
    return redirect(routes.Application.tasks());
  }

  ////////////////////////////////////////
  // Task Management
  ////////////////////////////////////////

  public static Result tasks() {
    return ok(
     views.html.index.render(Task.all(), taskForm)
     );
  }

  public static Result newTask() {
    // Check the inbound POST request
    // Create a Form<Task> which contains the user's new task
    Form<Task> filledForm = taskForm.bindFromRequest();
    // Is the form valid?
    if(filledForm.hasErrors()) {
      // If not, let the user know that they screwed up!
      return badRequest(
          views.html.index.render(Task.all(), filledForm)
          );
    } else {
      // If valid, we create a task from the form
      Task.create(filledForm.get());
      // Then redirect the user back to her task list
      return redirect(routes.Application.tasks());
    }
  }

  public static Result deleteTask(Long id) {
    Task.delete(id);
    return redirect(routes.Application.tasks());
  }

}
