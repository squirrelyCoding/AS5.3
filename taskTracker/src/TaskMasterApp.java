import java.util.ArrayList;

class Task {
    // Unique variables to each task needed here
    private String taskName;
    private int taskDuration;
    private boolean taskCompletion;

    // Constructor to initialize Task object with a name and duration
    public Task(String taskName, int taskDuration) {
        this.taskName = taskName;
        this.taskDuration = taskDuration;
        this.taskCompletion = false;
        // Initially, the task is not completed
    }

    //getters for taskDuration and taskName
    public String getName() {
        return taskName;
    }

    public int getDuration() {
        return taskDuration;
    }

    //gets true or false result for boolean
    public boolean isCompleted() {
        return taskCompletion;
    }

    //sets taskCompletion status to true if called
    public void markCompleted() {
        this.taskCompletion = true;
    }

}

class TaskTracker {
    // List to store Task objects
    private ArrayList<Task> tasks;
    // Constructor to initialize TaskTracker object with an empty task list
    public TaskTracker() {
        tasks = new ArrayList<>();
    }

    // Method to add a new task to the task list
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Method to mark a task as completed based on its index in the list
    public void taskIsComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
        } else {
            System.out.println("Invalid task index.");
        }
    }

    // Method to display all tasks in the task list
    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            
            //This line assigns "completed" or "not completed" 
            //to status by calling the isCompleted() method. 
            //This is a shorthand way of writing an if-else statement
            String status = task.isCompleted() ? "Completed" : "Not Completed";
            System.out.println(i + ": " + task.getName() + " (Duration: " + task.getDuration() + " minutes) - " + status);
        }
    }

    // Method to calculate the total duration of completed tasks
    public int calculateTotalDuration() {
        int totalDuration = 0;
        // loop logic goes here
        for (Task task : tasks) {
            if (task.isCompleted()) {
                totalDuration += task.getDuration();
            }
        }
        return totalDuration;
    }

    // Method to calculate the average duration of completed tasks
    public double calculateAverageDuration() {
        int totalDuration = calculateTotalDuration();
        int completedTaskCount = 0;

        //this is a for-each loop that goes through each Task object
        //in the tasks list and checks if the task has been completed.
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTaskCount++;
            }
        }

        if (completedTaskCount == 0) {
            return 0;
        }

        return Math.round((double) totalDuration / completedTaskCount * 100.0) / 100.0; // Rounded to 2 decimal places
    }

    // Method to find the maximum duration among completed tasks
    public int findMaxDuration() {
        int maxDuration = 0;
        for (Task task : tasks) {
            if (task.isCompleted() && task.getDuration() > maxDuration) {
                maxDuration = task.getDuration();
            }
        }
        return maxDuration;
    }
}

public class TaskMasterApp {
    public static void main(String[] args) {
        // Create Task objects
        Task task1 = new Task("Complete Assignment", 120);
        //more tasks go here
        Task task2 = new Task("Create New Employee Class to Store Employees", 45);
        Task task3 = new Task("Edit employee data", 30);
        Task task4 = new Task("Delete employee data and employee member", 25);
        Task task5 = new Task("Save employee data and employee member", 60);
        Task task6 = new Task("View employee data and employee member ", 25);
        Task task7 = new Task("Store evaluation data to access past assessments of performance", 30);
        Task task8 = new Task("View multiple profiles in a list", 35);
       
        // Create TaskTracker object called "tracker"
        TaskTracker tracker = new TaskTracker();

        // Add tasks to the task list
        tracker.addTask(task1);
        tracker.addTask(task2);
        tracker.addTask(task3);
        tracker.addTask(task4);
        tracker.addTask(task5);
        tracker.addTask(task6);
        tracker.addTask(task7);
        tracker.addTask(task8);
        // Display tasks in the task list
        System.out.println("Task List: ");
        tracker.displayTasks();
        // Mark tasks as completed

        //task2 and task6 are completed. The index goes from 0 to 7 hence why the task names are not the same
        tracker.taskIsComplete(1);
        tracker.taskIsComplete(5);

        //This outputs and updated list of tasks to show which are completed and which aren't
        System.out.println("\nUpdated Task List: ");
        tracker.displayTasks();

        // Display calculated statistics
        System.out.println("Total Duration of Completed Tasks: " + tracker.calculateTotalDuration() + " minutes");
        System.out.println("Average Duration of Completed Tasks: " + tracker.calculateAverageDuration() + " minutes");
        System.out.println("Maximum Duration among Completed Tasks: " + tracker.findMaxDuration() + " minutes");
    }
}

