import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class BankMain {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank_System bankSystem = new Bank_System();  // 은행 시스템 인스턴스

    // 계좌 생성 기능
    private static void createAccount() {
        System.out.print("사용자 ID 입력: ");
        String id = scanner.nextLine();
        if (bankSystem.isUserIdExists(id)) {
            System.out.println("이 아이디는 중복입니다: " + id);
            return;  // 중복되면 계좌 생성 중단
        }
        System.out.print("사용자 이름 입력: ");
        String name = scanner.nextLine();
        System.out.print("비밀번호 입력: ");
        String password = scanner.nextLine();

        // 계좌번호 생성 (앞 4자리 고정 6666, 뒤 10자리 랜덤)
        String accountNumber = generateAccountNumber();
        System.out.println("생성된 계좌번호: " + accountNumber);

        bankSystem.createAccountWithUser(id, name, password, accountNumber);
    }

    // 계좌번호 생성 메서드
    private static String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder("6666");  // 앞 4자리 고정
        Random random = new Random();

        for (int i = 0; i < 10; i++) {  // 뒤에 10자리 랜덤 생성
            int digit = random.nextInt(10);  // 0~9 사이의 랜덤 숫자
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }

    // 입금 기능
    private static void deposit() {
        System.out.print("계좌번호 입력: ");
        String accountNumber = scanner.nextLine();
        System.out.print("입금할 금액 입력: ");
        double amount = Double.parseDouble(scanner.nextLine());
        bankSystem.deposit(accountNumber, amount);
    }

    // 출금 기능
    private static void withdraw() {
        System.out.print("계좌번호 입력: ");
        String accountNumber = scanner.nextLine();
        System.out.print("출금할 금액 입력: ");
        double amount = Double.parseDouble(scanner.nextLine());
        bankSystem.withdraw(accountNumber, amount);
    }

    private static void transfer() {
        System.out.print("출금할 계좌번호 입력: ");
        String fromAccount = scanner.nextLine();
        System.out.print("입금할 계좌번호 입력: ");
        String toAccount = scanner.nextLine();
        System.out.print("송금할 금액 입력: ");
        double amount = Double.parseDouble(scanner.nextLine());

        bankSystem.transfer(fromAccount, toAccount, amount);
    }

    // 잔액 조회 기능
    private static void checkBalance() {
        System.out.print("계좌번호 입력: ");
        String accountNumber = scanner.nextLine();
        bankSystem.checkBalance(accountNumber);
    }

    public static void main(String[] args) throws FileNotFoundException {
        boolean running = true;

        while (running) {
            System.out.println("\n====== 은행 관리 시스템 ======");
            System.out.println("1. 계좌 생성");
            System.out.println("2. 입금");
            System.out.println("3. 출금");
            System.out.println("4. 잔액 조회");
            System.out.println("5. 송금");
            System.out.println("6. 종료");


            System.out.print("선택: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    transfer();
                    break;
                case 6:
                    System.out.println("시스템을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }
}
