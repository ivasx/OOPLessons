package Task3_Arrays;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 4, 24, 4, 68, 6, 13};
        ArraysWorks.arrayOperations(array);
    }
}

class ArraysWorks {
    public static void arrayOperations(int[] array) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            printOperations();  //Вивід списку операцій
            System.out.print("Введіть номер операції: ");
            choice = scan.nextInt();

            if (choice == 6) {
                System.out.println("Закінчення роботи програми..");
                break;
            }

            doItOperation(choice, array);
        }

        scan.close();
    }

    static void printOperations() {
        System.out.println("Виберіть операцію:");
        System.out.println("1. Сума всіх елементів масиву");
        System.out.println("2. Середнє значення");
        System.out.println("3. Максимальне та мінімальне значення");
        System.out.println("4. Виведення всіх елементів масиву в простому та зворотному напрямку");
        System.out.println("5. Замінити всі значення, що менші за середнє на 0");
        System.out.println("6. Вихід з програми");
    }

    static void doItOperation(int choice, int[] array) {
        switch (choice) {
            case 1:
                arraySum(array);
                break;
            case 2:
                arrayAverage(array);
                break;
            case 3:
                arrayMax(array);
                arrayMin(array);
                break;
            case 4:
                arrayPrint(array);
                arrayPrintInReverse(array);
                break;
            case 5:
                replaceSmallerAverage(array);
                break;
            default:
                System.out.println("Вибір неправильний, спробуйте ще раз.");
        }

    }

    static void arraySum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        System.out.println("Сума всіх елементів масиву: " + sum);
    }

    static void arrayAverage(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        double average = (double) sum / array.length;
        System.out.println("Середнє значення: " + sum);
    }

    static void arrayMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println("Максимальне значення: " + max);
    }

    static void arrayMin(int[] array) {
        int min = array[0];
        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println("Мінімальне значення: " + min);
    }

    static void arrayPrint(int[] array) {
        System.out.print("Масив у простому порядку: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void arrayPrintInReverse(int[] array) {
        System.out.print("Масив у зворотному порядку: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void replaceSmallerAverage(int[] array) {
        int num = 0;
        for (int i : array) {
            num += 1;
        }

        double average = (double) num / array.length;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < average) {
                array[i] = 0;
            }
        }

        System.out.print("Масив після заміни всіх значеннь, що менші за середнє на 0: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
