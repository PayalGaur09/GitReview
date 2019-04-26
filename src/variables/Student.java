package variables;

public class Student {
   String name;
   int age;
   char gender;
   String branch;
   static String collegeName="F.R.I.E.N.D.S";
   static double totalAge;
   static int numberOfObjects;

    public Student(String name, int age, char gender, String branch){
      this.name=name;
      this.age=age;
      this.gender=gender;
      this.branch=branch;
      numberOfObjects++;
      totalAge= totalAge + age;
    }

    public static double averageAge() {
        return totalAge / numberOfObjects;

    }

    public static double squareOfAvg(double avg){
        return avg*avg;
    }


    }


