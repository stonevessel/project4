import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
        ArrayList<String> myTasks = new ArrayList<>();
        int choose = 7;
        int user = 0;

        while (choose != 0) {
            choose = intInput();

            if (choose == 1) {
                System.out.println("What task would you like to add? ");
                String taskToAddToList = input();
                myTasks.add(taskToAddToList);
                menu();
            }
            if (choose == 2){
                System.out.println(myTasks);
                System.out.println("which task would you like to remove?");
                user=intInput();
                myTasks.remove(user);
                menu();
            }
            if (choose == 3){
                System.out.println(myTasks);
                System.out.println("which task would you like to update?");
                user=intInput();
                myTasks.remove(user);
                System.out.println("Update your task.");
                String taskToAddToList = input();
                myTasks.add(taskToAddToList);
                menu();

            }
            if (choose == 4){
                System.out.println(myTasks);
            }
        }
        System.out.println("System shutting down......");
    }


    static void menu() {
        System.out.println("Please choose a option");
        System.out.println("(1) add a task");
        System.out.println("(2) remove a task");
        System.out.println("(3) update a task");
        System.out.println("(4) list all tasks");
        System.out.println("(0) quit");
    }

    static String input() {


        String choose = input.nextLine();
        return choose;
    }

    static int intInput() {
        int choose = input.nextInt();
        input.nextLine();
        return choose;
    }


}