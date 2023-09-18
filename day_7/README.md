# Assignments 7

## Task
Write a Java program that prompts the user to enter a sentence, and then writes that sentence to a file named "output.txt" in the project directory.

## Approach

1. Create a method inside Main method called `textWriter` which takes two arguments.
  * `text` (Content to be written in the text file).
  * `path` (location with name of the file).
2. Inside this method create`FileWriter` object with a specific filepath.
3. Write the text on the given file using `[FileWriter Object].write(text)`.
4. Use this method inside the main method.

To check the .java file:
* go to day_7/textFileWriter/src.
* click on Main.java file.
