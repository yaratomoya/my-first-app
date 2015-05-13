package controllers;

import java.util.*;

import models.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result tasks(){
    	List<String> taskList=Arrays.asList("foo", "bar", "baz", "<strong>Pizza</strong>", "<script>alert('hello');</script>");
    	return ok(tasks.render(taskList));
    }

    public static Result helps(){
    	return ok(helps.render());
    }

    public static Result addrec(){
    	Task task=new Task();
    	Products pro=new Products();

    	task.name="Pizzaを食べる";
    	task.period=new Date();
    	task.save();

    	pro.name="Pizza";
    	pro.price=1000;
    	pro.save();

    	return ok(addrec.render());
    }

}
