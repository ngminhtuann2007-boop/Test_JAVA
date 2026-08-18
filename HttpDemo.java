import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpDemo {
    public static void main(String[] args) {
        try {
            // 1. Khởi tạo HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // 2. Tạo Request trỏ tới một API mẫu
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                    .GET()
                    .build();

            // 3. Gửi Request và nhận Response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. In kết quả nhận được
            System.out.println("Mã trạng thái (Status Code): " + response.statusCode());
            System.out.println("Nội dung dữ liệu (Body):");
            System.out.println(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}