package util;

import java.util.Scanner;
import java.util.UUID;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    public static int intInput(){
        while(true){
            try {
                return Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Lỗi: Vui lòng chỉ nhập số nguyên! Hãy thử lại.");
            }
        }
    } 
    public static String stringInput() {
        while (true) {
            try {
                String input = sc.nextLine().trim();  
                if (input.isEmpty())
                    throw new IllegalArgumentException("Chuỗi không được để trống! Hãy thử lại.");
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }

    public static UUID createUUID(){ return UUID.randomUUID(); }
}