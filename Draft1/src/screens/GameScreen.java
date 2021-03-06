package screens;

import java.util.ArrayList;

import org.joml.Vector3f;

import main.Main;
import objects.Entity;
import objects.Loader;
import objects.Model;
import renderEngine.Renderer;
import widgets.Button;
import widgets.GUIComponent;

/**
 * This class implements the game screen of the 
 * physics simulator.
 * 
 * @author Cindy Li
 * @author Larissa Jin
 * @since Thursday, April 19th, 2018
 */
public class GameScreen {

	// instance variables
	private Button menuButton, infoButton;		// mButton
	
	private ArrayList<GUIComponent> guiComponents;
	private ArrayList<Button> buttons;
	
	// static variables
	private static String MENU_BUTTON_TEXTURE_FILE = "./res/MenuB.png";
	private static String INFO_BUTTON_TEXTURE_FILE = "./res/InfoB.png";
	
	// constructor
	public GameScreen(Loader loader, float screenWidth, float screenHeight, float z) {
		
		// ******** INITIAL STATES OF BUTTONS ********
		//
		// 	width		the button width
		// 	height		the button height
		// 	x			the x coordinate of the center of the button (in OpenGL world coordinates)
		// 	y			the y coordinate of the center of the button (in OpenGL world coordinates)
		
		float mbuttonWidth = 100f;
		float hbuttonHeight = 70f;	
		float mButtonX = -screenWidth/2 + mbuttonWidth/2;	// flush against left side of the screen
		float mButtonY = screenHeight/2 - hbuttonHeight/2;  // flush against top of the screen
		Vector3f mButtonPos = new Vector3f(mButtonX, mButtonY, z);
		
		float[] mButtonVertices = Entity.getVertices(mbuttonWidth, hbuttonHeight, z);
		
		float ibuttonWidth = 70f;
		float iButtonX = -screenWidth/2 + ibuttonWidth/2;
		float iButtonY = screenHeight/2 - hbuttonHeight/2; 
		Vector3f iButtonPos = new Vector3f(iButtonX, iButtonY, z);
		
		float[] iButtonVertices = Entity.getVertices(ibuttonWidth, hbuttonHeight, z);
		
		
		
		// the following will be the same for each button
		float[] texCoords = Entity.getTexCoords();
		int[] indices = Entity.getIndices();		
		Vector3f rotation = new Vector3f(0,0,0);
		float scale = 1f;
				
		// **************************************************
				
		// menu button
		int textureID = loader.loadTexture(MENU_BUTTON_TEXTURE_FILE);
		Model gButtonModel = loader.loadToVAO(mButtonVertices, texCoords, indices, textureID);
				
		menuButton = new Button(gButtonModel, mButtonPos, rotation, scale, mbuttonWidth, hbuttonHeight);
				
		textureID = loader.loadTexture(INFO_BUTTON_TEXTURE_FILE);
		Model iButtonModel = loader.loadToVAO(iButtonVertices, texCoords, indices, textureID);
				
		infoButton = new Button(iButtonModel, iButtonPos, rotation, scale, ibuttonWidth, hbuttonHeight);
		
		// initialize GUI components array list
		guiComponents = new ArrayList<GUIComponent>();
		guiComponents.add(menuButton);
		guiComponents.add(infoButton);
				
		// initialize button array list
		buttons = new ArrayList<Button>();
		buttons.add(menuButton);
		buttons.add(infoButton);
	}
	
	/**
	 * Renders the GUI components of the game screen.
	 * 
	 * @param renderer		the renderer
	 */
	public void render(Renderer renderer) {
		
		renderer.renderGUI(guiComponents);
	}
	
	/**
	 * Contains the logic for when a mouse is clicked.
	 * 
	 * @param x		the x coordinate of the cursor position
	 * @param y		the y coordinate of the cursor position
	 */
	public void mouseInput(Main main, float x, float y) {
		
		// loop through buttons array list
		for (Button button: buttons) {
					
			// check if this button was clicked
			if (button.getAabb().intersects(x, y)) {
						
				// check which button
				if (button.equals(menuButton))
					main.setCurrScreen(0);
			}
			
		}
		
	}
}
