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
    	Random rnd = new Random();

        Task task   = new Task();
        task.name   = "ピザを" + rnd.nextInt(10) + "枚食べる";
        task.period = new Date();
        task.save();


    	List<Task> taskList=Task.find.all();
    	String now=task.name;
    	Integer cnt=taskList.size();
    	List<Task> taskList2=Task.find.where().eq("name", "ピザを5枚食べる").findList();

    	return ok(addrec.render(taskList, now, cnt, taskList2));
    }

}
