import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.Date;

public class ATM extends Account{

    public ATM(String name, int balance) {
        super(name, balance);

    }

    public ATM() {

    }




    public void transactionDeposit(int amount){
        super.addToBalance(amount);
    }

    public void transactionWithdraw(int amount){
        super.subStractFromBalance(amount);
    }
    public int getBalance(){
        return super.getBalance();
    }

    public void checkTradeHistory(ArrayList o) {
        int j = 1;
        for(int i = o.size() - 1; i > o.size() - 4 && i >= 0; i--, j++) {
            System.out.println(j + ". " + o.get(i));
        }
    }

    public void writeFile(ArrayList o) throws IOException {
        try {
            Date now = new Date();
            FileWriter fw = new FileWriter("file.txt", true);
            BufferedWriter bw  =new BufferedWriter(fw);

            bw.write(String.valueOf(now));
            bw.write("\n" + toString() + " vnd\n");
            for (int i = 0; i < o.size(); i++) {
                bw.write((i + 1) + ". " + o.get(i) + " vnd\n");
            }
            bw.close();
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
