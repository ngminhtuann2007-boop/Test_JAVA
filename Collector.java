// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

// class Student {
//     String name;
//     String major; // Ngành: "IT" hoặc "Biz"
//     double score;

//     public Student(String name, String major, double score) {
//         this.name = name;
//         this.major = major;
//         this.score = score;
//     }

//     @Override
//     public String toString() {
//         return name + " (" + major + " - " + score + "b)";
//     }
// }

// public class Collector {
//     public static void main(String[] args) {
//         // Dữ liệu mẫu đã setup sẵn
//         List<Student> students = List.of(
//             new Student("Anh Tuấn", "IT", 8.5),
//             new Student("Minh Tuấn", "IT", 6.0),
//             new Student("Quốc Tuấn", "Biz", 9.0),
//             new Student("Tuấn Kiệt", "Biz", 7.5),
//             new Student("Hoàng Tuấn", "IT", 9.5)
//         );

//         // VÍ DỤ MẪU: Lấy danh sách sinh viên ngành IT gom vào List
//         List<Student> itList = students.stream()
//                 .filter(s -> s.major.equals("IT"))
//                 .collect(Collectors.toList());
//         System.out.println("1. Sinh viên IT: " + itList);

//         // ========================================================
//         // BÀI TẬP CỦA BẠN (VIẾT DÒNG CHÍNH VÀO CÁC VỊ TRÍ BÊN DƯỚI)
//         // ========================================================

//         // BÀI 1: Nối tất cả TÊN sinh viên thành 1 chuỗi cách nhau bởi dấu ", "
//         String allNames = students.stream()
//                 .map(s-> s.name)
//                 .collect(Collectors.joining(", "));
//         System.out.println("Ten cac sinh vien: " + allNames);
        

//         // BÀI 2: Chuyển danh sách thành Map<String, Double> (Key: Tên, Value: Điểm)
//         Map<String, Double> scoreMap = students.stream()
//                 .collect(Collectors.toMap(s -> s.name, s -> s.score));

//         scoreMap.forEach((name, score) -> System.out.println(name + " : " + score));
//         System.out.println();
        

//         // BÀI 3: Nhóm sinh viên THEO NGÀNH (Trả về Map<String, List<Student>>)
//         Map<String, List<Student>> groupedByMajor = students.stream()
//                 .collect(Collectors.groupingBy(s -> s.major));
        
//         groupedByMajor.forEach((major, list)->{
//             System.out.println("Nganh: " + major + ": " + list);
//         });

//         // BÀI 4: Nhóm sinh viên trên 8 điểm.
//         Map<Boolean, List<Student>> tren_8 = students.stream()
//                 .collect(Collectors.partitioningBy(s -> s.score >= 8));
                
//         tren_8.forEach((bool, list)->{
//             if(bool == true)
//                 System.out.println(list);
//         });
        
//     }
// }