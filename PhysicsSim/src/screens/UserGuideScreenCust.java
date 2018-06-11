package screens;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This class implements the user guide pop-up of the 
 * physics simulator.
 * 
 * @author Cindy Li
 * @author Larissa Jin
 * @since Thursday, April 19th, 2018
 */
public class UserGuideScreenCust {

	
	/**
	 * Shows the user guide pop-up.
	 */
	public static void showUserGuide() {
		
		//String pt1 = "<html><body width='";
        String pt2 =
           "Features \n" +
           "            1. The top bar : \n" +
           "               Allows you to drag and drop the selected objects over to your simulation \n" +
           "                    - The Menu button allows you to go back to the main menu \n"+
           "                    - The info button allows you to acess the user guide \n"+
           "                    - The box button allows you to add boxes to your simulation \n"+
           "                    - The ball button allows you to add balls to your simulation \n"+
           "                    - The cannon button allows you to add cannons to your simulation \n"+
           "                    - The save button allows you to save your selected simulation \n"+
           "                    - The delete button allows you to delete your selected simulation \n"+
           "                    - The reset button allows you to reset your selected simulation \n"+
           "                    - The play button allows you to play your selected simulation \n"+
           "            2. The side bar : \n" +
           "               Allows you to select a simulation and create a new simulation \n" +
           "               The side bar will diplay four of the simulations \n"+
           "                    - The simulation button allows you to open the selected simulation \n"+
           "                    - The add new simulation button allows you to add a new simulation and name it \n"+
           "                    - The arrows allow you to scroll through your simulations (when you have more than 4 simulations) \n"+
           "            3. The simulation window : \n" +
           "               This is where your simulation is displayed. Objects from the toolbar can be added to this window. \n" +
           "               If you have dragged an object over to the simulation you will be able to place it down by clicking again. \n"+
           "               If the object is not within the simulation it will delete it, or place it back to where it was before \n"+
           "               Objects are able to bounce off the boundaries, and have an acceleration downwards, which is the force of gravity \n"+
           "               The top right corner of your simulation is where your simulation name will be displayed \n"+
           
           "            4. Pop-Up boxes: \n" +
           "               Pop-up boxes are used to change the velocity, mass, and size of the object \n" +
           "               These are opened by right clicking on an object in a simulation \n" +
           "               Once it is displayed: \n" +
           "                     - The mass, size and velocities will be displayed \n" +
           "                     - You will be able to use the arrows to either increase or decrease the values \n" +
           "                     - You will be able to delete the object \n" +
           "                     - To close the pop-up box click the x in the topright corner \n" +
           "            5. Moving an object \n"+
           "               To move an object: click on the object, then move the cursor to where you want it to be placed \n" +
           "               To place an object: click on the object again \n" +
           "               *Objects have to be placed to an area inside the simulation window, otherwise they will be moved back \n" +
           "Objects: \n" +
           "   1. Box : Has the ability to collide with another thus, influencing another's movement \n" +
           "   2. Ball : Has the ability to collide with another thus, influencing another's movement \n" +
           "   3. Cannon : Has the ability to collide with another thus, influencing another's movement \n" +
           "               Has the ability to change other object's velocities to specific values " ;
       
        JTextArea textArea = new JTextArea(pt2);
        JScrollPane scrollpane =new JScrollPane(textArea);
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(true); 
        scrollpane.setPreferredSize( new Dimension( 800, 500 ) );
        JOptionPane.showMessageDialog(null, scrollpane, "Customized User Guide",  
                                               JOptionPane.YES_NO_OPTION);
        
       JPanel p = new JPanel( new BorderLayout() );

       int width = 700;

      // String s = pt1 + width + pt2 ;

       JFrame frame = new JFrame("User Guide");
       
       frame.getContentPane().add(p);
      // JOptionPane.showMessageDialog(null,scrollpane, s, JOptionPane.CLOSED_OPTION);

	}
}
