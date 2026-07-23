// Task Node
class Task {

    int taskId;
    String taskName;
    String status;
    Task next;

    // Constructor
    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    // Display Task Details
    public void display() {
        System.out.println("Task ID   : " + taskId);
        System.out.println("Task Name : " + taskName);
        System.out.println("Status    : " + status);
        System.out.println("--------------------------");
    }
}

public class exercise5taskmagsystem{

    Task head = null;

    // Add Task
    public void addTask(int id, String name, String status) {

        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {

            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }

        System.out.println("Task added successfully.");
    }

    // Search Task
    public void searchTask(int id) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == id) {

                System.out.println("\nTask Found\n");
                temp.display();
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task not found.");
    }

    // Traverse Tasks
    public void traverseTasks() {

        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        System.out.println("\nTask List\n");

        Task temp = head;

        while (temp != null) {

            temp.display();
            temp = temp.next;
        }
    }

    // Delete Task
    public void deleteTask(int id) {

        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        // Delete first node
        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Task current = head;
        Task previous = null;

        while (current != null && current.taskId != id) {

            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task not found.");
            return;
        }

        previous.next = current.next;

        System.out.println("Task deleted successfully.");
    }

    public static void main(String[] args) {

        exercise5taskmagsystem list = new exercise5taskmagsystem();

        list.addTask(101, "Design Homepage", "Pending");
        list.addTask(102, "Develop Login Module", "In Progress");
        list.addTask(103, "Database Integration", "Completed");

        list.traverseTasks();

        list.searchTask(102);

        list.deleteTask(101);

        System.out.println("\nAfter Deletion\n");

        list.traverseTasks();
    }
}