import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.createAccount("4444 1111 0678 1148", "Івас", 17);
        bank.createAccount("5375 2121 4839 2290", "Іван", 20);

        System.out.println("Перегляд інформації про рахунок:");
        bank.idGetAccount("4444 1111 0678 1148");

        System.out.println("Поповнення рахунку:");
        bank.getBankAccounts().get("4444 1111 0678 1148").deposit(100);

        System.out.println("Зняття коштів:");
        bank.getBankAccounts().get("4444 1111 0678 1148").withdrawal(200);

        System.out.println("Показ усіх рахунків:");
        bank.showAccounts();

        System.out.println("Історія транзакцій:");
        bank.getBankAccounts().get("4444 1111 0678 1148").transactionHistoryGet();

        System.out.println("Редагування інформації власника:");
        bank.getBankAccounts().get("4444 1111 0678 1148").editOwnerInf();

        System.out.println("Переказ коштів:");
        bank.sendMoney("4444 1111 0678 1148", "5375 2121 4839 2290", 100);

        System.out.println("Історія транзакцій:");
        bank.getBankAccounts().get("4444 1111 0678 1148").transactionHistoryGet();
    }
}


class BankAccount {
    private String accountNumber;
    private double balance;
    private HashMap<String, String> transactionHistory; // У форматі {дата: транзакція}, при зчитуванні (транзакція, дата)
    private String ownerName;
    private int ownerAge;
    private Scanner scan = new Scanner(System.in);

    public BankAccount(String accountNumber, String ownerName, int ownerAge){
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new HashMap<>();
        this.ownerName = ownerName;
        this.ownerAge = ownerAge;
    }

    public void deposit(double depositAmount){
        if(depositAmount < 0){
            System.out.println("Сума депозиту не може бути від'ємною.");
        } else {
            setBalance(getBalance() + depositAmount);
            System.out.println("Рахунок поповнено на " + depositAmount + ". Поточний баланс: " + getBalance());
            recordTransactionInf("Поповнення рахунку", depositAmount);
        }
    }

    public void withdrawal(double withdrawalAmount){
        if(withdrawalAmount < 0 || withdrawalAmount > getBalance()){
            System.out.println("Сума зняття не може бути від'ємною та більшою за баланс рахунку.");
        } else {
            setBalance(getBalance() - withdrawalAmount);
            System.out.println("З рахунку знято " + withdrawalAmount + ". Поточний баланс: " + getBalance());
            recordTransactionInf("Зняття з рахунку", withdrawalAmount);
        }
    }

    public void viewBalance(){
        System.out.println("Баланс рахунку " + getAccountNumber() + ": " + getBalance());
    }

    public void transactionHistoryGet(){
        if(getTransactionHistory().isEmpty()){
            System.out.println("Ще не було жодних транзакцій.");
        } else {
            System.out.println("Історія транзакцій " + getOwnerName() + ":");
            for (HashMap.Entry<String, String> entry : getTransactionHistory().entrySet()) {
                System.out.println("Транзакція: " + entry.getValue() + ", Час транзакції: " + entry.getKey());
            }
        }
    }

    public void editOwnerInf(){
        System.out.println("Введіть нове ім'я власника рахунку: ");
        setOwnerName(scan.nextLine());
        System.out.println("Введіть новий вік власника рахунку: ");
        setOwnerAge(scan.nextInt());
        scan.nextLine();
    }

    public void recordTransactionInf(String transaction, double transactionAmount) {
        if (transactionAmount < 0) {
            System.out.println("Сума транзакції не може бути від'ємною.");
            return;
        }
        LocalDateTime transactionTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = transactionTime.format(myFormatObj);
        String formattedTransactionAmount = String.format("%.2f", transactionAmount);
        getTransactionHistory().put(formattedTime, transaction + ": " + formattedTransactionAmount);
    }

    // Гетери
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public HashMap<String, String> getTransactionHistory() {
        return transactionHistory;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getOwnerAge() {
        return ownerAge;
    }

    // Сетери
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactionHistory(HashMap<String, String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerAge(int ownerAge) {
        this.ownerAge = ownerAge;
    }
}

class Bank {
    private HashMap<String, BankAccount> bankAccounts;  //ID та загалом рахунок

    public Bank(){
        this.bankAccounts = new HashMap<>();
    }

    public HashMap<String, BankAccount> getBankAccounts() {
        return bankAccounts;
    }
    public void setBankAccounts(HashMap<String, BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }



    public void createAccount(String accountNumber, String ownerName, int ownerAge){
        if (getBankAccounts().containsKey(accountNumber)){
            System.out.println("Банківський рахунок з таким номером уже існує. Користувача не створено.");
        } else {
            BankAccount account = new BankAccount(accountNumber, ownerName, ownerAge);
            getBankAccounts().put(accountNumber, account);
        }
    }

    public void idGetAccount(String accountNumber){
        if (getBankAccounts().containsKey(accountNumber)){
            System.out.println("Рахунок " + accountNumber);
            System.out.println("Баланс: " + getBankAccounts().get(accountNumber).getBalance());
            System.out.println("Ім'я власника: " + getBankAccounts().get(accountNumber).getOwnerName());
            System.out.println("Вік власника: " + getBankAccounts().get(accountNumber).getOwnerAge());
            System.out.println("Історія транзакцій: ");
            getBankAccounts().get(accountNumber).transactionHistoryGet();
        }
    }

    public void showAccounts() {
        for (HashMap.Entry<String, BankAccount> entry : getBankAccounts().entrySet()) {
            String accountNumber = entry.getKey();
            BankAccount account = entry.getValue();
            System.out.println("Номер рахунку: " + accountNumber);
            System.out.println("Ім'я власника: " + account.getOwnerName());
            System.out.println("Баланс: " + account.getBalance());
        }
    }

    public void sendMoney(String senderNumber, String recipientNumber, double sendAmount){
        BankAccount sender = getBankAccounts().get(senderNumber);
        BankAccount recipient = getBankAccounts().get(recipientNumber);

        if (sender == null){
            System.out.println("Рахунок відправника (" + senderNumber + ") не знайдено.");
            return;
        }
        if (recipient == null){
            System.out.println("Рахунок одержувача (" + recipientNumber + ") не знайдено.");
            return;
        }


        if (sendAmount <= sender.getBalance()){
            sender.setBalance(sender.getBalance() - sendAmount);
            recipient.setBalance(recipient.getBalance() + sendAmount);
            System.out.println("Переказ здійснено успішно.");
            System.out.println("Баланс відправника (" + sender.getOwnerName() + "): " + sender.getBalance());
            System.out.println("Баланс отримувача (" + recipient.getOwnerName() + "): " + recipient.getBalance());
            System.out.println("Переказ здійснено успішно.");
            sender.recordTransactionInf(("Надіслав кошти " + recipient.getOwnerName()), sendAmount);
            recipient.recordTransactionInf(("Отримав кошти від " + sender.getOwnerName()), sendAmount);
        } else {
            System.out.println("Коштів недостатньо для переказу.");
        }
    }
}

