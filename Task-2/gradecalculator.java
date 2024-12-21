import java.util.*;
class gradecalculator{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("------GRADE CALCULATOR------");
        System.out.println("*****************************");
        System.out.println("Enter no of Subjects :");
        int subjectsno=sc.nextInt();

        String[] subjects=new String[subjectsno];
        int[] marks=new int[subjectsno];
        int totalmarks= subjectsno*100;
        int obtainedmarks = 0;

        System.out.println("Enter the Marks of each Subject");
        for (int i = 0; i < subjectsno; i++) {
            System.out.print("Subject " + (i + 1) + " Name: ");
            subjects[i] = sc.next();
            System.out.print(subjects[i] + " Marks (0-100): ");
            marks[i] = sc.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks for " + subjects[i] + ". Please enter a marks between 0 and 100.");
                return;
            }

            obtainedmarks += marks[i];
        }

        float percentage = (obtainedmarks/(float)totalmarks)*100;
        int avg=obtainedmarks/subjectsno;
        String grade=" ";
        String description=" ";

        if(percentage>=90 && percentage<=100){
            grade = "A+";
            description = "Outstanding";
        }
        else if(percentage>=80 && percentage<=89){
            grade= "A";
            description= "Excellent";
        }
        else if(percentage>=70 && percentage<=79){
            grade= "B+";
            description= "Excellent";
        }
        else if(percentage>=60 && percentage<=69){
            grade= "B";
            description= "Excellent";
        }
        else if(percentage>=50 && percentage<=59){
            grade= "C";
            description= "Excellent";
        }
        else{
            grade= "F";
            description= "Fail";
        }
        System.out.println("---------------------------");
        System.out.println("Total Marks obtained = "+obtainedmarks+"/"+totalmarks);
        System.out.println("Average marks = "+avg);
        System.out.printf("Percentage = %.2f%%\n", percentage);
        System.out.println("Grade = "+grade+" ( "+description+" )");
        System.out.println("---------------------------");
    }
}