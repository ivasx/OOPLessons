public class Main{
   public static void main(String[] args) {
       Phone iPhone12 = new Phone();
       iPhone12.brand = "iPhone";
       iPhone12.model = "12";
       iPhone12.price = 20000;
       iPhone12.showInfo();


   }
}


class Phone {
   String brand;
   String model;
   int price;


   void showInfo(){
       System.out.println("Інформація про телефон: ");
       System.out.println("Бренд: " + brand);
       System.out.println("Модель: " + model);
       System.out.println("Ціна: " + price + " грн.");
   }
}
