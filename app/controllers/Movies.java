package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Movies extends Controller {

  public static Result movies() {
    return ok("My list of movies: ...");
  }

}
