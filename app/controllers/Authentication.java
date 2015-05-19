package controllers;

import play.mvc.*;
import play.data.*;
import views.html.authentication.*;

public class Authentication extends Controller{
	public static class Login{
		public String username;
		public String password;
	}

	public static Form<Login> loginForm=Form.form(Login.class);

	public static Result index(){
		return ok(index.render(loginForm));
	}

	public static Result authenticate(){
		Login login=loginForm.bindFromRequest().get();
		return ok("ログインしたユーザは" + login.username + "です。");
	}
}
