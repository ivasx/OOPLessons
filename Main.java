import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;




public class Main {
   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       ArrayList<Form> forms = new ArrayList<>();


       forms.add(new Form("Івас", 2007, "Гра на піаніно", 10, "Закінчив музичну школу", false, 2500));
       forms.add(new Form("Марічка", 2006, "Малювання", 8, "Ходить на гурток образотворчого мистецтва", true, 2300));
       forms.add(new Form("Остап", 2005, "Футбол", 9, "Грав у шкільній команді", false, 2100));
       forms.add(new Form("Софія", 2008, "Танці", 7, "Брала участь у конкурсах", true, 2400));
       forms.add(new Form("Богдан", 2007, "Плавання", 10, "Переможець змагань району", false, 2600));
       forms.add(new Form("Катерина", 2009, "Шахи", 6, "Має грамоти", true, 2000));
       forms.add(new Form("Андрій", 2006, "Програмування", 10, "Вивчає Java самостійно", false, 2700));
       forms.add(new Form("Олена", 2005, "Писання віршів", 9, "Друкувалась у шкільній газеті", true, 2200));
       forms.add(new Form("Дмитро", 2008, "Баскетбол", 7, "Грає за юнацьку команду", false, 2150));
       forms.add(new Form("Ірина", 2007, "Співи", 8, "Закінчила вокальний гурток", true, 2550));
       forms.add(new Form("Тарас", 2006, "Робототехніка", 10, "Брав участь у всеукраїнських конкурсах", false, 2900));


       FormAnalytics formAnalytics = new FormAnalytics(forms);


       formAnalytics.printForms(forms);
       formAnalytics.sortAge(forms);
       System.out.println("Анкети після сортування по віку:");
       formAnalytics.printForms(forms);
       formAnalytics.sortName(forms);
       System.out.println("Анкети після сортування по імені:");
       formAnalytics.printForms(forms);
       formAnalytics.calculateAverageSalary(forms);
       formAnalytics.calculateAverageAge();
       formAnalytics.countMarriedPeople(forms);
       formAnalytics.quantityForms();
       formAnalytics.countFormsByYear(2007);
       formAnalytics.peopleWithSalaryAboveAverage();
       formAnalytics.topHobbies();
       formAnalytics.sortHobbiesByLength();
       formAnalytics.topHobbiesByMaritalStatus();
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


   public String getName() { return name; }
   public int getBirthYear() { return birthYear; }
   public String getHobby() { return hobby; }
   public int getHobbyDuration() { return hobbyDuration; }
   public String getHobbyAchievements() { return hobbyAchievements; }
   public boolean getIsMarried() { return isMarried; }
   public double getSalary() { return salary; }
   public int getAge() { return 2025 - birthYear; }


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


}


class FormAnalytics {
   private ArrayList<Form> forms;


   FormAnalytics(ArrayList<Form> forms) {
       this.forms = forms;
   }


    void printForms(ArrayList<Form> forms){
       for (Form form : forms) {
           form.aboutMyself();
       }
   }


   void sortAge(ArrayList<Form> forms) {
       forms.sort(Comparator.comparingInt(Form::getAge));
   }


   void sortName(ArrayList<Form> forms) {
       forms.sort(Comparator.comparing(Form::getName));
   }


   void calculateAverageSalary(ArrayList<Form> forms) {
       double totalSalary = 0;
       for (Form form : forms) {
           totalSalary += form.getSalary();
       }
       System.out.println("Середня зарплата: " + totalSalary / forms.size());
   }


   void countMarriedPeople(ArrayList<Form> forms) {
       int count = 0;
       for (Form form : forms) {
           if (form.getIsMarried()) {
               count++;
           }
       }
       System.out.println("Кількість одружених людей: " + count);
   }


   void quantityForms(){System.out.println("Кількість анкет: " + forms.size());}


