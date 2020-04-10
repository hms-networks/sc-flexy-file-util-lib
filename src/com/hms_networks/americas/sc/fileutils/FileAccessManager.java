package com.hms_networks.americas.sc.fileutils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Class for reading and writing files using Java strings on the Ewon Flexy filesystem.
 *
 * @author HMS Networks, MU Americas Solution Center
 * @since 1.0
 */
public class FileAccessManager {
  /**
   * Reads the specified file into a string.
   *
   * @param filename file to read
   * @return file contents
   * @throws IOException if unable to access or read file
   */
  private static String readFileToString(String filename) throws IOException {
    // Create input stream and buffered reader
    InputStream inputStream = new FileInputStream(filename);
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    // Create string for file contents
    StringBuffer fileContents = new StringBuffer();

    // Loop through file and add to string
    String currentLine = bufferedReader.readLine();
    while (currentLine != null) {
      // Append current line
      fileContents.append(currentLine);

      // Read next line
      currentLine = bufferedReader.readLine();

      // If next line exists, add new line to string
      fileContents.append("\n");
    }

    // Close reader and stream
    bufferedReader.close();
    inputStream.close();

    return fileContents.toString();
  }

  /**
   * Writes the specified string to the specified file
   *
   * @param filename file to write to
   * @param contents file contents
   * @throws IOException if unable to access or write file
   */
  private static void writeStringToFile(String filename, String contents) throws IOException {
    // Create output stream and buffered writer
    OutputStream outputStream = new FileOutputStream(filename);
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

    // Write contents to file
    bufferedWriter.write(contents);

    // Close writer and stream
    bufferedWriter.close();
    outputStream.close();
  }
}
