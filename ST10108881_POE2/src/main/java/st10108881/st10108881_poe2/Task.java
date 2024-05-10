/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10108881.st10108881_poe2;


import java.util.Scanner;
import java.util.ArrayList;

public class Task {
    private int taskPos;
    private String name;
    private String description;
    private String developer;
    public static double duration;
    private String status;
    private String taskID;

    
    public Task(int taskPos, String name, String description, String developer, double duration, String status, String taskID) {
        this.taskPos = taskPos+1;
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.duration = duration;
        this.status = status;
        this.taskID = taskID;
    }
    
    public static boolean checkTaskDescription(String description) {
        // check if the task description is not more than 50 characters

        return description.length() <= 50;
    }

    public static int returnTotalHours(ArrayList<Task> tasks) {
        // accumulate and return the total number of hours across all tasks

        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getDuration();
        }

        return totalHours;
    }

        
    public double getDuration() {
        return duration;
    }
    
    
    public void setStatus(String status) {
        // set thetask status

        this.status = status;
    }

    public String printTaskDetails() {
        // return a string containing the task details

        String details = "";

        details += String.format("Status: %s%n", status);
        details += String.format("Developer: %s%n", developer);
        details += String.format("Task Number: %d%n", this.hashCode());
        details += String.format("Task Name: %s%n", name);
        details += String.format("Task Description: %s%n", description);
        details += String.format("Task ID: %s%n", taskID);
        return details;
    }

}

