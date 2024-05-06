import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Main {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Tasks> myTasks= new ArrayList<>();

    public static void main(String[] args) {
        menu();
        int choose = -7;
        int user = 0;
        serializeSimple();
        deserializeSimple();


        while (choose != 0) {
            choose = intInput();

            if (choose == 1) {
                System.out.println("Whats the priority of your task? from 1 to 5");
                int taskPriority = intInput();
                try{while (taskPriority >5 || taskPriority<0){
                    System.out.println("try that again please enter a number between 1 and 5 for your priority");
                    System.out.println("Whats the priority of your task? from 1 to 5");
                    taskPriority = intInput();
                }
                    System.out.println("Whats the title of your task?");
                    String taskTitle = input();
                    System.out.println("What task would you like to add? ");
                    String taskToAddToList = input();
                    Tasks task1 = new Tasks(taskPriority, taskTitle, taskToAddToList);
                    myTasks.add(task1);
                    serializeSimple();
                    menu();
                }catch (Exception e){
                    System.out.println("try that again please enter a whole number between 1 and 5 for your priority");
                    System.out.println("Whats the priority of your task? from 1 to 5");
                    taskPriority = intInput();
                    System.out.println("Whats the title of your task?");
                    String taskTitle = input();
                    System.out.println("What task would you like to add? ");
                    String taskToAddToList = input();
                    Tasks task1 = new Tasks(taskPriority, taskTitle, taskToAddToList);
                    myTasks.add(task1);
                    serializeSimple();
                    menu();
                }
            }
            if (choose == 2){
                try {
                    System.out.println(myTasks);
                    System.out.println("which task would you like to remove by index?");
                    user = intInput();
                    myTasks.remove(user);
                    serializeSimple();
                    menu();
                }catch (Exception e){
                    System.out.println("Program shutting down");
                }
                //come back to error proof this section olinger
            }
            if (choose == 3){
                System.out.println(myTasks);
                System.out.println("which task would you like to update by index?");
                user=intInput();
                myTasks.remove(user);
                System.out.println("Whats the priority of your task? from 1 to 5");
                int taskPriority = intInput();
                try{
                    if (taskPriority <5 || taskPriority>0){
                        System.out.println("Whats the title of your task?");
                        String taskTitle = input();
                        System.out.println("What task would you like to add? ");
                        String taskToAddToList = input();
                        Tasks task1 = new Tasks(taskPriority, taskTitle, taskToAddToList);
                        myTasks.add(task1);
                        serializeSimple();
                        menu();
                    }else{
                        System.out.println("try that again please enter a number between 1 and 5 for your priority");
                        System.out.println("Whats the priority of your task? from 1 to 5");
                        taskPriority = intInput();
                        System.out.println("Whats the title of your task?");
                        String taskTitle = input();
                        System.out.println("What task would you like to add? ");
                        String taskToAddToList = input();
                        Tasks task1 = new Tasks(taskPriority, taskTitle, taskToAddToList);
                        myTasks.add(task1);
                        serializeSimple();
                        menu();
                    }

                }catch (Exception e){
                    System.out.println("try that again please enter a whole number between 1 and 5 for your priority");
                    System.out.println("Whats the priority of your task? from 1 to 5");
                    taskPriority = intInput();
                    System.out.println("Whats the title of your task?");
                    String taskTitle = input();
                    System.out.println("What task would you like to add? ");
                    String taskToAddToList = input();
                    Tasks task1 = new Tasks(taskPriority, taskTitle, taskToAddToList);
                    myTasks.add(task1);
                    serializeSimple();
                    menu();
                }
            }
            if (choose == 4){
                System.out.println(myTasks);
                menu();
            }
            if (choose == 5){
                System.out.println("what priority of task would you like to see?");
                int finder = intInput();
                String find = input();
                Tasks p1 = new Tasks(finder);
                System.out.println(myTasks);
                menu();



            }
        }
        deserializeSimple();
        System.out.println("System shutting down......");
    }


    static void menu() {
        System.out.println("Please choose a option");
        System.out.println("(1) add a task");
        System.out.println("(2) remove a task");
        System.out.println("(3) update a task");
        System.out.println("(4) list all tasks");
        System.out.println("(5) list all tasks by priority");
        System.out.println("(0) quit");
    }
    static void deserializeSimple(){
        try (FileReader reader = new FileReader("data.json")){
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(reader);
            Gson gson = new Gson();
            ArrayList<Tasks> yeah= gson.fromJson(jsonElement,ArrayList.class);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void serializeSimple(){
        Tasks losdais = new Tasks(3,"dog","walk the dog dude bro");
        Tasks losmanas = new Tasks(2,"cat","eat the cat bruh");
        myTasks.add(losdais);
        myTasks.add(losmanas);


        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("data.json")){
            gson.toJson(myTasks,writer);
        } catch (IOException e) {e.printStackTrace();}


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