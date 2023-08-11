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
            model.put("useremail", request.session().attribute("useremail"));
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
            return new ModelAndView(model, "allprojects.hbs");
        }, new HandlebarsTemplateEngine());
        post("/projects/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String name     = request.queryParams("asset-name");
            String description = request.queryParams("project-description");
            String department = request.queryParams("department");
            Project newProject = new Project(name,description,department);
            model.put("projects",newProject);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        post("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String inputtedUsername = request.queryParams("useremail");
            request.session().attribute("useremail", inputtedUsername);
            model.put("useremail", inputtedUsername);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
