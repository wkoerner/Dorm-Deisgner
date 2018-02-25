import java.io.IOException;

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
 * Executes the functions of the program, calling on various methods to perform actions such as Load
 * Button, Save Button, Create Bed, and Create Sofa.
 * 
 */

public class Main {
    // declaring private fields
    private PApplet processing;
    private PImage backgroundImage;
    private CreateBedButton createBedButton;
    private CreateSofaButton createSofaButton;
    private SaveButton saveButton;
    private LoadButton loadButton;
    private Furniture[] furniture;



    // creating public constructor for processing
    public Main(PApplet processing) {
        // allocating room for 6 furniture objects
        furniture = new Furniture[6];
        // setting the location of the "saveButton"
        saveButton = new SaveButton(650, 24, processing);
        // setting the location of the "LoadButton"
        loadButton = new LoadButton(750, 24, processing);

        // setting the location of the "LoadButton"
        createBedButton = new CreateBedButton(50, 24, processing);
        // setting the location of the "SofaButton"
        createSofaButton = new CreateSofaButton(150, 24, processing);
        this.processing = processing;
        // setting the background to the png image file
        backgroundImage = processing.loadImage("images/background.png");

    }

    /**
     * Executes the application and all its functions
     */
    public static void main(String[] args) {
        // creates the window, and then repeatedly updates its
        // appearance and checks for user input
        // It is also checking to see whether we have defined specific methods in our Main class to
        // specify additional computation that should happen when the program begins, when the user
        // pressed a key or mouse button, and every time the window is repeatedly redrawn to the
        // screen.
        Utility.startApplication();


    }



    /**
     * Updates the colors, images, and buttons of the application
     */
    public void update() {

        // sets the background color using rgb values
        processing.background(100, 150, 250);
        // sets the background image
        processing.image(backgroundImage, processing.width / 2, processing.height / 2);
        // calls the update methods in each of the four update classes
        createBedButton.update();
        createSofaButton.update();
        saveButton.update();
        loadButton.update();

        // iterate through the furniture positions and adds furniture if there is no furniture at
        // that index
        for (int i = 0; i < furniture.length; i++) {
            if (furniture[i] != null) {
                furniture[i].update();

            }
        }



    }

    /**
     * Checks if the mouse is in the bed and the user has clicked, executes the operations the user
     * performs
     */
    public void mouseDown() {
        // iterates through the bed and checks if the mouse is within the bed button
        if (createBedButton.isMouseOver()) {

            for (int i = 0; i < furniture.length; i++) {

                if (furniture[i] == null) {
                    furniture[i] = createBedButton.mouseDown();
                    break;
                }

            }
        }
        // checks if the mouse is over the "save button" and calls the save button mouse down method
        if (saveButton.isMouseOver()) {
            saveButton.mouseDown(furniture);

        }
        // checks if the mouse is over the "load button" and calls the load button mouse down method
        if (loadButton.isMouseOver()) {
            loadButton.mouseDown(furniture);
        }
        // checks if the mouse is over the "sofa button" iterates through the furniture and places a
        // sofa where there is no furniture
        if (createSofaButton.isMouseOver()) {

            for (int i = 0; i < furniture.length; i++) {

                if (furniture[i] == null) {
                    furniture[i] = createSofaButton.mouseDown();
                    break;
                }

            }
        }
        // iterates through the furniture, checks if the furniture is not equal to null, calls the
        // method of mouseDown, breaks out
        for (int i = 0; i < furniture.length; i++) {

            if (furniture[i] != null) {

                furniture[i].mouseDown();
                if (furniture[i].isMouseOver() == true)
                    break;
            }

        }



    }

    /**
     * Checks the furniture length and calls mouse up depending on the state of the furniture
     */
    public void mouseUp() {
        // iterate through the furniture and call the mouse up method
        for (int i = 0; i < furniture.length; i++) {
            if (furniture[i] != null) {
                furniture[i].mouseUp();

            }
        }


    }

    /**
     * Implements the various key presses for the user, including d and r for delete and rotate.
     * Allows the user to interact to create their specified dorm.
     */
    public void keyPressed() {
        // check is d or D is pressed run through the bed array and check if the mouse is inside of
        // the bed. if it is change the bed's contents to null.
        if (processing.key == 'd' || processing.key == 'D') {

            for (int i = 0; i < furniture.length; i++) {
                if (furniture[i] != null) {
                    if (furniture[i].isMouseOver()) {
                        furniture[i] = null;
                    }
                }
            }
        }
        // checks if r or R is pressed. iterates through furniture array and rotates the furniture
        // if there is furniture and mouse is over that furniture
        if (processing.key == 'r' || processing.key == 'R') {
            for (int i = 0; i < furniture.length; i++) {
                if (furniture[i] != null) {
                    if (furniture[i].isMouseOver()) {
                        furniture[i].rotate();
                    }
                }
            }

        }
    }
}

