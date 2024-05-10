/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10108881.st10108881_poe2;

import java.util.ArrayList;
import java.util.Scanner;
import static st10108881.st10108881_poe2.Task.checkTaskDescription;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Login login = new Login();
        
        System.out.println("Welcome \nPlease create an account");
        
        
        System.out.println("Enter username: ");
        login.setUsername(scanner.nextLine());
        System.out.println("Enter password: ");
        login.setPassword(scanner.nextLine());
        System.out.println("Enter first name: ");
        login.setFirstName(scanner.nextLine());
        System.out.println("Enter last name: ");
        login.setLastName(scanner.nextLine());

        System.out.println(login.registerUser());

        System.out.println("Welcome to Login \nPlease login to your account");
        
        
        System.out.println("Enter username: ");
        String usr = scanner.nextLine();
        System.out.println("Enter password: ");
        String pw =scanner.nextLine();       
       

        if (Login.login(usr, pw)) {
            
            System.out.println("Login successful.\nWelcome " + login.getFirstName() + " " + login.getLastName());

            System.out.println("Please enter the number of tasks to add:");
            int numTasks = scanner.nextInt();
            scanner.nextLine(); // consume newline not consumed by nextInt()

            ArrayList<Task> tasks = new ArrayList<>();
            for (int i = 0; i < numTasks; i++) {
                tasks.add(createTask(i));
            }

            double totalHours = 0;
            
            for (Task task : tasks) {
                
                totalHours =+ Task.duration;
                System.out.println(task.printTaskDetails());
                
            }

            
            System.out.println("Total Hours: " + totalHours);

        } else {
            System.out.println("Login failed.");
        }

        scanner.close();
    }
    
    public static Task createTask(int taskPos) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the task name:");
        String name = scanner.nextLine();

        System.out.println("Please enter the task description: (less than 50 characters)");
        String description = scanner.nextLine();
        while (!checkTaskDescription(description)) {
            System.out.println("Please enter a shorter task description: (less than 50 characters)");
            description = scanner.nextLine();
        }

        System.out.println("Please enter the developer's name: (first last)");
        String developer = scanner.nextLine();

        System.out.println("Please enter the estimated task duration: (in hours)");
        double duration = scanner.nextDouble();
        
        System.out.println("Please enter the task status: (To Do, Doing, Done)");
        String status = scanner.nextLine();
        
        // Get the first two letters of the name
        String firstTwoLettersOfName = name.substring(0, Math.min(name.length(), 2)).toUpperCase();
        
        // Get the last three letters of the developer
        String lastThreeLettersOfDeveloper = developer.substring(Math.max(0, developer.length() - 3)).toUpperCase();
        
        // Create the task ID
        String taskID = firstTwoLettersOfName + ":" + (taskPos + 1) + ":" + lastThreeLettersOfDeveloper;
                

        Task task = new Task(taskPos,name, description, developer, duration,status,taskID);
        
               
        return task;
        
    }
    
    
    
    
}
