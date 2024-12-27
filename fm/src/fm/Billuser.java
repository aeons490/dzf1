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
	        System.out.println("������������Ϣ:");
	        try {
	            System.out.print("����(YYYY-MM-DD):");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = sdf.parse(scanner.next());
	            System.out.print("���:");
	            double amount = scanner.nextDouble();
	            if (amount <= 0) {
	                throw new IllegalArgumentException("���������Ϊ����");
	            }
	            System.out.print("���(�繤�ʡ������):");
	            String category = scanner.next();
	            System.out.print("��ע:");
	            String remark = scanner.next();
	            IncomeBill bill = new IncomeBill(date, amount, category, remark);
	            incomeBills.add(bill);
	            System.out.println("�����ѳɹ���¼!");
	        } catch (Exception e) {
	            System.out.println("�������: " + e.getMessage());
	        }
	    }

	    public void recordExpense() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("������֧����Ϣ:");
	        try {
	            System.out.print("����(YYYY-MM-DD):");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = sdf.parse(scanner.next());
	            System.out.print("���:");
	            double amount = scanner.nextDouble();
	            if (amount <= 0) {
	                throw new IllegalArgumentException("֧��������Ϊ����");
	            }
	            System.out.print("���(���������ͨ�������):");
	            String category = scanner.next();
	            System.out.print("��ע:");
	            String remark = scanner.next();
	            ExpenseBill bill = new ExpenseBill(date, amount, category, remark);
	            expenseBills.add(bill);
	            currentExpense += amount;
	            System.out.println("֧���ѳɹ���¼!");
	        } catch (Exception e) {
	            System.out.println("�������: " + e.getMessage());
	        }
	    }

	    public void showAllBills() {
	        System.out.println("�����˵�:");
	        for (IncomeBill bill : incomeBills) {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            System.out.println("����: " + sdf.format(bill.getDate()) + ", ���: " + bill.getAmount() +
	                    ", ���: " + bill.getCategory() + ", ��ע: " + bill.getRemark());
	        }
	        System.out.println("֧���˵�:");
	        for (ExpenseBill bill : expenseBills) {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            System.out.println("����: " + sdf.format(bill.getDate()) + ", ���: " + bill.getAmount() +
	                    ", ���: " + bill.getCategory() + ", ��ע: " + bill.getRemark());
	        }
	    }

	    public void queryBills() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("��ѡ���ѯ��ʽ:");
	        System.out.println("1. �����ڲ�ѯ");
	        System.out.println("2. �����ڷ�Χ��ѯ");
	        System.out.println("3. ������ѯ");
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
	                System.out.println("��Ч��ѡ��");
	        }
	    }

	    private void queryByDate() {
	        Scanner scanner = new Scanner(System.in);
	        try {
	            System.out.print("����������(YYYY-MM-DD):");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = sdf.parse(scanner.next());
	            System.out.println("�����˵�:");
	            for (IncomeBill bill : incomeBills) {
	                if (bill.getDate().equals(date)) {
	                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	                    System.out.println("����: " + sdf1.format(bill.getDate()) + ", ���: " + bill.getAmount() +
	                            ", ���: " + bill.getCategory() + ", ��ע: " + bill.getRemark());
	                }
	            }
	            System.out.println("֧���˵�:");
	            for (ExpenseBill bill : expenseBills) {
	                if (bill.getDate().equals(date)) {
	                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	                    System.out.println("����: " + sdf1.format(bill.getDate()) + ", ���: " + bill.getAmount() +
	                            ", ���: " + bill.getCategory() + ", ��ע: " + bill.getRemark());
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("�������: " + e.getMessage());
	        }
	    }

	    private void queryByDateRange() {
	        Scanner scanner = new Scanner(System.in);
	        try {
	            System.out.print("��������ʼ����(YYYY-MM-DD):");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date startDate = sdf.parse(scanner.next());
	            System.out.print("�������������(YYYY-MM-DD):");
	            Date endDate = sdf.parse(scanner.next());
	            System.out.println("�����˵�:");
	            for (IncomeBill bill : incomeBills) {
	                if (bill.getDate().after(startDate) && bill.getDate().before(endDate)) {
	                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	                    System.out.println("����: " + sdf1.format(bill.getDate()) + ", ���: " + bill.getAmount() +
	                            ", ���: " + bill.getCategory() + ", ��ע: " + bill.getRemark());
	                }
	            }
	            System.out.println("֧���˵�:");
	            for (ExpenseBill bill : expenseBills) {
	                if (bill.getDate().after(startDate) && bill.getDate().before(endDate)) {
	                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	                    System.out.println("����: " + sdf1.format(bill.getDate()) + ", ���: " + bill.getAmount() +
	                            ", ���: " + bill.getCategory() + ", ��ע: " + bill.getRemark());
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("�������: " + e.getMessage());
	        }
	    }

	    private void queryByCategory() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("���������:");
	        String category = scanner.next();
	        System.out.println("�����˵�:");
	        for (IncomeBill bill : incomeBills) {
	            if (bill.getCategory().equals(category)) {
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                System.out.println("����: " + sdf.format(bill.getDate()) + ", ���: " + bill.getAmount() +
	                        ", ���: " + bill.getCategory() + ", ��ע: " + bill.getRemark());
	            }
	        }
	        System.out.println("֧���˵�:");
	        for (ExpenseBill bill : expenseBills) {
	            if (bill.getCategory().equals(category)) {
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                System.out.println("����: " + sdf.format(bill.getDate()) + ", ���: " + bill.getAmount() +
	                        ", ���: " + bill.getCategory() + ", ��ע: " + bill.getRemark());
	            }
	        }
	    }

	    public void setMonthlyBudget() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("�������¶�Ԥ��:");
	        try {
	            double budget = scanner.nextDouble();
	            if (budget < 0) {
	                throw new IllegalArgumentException("Ԥ�������Ϊ����");
	            }
	            monthlyBudget = budget;
	            System.out.println("�¶�Ԥ�������óɹ�!");
	        } catch (Exception e) {
	            System.out.println("�������: " + e.getMessage());
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
	        System.out.println("�¶�ͳ�Ʊ���:");
	        System.out.println("������: " + totalIncome);
	        System.out.println("��֧��: " + totalExpense);
	        System.out.println("�����֧��:");
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
	            System.out.println("��ӭʹ�ø����˵�����ϵͳ");
	            System.out.println("��ѡ�����:");
	            System.out.println("1. ��¼����");
	            System.out.println("2. ��¼֧��");
	            System.out.println("3. �鿴�����˵�");
	            System.out.println("4. ��ѯ�˵�");
	            System.out.println("5. �����¶�Ԥ��");
	            System.out.println("6. �鿴�¶�ͳ�Ʊ���");
	            System.out.println("7. �˳�ϵͳ");
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
	                    System.out.println("���˳�ϵͳ");
	                    return;
	                default:
	                    System.out.println("��Ч��ѡ������������");
	            }
	        }
	    }
}


	
