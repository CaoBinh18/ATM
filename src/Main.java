import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        ATM account = new ATM("Nguyen Van A", 1200000);
        ArrayList arr = new ArrayList();
        char choice;

        System.out.println("Ngan hang ABC kinh chao Quy khach Nguyen Van A");
        System.out.println("Menu");
        System.out.println("1. Nhan phim A de kiem tra tai khoan");
        System.out.println("2. Nhan phim D de nap tien");
        System.out.println("3. Nhan phim W de rut tien");
        System.out.println("4. Nhan phim H de xem lich su 3 lan");
        System.out.println("5. Nhan phim X de thoat");
        System.out.println("===========================================");
        System.out.println("Nhap lua chon cua ban:");

        while (true) {

            choice = sc.next().charAt(0);

            switch (choice) {
                case 'A':
                    System.out.printf("So du tai khoan khach hang la: %d vnd\n", account.getBalance());
                    System.out.println("Bam nut theo menu de tiep tuc giao dich");
                    System.out.println("===========================================");
                    break;
                case 'D':
                    System.out.println("Giao dich Nap tien");
                    System.out.println("Vui long nhap so tien:");
                    int amount = 0;
                    try {
                        amount = sc.nextInt();
                    }
                    catch (InputMismatchException e) {
                        e.getStackTrace();
//                        System.out.println("Vui long nhap lai so tien");
                       break;
                    }
                    System.out.printf("Giao dich thah cong ban vua nap <%d vnd> vao tai khoan", amount);
                    account.addToBalance(amount);
                    arr.add("Nap tien:" + amount);
                    System.out.printf("\nSo du tai khoan cua khach hang la: %d vnd", account.getBalance());
                    System.out.println("\nBam nut theo menu de tiep tuc giao dich");
                    System.out.println("===========================================");
                    break;
                case 'W':
                    System.out.println("Giao dich Rut tien");
                    System.out.println("Vui long nhap so tien:");
                    int amountWithdrawal = 0;

                    try {
                        amountWithdrawal = sc.nextInt();
                    }
                    catch (InputMismatchException e) {
                        e.getStackTrace();
//                        System.out.println("Vui long nhap lai so tien");
                        break;
                    }

                    if (account.getBalance() > amountWithdrawal) {
                       account.subStractFromBalance(amountWithdrawal);
                        arr.add("Rut tien:" + amountWithdrawal);
                        System.out.printf("Giao dich thanh cong. Ban vua rut %d vnd\n", amountWithdrawal);
                        System.out.printf("So du tai khoan khach hang la: %d vnd\n", account.getBalance());
                        System.out.printf("Bam nut theo menu de tiep tuc giao dich\n");
                    } else {
                        System.out.println("\nGiao dich khong thanh cong.");
                        System.out.println("So du trong tai khoan cua ban khong du de thuc hien chuc nang nay");
                        System.out.printf("So du tai khoan cua ban la: %d",account.getBalance());
                        System.out.println("\nBam nut theo menu de tiep tuc giao dich");
                        System.out.println("===========================================");
                    }
                    break;
                case 'H':
                    System.out.printf("Lich su giao dich\n");
                    account.checkTradeHistory(arr);
                    System.out.println("\nBam nut theo menu de tiep tuc giao dich");
                    System.out.println("===========================================");
                    break;
                case 'X':
                    System.out.println("Cam on ban da su dung dich vu ATM");
                    account.writeFile(arr);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ban nhap sai chuc nang\n");
                    System.out.println("Bam nut theo menu de tiep tuc giao dich\n");
                    System.out.println("===========================================");
                    break;
            }
        }
    }
}
