package Task2_Calculator;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Calculator.calculator();
    }
}

class Calculator {
    public static void calculator() {
        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();
        int choice = 0;

        while (choice != 6) {
            Calculator.optionsOperation();  //Вивід списку операцій
            System.out.print("Введіть номер операції: ");
            choice = scan.nextInt();

            if (choice == 6) {
                System.out.println("Закінчення роботи програми..");
                break;
            }

            System.out.print("Введіть перше значення: ");
            int firstNumber = scan.nextInt();
            System.out.print("Введіть друге значення: ");
            int secondNumber = scan.nextInt();
            calculator.doItOperation(choice, firstNumber, secondNumber);
        }
        scan.close();
    }

    static void optionsOperation() {    //Вивід списку операцій
        System.out.println("Виберіть операцію:");
        System.out.println("1. Додавання");
        System.out.println("2. Віднімання");
        System.out.println("3. Множення");
        System.out.println("4. Ділення");
        System.out.println("5. Зведення до степеня");
        System.out.println("6. Вихід з програми");
    }

    void doItOperation(int choice, int firstNumber, int secondNumber){
        switch (choice) {
            case 1:
                addition(firstNumber, secondNumber);
                break;
            case 2:
                subtraction(firstNumber, secondNumber);
                break;
            case 3:
                multiplication(firstNumber, secondNumber);
                break;
            case 4:
                division(firstNumber, secondNumber);
                break;
            case 5:
                exponentiation(firstNumber, secondNumber);
                break;
            default:
                System.out.println("Вибір неправильний, попробуйте ще раз.");
        }
    }
    void addition(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        System.out.println("Результат: " + firstNumber + " + " + secondNumber + " = " + result);
        System.out.println("Виконалась дія додавання двох чисел.");
        System.out.println();
    }

    void subtraction(int firstNumber, int secondNumber) {
        int result = firstNumber - secondNumber;
        System.out.println("Результат: " + firstNumber + " - " + secondNumber + " = " + result);
        System.out.println("Виконалась дія віднімання двох чисел.");
        System.out.println();
    }

    void multiplication(int firstNumber, int secondNumber) {
        int result = firstNumber * secondNumber;
        System.out.println("Результат: " + firstNumber + " * " + secondNumber + " = " + result);
        System.out.println("Виконалась дія множення двох чисел.");
        System.out.println();
    }

    void division(int firstNumber, int secondNumber) {
        if (secondNumber != 0) {
            int result = firstNumber / secondNumber;
            System.out.println("Результат: " + firstNumber + " / " + secondNumber + " = " + result);
            System.out.println("Виконалась дія ділення двох чисел.");
        } else {
            System.out.println("Помилка: Не можна ділити на нуль. Попробуйте ще раз.");
            System.out.println();
        }
    }

    void exponentiation(int firstNumber, int secondNumber) {
        double result = Math.pow(firstNumber, secondNumber);
        System.out.println("Результат: " + firstNumber + " ^ " + secondNumber + " = " + result);
        System.out.println("Виконалась дія піднесення першого числа до степеня другого числа.");
        System.out.println();
    }
}