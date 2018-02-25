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

/*
 * Executes all operations to create the bed button, including position, label, and storage.
 */
public class CreateBedButton {
    // intializing private fields
    private static final int WIDTH = 96;
    private static final int HEIGHT = 32;

    private PApplet processing;
    private float[] position;
    private String label;

    public CreateBedButton(float x, float y, PApplet processing) {
        this.processing = processing;
        // storing position of bed
        position = new float[2];
        // sets position of the create bed button
        position[0] = x;
        position[1] = y;

        label = "Create Bed";

    }

    /*
     * Updates the button for "Create Bed," setting color and position of the text.
     */
    public void update() {
        // setting button color to dark grey if mouse is over the button
        if (isMouseOver()) {
            processing.fill(100);
        } else {
            // set button to light grey otherwise
            processing.fill(200);
        }
        // sets the position of the button
        processing.rect(position[0] - WIDTH / 2, position[1] - HEIGHT / 2, position[0] + WIDTH / 2,
                        position[1] + HEIGHT / 2);
        // sets the color of the text
        processing.fill(0);
        // sets position of the text
        processing.text(label, position[0], position[1]);
    }

    /**
     * Checks if the user clicks the mouse and allocates a new bed object
     */
    public Furniture mouseDown() {
        // creates and returns the reference to a new bed when the mouse is clicked over the button
        if (isMouseOver()) {
            return new Furniture("bed", processing);
        } else {
            return null;
        }
    } // After step 10, this method will instead return Furniture

    /**
     * Checks if the user's mouse is over the
     */
    public boolean isMouseOver() {
        // checks if the mouse is inside (and over) the button, returning true or false depending on
        // the user.
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
