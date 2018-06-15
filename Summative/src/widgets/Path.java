package widgets;

import java.util.ArrayList;

import org.joml.Vector3f;

import objects.Entity;
import objects.Loader;
import objects.Model;
import renderEngine.Renderer;

/**
 * This class creates the path of a ball
 * 
 * @author Cindy Li
 * @author Larissa Jin
 * @since Thursday, April 26th, 2018
 */
public class Path {

	//instance variables
	private static final String PATH_TEXTURE_FILE = "./res/Path.png";
	private Button pathButton;
	private ArrayList<GUIComponent> guiComponents = new ArrayList<GUIComponent>();
	
	/**
	 * Creates a model of where the traced ball is
	 * 
	 * @param loader  This is the current loader
	 * @param x       This is the x value of the ball that's path is being traced
	 * @param y       This is the y value of the ball that's path is being traced
	 * @param z        This is the z value of the ball that's path is being traced
	 */
	public void trajectory(Loader loader,  float x,float y, float z)
	{

		float buttonWidth = 10f;
		float buttonHeight = 10f;

		float[] vertices = Entity.getVertices(buttonWidth, buttonHeight, z);
		float[] texCoords = Entity.getTexCoords();
		int[] indices = Entity.getIndices();

		Vector3f rotation = new Vector3f(0,0,0);
		float scale = 1f;

		Vector3f paButtonPos = new Vector3f(x, y, z);

		int textureID = loader.loadTexture(PATH_TEXTURE_FILE);
		Model paButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);

		pathButton = new Button(paButtonModel, paButtonPos, rotation, scale, buttonWidth, buttonHeight);


		guiComponents.add(pathButton);
	}
	/**
	 * Renders the objects of the simulation window.
	 * 
	 * @param renderer		the renderer
	 */
	public void render(Renderer renderer) {
		
		renderer.renderGUI(guiComponents);
	}
	
	/**
	 * deletes the path that was created
	 */
	public void delete()
	{
		guiComponents.clear();
	}
	
}
