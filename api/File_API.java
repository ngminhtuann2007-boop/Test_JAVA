// package api;

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.StandardCopyOption;
// import java.nio.file.StandardOpenOption;

// public class File_API {
//     public static void main(String[] args) throws IOException{
//         Path filePath = Path.of("./api/tuan_note.txt");
//         if (filePath.getParent() != null) {
//             Files.createDirectories(filePath.getParent());
//         }
//         String content = " Tao la con nguoi dep trai";
//         // Files.writeString(filePath, content, StandardOpenOption.APPEND);
//         System.out.println(Files.readString(filePath));

//         // Files.move(filePath, Path.of("./tuan_note.txt"), StandardCopyOption.REPLACE_EXISTING);
//     }
// }