import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/projects/new", (request, response) -> { //URL to make new project on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "newasset-form.hbs");
        }, new HandlebarsTemplateEngine());
//        <view the homepage >
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            model.put("content",request.session().attribute("content"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        get("/allprojects", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Project> projects = Project.getAll();
            model.put("projects", projects);
//            model.put("content",request.session().attribute("content"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
