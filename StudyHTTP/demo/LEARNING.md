# Học Spring Boot từ project này

Project hiện tại là một ứng dụng web Spring Boot tối giản. Mục tiêu của phần đầu tiên là hiểu được một HTTP request đi qua ứng dụng như thế nào.

## 1. Chạy ứng dụng

Mở terminal tại thư mục `demo/`:

```bash
./mvnw spring-boot:run
```

Sau đó mở:

```text
http://localhost:8080/hello
http://localhost:8080/hello?name=Lan
```

Kết quả lần lượt là `Xin chào, bạn!` và `Xin chào, Lan!`.

Build và chạy test:

```bash
./mvnw clean test
./mvnw package
```

## 2. Spring Boot đang làm gì?

`DemoApplication` là điểm bắt đầu của chương trình. `SpringApplication.run(...)` khởi động Spring và web server nhúng.

`@SpringBootApplication` gộp ba khả năng quan trọng:

- `@Configuration`: class này có thể chứa cấu hình.
- `@EnableAutoConfiguration`: Spring Boot tự cấu hình dựa trên dependency trong `pom.xml`.
- `@ComponentScan`: tìm các class Spring trong package hiện tại và package con.

Vì `HelloController` nằm cùng package với `DemoApplication`, Spring tự tìm thấy và đăng ký nó.

## 3. Đọc `HelloController`

- `@RestController`: class xử lý HTTP và trả dữ liệu trực tiếp trong response body.
- `@GetMapping("/hello")`: ánh xạ HTTP GET `/hello` vào method `hello`.
- `@RequestParam`: lấy giá trị `name` từ query string.
- `defaultValue`: dùng `bạn` khi URL không truyền `name`.
- Giá trị `String` được trả về chính là nội dung response.

Luồng xử lý:

```text
Client -> GET /hello?name=Lan -> HelloController.hello -> HTTP 200 + text
```

## 4. Những thứ cần học theo thứ tự

1. Java nền tảng: class, interface, exception, collection, generic và lambda.
2. HTTP: method GET/POST/PUT/DELETE, URL, query parameter, header, body và status code.
3. Spring Core: IoC, Dependency Injection, bean, `@Component`, `@Service`, `@Repository`.
4. Spring Web: controller, routing, request/response, DTO và xử lý lỗi.
5. Validation: kiểm tra dữ liệu với `@Valid` và Bean Validation.
6. Database: SQL, JPA/Hibernate, entity, repository, transaction và migration.
7. Testing: unit test, integration test, `MockMvc` và test database.
8. Bảo mật và vận hành: Spring Security, logging, profile, Actuator và Docker.

## 5. Bài tập tiếp theo

1. Đổi response thành JSON bằng cách tạo class `Greeting` có field `message`.
2. Tạo endpoint `GET /greet/{name}` và lấy `name` bằng `@PathVariable`.
3. Tạo endpoint `POST /greet` nhận JSON bằng `@RequestBody`.
4. Viết test cho cả trường hợp có và không có `name`.

## 6. Cách tự học mỗi annotation

Khi gặp annotation mới, hãy trả lời bốn câu hỏi: nó tác động lên class hay method, Spring đọc nó lúc nào, dữ liệu đi vào bằng cách nào, và test hành vi đó ra sao. Đừng học thuộc annotation tách rời khỏi request thực tế.