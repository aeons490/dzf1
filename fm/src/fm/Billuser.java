package bill2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bill {		
	    private Date date;
	    private double amount;
	    private String category;
	    private String remark;

	    public Bill(Date date, double amount, String category, String remark) {
	        this.date = date;
	        this.amount = amount;
	        this.category = category;
	        this.remark = remark;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public String getRemark() {
	        return remark;
	    }
}

class IncomeBill extends Bill {
	public IncomeBill(Date date, double amount, String category, String remark) {
	        super(date, amount, category, remark);
	    }
}

class ExpenseBill extends Bill {
	public ExpenseBill(Date date, double amount, String category, String remark) {
	        super(date, amount, category, remark);
	    }
}

class BillManagementSystem {
	private ArrayList<IncomeBill> incomeBills = new ArrayList<>();
	private ArrayList<ExpenseBill> expenseBills = new ArrayList<>();
	private double monthlyBudget = 0;
	private double currentExpense = 0;

	public void recordIncome() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("请输入收入信息:");
	        try {
	            System.out.print("日期(YYYY-MM-DD):");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = sdf.parse(scanner.next());
	            System.out.print("金额:");
	            double amount = scanner.nextDouble();
	            if (amount <= 0) {
	                throw new IllegalArgumentException("收入金额必须为正数");
	            }
	            System.out.print("类别(如工资、奖金等):");
	            String category = scanner.next();
	            System.out.print("备注:");
	            String remark = scanner.next();
	            IncomeBill bill = new IncomeBill(date, amount, category, remark);
	            incomeBills.add(bill);
	            System.out.println("收入已成功记录!");
	        } catch (Exception e) {
	            System.out.println("输入错误: " + e.getMessage());
	        }
	    }

	    public void recordExpense() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("请输入支出信息:");
	        try {
	            System.out.print("日期(YYYY-MM-DD):");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = sdf.parse(scanner.next());
	            System.out.print("金额:");
	            double amount = scanner.nextDouble();
	            if (amount <= 0) {
	                throw new IllegalArgumentException("支出金额必须为正数");
	            }
	            System.out.print("类别(如餐饮、交通、购物等):");
	            String category = scanner.next();
	            System.out.print("备注:");
	            String remark = scanner.next();
	            ExpenseBill bill = new ExpenseBill(date, amount, category, remark);
	            expenseBills.add(bill);
	            currentExpense += amount;
	            System.out.println("支出已成功记录!");
	        } catch (Exception e) {
	            System.out.println("输入错误: " + e.getMessage());
	        }
	    }

	    public void showAllBills() {
	        System.out.println("收入账单:");
	        for (IncomeBill bill : incomeBills) {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            System.out.println("日期: " + sdf.format(bill.getDate()) + ", 金额: " + bill.getAmount() +
	                    ", 类别: " + bill.getCategory() + ", 备注: " + bill.getRemark());
	        }
	        System.out.println("支出账单:");
	        for (ExpenseBill bill : expenseBills) {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            System.out.println("日期: " + sdf.format(bill.getDate()) + ", 金额: " + bill.getAmount() +
	                    ", 类别: " + bill.getCategory() + ", 备注: " + bill.getRemark());
	        }
	    }

	    public void queryBills() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("请选择查询方式:");
	        System.out.println("1. 按日期查询");
	        System.out.println("2. 按日期范围查询");
	        System.out.println("3. 按类别查询");
	        int choice = scanner.nextInt();
	        switch (choice) {
	            case 1:
	                queryByDate();
	                break;
	            case 2:
	                queryByDateRange();
	                break;
	            case 3:
	                queryByCategory();
	                break;
	            default:
	                System.out.println("无效的选择");
	        }
	    }

	    private void queryByDate() {
	        Scanner scanner = new Scanner(System.in);
	        try {
	            System.out.print("请输入日期(YYYY-MM-DD):");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = sdf.parse(scanner.next());
	            System.out.println("收入账单:");
	            for (IncomeBill bill : incomeBills) {
	                if (bill.getDate().equals(date)) {
	                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	                    System.out.println("日期: " + sdf1.format(bill.getDate()) + ", 金额: " + bill.getAmount() +
	                            ", 类别: " + bill.getCategory() + ", 备注: " + bill.getRemark());
	                }
	            }
	            System.out.println("支出账单:");
	            for (ExpenseBill bill : expenseBills) {
	                if (bill.getDate().equals(date)) {
	                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	                    System.out.println("日期: " + sdf1.format(bill.getDate()) + ", 金额: " + bill.getAmount() +
	                            ", 类别: " + bill.getCategory() + ", 备注: " + bill.getRemark());
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("输入错误: " + e.getMessage());
	        }
	    }

	    private void queryByDateRange() {
	        Scanner scanner = new Scanner(System.in);
	        try {
	            System.out.print("请输入起始日期(YYYY-MM-DD):");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date startDate = sdf.parse(scanner.next());
	            System.out.print("请输入结束日期(YYYY-MM-DD):");
	            Date endDate = sdf.parse(scanner.next());
	            System.out.println("收入账单:");
	            for (IncomeBill bill : incomeBills) {
	                if (bill.getDate().after(startDate) && bill.getDate().before(endDate)) {
	                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	                    System.out.println("日期: " + sdf1.format(bill.getDate()) + ", 金额: " + bill.getAmount() +
	                            ", 类别: " + bill.getCategory() + ", 备注: " + bill.getRemark());
	                }
	            }
	            System.out.println("支出账单:");
	            for (ExpenseBill bill : expenseBills) {
	                if (bill.getDate().after(startDate) && bill.getDate().before(endDate)) {
	                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	                    System.out.println("日期: " + sdf1.format(bill.getDate()) + ", 金额: " + bill.getAmount() +
	                            ", 类别: " + bill.getCategory() + ", 备注: " + bill.getRemark());
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("输入错误: " + e.getMessage());
	        }
	    }

	    private void queryByCategory() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("请输入类别:");
	        String category = scanner.next();
	        System.out.println("收入账单:");
	        for (IncomeBill bill : incomeBills) {
	            if (bill.getCategory().equals(category)) {
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                System.out.println("日期: " + sdf.format(bill.getDate()) + ", 金额: " + bill.getAmount() +
	                        ", 类别: " + bill.getCategory() + ", 备注: " + bill.getRemark());
	            }
	        }
	        System.out.println("支出账单:");
	        for (ExpenseBill bill : expenseBills) {
	            if (bill.getCategory().equals(category)) {
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                System.out.println("日期: " + sdf.format(bill.getDate()) + ", 金额: " + bill.getAmount() +
	                        ", 类别: " + bill.getCategory() + ", 备注: " + bill.getRemark());
	            }
	        }
	    }

	    public void setMonthlyBudget() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("请设置月度预算:");
	        try {
	            double budget = scanner.nextDouble();
	            if (budget < 0) {
	                throw new IllegalArgumentException("预算金额必须为正数");
	            }
	            monthlyBudget = budget;
	            System.out.println("月度预算已设置成功!");
	        } catch (Exception e) {
	            System.out.println("输入错误: " + e.getMessage());
	        }
	    }

	    public void showMonthlyStatistics() {
	        double totalIncome = 0;
	        for (IncomeBill bill : incomeBills) {
	            totalIncome += bill.getAmount();
	        }
	        double totalExpense = 0;
	        ArrayList<String> expenseCategories = new ArrayList<>();
	        for (ExpenseBill bill : expenseBills) {
	            totalExpense += bill.getAmount();
	            if (!expenseCategories.contains(bill.getCategory())) {
	                expenseCategories.add(bill.getCategory());
	            }
	        }
	        System.out.println("月度统计报告:");
	        System.out.println("总收入: " + totalIncome);
	        System.out.println("总支出: " + totalExpense);
	        System.out.println("各类别支出:");
	        for (String category : expenseCategories) {
	            double categoryTotal = 0;
	            for (ExpenseBill bill : expenseBills) {
	                if (bill.getCategory().equals(category)) {
	                    categoryTotal += bill.getAmount();
	                }
	            }
	            System.out.println(category + ": " + categoryTotal);
	        }
	    }

	    public void run() {
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("欢迎使用个人账单管理系统");
	            System.out.println("请选择操作:");
	            System.out.println("1. 记录收入");
	            System.out.println("2. 记录支出");
	            System.out.println("3. 查看所有账单");
	            System.out.println("4. 查询账单");
	            System.out.println("5. 设置月度预算");
	            System.out.println("6. 查看月度统计报告");
	            System.out.println("7. 退出系统");
	            int choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    recordIncome();
	                    break;
	                case 2:
	                    recordExpense();
	                    break;
	                case 3:
	                    showAllBills();
	                    break;
	                case 4:
	                    queryBills();
	                    break;
	                case 5:
	                    setMonthlyBudget();
	                    break;
	                case 6:
	                    showMonthlyStatistics();
	                    break;
	                case 7:
	                    System.out.println("已退出系统");
	                    return;
	                default:
	                    System.out.println("无效的选择，请重新输入");
	            }
	        }
	    }
}


	
