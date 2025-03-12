package Task3;

import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;



public class Main {
    public static void main(String[] args) {
        Dictionnaire myDict = new Dictionnaire();
        myDict.workDict();
    }
}

class Dictionnaire {
    Scanner scan = new Scanner(System.in);
    HashMap<String, String> dictionary  = new HashMap<>();
    boolean condition = true;

    void workDict(){
        while (condition) {
            optionsOperation();
            System.out.println("Введіть номер операції: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1:
                    addNewWords();
                    break;
                case 2:
                    findTranslation();
                    break;
                case 3:
                    showDictionary();
                    break;
                case 4:
                    deleteWord();
                    break;
                case 5:
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
        System.out.println("1. Додавання нових слів");
        System.out.println("2. Знаходження перекладу слів");
        System.out.println("3. Показати весь словник");
        System.out.println("4. Видалити слово");
        System.out.println("5. Вийти");
    }

    void addNewWords(){
        System.out.println("Введіть слово:");
        String word = scan.nextLine();
        System.out.println("Введіть переклад:");
        String translation = scan.nextLine();

        dictionary.put(word, translation);
    }

    void findTranslation(){
        System.out.println("Введіть слово переклад якого хочете знайти:");
        String word = scan.nextLine();
        String wordTranslation = dictionary.get(word);
        if (wordTranslation == null){
            System.out.println("Перекладу для цього слова немає. Бажаєте додати?");
            System.out.println("1. Так");
            System.out.println("2. Ні");
            int choice = scan.nextInt();
            if (choice == 1){
                addNewWords();
            }else {
                workDict();
            }
        }
        System.out.println("Слово:\t\tПереклад:");
        System.out.println(word + "\t\t" + wordTranslation);
    }

    void showDictionary() {
        if (dictionary.size() < 1) {
            System.out.println("Словник пустий!");
        } else {
            System.out.println("==============================");
            System.out.println("Слово:\t\tПереклад:");
            for (HashMap.Entry<String, String> entry : dictionary.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println(key + "\t\t" + value);
            }
            System.out.println("==============================");
        }
    }

    void deleteWord(){
        System.out.println("Введіть слово яке хочете видалити:");
        String word = scan.nextLine();
        dictionary.remove(word);
        System.out.println("Слово " + word + " успішно видалено!");
    }

    void exit(){
        System.out.println("Закінчення роботи програми..");
        condition = false;
    }
}



