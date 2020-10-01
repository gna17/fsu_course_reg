import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WaitList {
    public static void main(String[] args) {
        TreeMap<FsuStudent, Integer> fs1 = new TreeMap<>(new Comparator <FsuStudent>() {
            public int compare(FsuStudent p1, FsuStudent p2) {
                System.out.println("i am called!");
                return 0;
            }
        });
        var s1 = new FsuStudent();
        var s2 = new FsuStudent();
        s1.setName("Tom");s1.setStudentNum(45);
        s2.setName("Mike");s2.setStudentNum(46);
        fs1.put(s1,1);
        fs1.put(s2,2);
        System.out.println(s1.getName());
        System.out.println(s2.getName());
        System.out.println("------");
        for (FsuStudent sd: fs1.keySet()
             ) {
            System.out.println(sd.getName()+"\t"+sd.getStudentNum());

        }
        System.out.println("------");
        fs1.forEach((i,j)->{
            System.out.println(i.getName()+"\t"+i.getStudentNum()+"rank is\t"+j);
        });
}
}
class FsuStudent {

    public FsuStudent(String name, int studentNum){
        this.setName(name);
        this.setStudentNum(studentNum);
    };
    public FsuStudent(){};

    private String name;
    private int studentNum;

    public int getStudentNum() {
        return this.studentNum;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }
}