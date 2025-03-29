import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Form> forms = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Створення нової форми: ");
            System.out.println("Введіть ім'я: ");
            String name = scan.nextLine();
            System.out.println("Введіть рік народження: ");
            int birthYear = scan.nextInt();
            scan.nextLine();
            System.out.println("Введіть назву захоплення: ");
            String hobby = scan.nextLine();
            System.out.println("Введіть тривалість захоплення (у роках): ");
            int hobbyDuration = scan.nextInt();
            scan.nextLine();
            System.out.println("Введіть досягнення: ");
            String hobbyAchievements = scan.nextLine();
            System.out.println("Введіть сімейний стан, одружений(-на) так/ні: ");
            String married = scan.nextLine();
            boolean isMarried = married.equalsIgnoreCase("так");
            System.out.println("Введіть зарплату: ");
            double salary = scan.nextDouble();
            scan.nextLine();

            forms.add(new Form(name, birthYear, hobby, hobbyDuration, hobbyAchievements, isMarried, salary));
        }

        printForms(forms);
        System.out.println("ФОрми відсортовані за віком: ");
        sortAge(forms);
        printForms(forms);
        System.out.println("ФОрми відсортовані за імям: ");
        sortName(forms);
        printForms(forms);

        countMarriedPeople(forms);
        calculateAverageSalary(forms);
    }

    static void sortAge(ArrayList<Form> forms) {
        forms.sort(Comparator.comparingInt(Form::getAge));
    }

    static void sortName(ArrayList<Form> forms) {
        forms.sort(Comparator.comparing(Form::getName));
    }

    static void calculateAverageSalary(ArrayList<Form> forms) {
        double totalSalary = 0;
        for (Form form : forms) {
            totalSalary += form.getSalary();
        }
        System.out.println("Середня зарплата: " + totalSalary / forms.size());
    }

    static void countMarriedPeople(ArrayList<Form> forms) {
        int count = 0;
        for (Form form : forms) {
            if (form.getIsMarried()) {
                count++;
            }
        }
        System.out.println("Кількість одружених людей: " + count);
    }

    static void printForms(ArrayList<Form> forms){
        for (Form form : forms) {
            form.aboutMyself();
        }
    }
}

class Form {
    private String name;
    private int birthYear;
    private String hobby;
    private int hobbyDuration;
    private String hobbyAchievements;
    private boolean isMarried;
    private double salary;

    Form(String name, int birthYear, String hobby, int hobbyDuration, String hobbyAchievements, boolean isMarried, double salary) {
        this.name = name;
        this.birthYear = birthYear;
        this.hobby = hobby;
        this.hobbyDuration = hobbyDuration;
        this.hobbyAchievements = hobbyAchievements;
        this.isMarried = isMarried;
        this.salary = salary;
    }

    public void aboutMyself() {
        System.out.println("==============================================================");
        System.out.println(" Ім'я          : " + name);
        System.out.println(" Вік           : " + getAge() + " років");
        System.out.println(" Рік народження: " + birthYear);
        System.out.println(" Захоплення    : " + hobby + " (" + hobbyDuration + " років)");
        System.out.println(" Досягнення    : " + hobbyAchievements);
        System.out.println(" Одружений(-на): " + (isMarried ? "💍 Так" : "❌ Ні"));
        System.out.println(" Зарплата      : " + salary + " грн");
        System.out.println("==============================================================");
    }

    //Гетери і сетери


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getHobbyDuration() {
        return hobbyDuration;
    }

    public void setHobbyDuration(int hobbyDuration) {
        this.hobbyDuration = hobbyDuration;
    }

    public String getHobbyAchievements() {
        return hobbyAchievements;
    }

    public void setHobbyAchievements(String hobbyAchievements) {
        this.hobbyAchievements = hobbyAchievements;
    }

    public boolean getIsMarried() {
        return isMarried;
    }

    public void setMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getAge() {
        return 2025 - birthYear;
    }
}
