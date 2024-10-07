package fm;
import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  
  
public class AccountingApp {  
    private List<Transaction> transactions = new ArrayList<>();  
  
    public void addTransaction() {  
        Scanner scanner = new Scanner(System.in);  
        System.out.print("请输入交易描述: ");  
        String description = scanner.nextLine();  
        System.out.print("请输入交易金额: ");  
        double amount = scanner.nextDouble();  
        System.out.print("是收入吗? (y/n): ");  
        boolean isIncome = scanner.next().equalsIgnoreCase("y");  
        scanner.nextLine(); // 清除换行符  
  
        Transaction transaction = new Transaction(description, amount, isIncome);  
        transactions.add(transaction);  
        System.out.println("交易已添加: " + transaction);  
    }  
  
    public void listTransactions() {  
        for (Transaction transaction : transactions) {  
            System.out.println(transaction);  
        }  
    }  
  
    public static void main(String[] args) {  
        AccountingApp app = new AccountingApp();  
  
        while (true) {  
            System.out.println("1. 添加交易");  
            System.out.println("2. 列出所有交易");  
            System.out.print("请输入选项 (1/2): ");  
            int choice = Integer.parseInt(new Scanner(System.in).nextLine());  
  
            switch (choice) {  
                case 1:  
                    app.addTransaction();  
                    break;  
                case 2:  
                    app.listTransactions();  
                    break;  
                default:  
                    System.out.println("无效的选项，请重新输入！");  
            }  
        }  
    }  
}
