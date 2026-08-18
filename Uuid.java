// import java.util.ArrayList;
// import java.util.List;
// import java.util.UUID;
// import java.math.BigDecimal;

// class Order { 
//     private UUID id; 
//     private String customerName;
//     private BigDecimal totalAmount;

//     public Order(String customerName, BigDecimal totalAmount) {
//         this.id = UUID.randomUUID();
//         this.customerName = customerName;
//         this.totalAmount = totalAmount;
//     }
//     public UUID getId() { return id; }
//     public String getCustomerName() { return customerName; }
//     public BigDecimal getTotalAmount() { return totalAmount; }

//     @Override
//     public String toString() {
//         return "Order { ID: " + id + " | Khách: " + customerName + " | Tổng tiền: $" + totalAmount + " }";
//     }
// }

// public class Uuid {
//     public static void main(String[] args) {
//         List<Order> orders = new ArrayList<>();

//         // THÊM ĐƠN HÀNG (Dùng BigDecimal.valueOf)
//         Order order1 = new Order("Anh Tuấn", BigDecimal.valueOf(199.99));
//         Order order2 = new Order("Minh Tuấn", new BigDecimal("500.50"));
//         orders.add(order1);
//         orders.add(order2);
//         System.out.println(order1.getId().version());

//         System.out.println("=== DANH SÁCH ĐƠN HÀNG ===");
//         orders.forEach(System.out::println);

//         // TÌM ĐƠN HÀNG THEO UUID
//         UUID targetId = order2.getId();
//         System.out.println("\n--> Đang tìm kiếm đơn hàng có mã UUID: " + targetId);

//         Order result = orders.stream()
//                 .filter(s -> s.getId().equals(targetId))
//                 .findFirst()
//                 .orElse(null);
//         if(result != null) System.out.println("tim thay: "+ result);
//         else System.out.println("khong tim thay");
//     }
// }
