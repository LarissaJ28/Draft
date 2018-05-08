package widgets;

import java.util.ArrayList;

import org.joml.Vector3f;

import objects.Entity;
import objects.Loader;
import objects.Model;
import renderEngine.Renderer;


public class Path {

	private static final String PATH_TEXTURE_FILE = "./res/Path.png";
	
	private Button pathButton;
	private ArrayList<GUIComponent> guiComponents = new ArrayList<GUIComponent>();
	
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
		// info button
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
	
	public void delete()
	{
		guiComponents.clear();
	}
	
}
