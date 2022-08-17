package treedriver;

import javax.swing.JFrame;
import java.util.ArrayList;

public class TreeDriver {

    private final int WIDTH = 625, HEIGHT = 400;
    private TreePanel panel = new TreePanel(HEIGHT, WIDTH);
    private int time = 0;
    //***********************************************************

    public TreeDriver() {
        JFrame frame = new JFrame("Growing Trees");

        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    } // end constructor

    //****************************************************************
    //Start four tree at different times to show what this 
    //kind of tree looks like at different stages of it life.
    public void simulate() throws Exception {
        ArrayList<Tree> trees = panel.getTrees();
        boolean done = false;

        while (!done) {
            switch (time) {
                case 0:
                    panel.addTree(400, 3, time);
                    break;
                case 360:
                    panel.addTree(100, 3, time);
                    break;
                case 540:
                    panel.addTree(300, 3, time);
                    break;
                case 630:
                    panel.addTree(200, 3, time);
                    break;
                case 675:
                    done = true;
            } // end switch
            panel.repaint();

            time++;
            panel.setTime(time);
            for (Tree tree : trees) {
                tree.updateTrunkLength(); //to correspond to the new time
            }
            Thread.sleep(50); // throws and InterruptedException
        } //end while
    } // end simulate

    //***********************************************************************
    public static void main(String[] args) throws Exception {
        TreeDriver driver = new TreeDriver();

        driver.simulate();
    } // end main
} // end TreeDriver class
