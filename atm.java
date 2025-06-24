import java.util.Scanner;
class atm{
    private double balance;
    String name;
    int accnumber;
    public atm(double initialBalance,String n,int acc){
        this.balance = initialBalance;
        name = n;
        accnumber = acc;
        
    }

    double checkBalance(){
        return balance;
    }

    double deposit(double amount){
        if(amount>0){
            balance = balance+amount;
        }
        return balance;
    }

    double withdraw(double amount){
         if(amount<=balance && amount>0){
            balance = balance-amount;
        }
        else{
            System.out.println("INSUFFICIENT BALANCE");
        }
        return balance;
    }
        public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        //user details
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your account number: ");
        int accNum = sc.nextInt();

        //options
        System.out.println("CODSOFT ATM- MAke your choice ");
        System.out.println("1.CHECK BALANCE");
        System.out.println("2.DEPOSIT");
        System.out.println("3.WITHDRAW");
        System.out.println("4.EXIT");
        int choice = sc.nextInt();
        double amount = 0;

        atm obj1 = new atm(amount, name, accNum);

        switch(choice)
        {
            case 1:
            System.out.println("BALANCE: "+obj1.checkBalance());
            break;

            case 2:
            System.out.println("Enter the amount to be deposited.");
            amount = sc.nextInt();
            System.out.println("DEPOSIT: "+amount);
            System.out.println("INITIAL BALANCE: "+obj1.checkBalance());
            System.out.println("CURRENT BALANCE: "+obj1.deposit(amount));
            break;

            case 3:
            System.out.println("Enter the amount to be withrawn.");
            amount = sc.nextInt();
            System.out.println("WITHRAWAL AMOUNT: "+amount);
            System.out.println("INITIAL BALANCE: "+obj1.checkBalance());
            System.out.println("CURRENT BALANCE: "+obj1.withdraw(amount));
            break;
            
            case 4:
            System.out.println("EXIT");
            break;
            default:
                System.out.println("WRONG OPTION");
            

        }

    }
}
