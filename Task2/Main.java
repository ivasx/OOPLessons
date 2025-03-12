package Task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArraysWorks myArray = new ArraysWorks();
        myArray.initialArray();
        myArray.workArray();

    }
}

class ArraysWorks {
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> array = new ArrayList<Integer>();
    boolean condition = true;

    void workArray(){
        while (condition) {
            optionsOperation();
            System.out.println("Введіть номер операції: ");
            int choice = scan.nextInt();

            switch (choice){
                case 1:
                    addValue();
                    break;
                case 2:
                    overwritingValue();
                    break;
                case 3:
                    deleteValue();
                    break;
                case 4:
                    printArray();
                    break;
                case 5:
                    sortArray();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("Введено неправильне значення, спробуйте ще раз.");
                    break;
            }

        }
    }

    void optionsOperation() {
        System.out.println("Виберіть операцію:");
        System.out.println("1. Додавання нового значення");
        System.out.println("2. Перезапис існуйочого");
        System.out.println("3. Видалення значення");
        System.out.println("4. Перегляд всіх значень");
        System.out.println("5. Сортування");
        System.out.println("6. Вийти");
    }

    void initialArray(){
        for (int i = 0; i < 11; i++) {
            array.add(random.nextInt(100));
        }
    }

    void addValue(){
        int value = random.nextInt(100);
        System.out.println("Додано нове значення: " + value);
        array.add(value);
    }

    void overwritingValue(){
        printArray();
        System.out.println("Введіть порядковий номер елемента який хочете замінити: ");
        int index = scan.nextInt() - 1;
        int value = random.nextInt(100);
        System.out.println("Значення (" + array.get(index) + ") заміненно на: " + value);
        System.out.println(index);
        array.set(index, value);
    }

    void deleteValue(){
        printArray();
        System.out.print("Введіть порядковий номер елемента який хочете видалити: ");
        int index = scan.nextInt() - 1;
        array.remove(index);
    }

    void printArray(){
        System.out.print("Всі значення масиву: ");
        System.out.println(array);
    }

    void sortArray(){
        System.out.println("В якому напрямку ви хочете відсортувати масив?");
        System.out.println("1. В прямому");
        System.out.println("2. В зворотньому");
        int choice = scan.nextInt();
        if (choice == 1){
            sortNatural();
        } else if (choice == 2) {
            sortReverse();
        }else {
            System.out.println("Введено неправильне значення, спробуйте ще раз.");
            sortArray();
        }
    }

    void sortNatural(){
        array.sort(Comparator.naturalOrder());
        System.out.println("Масив відсортовано у простому порядку: " + array);
    }

    void sortReverse(){
        array.sort(Comparator.reverseOrder());
        System.out.println("Масив відсортовано у зворотному порядку: " + array);
    }

    void exit(){
        System.out.println("Закінчення роботи програми..");
        condition = false;
    }
}



