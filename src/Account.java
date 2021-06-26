class Account {
    private String name;
    private int balance = 0;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    //Phuong thuc cong tien vao tai khoan
    public void addToBalance(int amount){
        balance += amount;
    }

    //Phuong thuc tru tien vao tai khoan
    public void subStractFromBalance(int amount){
        //kiem tra so tien rut voi so du hien tai
        if(amount < getBalance()){
            balance -= amount;
        }else {
            System.out.println("So tien khong du de rut");
        }
    }

    public String toString(){
        return name + ": " + balance;
    }
}
