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
 * @author Wesley intiailzies the float position array to store the position of the load button, and
 *         sets the two positons for the button
 */
/**
 * @author Wesley
 *
 */
/**
 * @author Wesley
 *
 */
/**
 * @author Wesley
 *
 */
/**
 * @author Wesley
 *
 */
/**
 * @author Wesley
 *
 */
/**
 * @author Wesley
 *
 */
public class CreateSofaButton {
    // creating private fields
    private static final int WIDTH = 96;
    private static final int HEIGHT = 32;

    private PApplet processing;
    private float[] position;
    private String label;

    public CreateSofaButton(float x, float y, PApplet processing) {
        this.processing = processing;
        // initialize position array to store the position of a sofa
        position = new float[2];
        // sets the position of the sofa button
        position[0] = x;
        position[1] = y;
        // initialize the label on the sofa button
        label = "Create Sofa";

    }

    /**
     * Updates the Button and sets the colors to light or dark grey, and the position & text & fill
     * of the button on the screen
     */
    public void update() {
        // if mouse is over the button than change to dark grey color
        if (isMouseOver()) {

            processing.fill(100);
        } else {
            // set the button color to light grey
            processing.fill(200);
        }
        // set the position of the sofa button
        processing.rect(position[0] - WIDTH / 2, position[1] - HEIGHT / 2, position[0] + WIDTH / 2,
                        position[1] + HEIGHT / 2);
        // set the text color
        processing.fill(0);
        // set the text position
        processing.text(label, position[0], position[1]);
    }

    /**
     * checks if the user is over the mouse, and creates new furniture otherwise returns null.
     * 
     */
    public Furniture mouseDown() {
        // if the user clicks and the mouse is over the button, creates a new furniture object of
        // type sofa, otherwise returns null
        if (isMouseOver()) {
            return new Furniture("sofa", processing);
        } else {
            return null;
        }
    }

    /**
     * looks at if the mouse is over the button and returns accordingly
     * 
     */
    public boolean isMouseOver() {
        // checks if the mouse is over the button, returning either true or false
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
