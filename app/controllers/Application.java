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
    	Random rnd = new Random();

        Task task   = new Task();
        task.name   = "ピザを" + rnd.nextInt(10) + "枚食べる";
        task.period = new Date();
        task.save();


    	List<Task> taskList=Task.find.all();
    	String now=task.name;
    	Integer cnt=taskList.size();
    	List<Task> taskList2=Task.find.where().eq("name", "ピザを5枚食べる").findList();

    	return ok(addrec.render(taskList, now, cnt, taskList2, taskForm));
    }

    public static Result createTask(){
    	Form<Task> form = Form.form(Task.class).bindFromRequest();
    	if(form.hasErrors()){
    		return badRequest(form.errorsAsJson());
    	}else{
    		Task newTask=form.get();
    		newTask.save();
    		return redirect(routes.Application.addrec());
    	}
    }

}
