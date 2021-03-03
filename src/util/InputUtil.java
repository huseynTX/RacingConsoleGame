package util;

import main.Config;
import main.Players;

import java.util.Random;
import java.util.Scanner;

public class InputUtil {
    public static void systemLogin(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter username:");
        String userName = sc.nextLine();

        System.out.println("Enter password:");
        String password = sc.nextLine();
    }

    public static int requireNumber(String title){
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        int answer = sc.nextInt();
        return answer;
    }

    public static String requireText(String title){
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        String answer = sc.nextLine();
        return answer;
    }

    public static void showMenu(){
        System.out.println("1.Register players" +
                "\n2.Start the game" +
                "\n3.Log out" +
                "\n4.Exit");
    }

    public static void registerPlayers(){
        int numberOfPlayer = InputUtil.requireNumber("How many player will take part in?");
        Config.players = new Players[numberOfPlayer];
        for (int i = 0; i < numberOfPlayer; i++) {
            String name = InputUtil.requireText("Enter name:");

            String surname = InputUtil.requireText("Enter surname:");

            int age = InputUtil.requireNumber("Enter age:");

            Players pl = new Players(name, surname, age);
            Config.players[i] = pl;
        }
        for (int i = 0; i < Config.players.length; i++) {
            Players pl = Config.players[i];
            System.out.println(pl.getName() + " " + pl.getSurname() + " " + pl.getAge());
        }
    }

    public static void playGame(){
        Random random = new Random();
        int randomNumber = random.nextInt(5);

        int choicedPlayer = InputUtil.requireNumber("Who did choose?");

        if (randomNumber == choicedPlayer) {
            System.out.println("Congratulations You Won!");
        } else {
            System.out.println("You Failed");
        }
    }

    public static void processMenu(){
        int count = 0;
        String userName = InputUtil.requireText("Enter username:");

        String password = InputUtil.requireText("Enter password:");
        while (true) {
            if (userName.equals("Huseyn") && password.equals("12345")) {
                System.out.println("Successfully logged in!");
                InputUtil.showMenu();
                int menu = InputUtil.requireNumber("Select Menu");

                if (menu == 1) {
                    InputUtil.registerPlayers();
                    System.out.println("Players registered successfully!");
                } else if (menu == 2) {
                    InputUtil.playGame();
                }
                if (menu == 3) {
                    InputUtil.systemLogin();
                } else if (menu == 4) {
                    System.exit(0);
                }
            }
            else {
                System.out.println("Try again-!");
                count++;
                InputUtil.systemLogin();
                if (count==3){
                    System.out.println("You are Banned!");
                    System.exit(0);
                }
            }
        }
    }
}
