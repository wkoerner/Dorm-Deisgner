import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Dorm Designer
// Files: Dorm Designer
// Course: 300, spring, 2018
//
// Author: Wes Koerner
// Email: wkoerner@wisc.edu
// Lecturer's Name: Alexi Brooks
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Ali Tarawneh
// Partner Email: atarawneh@wisc.edu
// Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates
// strangers, etc do. If you received no outside help from either type of
// source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * Performs all the function for the Load Button shown to the user
 *
 */
public class LoadButton {

    // initialize private variable
    private static final int WIDTH = 96;
    private static final int HEIGHT = 32;

    private PApplet processing;
    private float[] position;
    private String label;

    /**
     * intiailzies the float position array to store the position of the load button, and sets the
     * two positons for the button
     * 
     * @param x
     * @param y
     * @param processing
     */
    public LoadButton(float x, float y, PApplet processing) {
        this.processing = processing;
        // Initialize float position array to store position of the load button
        position = new float[2];
        // set x position
        position[0] = x;
        // set y position
        position[1] = y;
        // Initialize the label shown on the button
        label = "Load Room";

    }



    /**
     * Updates the LoadButton Button and sets the colors to light or dark grey, and the position &
     * text & fill of the button on the screen
     */
    public void update() {
        // if mouse is over the button change to darker grey
        if (isMouseOver()) {

            processing.fill(100);
        } else {
            // button will be a light grey color
            processing.fill(200);
        }
        // sets the position of the button
        processing.rect(position[0] - WIDTH / 2, position[1] - HEIGHT / 2, position[0] + WIDTH / 2,
                        position[1] + HEIGHT / 2);
        // sets the text fill
        processing.fill(0);
        // sets the text position
        processing.text(label, position[0], position[1]);
    }

    /**
     * iterates through furniture and attempts to read from the file. If the file is read
     * unsuccessfully, a warning is printed to the user; depending on the error which is presented.
     * 
     * @param furniture
     */
    public void mouseDown(Furniture[] furniture) {

        float xPosition;
        float yPosition;
        int rotation;
        // Iterates through the furniture array and sets each index to null
        for (int i = 0; i < furniture.length; i++) {
            furniture[i] = null;
        }
        try {
            // creates new scanner to read the RoomData.ddd file
            Scanner fileReader = new Scanner((new FileReader("RoomData.ddd")));

            // Initialize a counter to keep track of the furniture index
            int counter = 0;
            // intilize a string to read the roomData file
            String roomDataRead = "";

            while (fileReader.hasNextLine()) {
                if (counter > furniture.length) {
                    System.out.println("WARNING: Unable to load more furniture.");
                    roomDataRead = fileReader.nextLine();
                } else {
                    // reads the next of text and stores it in a string
                    roomDataRead = fileReader.nextLine();

                    roomDataRead = roomDataRead.trim();


                    // split the line at a colon
                    if (roomDataRead.equals("")) {
                        continue;
                    }

                    String[] roomArray = roomDataRead.split(":");

                    // System.out.print(": split length = " + roomArray.length + " ");
                    if (roomArray.length != 2) {
                        System.out.println("WARNING: Found incorrectly formatted line in file: "
                                        + (counter + 1));
                        break;
                    }

                    // split the line at all the commas
                    String[] coordinates = roomArray[1].split(",");
                    roomArray[0] = roomArray[0].trim();
                    roomArray[1] = roomArray[1].trim();
                    // checks if length of coordinates is not equal to 3, and prints a warning
                    // message
                    if (coordinates.length != 3) {
                        System.out.println("WARNING: Found incorrectly formatted line in file: "
                                        + (counter + 1));
                        break;
                    }


                    // Attempts to parse the float
                    try {

                        xPosition = Float.parseFloat(coordinates[0].trim());
                        // catches a Number Format Exception, prints out the appropriate warning
                    } catch (NumberFormatException e) {
                        System.out.println("WARNING: Found incorrectly formatted line in file: "
                                        + (counter + 1));
                        continue;
                    }
                    try {
                        yPosition = Float.parseFloat(coordinates[1].trim());
                        // catches a Number Format Exception, prints out the appropriate warning
                    } catch (NumberFormatException e) {
                        System.out.println("WARNING: Found incorrectly formatted line in file: "
                                        + (counter + 1));
                        continue;
                    }
                    // change the number of rotations from a string to an int
                    try {

                        rotation = Integer.parseInt(coordinates[2].trim());
                        // catches a Number Format Exception, prints out the appropriate warning
                    } catch (NumberFormatException e) {
                        System.out.println("WARNING: Found incorrectly formatted line in file: "
                                        + (counter + 1));
                        continue;
                    }

                    // if the type is not a bed or sofa print an error

                    if (!roomArray[0].equals("bed") && !roomArray[0].equals("sofa")) {
                        System.out.println(
                                        "WARNING: Could not find an image for a furniture object of type: "
                                                        + roomArray[0]);
                        counter++;
                        continue;
                    }

                    // set the furniture type, x position, y position, and rotation back into the
                    // furniture array
                    furniture[counter] = new Furniture(roomArray[0], processing); //
                    furniture[counter].setXPosition(xPosition);
                    furniture[counter].setYPosition(yPosition);
                    furniture[counter].setRotations(rotation);

                    // add one to the furniture index
                    counter++;


                }


            }
            // close the file reader to ensure all the contents are saved to the file
            fileReader.close();


        }
        // throw a warning when I
        catch (FileNotFoundException e) {
            System.out.println("WARNING: Could not load room contents from file RoomData.ddd.");
            // TODO Auto-generated catch block

        }

    }

    /**
     * checks if the mouse is over the load button and returns either true or false
     * 
     * @return
     */
    public boolean isMouseOver() {
        // check whether the mouse is over the load button
        if (processing.mouseX >= position[0] - WIDTH / 2
                        && processing.mouseX <= position[0] + WIDTH / 2
                        && processing.mouseY >= position[1] - HEIGHT / 2
                        && processing.mouseY <= position[1] + HEIGHT / 2)
            return true;
        else {
            return false;
        }

    }

}
