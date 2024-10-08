/**
 * Task 1: ATM Simulation 
 */
public class ATM {

    //VARIABLE DECLARE AS PRIVATE
    private int balance;
    private int pin;

    //CONSTRUCTOR
    public ATM(int balance, int pin){

        //THIS POINTER REFERES THE CURRENT VARIABLE BY PARAMETERS
        this.balance = balance;
        this.pin = pin;
    }

    //FUNCTION FOR DISPLAY THE MENU'S
    public void displayMenu() {
        System.out.println("\n");
        System.out.println("1: Check Balance");
        System.out.println("2: Deposit amount");
        System.out.println("3: Withdraw amount");
        System.out.println("4: Change transaction PIN");
        System.out.println("5: Exit");
    }

    //CREATE ALL MENU FUNCTIONS
    //CHECK BALANCE FUNCTION
    public void deposit(int amount){
        balance += amount;
    }

    //FUNCTION FOR WITHDRAW MONEY
    public void withdraw(int amount){
        if (balance<amount) {
            System.out.println("Insufficient Balance");
            return;
        }
        balance -= amount;
    }

    //FUNCTION FOR GET BALANCE
    public int getBalance(){
        return balance;
    }

    //FUNCTION FOR VALIDATE PIN
    public boolean validatePin(int pin){
        return this.pin == pin;
    }

    //FUNCTION FOR CHANGE PIN
    public void changePin(int newPin){
        pin = newPin;
        System.out.println("Your PIN chnaged successfully!");
    }


    //MAIN METHOD 
    public static void main(String[] args) {

        //CREATE ATM OBJECT
        ATM atm = new ATM(10000, 1234);

        //DISPLAY MENU BY ENTERING VALID PIN FUNCTIONALITY
        System.out.println("\n****** Welcome to ATM Simulation! ****** ");
        System.out.println("\nPlease enter your transaction PIN: ");
        int pin = Integer.parseInt(System.console().readLine());

        if (atm.validatePin(pin)) {
            int option = 0;
            System.out.println("\nHere, are the options available for you");
            while (option!=5) {
                atm.displayMenu();
                System.out.println("\nChoose your options from above: ");
                option = Integer.parseInt(System.console().readLine());

                //SWITCH CASES FOR ACCESSING MENU FUNCTIONS
                switch (option) {
                    case 1:
                        System.out.println("Your available balance is: "+atm.getBalance());
                        break;
                
                    case 2:
                        System.out.println("Enter deposit amount: ");
                        int amount = Integer.parseInt(System.console().readLine());
                        atm.deposit(amount);
                        break;
                        
                    case 3:
                        System.out.println("Enter withdrawal amount: ");
                        amount = Integer.parseInt(System.console().readLine());
                        atm.withdraw(amount);
                        break;

                    case 4:
                        System.out.println("Enter new PIN: ");
                        int newPin = Integer.parseInt(System.console().readLine());
                        atm.changePin(newPin);
                        break;

                    case 5:
                        System.out.println("****** Thank You for using ATM! ******");
                        break;
                    
                    default:
                        break;
                }
            }
        }
        else{
            System.out.println("You entered Invalid PIN!");
        }
    }
}