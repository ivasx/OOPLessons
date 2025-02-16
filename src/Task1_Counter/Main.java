package Task1_Counter;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        chooseOperation();
    }

    public static void chooseOperation() {
        Scanner scan = new Scanner(System.in);
        int value = 0;
        int choice = 0;

        System.out.println("1. Збільшити значення на одиницю");
        System.out.println("2. Зменшити значення на одиницю");
        System.out.println("3. Показати значення");
        System.out.println("4. Закінчити роботу програми");

        while (choice !=4){
            System.out.print("Введіть номер операції: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    value++;
                    break;
                case 2:
                    value--;
                    break;
                case 3:
                    System.out.println("Значення: " + value);
                    break;
                case 4:
                    System.out.println("Закінчення роботи програми.");
                    break;
                default:
                    System.out.println("Введено неправильне значенн. Спробуйте ще раз.");
            }
        }
    }
}
