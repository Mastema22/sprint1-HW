import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);


        while (true) {
            printMenu();
            int numberMenu = scanner.nextInt();

            if (numberMenu == 1) {
                stepTracker.addNewNumberStepsDay();

            } else if (numberMenu == 2) {
                stepTracker.changeStepGoal();

            } else if (numberMenu == 3) {
                stepTracker.printStatistic();

            } else if (numberMenu == 0) {
                System.out.println("Выход! Всего доброго!");
                return;
            } else System.out.println("Такой команды нет, попробуйте снова!");


        }

    }

    static void printMenu() {
        System.out.println("1 - Вести количество шагов за определенный день;");
        System.out.println("2 - Изменить цель по количеству шагов в день;");
        System.out.println("3 - Напечатать статистику за определённый месяц;");
        System.out.println("0 - Выйти из приложения.");
        System.out.println("-------------------------------------------------");
        System.out.println("Пожалуйста, выберите нужный пункт меню:");
    }
}

