package screens;

import static org.lwjgl.glfw.GLFW.*;

import java.nio.DoubleBuffer;
import java.util.ArrayList;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import io.IOreader;
import main.Main;
import objects.Circle;
import objects.Entity;
import objects.Loader;
import objects.Rectangle;

import renderEngine.Renderer;
import widgets.Button;
import widgets.Path;
import widgets.SidebarCust;
import widgets.SimulationWindow;
import widgets.Toolbar;

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
	private SimulationWindow simulation;
	private Toolbar toolbar;
	private Path path =new Path();
	private SidebarCust sidebar;
	private Loader loader;
	private float z;
	private boolean newEntityCreated;
	private boolean scroll = false;
	private long window;
	private float screenWidth;
	private float screenHeight;
	private int index=0;
	private int ButtonSize;
	private ArrayList<SimulationWindow> simulations = new ArrayList<SimulationWindow>();
	private Boolean start =false , pause =true;
	private ArrayList<Path> paths =  new  ArrayList<Path>();
	
	private static String START_BUTTON_TEXTURE_FILE = "./res/start.png";
	private static String PAUSE_BUTTON_TEXTURE_FILE = "./res/pause.png";
	// constructor
	public CustomizedScreen(long window, Loader loader, float screenWidth, float screenHeight, float z) {
					
		// simulation window
		simulation = new SimulationWindow(window, loader, screenWidth, screenHeight, z);
		
		simulations.add(simulation);
		// toolbar
		toolbar = new Toolbar(loader, screenWidth, screenHeight, z);
		
		sidebar = new SidebarCust(loader, screenWidth, screenHeight, z);
		ButtonSize= IOreader.getButtons();
		for(int i = 0; i< ButtonSize-1;i++)
		{
			simulation = new SimulationWindow(window, loader, screenWidth, screenHeight, z);
			simulations.add(simulation);
		}
		this.z = z;
		newEntityCreated = false;
		this.loader = loader;
		this.window = window;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}
		
	/**
	 * Renders the customized screen.
	 * 
	 * @param renderer		the renderer
	 */
	public void render(Renderer renderer) {
		
		toolbar.render(renderer);
		simulations.get(index).render(renderer);
		sidebar.render(renderer);
			
		
		
		if (scroll)
		{
			
			scroll = sidebar.Scroll(window);
		}
		
		if (newEntityCreated)
		{
			moveNewObject();
			
			
		
		}
		if(start==true)
		{

			if(simulations.get(index).getCircle().size() >0)
			{
			float x = simulations.get(index).getCircle().get(0).getPosition().x;
			float y = simulations.get(index).getCircle().get(0).getPosition().y;
			
			path.trajectory(loader, x, y,z);
			path.render(renderer);
			}

		}
		
		
	}
	
	/**
	 * Updates the game screen.
	 */
	public void update() {
		
		if (!simulations.get(index).isPause())
			simulations.get(index).update();
	}
	
	/**
	 * Contains the logic for input handling
	 * 
	 * @param main				where the main loop is
	 * @param key				the key that was pressed
	 * @param leftClick			whether the left mouse button was pressed
	 */
	public void input(Main main, int key, boolean leftClick) {
		
		// mouse input
		mouseInput(main, leftClick);
		
		// keyboard input
		keyboardInput(key);
	}
	
	/**
	 * Contains the logic for when a mouse is clicked.
	 * 
	 * @param main				where the main loop is
	 * @param leftClick			whether the left mouse button was pressed
	 */
	public void mouseInput(Main main, boolean leftClick) {
			
		// get cursor coordinate
		
		DoubleBuffer cursorPosX = BufferUtils.createDoubleBuffer(1);
		DoubleBuffer cursorPosY = BufferUtils.createDoubleBuffer(1);
		
		glfwGetCursorPos(window, cursorPosX, cursorPosY);
		
		float x = (float) cursorPosX.get(0);
		float y = (float) cursorPosY.get(0);
		
		
		// convert cursor coordinate to OpenGL world coordinate
		x -= screenWidth/2;
		y *= -1;
		y += screenHeight/2;
		
		// if left mouse button was pressed
		if (leftClick) {
			
			// clear new entity
			if (newEntityCreated) {
				
				placeNewEntity(simulations.get(index).getEntities().get(simulations.get(index).getEntities().size()-1));
				newEntityCreated = false;
			}
			
			else {
				
				// loop through buttons of toolbar
				for (Button button: toolbar.getButtons()) {
						
					// check if this button was clicked
					if (button.getAabb().intersects(x, y)) {
											
						// menu button
						if (button.equals(toolbar.getMenuButton())) {
								
							// pause simulation
							simulations.get(index).setPause(true);
											
							main.setCurrScreen(0);
						}
							
						// info button
						else if (button.equals(toolbar.getInfoButton())) {
								
								UserGuideScreen.showUserGuide();
						}
						
						// rectangle button
						else if (button.equals(toolbar.getRectangleButton())) {
								
							// generate random crate for now
							float sideLength = (float) Math.random() * 50 + 30;
							float posX = toolbar.getRectangleButton().getPosition().x;
							float posY = toolbar.getRectangleButton().getPosition().y;
							float mass = (float) Math.random() * 20 + 1;
							float e = -0.5f;
								
							simulations.get(index).createCrateEntity(sideLength, posX, posY, z, mass, e);
							
							newEntityCreated = true;
						}

						// circle button
						else if (button.equals(toolbar.getCircleButton())) {

							// generate random ball for now
							float radius = (float) Math.random() * 25 + 20;
							float posX = toolbar.getCircleButton().getPosition().x;
							float posY = toolbar.getCircleButton().getPosition().y;
							float mass = (float) Math.random() * 20 + 1;
							float e = -0.5f;

							simulations.get(index).createBallEntity(radius, posX, posY, z, mass, e);
						
							newEntityCreated = true;
						}
						else if(button.equals(toolbar.getSaveButton()))
						{
							IOreader.saveSim("Custom"+index, simulations.get(index));
						}

						else if (button.equals(toolbar.getDeleteButton()))
						{
							simulations.get(index).getEntities().removeAll(simulations.get(index).getEntities());

							simulations.remove(simulations.get(index));
							SidebarCust.deleteSim(index);
							IOreader.deleteTxtFile(index, simulations);
							IOreader.SaveButton(SidebarCust.getButtons1().size());
							
						}
						else if(button.equals(toolbar.getStartButton()))
						{
							if(pause)
							{
								simulations.get(index).setPause(!simulations.get(index).isPause());
								int textureID = loader.loadTexture(PAUSE_BUTTON_TEXTURE_FILE);
								toolbar.getStartButton().getModel().setTextureID(textureID);
								pause=false;
							}
							else
							{
								simulations.get(index).setPause(!simulations.get(index).isPause());
								int textureID = loader.loadTexture(START_BUTTON_TEXTURE_FILE);
								toolbar.getStartButton().getModel().setTextureID(textureID);
								pause=true;
							}
						}
						else if(button.equals(toolbar.getResetButton()))
						{
							
						}

					}
				}
				// loop through buttons of toolbar
				for ( Button button1: sidebar.getButtons()) {

					// check if this button was clicked
					if (button1.getAabb().intersects(x, y)) {


						if(button1.equals(sidebar.getNewButton()))
						{
							sidebar.addsim();
							simulation = new SimulationWindow(window, loader, screenWidth, screenHeight, z);
							simulations.add(simulation);
							index = simulations.size()-1;
							IOreader.SaveButton(SidebarCust.getButtons1().size());

						}
						else if(button1.equals(sidebar.getUpButton()))
						{
							sidebar.moveUp();
							
						}
						else if (button1.equals(sidebar.getDownButton()))
						{
							sidebar.moveDown();
						}
					}
				}
				for ( Button button1: sidebar.getButtons1()) {

					// check if this button was clicked
					if (button1.getAabb().intersects(x, y)) {



						int size = SidebarCust.getButtons1().size();
						for(int i = 0; i<size;i++)
						{
							
							if(button1.equals(sidebar.getSimButton(i)))
							{
								
								scroll = true;
								IOreader.getSimulation("Custom"+i, simulations.get(i));
								path.delete();
								start=false;
								index = i;
								
								if(size>7)
								{
									sidebar.upAndDown();
									
								}
							}
						}
						
					}
				}
			}
		}
					
						
				
			}
			
		
			
	
	
	/**
	 * Contains the logic for when a key is pressed.
	 * 
	 * @param key  the key that was pressed
	 */
	public void keyboardInput(int key) {
		
		// space bar
		if(key == Main.KEY_SPACE) {
			simulations.get(index).setPause(!simulations.get(index).isPause());
			
			start = true;
			
		}
	}

	/**
	 * Returns the game screen's simulation window.
	 * 
	 * @return simulation
	 */
	public SimulationWindow getSimulationWindow() {
		return simulations.get(index);
	}
	
	/**
	 * Moves the newly created entity following the position of the cursor.
	 */
	public void moveNewObject() {
	
		// get cursor coordinate
		
		DoubleBuffer cursorPosX = BufferUtils.createDoubleBuffer(1);
		DoubleBuffer cursorPosY = BufferUtils.createDoubleBuffer(1);
		
		glfwGetCursorPos(window, cursorPosX, cursorPosY);
				
		float x = (float) cursorPosX.get(0);
		float y = (float) cursorPosY.get(0);
				
				
		// convert cursor coordinate to OpenGL world coordinate
		x -= screenWidth/2;
		y *= -1;
		y += screenHeight/2;
		
		// set position of entity
		Entity e = simulations.get(index).getEntities().get(simulations.get(index).getEntities().size()-1);
		e.setPosition(new Vector3f(x,y, e.getPosition().z));
				
		// update AABB if entity is a rectangle
		if (e instanceof Rectangle) {
			Rectangle r = (Rectangle) e;
					
			r.getAabb().setMin(new Vector2f(r.getPosition().x - r.getWidth()/2, r.getPosition().y - r.getHeight()/2)); 
			r.getAabb().setMax(new Vector2f(r.getPosition().x + r.getWidth()/2, r.getPosition().y + r.getHeight()/2));
		}
			
	}
	
	/**
	 * Checks whether or not a newly created entity can 
	 * be placed at the location of the cursor.
	 * 
	 * @param entity		the newly created entity
	 * @return true if yes, false otherwise
	 */
	public void placeNewEntity(Entity newEntity) {
		
		// if entity is a rectangle
		if (newEntity instanceof Rectangle) {
			
			Rectangle r = (Rectangle) newEntity;
			
			// horizontal check
			if (r.getAabb().getMin().x < simulations.get(index).getMin().x || 
					r.getAabb().getMax().x > simulations.get(index).getMax().x) {
				
				simulations.get(index).getEntities().remove(simulations.get(index).getEntities().size()-1);
				return;
			}
			
			// vertical check
			if (r.getAabb().getMin().y < simulations.get(index).getMin().y || 
					r.getAabb().getMax().y > simulations.get(index).getMax().y) {
				
				simulations.get(index).getEntities().remove(simulations.get(index).getEntities().size()-1);
				return;
			}
		}
		
		// if entity is circle
		else if (newEntity instanceof Circle) {
			
			Circle c = (Circle) newEntity;
			
			// horizontal check
			if (c.getPosition().x - c.getRadius() < simulations.get(index).getMin().x || 
					c.getPosition().x + c.getRadius() > simulations.get(index).getMax().x) {
				
				simulations.get(index).getEntities().remove(simulations.get(index).getEntities().size()-1);
				return;
			}
			
			// vertical check
			if (c.getPosition().y - c.getRadius() < simulations.get(index).getMin().y || 
					c.getPosition().y + c.getRadius() > simulations.get(index).getMax().y) {
				
				simulations.get(index).getEntities().remove(simulations.get(index).getEntities().size()-1);
				return;
			}
		}
		
		// loop through entities
		for(Entity entity : simulations.get(index).getEntities()) {
			
			// check that the entities to check collision for are not the same entity
			if (!newEntity.equals(entity)) {
				
				if (newEntity.intersects(entity)) {
					
					simulations.get(index).getEntities().remove(simulations.get(index).getEntities().size()-1);
					return;
				}
			}
		}
		
	}
}
