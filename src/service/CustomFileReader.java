package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CustomFileReader {
    public StringBuilder readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            StringBuilder fileInfo = new StringBuilder();
            int buffer;
            while((buffer = fileReader.read()) != -1) {
                fileInfo.append((char)buffer);
            }
            return fileInfo;
        } catch(FileNotFoundException exception) {
            throw new RuntimeException("File " + "\"" + fileName + "\" not found", exception);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
