class Account {

    private String customerName;

    private String accno;

    double bal;



    public Account(String customerName, String accno, double ibal) {

        this.customerName = customerName;

        this.accno = accno;

        this.bal = ibal;

    }


    public void deposit(double amt) {

        bal += amt;

        System.out.println("Deposited: " + amt);

    }



    public void displayBalance() {

        System.out.println("Current Balance: " + bal);

    }

    public boolean withdraw(double amt) {

        if (amt <= bal) {

            bal -= amt;

            System.out.println("Withdrawn: " + amt);

            return true;

        } else {

            System.out.println("Insufficient balance for withdrawal.");

            return false;

        }

    }




    public double getBalance() {

        return bal;

    }

}



class SavingsAccount extends Account {

    private double IR;



    public SavingsAccount(String customerName, String accno, double ibal, double IR) {

        super(customerName, accno, ibal);

        this.IR= IR;

    }




    public void addInterest() {

        double interest = bal * IR/ 100;

        deposit(interest);

        System.out.println("Interest added: " + interest);

    }

}




class CurrentAccount extends Account {

    private static final double MIN_BALANCE = 500.0;

    private static final double SERVICE_CHARGE = 50.0;



    public CurrentAccount(String customerName, String accno, double ibal) {

        super(customerName, accno, ibal);

    }


    public boolean withdraw(double amt) {

        if (amt > bal) {

            System.out.println("Insufficient balance for withdrawal.");

            return false;

        }

        if (bal - amt < MIN_BALANCE) {

            System.out.println("Minimum balance violation. Service charge applied.");

            bal -= SERVICE_CHARGE; 

            System.out.println("Service charge: " + SERVICE_CHARGE);

        }

        return super.withdraw(amt);

    }

}


public class Bank {

    public static void main(String[] args) {

        SavingsAccount sa = new SavingsAccount("Piyush", "SA3321", 100000.0, 5.0);

        sa.displayBalance();

        sa.addInterest();

        sa.displayBalance();

        sa.withdraw(200);

        sa.displayBalance();


        CurrentAccount ca = new CurrentAccount("Vaibhav", "CA1456", 6000.0);

        ca.displayBalance();

        ca.withdraw(200);

        ca.displayBalance();

        ca.withdraw(1000); 

        ca.displayBalance();

    }

}