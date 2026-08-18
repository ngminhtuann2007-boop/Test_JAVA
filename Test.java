import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.time.Duration;

public class Test {
    public static void main(String[] args) {
        // String[] date = {"08", "08", "2026"};
        // String[] It = {"Java", "Python", "C++"};

        // StringJoiner sj = new StringJoiner("/");
        // StringJoiner test = new StringJoiner("/");
        // StringJoiner sjit = new StringJoiner(", ", "[", "]");

        // for (String s : date) {
        //     sj.add(s);
        // }
        // for(String s: It) sjit.add(s);
        // System.out.println(sj.toString());
        // System.out.println(sjit.toString());
        // sjit.merge(sj);
        // System.out.println(sjit.toString());

        // test.setEmptyValue("Danh sách còn rỗng");
        // System.out.println("sj2 (khi rỗng): " + test.toString());
        // test.add("con chim");
        // System.out.println("sj2: " + test.toString());

        // List<String> list = List.of("Java", "Kotlin", "Scala");
        // String result = list.stream().collect(Collectors.joining(", ", "<", ">"));
        // System.out.println(result);
        // result = String.join("-", "423", "252");
        // System.out.println(result);

        // // LUYỆN TẬP STREAM
        // List<Integer> numbers = List.of(1, 2, 5, 8, 12, 15, 18, 20);
        // List<String> names = List.of("An", "Bảo", "Chi", "Duy");
        // System.out.println(numbers.stream().filter(n -> n > 10).collect(Collectors.toList()));
        // System.out.println(names.stream().map(name -> name.length()).collect(Collectors.toList()));

        // List<Double> scores = List.of(4.5, 7.0, 8.5, 3.0, 9.0, 5.5);
        // System.out.println(scores.stream()
        //                         .filter(n -> n > 5)
        //                         .map(n -> n + 0.5)
        //                         .map(n -> String.valueOf(n))
        //                         .collect(Collectors.joining("; " , "{", "}")));;
        // // Nên dùng valueOf: Trả về chính xác 0.1
        // BigDecimal d1 = BigDecimal.valueOf(0.1); 
        // System.out.println(d1);
        // // KHÔNG nên dùng new với double: Sẽ bị ra 0.1000000000000000055511151231257827021181583404541015625
        // BigDecimal d2 = new BigDecimal(0.1);
        // System.out.println(d2);
        

        /* DAY TIME*/
        // LocalTime time = LocalTime.now();
        // LocalDate day = LocalDate.now();
        // LocalDate dayTest = LocalDate.of(2007, 04, 30);
        // System.out.println(day);
        // System.out.println(time);
        // System.out.println(dayTest);

        // LocalDateTime now = LocalDateTime.now();

        // // Khai báo định dạng: Ngày/Tháng/Năm Giờ:Phút:Giây
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // String formattedDate = now.format(formatter); 
        // System.out.println(formattedDate); // Ví dụ: 10/08/2026 10:41:36

        // LocalDate startDate = LocalDate.of(2023, 5, 15);
        // LocalDate endDate = LocalDate.of(2026, 8, 10);

        // // Tính khoảng cách giữa 2 ngày
        // Period period = Period.between(startDate, endDate); 

        // System.out.printf("Chênh lệch: %d năm, %d tháng, %d ngày\n", 
        //     period.getYears(), period.getMonths(), period.getDays());

        //     // Tính TỔNG số ngày giữa 2 mốc
        // long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
        // // Tính TỔNG số tháng giữa 2 mốc
        // long totalMonths = ChronoUnit.MONTHS.between(startDate, endDate);

        // System.out.println(totalDays);
        // System.out.println(totalMonths);



        // LocalTime startTime = LocalTime.of(8, 30, 0);
        // LocalTime endTime = LocalTime.of(17, 15, 30);

        // Duration duration = Duration.between(startTime, endTime);

        // System.out.println("Tổng số giờ: " + duration.toHours());       // 8 giờ
        // System.out.println("Tổng số phút: " + duration.toMinutes());   // 525 phút
        // System.out.println("Tổng số giây: " + duration.toSeconds());   // 31530 giây
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        // LocalDate current = LocalDate.now();
        // String date = formatter.format(current);
        // System.out.println("Ngày sinh định dạng: " + date);
        // System.out.println("Thứ trong tuần: " + current.getDayOfWeek());

        // LocalDate birthDate = LocalDate.of(2007, 04, 30);
        // Period period = Period.between(birthDate, current);
        
        // long totalDaysLive = ChronoUnit.DAYS.between(birthDate, current);
        // System.out.printf("Tuoi cua ban than: %d tuoi, %d thang, %d ngay \n", period.getYears(), period.getMonths(), period.getDays());
        // System.out.printf("Tong so ngay song: %d ngay \n", totalDaysLive);

        // LocalDateTime startWork = LocalDateTime.of(current,LocalTime.of(7, 30));
        // LocalDateTime endWork = LocalDateTime.of(current,LocalTime.of(20, 0));
        // Duration duration =  Duration.between(startWork, endWork);

        // long totalMinutesWork = ChronoUnit.MINUTES.between(startWork, endWork);

        // System.out.println("Gio vao ca: " + startWork);
        // System.out.println("Gio ra ca: " + endWork);
        // System.out.printf("tong gio lam viec: %d gio, %d phut \n",duration.toHours(), duration.toMinutes()%60);
        // System.out.println("Tong so phut lam: " + totalMinutesWork + " Phut");


        /* OPTIONAL */
        // String name = null;
        // // An toàn:
        // Optional<String> opt1 = Optional.ofNullable(name); // Hộp rỗng (empty)
        // String result = opt1.orElse("Tên mặc định"); 
        // System.out.println(result); // In ra: Tên mặc định (vì name = null)
        // name = "tao là con người";
        // opt1 = Optional.ofNullable(name); // Hộp rỗng (empty)
        
        // result = opt1.orElse("Tên mặc định"); 
        // System.out.println(result); // In ra: Tên mặc định (vì name = null)
   }  
}