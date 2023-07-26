package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BirthdayMatcherTest {

    @Test
    public void testBirthdayMatching() {
        String inputFileName = "testInput.txt";
        String outputFileName = "testOutput.txt";

        // Prepare test data with one matching person in July
        String testData = """
                John, Doe, 1990-07-15
                Jane, Smith, 1985-08-20
                """;
        FileHelper.writeToFile(inputFileName, testData);

        // Run the BirthdayMatcher application
        BirthdayMatcher.main(new String[]{inputFileName, "7", outputFileName});

        // Clean up: delete temporary files
        FileHelper.deleteFile(inputFileName);
        FileHelper.deleteFile(outputFileName);
    }
}