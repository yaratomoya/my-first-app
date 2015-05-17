package controllers;

import java.util.*;

import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {
	public static Form<Task> taskForm = Form.form(Task.class);

    public static Result index() {
    	System.out.println(flash("foo"));
        return ok(index.render("Your new application is ready."));
    }

    public static Result tasks(){
    	List<String> taskList=Arrays.asList("foo", "bar", "baz", "<strong>Pizza</strong>", "<script>alert('hello');</script>");
    	flash("foo", "pizza");
    	return ok(tasks.render(taskList));
    }

    public static Result helps(){
    	return ok(helps.render());
    }

    public static Result addrec(){
    	List<Task> taskList=Task.find.all();
    	return ok(addrec.render(taskList, taskForm));
    }

    public static Result createTask(){
    	Form<Task> form = taskForm.bindFromRequest();
    	if(form.hasErrors()){
    		List<Task> taskList=Task.find.all();
    		return badRequest(addrec.render(taskList, form));
    	}else{
    		Task newTask=form.get();
    		newTask.save();
    		return redirect(routes.Application.addrec());
    	}
    }

    public static Result deleteTask(){
    	Task deleteTask=Task.find.byId(1);
    	deleteTask.delete();
    	return redirect(routes.Application.addrec());
    }

}
