import java.util.Scanner;

class GTN {
    int start;
    int difficulty;
    int randomGen;
    int randomCheck;
    int stepLimit;
    Scanner sc;

    public GTN(Scanner sc) {
        this.sc = sc;

        System.out.println("                WELCOME TO GUESS THE NUMBER             ");
        System.out.println("To PLAY Press 1");
        System.out.println("To EXIT Press 0");
        System.out.print("Choice: ");
        start = this.sc.nextInt();
        start(start);
    }

    public void start(int start) {
        this.start = start;

        if (start == 1) {
            game();
        } else if (start == 0) {
            System.out.println("Thanks For Playing !!");
            stop();
        } else {
            System.out.println("");
            System.out.println("Enter valid input: ");
            start = sc.nextInt();
            start(start);
        }
    }

    public void game() {

        System.out.println("");
        System.out.println("CHOOSE DIFFICULTY: ");
        System.out.println("1) EASY (1-50)");
        System.out.println("2) MEDIUM (1-100)");
        System.out.println("3) HARD (1-500)");
        System.out.println("4) INSANE (1-1000)");
        System.out.println("");
        System.out.println("To Exit the game Press 0");
        System.out.println("");
        System.out.print("DIFFICULTY: ");
        difficulty = this.sc.nextInt();
        System.out.println("");

        random(difficulty);
    }

    public void random(int difficulty) {
        this.difficulty = difficulty;

        switch (difficulty) {
            case 1:
                randomGen = (1 + (int) (Math.random() * ((50 - 1) + 1)));
                System.out.println("GUESS THE NUMBER BETWEEN 1 & 50");
                checker(randomGen, 50);
                break;
            case 2:
                randomGen = (1 + (int) (Math.random() * ((100 - 1) + 1)));
                System.out.println("GUESS THE NUMBER BETWEEN 1 & 100");
                checker(randomGen, 100);
                break;
            case 3:
                randomGen = (1 + (int) (Math.random() * ((500 - 1) + 1)));
                System.out.println("GUESS THE NUMBER BETWEEN 1 & 500");
                checker(randomGen, 500);
                break;
            case 4:
                randomGen = (1 + (int) (Math.random() * ((1000 - 1) + 1)));
                System.out.println("GUESS THE NUMBER BETWEEN 1 & 1000");
                checker(randomGen, 1000);
                break;
            case 0:
                System.out.println("Thanks For Playing !!");
                stop();
                break;
            default:
                System.out.print("Enter Valid Choice: ");
                System.out.println("");
                break;
        }
    }

    public void checker(int random, int steps) {

        this.randomCheck = random;
        this.stepLimit = steps;
        int choice;

        System.out.println("To Exit the Game while playing press 0");
        System.out.println("");

        for (int i = 0; i < stepLimit; i++) {
            System.out.print("Enter your Guess: ");
            choice = this.sc.nextInt();

            if (choice == randomCheck) {
                System.out.println("");
                System.out.println("YOU GUESSED THE CORRECT NUMBER !!!");
                System.out.println("Number of Guesses Taken: " + (i + 1));
                stop();
                break;
            } else if (choice > randomCheck) {
                System.out.println("");
                System.out.println("Try a SMALLER Number!");
            } else if (choice < randomCheck && choice > 0) {
                System.out.println("");
                System.out.println("Try a BIGGER Number!");
            } else if (choice == 0) {
                System.out.println("Thanks for Playing");
                stop();
                break;
            } else {
                System.out.println("Enter Valid Value!");
            }
        }
        System.out.println("");
    }

    public void stop() {
        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        new GTN(sc);
    }
}