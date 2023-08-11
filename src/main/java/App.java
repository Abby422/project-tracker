import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
//        <view the homepage >
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            model.put("content",request.session().attribute("content"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
