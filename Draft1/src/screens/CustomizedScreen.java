package screens;

import java.util.ArrayList;

import org.joml.Vector3f;

import main.Main;
import objects.Entity;
import objects.IOreader;
import objects.Loader;
import objects.Model;
import renderEngine.Renderer;
import widgets.Button;
import widgets.GUIComponent;
import widgets.Toolbar;
import widgets.Translation;

/**
 * This class implements the customized screen of the 
 * physics simulator.
 * 
 * @author Cindy Li
 * @author Larissa Jin
 * @since Thursday, April 19th, 2018
 */
public class CustomizedScreen {
	// instance variables
		private Button menuButton, infoButton, rectButton, circButton, rampButton, NrectButton;		// mButton
		private int n =0;
		private float z1=0;
		private ArrayList<GUIComponent> guiComponents;
		private ArrayList<Button> buttons;
		private ArrayList<Button> buttons1 = new ArrayList();
		
		private Loader loader1;
		// static variables
		private static String MENU_BUTTON_TEXTURE_FILE = "./res/MenuB.png";
		private static String INFO_BUTTON_TEXTURE_FILE = "./res/InfoB.png";
		private static String RECT_BUTTON_TEXTURE_FILE = "./res/Rect.png";
		private static String CIRC_BUTTON_TEXTURE_FILE = "./res/Circ.png";
		private static String RAMP_BUTTON_TEXTURE_FILE = "./res/Ramp.png";
		
		
		// constructor
		public CustomizedScreen(Loader loader, float screenWidth, float screenHeight, float z) {
			z1=z;
			loader1=loader;
			// ******** INITIAL STATES OF BUTTONS ********
			//
			// 	width		the button width
			// 	height		the button height
			// 	x			the x coordinate of the center of the button (in OpenGL world coordinates)
			// 	y			the y coordinate of the center of the button (in OpenGL world coordinates)
			
			float buttonWidth = 70f;
			float buttonHeight = 70f;
			float ButtonY = 275;
			
			float mButtonX = -450;
			Vector3f gButtonPos = new Vector3f(mButtonX, ButtonY, z);
			
			float iButtonX = mButtonX+buttonWidth ;
			Vector3f lButtonPos = new Vector3f(iButtonX, ButtonY, z);
			
			float rectB = iButtonX+buttonWidth;
			Vector3f rectButtonPos = new Vector3f(rectB, ButtonY, z);
			
			float circB = rectB +buttonWidth;
			Vector3f circBPos = new Vector3f(circB, ButtonY, z);
			
			float rampB = circB +buttonWidth;
			Vector3f rampBPos = new Vector3f(rampB, ButtonY, z);
			
			// the following will be the same for each button
			float[] vertices = Entity.getVertices(buttonWidth, buttonHeight, z);
			float[] texCoords = Entity.getTexCoords();
			int[] indices = Entity.getIndices();
			
			Vector3f rotation = new Vector3f(0,0,0);
			float scale = 1f;
			
			// **************************************************
			
			// game button
			int textureID = loader.loadTexture(MENU_BUTTON_TEXTURE_FILE);
			Model gButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);
			
			menuButton = new Button(gButtonModel, gButtonPos, rotation, scale, buttonWidth, buttonHeight);
			
