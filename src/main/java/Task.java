public class Task {
    private String description; // Описание задачи
    private boolean isCompleted; // Статус завершенности задачи

    // Конструктор класса
    public Task(String description) {
        this.description = description; // Инициализируем описание
        this.isCompleted = false; // Задача по умолчанию не завершена
    }

    // Методы доступа (геттеры) для получения значений полей
    public String getDescription() {
        return description; // Возвращаем описание задачи
    }

    public boolean isCompleted() {
        return isCompleted; // Возвращаем статус завершенности
    }

    // Метод для завершения задачи
    public void completeTask() {
        isCompleted = true; // Устанавливаем статус завершенности в true
    }

    // Переопределение метода toString для удобного вывода задачи
    @Override
    public String toString() {
        return (isCompleted ? "[X] " : "[ ] ") + description; // Форма вывода задачи
    }
}