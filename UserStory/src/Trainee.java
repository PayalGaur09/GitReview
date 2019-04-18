package UserStory;

import UserStory.TeamQA;

public class Trainee {
public static void main(String[] args){
    TeamQA a= new TeamQA();
    a.name = "Payal";
    a.age=22;
    a.gender='F';
    a.designation = "QA Trainee";
    a.project_name = "Meeting Hub";

    System.out.println("Name: "+ a.name);
    System.out.println("Age: " + a.age);
    System.out.println("Gender: " + a.gender);
    System.out.println("Designation: " + a.designation);
    System.out.println("Project Name: " + a.project_name);
}
}
