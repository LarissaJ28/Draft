package widgets;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.opengl.GL11.GL_TRUE;

import java.util.ArrayList;

import org.joml.Vector2f;
import org.joml.Vector3f;

import io.IOreader;
import objects.Entity;
import objects.Loader;
import objects.Model;
import objects.Rectangle;
import renderEngine.Renderer;

public class SidebarCust {

	// instance variables
		private static ArrayList<GUIComponent> guiComponents;
		private ArrayList<Button> buttons;
		private ArrayList<GUIComponent> guiComponents1;
		private static ArrayList<Button> buttons1;
		private Model iButtonModel;
		private Button New;			// mButton
		private Button Sim;			// iButton
		private Button Sim1;
		private ArrayList<Entity> entities;

		// static variables
		private static String New_BUTTON_TEXTURE_FILE = "./res/New.png";
		private static String Sim_BUTTON_TEXTURE_FILE = "./res/Cust.png";
		private float z;
		
		private int ButtonSize=0;

		// constructor
		public  SidebarCust(Loader loader, float screenWidth, float screenHeight, float z) {
			
			this.z = z;
			// ******** INITIAL STATES OF BUTTONS ********
			//
			// 	width		the button width
			// 	height		the button height
			// 	x			the x coordinate of the center of the button (in OpenGL world coordinates)
			// 	y			the y coordinate of the center of the button (in OpenGL world coordinates)
				
			// the following will be the same for each button
			float ButtonX = -450;
			
			
			float buttonWidth = 70f;
			float buttonHeight = 70f;
			
			float[] vertices = Entity.getVertices(buttonWidth, buttonHeight, z);
			float[] texCoords = Entity.getTexCoords();
			int[] indices = Entity.getIndices();
					
			Vector3f rotation = new Vector3f(0,0,0);
			float scale = 1f;
			
			
			float nButtonY = 225;
			Vector3f nButtonPos = new Vector3f(ButtonX, nButtonY, z);
			
			float iButtonY = nButtonY-buttonHeight ;
			Vector3f iButtonPos = new Vector3f(ButtonX, iButtonY, z);
			
			// **************************************************
			
			// add button
			int textureID = loader.loadTexture(New_BUTTON_TEXTURE_FILE);
			Model nButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);
			
			New = new Button(nButtonModel, nButtonPos, rotation, scale, buttonWidth, buttonHeight);
			
			// added sim button
			textureID = loader.loadTexture(Sim_BUTTON_TEXTURE_FILE);
			 iButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);
			
			Sim = new Button(iButtonModel, iButtonPos, rotation, scale, buttonWidth, buttonHeight);
			
			
			// initialize GUI components array list
			guiComponents = new ArrayList<GUIComponent>();
			guiComponents1 = new ArrayList<GUIComponent>();
			guiComponents1.add(New);
			guiComponents.add(Sim);
			
			// initialize button array list
			buttons = new ArrayList<Button>();
			buttons1 = new ArrayList<Button>();
			buttons.add(New);
			buttons1.add(Sim);
			//buttons1.add(New);
			buttons.add(Sim);
			// initialize entities array list
			entities = new ArrayList<Entity>();
			
			ButtonSize= IOreader.getButtons();
			for(int i = 0; i< ButtonSize-1;i++)
			{
				addsim();
			}
			
		}
		
		//public void display
		public void addsim()
		{
			float y = 0;
			
			float x = -450;
			float sideLength = 70f;
			if(guiComponents.size()==0)
			{
				y = guiComponents1.get(0).getPosition().y - sideLength;
			}
			else {
			 y =guiComponents.get(guiComponents.size()-1).getPosition().y -sideLength;
			}
			
			Vector3f position = new Vector3f(x,y,z);

			Vector3f rotation = new Vector3f(0,0,0);
			float scale = 1f;
			
			
			Rectangle Sim = new Rectangle(iButtonModel, position, rotation, scale, sideLength, sideLength);
			entities.add(Sim);
			Sim.getAabb().setMin(new Vector2f(Sim.getPosition().x - Sim.getWidth()/2, Sim.getPosition().y - Sim.getHeight()/2)); 
			Sim.getAabb().setMax(new Vector2f(Sim.getPosition().x + Sim.getWidth()/2, Sim.getPosition().y + Sim.getHeight()/2));
			
			
			Sim1 = new Button(iButtonModel, position, rotation, scale, sideLength, sideLength);
			guiComponents.add(Sim1);
			buttons1.add(Sim1);
			
			
			
			
		}
		
		public Boolean Scroll(long window)
		{
			int size = guiComponents.size();
			Boolean stop = true;
			
			if(glfwGetKey(window, GLFW_KEY_UP) == GL_TRUE && buttons1.get(1).getAabb().getMin().y<=buttons1.get(0).getAabb().getMin().y )
			{
				for(int i = 0; i<size;i++)
			
			{
				guiComponents.get(i).setY(10);
				buttons1.get(i).getAabb().setMin(new Vector2f(guiComponents.get(i).getPosition().x - buttons1.get(i).Width()/2, guiComponents.get(i).getPosition().y - 				buttons1.get(i).Height()/2)); 
				buttons1.get(i).getAabb().setMax(new Vector2f(guiComponents.get(i).getPosition().x + buttons1.get(i).Width()/2, guiComponents.get(i).getPosition().y + 				buttons1.get(i).Height()/2));
			}
			}
			if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE && buttons1.get(size-1).getAabb().getMin().y>=-300)
			{
				for(int i = 0; i<size;i++)
					
				{
					guiComponents.get(i).setY(-10);
					buttons1.get(i).getAabb().setMin(new Vector2f(guiComponents.get(i).getPosition().x - buttons1.get(i).Width()/2, guiComponents.get(i).getPosition().y - 				buttons1.get(i).Height()/2)); 
					buttons1.get(i).getAabb().setMax(new Vector2f(guiComponents.get(i).getPosition().x + buttons1.get(i).Width()/2, guiComponents.get(i).getPosition().y + 				buttons1.get(i).Height()/2));
				}
			}
			

			if(glfwGetKey(window, GLFW_KEY_ENTER) == GL_TRUE)
			{
				stop = false;
			}
			
			return stop;
		}
		
		public static void deleteSim(int index)
		{
			guiComponents.remove(index);
			buttons1.remove(index);
			
			
		}
		
		/**
		 * Renders the objects of the simulation window.
		 * 
		 * @param renderer		the renderer
		 */
		public void render(Renderer renderer) {
			
			renderer.render(entities);
			renderer.renderGUI(guiComponents1);
			renderer.renderGUI(guiComponents);
			
		}

		/**
		 * Returns the array list of buttons of the toolbar.
		 * 
		 * @return buttons
		 */
		public ArrayList<Button> getButtons() {
			return buttons;
			
		}
		
		public static ArrayList<Button> getButtons1()
		{
			return buttons1;
		}

		/**
		 * Returns the menu button.
		 * 
		 * @return menuButton
		 */
		public Button getNewButton() {
			return New;
		}

		/**
		 * Returns the info button.
		 * 
		 * @return infoButton
		 */
		public Button getSimButton(int i) {
			return buttons1.get(i);
		}

	}

