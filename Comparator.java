// import java.util.ArrayList;
// import java.util.List;

// class Student {
//     String name;
//     int age;
//     double score;

//     public Student(String name, int age, double score) {
//         this.name = name;
//         this.age = age;
//         this.score = score;
//     }
    
//     public Student(String name) {
//         this.name = name;
//     }


//     @Override
//     public String toString() {
//         return name + " - " + age + " tuổi - " + score + " điểm";
//     }
// }
// public class Comparator {
//     public static void main(String[] args) {
//         List<Student> list = new ArrayList<>();
//         list.add(new Student("Anh Tuấn", 22, 8.5));
//         list.add(new Student("Minh Tuấn", 19, 7.0));
//         list.add(new Student("Tuấn Kiệt", 21, 9.2));
//         list.add(new Student("Quốc Tuấn", 20, 6.8));
//         list.add(new Student("Tuấn Anh", 18, 8.0));
//         list.add(new Student("Null"));

//         System.out.println("===Danh sach ban dau===");
//         list.forEach(System.out::println);
        
//         list.sort((s1, s2)-> s1.age - s2.age);
//         System.out.println("\n===Sap xep tuoi tang dan===");
//         list.forEach(System.out::println);

//         list.sort((s1, s2)-> s1.name.compareTo(s2.name));
//         System.out.println("\n===Sap xep theo ten(A-Z)===");
//         list.forEach(System.out::println);
//     }
// }