import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    private ArrayList<Task> tasks; // Список для хранения задач
    private Scanner scanner; // Объект для чтения пользовательского ввода

    public TodoApp() {
        tasks = new ArrayList<>(); // Инициализируем список задач
        scanner = new Scanner(System.in); // Инициализируем сканер для ввода
    }

    public void start() {
        System.out.println("Welcome to the To-Do List App!"); // Приветственное сообщение

        while (true) { // Главный цикл приложения
            System.out.println("\nOptions: ");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); // Чтение выбора пользователя
            scanner.nextLine(); // Поглощение переноса строки после ввода числа

            switch (choice) { // Обработка выбора
                case 1:
                    System.out.print("Enter task description: "); // Запрос описания задачи
                    String description = scanner.nextLine(); // Чтение описания
                    addTask(description); // Добавление задачи
                    break;
                case 2:
                    viewTasks(); // Просмотр задач
                    break;
                case 3:
                    completeTask(); // Завершение задачи
                    break;
                case 4:
                    removeTask(); // Удаление задачи
                    break;
                case 5:
                    System.out.println("Goodbye!"); // Прощальное сообщение
                    return; // Выход из программы
                default:
                    System.out.println("Invalid option. Please try again."); // Обработка некорректного ввода
            }
        }
    }

    private void addTask(String description) {
        Task task = new Task(description); // Создание новой задачи
        tasks.add(task); // Добавление задачи в список
        System.out.println("Task added: " + description); // Подтверждение добавления
    }

    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available."); // Сообщение, если нет задач
        } else {
            System.out.println("Tasks:"); // Заголовок для списка задач
            // Перебор и вывод всех задач
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i)); // Вывод каждой задачи
            }
        }
    }

    private void completeTask() {
        viewTasks(); // Отображение текущих задач
        System.out.print("Enter task number to complete: "); // Запрос номера задачи
        int taskNumber = scanner.nextInt() - 1; // Чтение номера задачи и корректировка индекса
        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.get(taskNumber).completeTask(); // Завершение выбранной задачи
            System.out.println("Task " + (taskNumber + 1) + " completed."); // Подтверждение завершения
        } else {
            System.out.println("Invalid task number."); // Обработка некорректного ввода
        }
    }

    private void removeTask() {
        viewTasks(); // Отображение текущих задач
        System.out.print("Enter task number to remove: "); // Запрос номера задачи
        int taskNumber = scanner.nextInt() - 1; // Чтение номера задачи и корректировка индекса
        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.remove(taskNumber); // Удаление выбранной задачи
            System.out.println("Task " + (taskNumber + 1) + " removed."); // Подтверждение удаления
        } else {
            System.out.println("Invalid task number."); // Обработка некорректного ввода
        }
    }

    public static void main(String[] args) {
        TodoApp app = new TodoApp(); // Создание экземпляра приложения
        app.start(); // Запуск приложения
    }
}
