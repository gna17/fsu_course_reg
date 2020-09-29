import java.util.Scanner;

public class Fsu_course_reg_sys {
    public static void main(String[] args) {
        String studentName[]=new String[4];
        String courseInfo[]=new String[4];
//        String location[]=new String[4];
//        String courseSession[]=new String[4];
//        String profName[]=new String[4];

        int states[]=new int[4];
        int waitListNum[]=new int[10];
        String courseNames[]= {"Data Structure","Operating System","AI","Networking"};//define a pre-existing lists of course name
        int sessionNum[]= {100,200,300,400,500,600};

        Scanner input=new Scanner(System.in);
        int num=-1;
        boolean isExit=false;
        System.out.println("Choose what to do");
        do {

            System.out.println("--------------------");
            System.out.println("1, see course offerings");
            System.out.println("2, course in pocket");
            System.out.println("3, confirm enrollment");
            System.out.println("4, drop a course");
            System.out.println("5, meh");
            System.out.println("6, quit");
            System.out.println("--------------------");

            System.out.println("type in the number to see what next");
            int choose=input.nextInt();

            switch(choose) {
                case 1:
                    System.out.println("see course offerings");
                    boolean isAdd=false;//see if the course is added already
                    for(int j=0;j<studentName.length;j++) {
                        if(studentName[j]==null) {//see if space is available
                            isAdd=true;//yes, there is a space
                            System.out.print("Enter your name here, please");
                            String yourName=input.next();
                            System.out.println("Course #"+"\t"+"Course Name"+"\t"+"Session Number"+"\t"+"WaitListed");
                            for(int i=0;i<courseInfo.length;i++) {
                                String sesNum="D"+sessionNum[i];
                                String waitNum=(waitListNum[i])>0 ? waitListNum[i] + "wait list":"0";
                                System.out.println((i+1)+"\t"+courseNames[i]+"\t"+sesNum+"\t"+waitNum);
                            }

                            System.out.print("Type which course to choose what course to enroll");
                            int chooseCourse=input.nextInt();

                            System.out.println("Course Added Successfully");
                            System.out.println("Info:"+courseInfo);

                            studentName[j]=yourName;//user enter name into array
                            break;

                        }
                    }
                    if(!isAdd) {
                        System.out.println("sorry, the enrollment is full!");
                    }
                    break;

                case 2:
                    System.out.println("check enrollment");
                    System.out.println("Course Number\tStudents Enrolled\tCourse Info\tEnrollment Status");
                    for(int i=0;i<studentName.length;i++) {
                        if(studentName[i]!=null) {
                            String state= (states[i]==0)?"added":"enrolled";
                            System.out.println((i+1)+"\t"+studentName[i]+"\t"+courseInfo[i]+"\t"+state);

                        }

                    }
                    break;
                case 3:
                    System.out.println("Confirm Enrollment");
                    boolean isEnrolled=false;//Enrollment status
                    System.out.print("enter which course you want to confirm enrollment");
                    int numChose=input.nextInt();
                    for(int i=0;i<studentName.length;i++) {
                        if(studentName[i]!=null && states[i]==0 && numChose==i+1) {
                            states[i]=1;
                            System.out.println("Enrollment confirmed.");
                            isEnrolled=true;
                        }else if(studentName[i]!=null && states[i]==1 && numChose==i+1){
                            System.out.println("you already enrolled.");
                            isEnrolled=true;//enrollment is already confirmed
                        }
                    }
                    if(!isEnrolled) {
                        System.out.println("The course you chose does not exist!");
                    }
                    break;
                case 4:
                    System.out.println("drop a course");
                    boolean isDropped=false;
                    System.out.print("Enter which course you wish to delete");
                    int numCourseToDelete=input.nextInt();
                    for(int i=0;i<studentName.length;i++) {
                        if(studentName[i]!=null && states[i]==1 && numCourseToDelete==i+1) {
                            isDropped=true;//confirm is dropped

                            for(int j=0;j<studentName.length-1;j++) {
                                studentName[j]=studentName[j+1];
                                courseInfo[j]=courseInfo[j+1];
                                states[j]=states[j+1];
                            }

                            int lastOfUs=studentName.length-1;
                            studentName[lastOfUs]=null;
                            courseInfo[lastOfUs]=null;
                            states[lastOfUs]=0;
                            System.out.println("The course has been dropped");
                            break;
                        }else if(studentName[i]!=null && states[i]==0 && numCourseToDelete==i+1) {
                            System.out.println("You cannot drop a course you are not enrolled in.");
                            isDropped=true;
                            break;
                        }
                    }
                    if(!isDropped){
                        System.out.println("the course you wish to drop does not exist!");
                    }
                    break;
                case 5:
                    System.out.println("Wait List a Course");
                    System.out.println("Course Number"+"\t"+"Course Name");
                    for(int i=0;i<courseNames.length;i++) {
                        String sesNum="D"+sessionNum[i];
                        String waitNum=(waitListNum[i])>0 ? waitListNum[i] + "wait list":"0";
                        System.out.println((i+1)+"\t"+courseNames[i]+"\t"+sesNum+"\t"+waitNum);
                    }
                    System.out.print("choose what course to enter the wait list");
                    int wtNum=input.nextInt();
                    waitListNum[wtNum-1]++;
                    System.out.println("Course wait-listed.");
                    break;
                case 6:
                    System.out.println("exit the system");
                    isExit=true;
                    break;
                default:
                    isExit=true;
                    break;
            }
        if(!isExit) {
            System.out.println("enter 0 to exit the system");
            num=input.nextInt();
        }else {
            break;
        }
    }while(num==0);
        System.out.println("Thank you for using the course reg system!");
    }

}
