import java.util.Scanner;
//STUDENT GRADE CALCULTOR :)
public class task2 {
    Scanner sc = new Scanner(System.in);
    int subNo;
    int i;
    int marks;
    static double percentage;
    static int totalmarks = 0;
    char grade;
    void userInput(){
        System.out.println("Enter the total number of subjects");
        subNo = sc.nextInt();
        for(i=1;i<=subNo;i++){
        System.out.println("Enter marks for Subject "+i);
            marks = sc.nextInt();
            totalmarks = totalmarks+marks; 
        }
        percentage = totalmarks/subNo;
    }

    char gradesys()
    {
        if(percentage>=90){
            grade = 'A';
        }
       else if(percentage>=80){
            grade = 'B';
        }
       else if(percentage>=70){
            grade = 'C';
        }
       else if(percentage>=60){
            grade = 'D';
        }
       else if(percentage>=50){
            grade = 'E';
        }
       else{
            grade = 'F';
       }
        return grade;
    }
    public static void main(String[] args) {
        task2 obj = new task2();
        obj.userInput();
        System.out.println("STUDENTS MARKS");
        System.out.println("TOTAL MARKS OBTAINED: " + totalmarks);
        System.out.println("AVERAGE PERCENTAGE: "+percentage);
        System.out.println("GRADE: "+obj.gradesys());

    }
}

