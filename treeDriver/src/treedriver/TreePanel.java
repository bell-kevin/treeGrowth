// this displays growing trees
package treedriver;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class TreePanel extends JPanel {

    private final int HEIGHT; // height of frame
    private final int WIDTH; // width of frame
    private ArrayList<Tree> trees = new ArrayList<>();
    private int time = 0;
    //********************************************************************

    public TreePanel(int frameHeight, int frameWidth) {
        this.HEIGHT = frameHeight;
        this.WIDTH = frameWidth;
    } // end constructor
    //***************************************************************

    public void setTime(int time) {
        this.time = time;
    } //setTime
    //************************************************************

    public void addTree(int location, double trunkLength, int plantTime) {
        trees.add(new Tree(location, plantTime, trunkLength));
    } // end addTree
//************************************************************************

    public ArrayList<Tree> getTrees() {
        return this.trees;
    } // end getTrees
    //*********************************************************************

    public void paintComponent(Graphics g) {
        int location; //horizontal starting position of a tree
        String age; // age of a tree in years

        super.paintComponent(g);
        //draw a horizontal line representing surface of the earth:
        g.drawLine(25, HEIGHT - 75, WIDTH - 45, HEIGHT - 75);
        for (Tree tree : trees) {
            //draw the current tree:
            location = tree.getStartX();
            tree.drawBranches(g, location, HEIGHT - 75, tree.getTrunkLength(), 90);
            //write the age of the current tree:
            age = Integer.toString((time - tree.getStartTime()) / 12);
            g.drawString(age, location - 5, HEIGHT - 50);
        }
    }  //end paintComponent
} // end TreePanel class
