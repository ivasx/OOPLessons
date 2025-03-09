package Task2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArraysWorks myArray = new ArraysWorks();
        myArray.initialArray();
        myArray.printArray();
        myArray.addValue();
        myArray.overwritingValue();

    }
}

class ArraysWorks {
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> array = new ArrayList<Integer>();

    void initialArray(){
        for (int i = 0; i < 11; i++) {
            array.add(random.nextInt(10));
        }
    }

    void printArray(){
        System.out.print("Масив: ");
        System.out.println(array);
    }

    void addValue(){
        int value = random.nextInt();
        System.out.print("Додано нове значення: " + value);
        array.add(value);
    }

    void overwritingValue(){
        System.out.println("Введіть порядковий номер елемента який хочете замінити");
        int index = scan.nextInt() - 1;
        int value = random.nextInt();
        System.out.print("Значення (" + array.get(index) + ") заміненно на: " + value);
        System.out.println(index);
        array.set(index, value);
    }




}