   void countFormsByYear(int year) {
       int count = 0;
       for (Form form : forms) {
           if (form.getBirthYear() == year) {
               count++;
           }
       }
       System.out.println("Кількість анкет людей, народжених у " + year + " році: " + count);
   }


   void calculateAverageAge() {
       int totalAge = 0;
       for (Form form : forms) {
           totalAge += form.getAge();
       }
       double averageAge = (double) totalAge / forms.size();
       System.out.println("Середній вік власників форм: " + averageAge);
   }


   void peopleWithSalaryAboveAverage() {
       double totalSalary = 0;
       for (Form form : forms) {
           totalSalary += form.getSalary();
       }


       double averageSalary = totalSalary / forms.size();
       double threshold = averageSalary * 1.1;


       System.out.println("Люди з ЗП більше на 10% від середньої:");
       for (Form form : forms) {
           if (form.getSalary() > threshold) {
               System.out.println(form.getName());
           }
       }
   }


   void topHobbies() {
       HashMap<String, Integer> hobbyCounts = new HashMap<>();


       for (Form form : forms) {
           String hobby = form.getHobby();
           if (hobbyCounts.containsKey(hobby)) {
               hobbyCounts.put(hobby, hobbyCounts.get(hobby) + 1);
           } else {
               hobbyCounts.put(hobby, 1);
           }
       }


       ArrayList<HashMap.Entry<String, Integer>> sortedList = new ArrayList<>(hobbyCounts.entrySet());


       for (int i = 0; i < sortedList.size() - 1; i++) {
           for (int j = i + 1; j < sortedList.size(); j++) {
               if (sortedList.get(i).getValue() < sortedList.get(j).getValue()) {
                   HashMap.Entry<String, Integer> temp = sortedList.get(i);
                   sortedList.set(i, sortedList.get(j));
                   sortedList.set(j, temp);
               }
           }
       }


       System.out.println("Топ 3 найпопулярніших захоплення:");
       for (int i = 0; i < Math.min(3, sortedList.size()); i++) {
           HashMap.Entry<String, Integer> entry = sortedList.get(i);
           System.out.println(entry.getKey() + " - " + entry.getValue());
       }
   }


   void sortHobbiesByLength() {
       forms.sort(Comparator.comparing((Form::getHobbyDuration)).reversed());
       System.out.println("Захоплення за довжиною:");
       for (Form form : forms) {
           System.out.println(form.getHobby() + " - " + form.getHobbyDuration() + " років");
       }
   }


   void topHobbiesByMaritalStatus() {
       HashMap<String, Integer> marriedHobbies = new HashMap<>();
       HashMap<String, Integer> unmarriedHobbies = new HashMap<>();


       for (Form form : forms) {
           String hobby = form.getHobby();
           if (form.getIsMarried()) {
               marriedHobbies.put(hobby, marriedHobbies.getOrDefault(hobby, 0) + 1);
           } else {
               unmarriedHobbies.put(hobby, unmarriedHobbies.getOrDefault(hobby, 0) + 1);
           }
       }


       ArrayList<HashMap.Entry<String, Integer>> sortedMarriedHobbies = new ArrayList<>(marriedHobbies.entrySet());


       System.out.println("Топ 3 захоплення для одружених:");
       for (int i = 0; i < Math.min(3, sortedMarriedHobbies.size()); i++) {
           HashMap.Entry<String, Integer> entry = sortedMarriedHobbies.get(i);
           System.out.println(entry.getKey() + " - " + entry.getValue());
       }


       ArrayList<HashMap.Entry<String, Integer>> sortedUnmarriedHobbies = new ArrayList<>(unmarriedHobbies.entrySet());


       System.out.println("Топ 3 захоплення для неодружених:");
       for (int i = 0; i < Math.min(3, sortedUnmarriedHobbies.size()); i++) {
           HashMap.Entry<String, Integer> entry = sortedUnmarriedHobbies.get(i);
           System.out.println(entry.getKey() + " - " + entry.getValue());
       }
   }
}
