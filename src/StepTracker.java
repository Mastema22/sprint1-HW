import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();

    void wrongEnter() {
        System.out.println("Введено неправильное значение!");
    }

    int goalByStepsPerDay = 10000;


    StepTracker(Scanner scan) {

        scanner = scan;

        for (int i = 0; i < monthToData.length;i++) {
            monthToData[i] = new MonthData();
        }

    }

    void  addNewNumberStepsDay() {
        System.out.println("Введите номер месяца от 1 до 12:");
        int month = scanner.nextInt();
        if(month >= 1 && month <= 12) {
            System.out.println("Введите номер дня от 1 до 30 (включительно) :");
            int day = scanner.nextInt();
            if(day >= 1 && day <=30) {
                System.out.println("Введите количество шагов (положительное значение):");
                int steps = scanner.nextInt();
                    if (steps > 0) {
                        MonthData monthData = monthToData[month -1];
                        monthData.days[day - 1] = steps;
                    } else wrongEnter();
            } else wrongEnter();

        } else wrongEnter();

    }

    void changeStepGoal() {
        System.out.println("Введите новую цель шагов на день (положительное значение):");
        int newStepGoal = scanner.nextInt();
        if(newStepGoal > 0 ) {
            goalByStepsPerDay = newStepGoal;
            System.out.println("Новая цель сохранена!");
        } else wrongEnter();
    }

    void printStatistic() {
        System.out.println("Введите число месяца:");
        int monthDataOfMonth = scanner.nextInt();

        if ((monthDataOfMonth  > 0) && (monthDataOfMonth <= 12) ) {
            int sumSteps = monthToData[monthDataOfMonth-1].sumStepsFromMonth();
            monthToData[monthDataOfMonth-1].printDaysAndStepsMonth();
            System.out.println("Сумма шагов за месяц " + monthDataOfMonth + ": " + sumSteps + "." );
            System.out.println("Максимально пройдное кволичество шагов: " + monthToData[monthDataOfMonth-1].maxSteps() + ".");
            System.out.println("Среднее пройденное к-во шагов за месяц: " + sumSteps/30);
            System.out.println("Пройденное за месяц дистанция: " + converter.convertToKm(sumSteps) + " км.");
            System.out.println("Количество сожженых килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps));
            System.out.println("Лучшая серия шагов за месяц: " + monthToData[monthDataOfMonth-1].bestSeries(goalByStepsPerDay));
            System.out.println();
        } else wrongEnter();



    }

}
