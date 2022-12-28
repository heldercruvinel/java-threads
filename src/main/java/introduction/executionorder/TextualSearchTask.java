package introduction.executionorder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextualSearchTask implements Runnable{

  private String file;
  private String name;
  public TextualSearchTask(String file, String name) {
    this.file = file;
    this.name = name;
  }

  @Override
  public void run() {

    try {
      Scanner scanner = new Scanner(new File(file));

      Integer lineNumber = 1;

      while (scanner.hasNextLine()) {
          String line = scanner.nextLine();

          if(line.toLowerCase().contains(name.toLowerCase())) {
            System.out.println(
                file
                    .concat(" - ")
                    .concat(lineNumber.toString())
                    .concat(" - ")
                    .concat(line)
            );
          }

        lineNumber++;
      }

      scanner.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}
