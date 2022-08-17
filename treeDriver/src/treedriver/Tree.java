// This defines a recursion that creates a self-similar tree.
package treedriver;

import java.awt.Graphics;

public class Tree {

    private final int START_X; // where the tree sprouts
    private final int START_TIME; // when the tree sprouts
    private final double MAX_TRUNK_LENGTH = 100;
    private double trunkLength;

    //**************************************************************
    public Tree(int location, int startTime, double trunkLength) {
        this.START_X = location;
        this.START_TIME = startTime;
        this.trunkLength = trunkLength;
    } // end constructor

    //****************************************************************
    int getStartX() {
        return START_X;
    } // end getStartX

    int getStartTime() {
        return START_TIME;
    } // end getStartTime

    double getTrunkLength() {
        return this.trunkLength;
    } // end getTrunkLength

    //*******************************************************************
    public void drawBranches(Graphics g, int x0, int y0, double length, double angle) {
        double radians = angle * Math.PI / 180;
        int x1 = x0 + (int) (length * Math.cos(radians));
        //negate y increment to flip image vertically
        int y1 = y0 - (int) (length * Math.sin(radians));

        if (length > 2) {
            g.drawLine(x0, y0, x1, y1);
            drawBranches(g, x1, y1, length * 0.75, angle + 30); // left tree branch
            drawBranches(g, x1, y1, length * 0.67, angle - 50); // right tree branch
        }
    } // end drawBranches

    //************************************************************************
    //This employs the logistic equation to generate bounded
    //growth along an S-curve
    public void updateTrunkLength() {
        trunkLength = trunkLength + 0.01 * trunkLength * (1.0 - trunkLength / MAX_TRUNK_LENGTH);
    } // end updateTrunkLength
} //end Tree class
