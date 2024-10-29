import java.text.DecimalFormat;

public class Account {
    private String accountNumber;
    private double balance;


    private static final DecimalFormat df = new DecimalFormat("#,###");

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;  // 새 계좌의 초기 잔액은 0
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(df.format(amount) + "원이 입금되었습니다.");
            System.out.println("현재 잔액: " + df.format(balance) + "원");
        } else {
            System.out.println("유효하지 않은 금액입니다.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(df.format(amount) + "원이 출금되었습니다.");
            System.out.println("현재 잔액: " + df.format(balance) + "원");
        } else {
            System.out.println("잔액이 부족합니다. 현재 잔액: " + df.format(balance) + "원");
        }
    }


}
