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
 * @author Wesley Creates private fields, intiializes the furniture and rotations and arrays, as
 *         well as x and y values of beds
 */
public class Furniture {
    // initialize private fields
    private PApplet processing;
    private PImage image;
    private float[] position;
    private boolean isDragging;
    private int rotations;
    private String type;

    // initializes the fields of a new bed object positioned in the center of the display
    public Furniture(String name, PApplet processing) {
        type = name;
        this.processing = processing;
        // Initialize which furniture type to display
        image = processing.loadImage("images/" + type + ".png");
        // Initialize the boolean that checks if the mouse is dragging the furniture
        isDragging = false;
        // Initialize rotations
        rotations = 0;
        // initialize a float array that will store the x and y value
        position = new float[2];
        // store x value of bed
        position[0] = processing.width / 2;
        // store y value of bed
        position[1] = processing.height / 2;
    }

    // draws this bed at its current position
    /**
     * checks if the dragging method is true, and sets the position accordingly
     */
    public void update() {
        if (isDragging == true) {
            position[0] = processing.mouseX;
            position[1] = processing.mouseY;
        }
        // draw the image at the x and y position form the position array and with the number of
        // rotations
        processing.image(image, position[0], position[1], rotations * PApplet.PI / 2);


    }


    /**
     * used to start dragging the bed, when the mouse is over this bed when it is pressed
     */
    public void mouseDown() {
        if (isMouseOver()) {
            isDragging = true;

        }

    }

    // used to indicate that the bed is no longer being dragged
    /**
     * creates a helper method, and performs the mouse up functions
     */
    public void mouseUp() {
        isDragging = false;
    }

    // helper method to determine whether the mouse is currently over this bed
    public boolean isMouseOver() {
        // if the rotations is odd check if the mouseX is within the image height and mouseY is
        // within the image width
        if ((rotations % 2) == 1) {
            if (processing.mouseX >= position[0] - image.height / 2
                            && processing.mouseX <= position[0] + image.height / 2
                            && processing.mouseY >= position[1] - image.width / 2
                            && processing.mouseY <= position[1] + image.width / 2) {
                return true;
            } else {
                return false;
            }
        } else {
            // if the rotations is even check if the mouseX is within the image width and mouseY is
            // within the image height
            if (processing.mouseX >= position[0] - image.width / 2
                            && processing.mouseX <= position[0] + image.width / 2
                            && processing.mouseY >= position[1] - image.height / 2
                            && processing.mouseY <= position[1] + image.height / 2) {
                return true;
            } else {
                return false;
            }
        }

    }

    // add 1 to rotation when rotate method is called
    /**
     * creates accessors and getters to be used in another class
     */
    public void rotate() {
        rotations++;
    }

    // accessor for the furniture type
    public String getType() {
        return type;
    }

    // accessor for the furniture x position
    public float getXPosition() {
        return position[0];
    }

    // accessor for the furniture y position
    public float getYPosition() {
        return position[1];
    }

    // accessor for the furniture rotations
    public int getRotations() {
        return rotations;
    }

    // setter method for the furniture x position
    public void setXPosition(float x) {
        this.position[0] = x;
    }

    // setter method for the furniture y position
    public void setYPosition(float y) {
        this.position[1] = y;
    }

    // setter method for the furniture rotations
    public void setRotations(int rotations) {
        this.rotations = rotations;
    }

}