			// lesson button
			textureID = loader.loadTexture(INFO_BUTTON_TEXTURE_FILE);
			Model lButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);
			
			infoButton = new Button(lButtonModel, lButtonPos, rotation, scale, buttonWidth, buttonHeight);
			
			textureID = loader.loadTexture(RECT_BUTTON_TEXTURE_FILE);
			Model rectButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);
			
			rectButton = new Button(rectButtonModel, rectButtonPos, rotation, scale, buttonWidth, buttonHeight);
			
			textureID = loader.loadTexture(CIRC_BUTTON_TEXTURE_FILE);
			Model circButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);
			
			circButton = new Button(circButtonModel, circBPos, rotation, scale, buttonWidth, buttonHeight);
			
			textureID = loader.loadTexture(RAMP_BUTTON_TEXTURE_FILE);
			Model rampButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);
			
			rampButton = new Button(rampButtonModel, rampBPos, rotation, scale, buttonWidth, buttonHeight);
			
			// initialize GUI components array list
			guiComponents = new ArrayList<GUIComponent>();
			guiComponents.add(menuButton);
			guiComponents.add(infoButton);
			guiComponents.add(rectButton);
			guiComponents.add(circButton);
			guiComponents.add(rampButton);
			
			
			
			
			
			// initialize button array list
			buttons = new ArrayList<Button>();
			buttons.add(menuButton);
			buttons.add(infoButton);
			buttons.add(rectButton);
			buttons.add(circButton);
			buttons.add(rampButton);
			
			
		}
		
	/**
	 * Renders the GUI components of the customized screen.
	 * 
	 * @param renderer		the renderer
	 */
	public void render(Renderer renderer) {
			
		ArrayList<Integer> height = new ArrayList<Integer>();
		height = IOreader.getHeight(1);
		
		ArrayList<Integer> width = new ArrayList<Integer>();
		width =IOreader.getWidth(1);
		
		ArrayList<Integer> X = new ArrayList<Integer>();
		X =IOreader.getX(1);
		
		ArrayList<Integer> Y = new ArrayList<Integer>();
		Y =IOreader.getY(1);
		
		int size = (IOreader.getHeight(1)).size();
		for(int i=0;i<size;i++)
		{
			
			float Bheight = height.get(i);
			float Bwidth = width.get(i);
			float BX = X.get(i);
			float BY = Y.get(i);
			
			Vector3f nButtonPos = new Vector3f(BX, BY, z1);
			
			float buttonWidth = 70f;
			float buttonHeight = 70f;
			
			// the following will be the same for each button
			float[] vertices = Entity.getVertices(buttonWidth, buttonHeight, z1);
			float[] texCoords = Entity.getTexCoords();
			int[] indices = Entity.getIndices();
			
			Vector3f rotation = new Vector3f(0,0,0);
			float scale = 1f;
			
			int textureID = loader1.loadTexture(RECT_BUTTON_TEXTURE_FILE);
			Model rectModel = loader1.loadToVAO(vertices, texCoords, indices, textureID);
			
			NrectButton = new Button(rectModel, nButtonPos, rotation, scale, Bwidth, Bheight);
			
			guiComponents.add(NrectButton);
			
			buttons1.add(NrectButton);
			
			
		}
		renderer.renderGUI(guiComponents);
		
	}
	
	public void mouseInputS(Main main, float x, float y, long window)
	{
		for ( Button button : buttons1)
		{
			int size = (IOreader.getHeight(1)).size();
			
			if (button.getAabb().intersects(x, y)) {
				
				for(int i =0; i<size; i++)
				{
					if(button.equals(buttons1.get(i)))
					{
						IOreader.changeX(i, window);
//						ArrayList<Integer> X = new ArrayList<Integer>();
//						X =IOreader.getX(1);
//						ArrayList<Integer> Y = new ArrayList<Integer>();
//						Y =IOreader.getY(1);
//						ArrayList<Integer> height = new ArrayList<Integer>();
//						height = IOreader.getHeight(1);
//						
//						ArrayList<Integer> width = new ArrayList<Integer>();
//						width =IOreader.getWidth(1);
//						float Bheight = height.get(i);
//						float Bwidth = width.get(i);
//						float BX = X.get(i);
//						float BY = Y.get(i);
//						
//						
//						
//						float buttonWidth = 70f;
//						float buttonHeight = 70f;
//						
//						// the following will be the same for each button
//						float[] vertices = Entity.getVertices(buttonWidth, buttonHeight, z1);
//						float[] texCoords = Entity.getTexCoords();
//						int[] indices = Entity.getIndices();
//						
//						Vector3f rotation = new Vector3f(0,0,0);
//						float scale = 1f;
//						
//						int textureID = loader1.loadTexture(RECT_BUTTON_TEXTURE_FILE);
//						Model rectModel = loader1.loadToVAO(vertices, texCoords, indices, textureID);
////						float num8 =IOreader.getX(1).get(i);
////						float num1 =  IOreader.getY(1).get(i);
//					
//						Translation.translate(Bheight, Bwidth,BX,BY,rotation, scale,rectModel,window);
					}
				}
			}
		}
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
					//System.out.println("ssss");
				
				if(button.equals(infoButton))
					UserGuideScreen.showUserGuide();
				
					
				if(button.equals(rectButton))
					System.out.println("Test");
					n++;
					IOreader.add(n);
					
					
//				 if(button.equals(NrectButton))
//					System.out.println("Click");
				
//				if(button.equals(circButton))
//					System.out.println("IN");
//					main.setCurrScreen(3);
//					
					
			
		
				
		}
			
	}
		
}
}
