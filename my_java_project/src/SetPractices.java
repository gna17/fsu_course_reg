import java.util.*;

public class SetPractices {
    //this is a series of practices on Map, List, Set, Stack ADTs.
    // String op. functions
    //Possibly to add lambda Expressions later on

    public static void main(String[] args) {
        // Map like dict in python, stores Key Value Pair. Key is unique.
        Student newStd1 = new Student("Tom", 80);
        Map<String, Student> newMap1 = new HashMap<>();
        newMap1.put("Tom", newStd1);
        Student findMe = newMap1.get("Tom");
        System.out.println(findMe == newStd1);
        System.out.println(findMe.score);
        Student another = newMap1.get("Bob");
        System.out.println(another);
        System.out.println("_________");
        Student newStd2 = new Student("Mike", 70);
        newMap1.put("Tom", newStd2);
        Student findMe2 = newMap1.get("Tom");

        System.out.println(findMe2 == newStd1);
        System.out.println(findMe2 == newStd2);
        System.out.println(findMe2.score);
        System.out.println("_____");
        Map<String, Integer> nm2 = new HashMap<String, Integer>();
        nm2.put("Tom", 45);
        nm2.put("Jack", 50);
        nm2.put("Sam", 55);
        for(String key:nm2.keySet()){
            int val = nm2.get(key);
            System.out.println(key + " = " + val);
        }
        System.out.println("------");

        List<Student> studentList = List.of(
                new Student("Bob", 78),
                new Student("Alice", 85),
                new Student("Brush", 66),
                new Student("Newton", 99));
        AllStudents holder = new AllStudents(studentList);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");


        Map<String, Integer> wlMap = new HashMap<String, Integer>();
        wlMap.put("student1", wlMap.size());
        wlMap.put("student2", wlMap.size());
        wlMap.put("student3", wlMap.size());
        for (String k : wlMap.keySet()){
            System.out.println(wlMap.get(k));
        }















    }
}

//To be used for later demos
class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class AllStudents {
    List<Student> list;
    Map<String, Integer> cache;

    AllStudents(List<Student> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    /**
     * 根据name查找score，找到返回score，未找到返回-1
     */
    int getScore(String name) {
        // 先在Map中查找:
        Integer score = this.cache.get(name);
        if (score == null) {
            // TODO:
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for (var ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}


