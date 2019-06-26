package variables;

import static variables.Student.averageAge;
import static variables.Student.squareOfAvg;

public class TestStudent {
    public static void main(String[] args){
        Student a=new Student("Joey", 22, 'M', "CSE");
        Student b=new Student("Rachel", 20, 'F', "ChE");
        Student c=new Student("Monica", 22, 'F', "BT");
        Student d=new Student("Chandler", 23, 'M', "CSE");
        Student e=new Student("Phoebe", 20, 'F', "EE");
        double avgAge=averageAge();
       double sqrOfAvg= squareOfAvg(avgAge);

        System.out.println(" Name: "+a.name+" Age: "+a.age+" Gender: "+a.gender+" Branch: "+a.branch);
        System.out.println(" Name: "+b.name+" Age: "+b.age+" Gender: "+b.gender+" Branch: "+b.branch);
        System.out.println(" Name: "+c.name+" Age: "+c.age+" Gender: "+c.gender+" Branch: "+c.branch);
        System.out.println(" Name: "+d.name+" Age: "+d.age+" Gender: "+d.gender+" Branch: "+d.branch);
        System.out.println(" Name: "+e.name+" Age: "+e.age+" Gender: "+e.gender+" Branch: "+e.branch);
        System.out.println(" Average age: "+avgAge);
        System.out.print("Square of average: "+ sqrOfAvg);




    }

    }



