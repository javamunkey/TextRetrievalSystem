package test;

import org.junit.Test;
import process.stemmer.PorterStemmer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class PorterStemmerTest {
    
    @Test
    public void testPorter2Algorithm() {
        int count = 0;
        
        try(Scanner porter2Input = new Scanner(new File("porter2Input.txt"))) {
            PorterStemmer.createMap();
            
            while(porter2Input.hasNext()) {
                String input = porter2Input.next();
                String output = porter2Input.next();
                
                String stemmed = PorterStemmer.stem(input);
                if(!stemmed.equals(output)) {
                    count++;
                    System.out.println(input + "=>" + stemmed + " but should be " + output);
                }
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        assertEquals(count, 0);
    }
    
}
