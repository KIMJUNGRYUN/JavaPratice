import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;

public class BankSystemGUI {
    private static Bank_System bankSystem = new Bank_System();
    private static final DecimalFormat df = new DecimalFormat("#,###.##");

    public static void main(String[] args) {
        // 메인 프레임 설정
        JFrame frame = new JFrame("은행 관리 시스템");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // 패널과 레이아웃 설정
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        frame.add(panel, BorderLayout.CENTER);

        // 버튼 생성
        JButton createAccountButton = new JButton("계좌 생성");
        JButton depositButton = new JButton("입금");
        JButton withdrawButton = new JButton("출금");
        JButton checkBalanceButton = new JButton("잔액 조회");
        JButton transferButton = new JButton("송금");
        JButton exitButton = new JButton("종료");

        // 버튼을 패널에 추가
        panel.add(createAccountButton);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(checkBalanceButton);
        panel.add(transferButton);
        panel.add(exitButton);

        // 계좌 생성 버튼 리스너
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(frame, "사용자 ID 입력:");
                if (bankSystem.isUserIdExists(id)) {
                    JOptionPane.showMessageDialog(frame, "이 아이디는 중복입니다: " + id);
                    return;
                }
                String name = JOptionPane.showInputDialog(frame, "사용자 이름 입력:");
                String password = JOptionPane.showInputDialog(frame, "비밀번호 입력:");
                String accountNumber = generateAccountNumber();
                JOptionPane.showMessageDialog(frame, "생성된 계좌번호: " + accountNumber);
                bankSystem.createAccountWithUser(id, name, password, accountNumber);
            }
        });

        // 입금 버튼 리스너
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = JOptionPane.showInputDialog(frame, "계좌번호 입력:");
                String amountStr = JOptionPane.showInputDialog(frame, "입금할 금액 입력:");
                double amount = Double.parseDouble(amountStr);
                bankSystem.deposit(accountNumber, amount);
            }
        });

        // 출금 버튼 리스너
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = JOptionPane.showInputDialog(frame, "계좌번호 입력:");
                String amountStr = JOptionPane.showInputDialog(frame, "출금할 금액 입력:");
                double amount = Double.parseDouble(amountStr);
                bankSystem.withdraw(accountNumber, amount);
            }
        });

        // 잔액 조회 버튼 리스너
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = JOptionPane.showInputDialog(frame, "계좌번호 입력:");
                double balance = bankSystem.checkBalance(accountNumber);
                JOptionPane.showMessageDialog(frame, "현재 잔액: " + df.format(balance) + "원");
            }
        });

        // 송금 버튼 리스너
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fromAccount = JOptionPane.showInputDialog(frame, "출금할 계좌번호 입력:");
                String toAccount = JOptionPane.showInputDialog(frame, "입금할 계좌번호 입력:");
                String amountStr = JOptionPane.showInputDialog(frame, "송금할 금액 입력:");
                double amount = Double.parseDouble(amountStr);
                bankSystem.transfer(fromAccount, toAccount, amount);
                JOptionPane.showMessageDialog(frame, df.format(amount) + "원이 " + fromAccount + "에서 " + toAccount + "으로 송금되었습니다.");
            }
        });

        // 종료 버튼 리스너
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // 프레임 표시
        frame.setVisible(true);
    }

    // 계좌번호 생성 메서드
    private static String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder("6666");
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }
}
