import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class ToDoTest {

  @Test
  public void todo_instantiatesCorrectly_true() {
    ToDo myToDo = new ToDo("Mow the lawn");
    assertEquals(true, myToDo.doesExist());
  }

  @Test
  public void todo_instantiatesWithDescription_String() {
    ToDo myToDo = new ToDo("Mow the lawn");
    assertEquals("Mow the lawn", myToDo.getDescription());
  }

  @Test
  public void isCompleted_isFalseAfterInstantiation_false() {
    ToDo myToDo = new ToDo("Mow the lawn");
    assertEquals(false, myToDo.isCompleted());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    ToDo myToDo = new ToDo("Mow the lawn");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myToDo.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOfTodo_true() {
    ToDo firstToDo = new ToDo("Mow the lawn");
    ToDo secondToDo = new ToDo("Buy groceries");
    assertTrue(ToDo.all().contains(firstToDo));
    assertTrue(ToDo.all().contains(secondToDo));
  }

  @Test
  public void clear_emptiesAllToDosFromArrayList_0() {
    ToDo myToDo = new ToDo("Mow the lawn");
    ToDo.clear();
    assertEquals(ToDo.all().size(), 0);
  }

  @Test
  public void getId_todosInstantiateWithAnID_1() {
    ToDo.clear();  // THIS TEST WILL FAIL WITHOUT THIS LINE!
    ToDo myToDo = new ToDo("Mow the lawn");
    assertEquals(1, myToDo.getId());
  }

  @Test
  public void find_returnsToDoWithSameId_secondToDo() {
    ToDo firstToDo = new ToDo("Mow the lawn");
    ToDo secondToDo = new ToDo("Buy groceries");
    assertEquals(ToDo.find(secondToDo.getId()), secondToDo);
  }

  @Test
  public void find_returnsNullWhenNoToDoFound_null() {
    assertTrue(ToDo.find(999) == null);
  }

}
