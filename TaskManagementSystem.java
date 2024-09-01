import java.util.*;

class Task {
    String name;
    int priority;
    Date deadline;

    public Task(String name, int priority, Date deadline) {
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    public int getPriority() {
        return priority;
    }

    public Date getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task: " + name + ", Priority: " + priority + ", Deadline: " + deadline;
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(
            Comparator.comparing(Task::getPriority).thenComparing(Task::getDeadline)
        );

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Task Scheduling and Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Process Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter priority (1 - high, 2 - medium, 3 - low): ");
                    int priority = scanner.nextInt();
                    System.out.print("Enter deadline (in minutes from now): ");
                    int minutes = scanner.nextInt();
                    Date now = new Date();
                    Date deadline = new Date(now.getTime() + minutes * 60 * 1000);
                    taskQueue.add(new Task(name, priority, deadline));
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    System.out.println("Processing tasks:");
                    while (!taskQueue.isEmpty()) {
                        Task task = taskQueue.poll();
                        System.out.println("Processing task: " + task);
                        // Simulate task processing
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("All tasks processed.");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
