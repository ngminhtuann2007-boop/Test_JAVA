package util;

import exception.InvalidTaskException;

public class Validator { 
    public static void validator(int displayIndex , int totalTasks){
        if(displayIndex < 1 || displayIndex > totalTasks) 
            throw new InvalidTaskException("STT không hợp lệ!!!");
    }
}