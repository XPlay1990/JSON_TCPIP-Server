/*
 *  Copyright (C) Jan Adamczyk (j_adamczyk@hotmail.com) 2017
 */
package JSON_Generation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author jan.adamczyk
 */
public class File_Reader {
    
    public String read_File(String fileName) throws IOException{
         String content = new String(Files.readAllBytes(Paths.get(fileName)));
         return content;
    }
    
}
