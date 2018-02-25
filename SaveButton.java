
import java.io.File;
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
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * implements all the methods to Save the furniture to the RoomData.ddd file
 */
public class SaveButton {
    // creating private fields
    private static final int WIDTH = 96;
    private static final int HEIGHT = 32;


    private PApplet processing;
    private float[] position;
    private String label;

    // creating new constructor for the save button
    /**
     * sets the position of the button for the "Save Room"
     * 
     * @param x
     * @param y
     * @param processing
     */
    public SaveButton(float x, float y, PApplet processing) {
        this.processing = processing;
        // setting position of the save room button
        position = new float[2];
        position[0] = x;
        position[1] = y;
        label = "Save Room";

    }

    /**
     * Updates "the Save Button" also setting it to various colors depending on the user and their
     * mouse
     */
    public void update() {
        // sets the button to light grey. checks if mouse is over the button and sets the color to
        // dark grey
        if (isMouseOver()) {
            processing.fill(100);
        } else {
            processing.fill(200);
        }
        // sets the position of the button
        processing.rect(position[0] - WIDTH / 2, position[1] - HEIGHT / 2, position[0] + WIDTH / 2,
                        position[1] + HEIGHT / 2);
        // sets color of the text
        processing.fill(0);
        // sets position of the text
        processing.text(label, position[0], position[1]);
    }

    /**
     * Handles the saving to the file, RoomData.ddd, also iterating through furniture and handling
     * FileNotFound Exceptions
     */
    public void mouseDown(Furniture[] furniture) {
        // declares a new printWriter so that the array can be save to the file RoomData.ddd
        PrintWriter printWriter;

        try {

            printWriter = new PrintWriter("RoomData.ddd");

            // iterating through the furniture and accessing the type position and roatations using
            // accessor methods defined in furniture class
            for (int i = 0; i < furniture.length; i++) {
                if (furniture[i] != null) {
                    String line = furniture[i].getType() + ":" + furniture[i].getXPosition() + ","
                                    + furniture[i].getYPosition() + ","
                                    + furniture[i].getRotations();
                    printWriter.println(line);

                }
            }
            // close printwriter so everything saves to the file
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("WARNING: Could not save room contents to file RoomData.ddd.");

        }


    }

    /**
     * Assesses the user's mouse, and checks to see if it hovers over the save button
     */
    // checks if the mouse is over the save button
    public boolean isMouseOver() {
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
