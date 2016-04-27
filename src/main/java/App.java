import java.util.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {

    staticFileLocation("/public");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("todos/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/todoForm.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/todos", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("todos", ToDo.all());
      model.put("template", "templates/todos.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    post("/todos", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String description = request.queryParams("description");
      ToDo newToDo = new ToDo(description);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/todos/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      ToDo todo = ToDo.find(Integer.parseInt(request.params(":id")));
      model.put("todo", todo);
      model.put("template", "templates/todo.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());
  }
}
