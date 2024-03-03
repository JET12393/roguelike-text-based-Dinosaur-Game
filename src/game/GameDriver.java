package game;

import edu.monash.fit2099.engine.Display;
import game.item.EcoPoints;

public class GameDriver {
    private static Display display = new Display();
    private static int ecoPointsGoal;
    private static int turnLimit;
    private static boolean quit, challenge;



    public static void main(String[] args) {
        boolean running = true;
        quit = false;
        while (running) {
            chooseGameMode();
            Application application;
            if (quit){
                break;
            }
            else if (challenge) {
                setEcoPointsGoal();
                setTurnLimit();
            }
            application = new Application();
            EcoPoints.setEcoPoints(0);
            application.runApplication();
            if (!newGame()){
                running = false;
            }
        }
    }

    public static boolean newGame(){
        String str = "Another game or quit?\n" + "1) Restart\n" + "2) Quit";
        boolean running=true;
        while (running) {
            int choice = promptInput(str);
            if (choice==1) {
                running=false;
                return true;
            }
            else if (choice==2) {
                running=false;
                return false;
            }
            else {
                running=true;
                System.out.println("Invalid Input, please input 1 or 2 only!");
            }
        }
        return false;
    }

    /**
     * method to prompt for user input
     * @param str the line to be display to ask for input
     * @return the player's input read by the system
     */
    public static int promptInput(String str){
        int choice=0;
        display.println(str);
        char character = display.readChar();
        choice = Character.getNumericValue(character);
        return choice;
    }

    /**
     * this method is for user to choose between 2 game modes or exit the game
     */
    public static void chooseGameMode(){
        String str="Pick Game Mode:\n" + "1) Challenge Mode\n" + "2) Sandbox Mode\n"+ "3) Quit Game!!!";
        boolean choosing = true;
        while (choosing){
            int choice = promptInput(str);
            if (choice==1){
                challenge = true;
                choosing = false;

            }
            else if (choice==2){
                challenge = false;
                choosing = false;
            }
            else if (choice==3){
                quit = true;
                choosing = false;
            }
            else {
                System.out.println("Invalid Input, please input 1,2 or 3 only !");
            }
        }
    }

    /**
     * getter for EcoPointsGoal
     * @return ecoPointsGoal defined by user
     */
    public static int getEcoPointsGoal() {
        return ecoPointsGoal;
    }

    /**
     * this method is for user to set the EcoPointsGoal, to make it easier, I defined the goal for user to choose
     */
    public static void setEcoPointsGoal() {
        String str = "EcoPoints Goal:\n" + "1) 50\n" + "2) 1000\n" + "3) 10000\n" + "4) 100000\n" + "5) 1000000";
        int ret = promptInput(str);
        boolean looping = true;
        while (looping) {
            looping = false;
            switch (ret) {
                case 1:
                    ret = 50;
                    break;
                case 2:
                    ret = 1000;
                    break;
                case 3:
                    ret = 10000;
                    break;
                case 4:
                    ret = 100000;
                    break;
                case 5:
                    ret = 1000000;
                    break;
                default:
                    looping = true;
                    display.println("Invalid input, try again!");
                    ret = promptInput(str);
            }
        }
        ecoPointsGoal=ret;
    }

    /**
     * getter for turn limit
     * @return turn limit
     */
    public static int getTurnLimit(){
        return turnLimit;
    }

    /**
     * setter for turn limit
     */
    public static void setTurnLimit() {
        String str="Turn Limit:\n" + "1) 5\n" + "2) 50\n" + "3) 100\n" + "4) 1000";
        int ret = promptInput(str);
        boolean loop = true;
        while (loop){
            loop = false;
            switch (ret) {
                case 1:
                    ret = 5;
                    break;
                case 2:
                    ret = 50;
                    break;
                case 3:
                    ret = 100;
                    break;
                case 4:
                    ret = 1000;
                    break;
                default:
                    loop = true;
                    display.println("Invalid input, try again!");
                    ret = promptInput(str);
                }
            }
        GameDriver.turnLimit=ret;
    }

    /**
     * getter for challenge
     * @return
     */
    public static boolean isChallenge() {
        return challenge;
    }

    public static void setChallenge(boolean challenge) {
        GameDriver.challenge = challenge;
    }

    public static boolean isQuit() {
        return quit;
    }

    public static void setQuit(boolean quit) {
        GameDriver.quit = quit;
    }

}
