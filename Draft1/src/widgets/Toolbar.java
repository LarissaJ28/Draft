package widgets;

import java.util.ArrayList;

import org.joml.Vector3f;

import main.Main;
import objects.Entity;
import objects.Loader;
import objects.Model;
import renderEngine.Renderer;
import widgets.Button;
import widgets.GUIComponent;

public class Toolbar {
private float z=1;

//private ArrayList<GUIComponent> guiComponents;
private ArrayList<Button> buttons;

//private Button menu;
private Button info;
//private Loader loader;
private static String HELP_BUTTON_TEXTURE_FILE = "./res/InfoB.png";
private static String MENU_BUTTON_TEXTURE_FILE = "./res/MenuB.png";

	public  ArrayList<GUIComponent> menuAndInfo(Loader loader, float screenWidth, float screenHeight, float z)
	{
		
		ArrayList<GUIComponent> guiComponents;
		// ******** INITIAL STATES OF BUTTONS ********
				//
				// 	width		the button width
				// 	height		the button height
				// 	x			the x coordinate of the center of the button (in OpenGL world coordinates)
				// 	y			the y coordinate of the center of the button (in OpenGL world coordinates)
					
				float mbuttonWidth = 100f;
				float mbuttonHeight = 70f;	
				float mButtonX = -screenWidth/2 + mbuttonWidth/2;	// flush against left side of the screen
				float mButtonY = screenHeight/2 - mbuttonHeight/2;  // flush against top of the screen
				Vector3f mButtonPos = new Vector3f(mButtonX, mButtonY, z);
					
				float[] mButtonVertices = Entity.getVertices(mbuttonWidth, mbuttonHeight, z);
					
				// the following will be the same for each button
				float[] texCoords = Entity.getTexCoords();
				int[] indices = Entity.getIndices();
							
				Vector3f rotation = new Vector3f(0,0,0);
				float scale = 1f;
							
				// **************************************************
							
				// menu button
				int textureID = loader.loadTexture(MENU_BUTTON_TEXTURE_FILE);
				Model gButtonModel = loader.loadToVAO(mButtonVertices, texCoords, indices, textureID);
							
				 Button menuButton = new Button(gButtonModel, mButtonPos, rotation, scale, mbuttonWidth, mbuttonHeight);
						
					
				// initialize GUI components array list
				guiComponents = new ArrayList<GUIComponent>();
				guiComponents.add(menuButton);
							
				return guiComponents;
			
				
						
		
	}
	

	
	public void sToolbar()
	{
		
	}
	
	public void aToolbar()
	{
		
	}
	
	public ArrayList guiComponent(Loader loader, float screenWidth, float screenHeight, float z)
	{
		
		
		// initialize GUI components array list
		guiComponents = new ArrayList<GUIComponent>();
		guiComponents.add(menu);
		
			System.out.println("TEst1");
				return guiComponents;
	}
	
	public ArrayList buttons(Loader loader, float screenWidth, float screenHeight, float z)
	{
		
		
		
		// initialize button array list
		buttons = new ArrayList<Button>();
		buttons.add(menu);
		
		return buttons;
	}
}
