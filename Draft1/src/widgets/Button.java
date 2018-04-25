package widgets;

import org.joml.Vector2f;
import org.joml.Vector3f;

import objects.AABB;
import objects.Model;

/**
 * This class is the blueprint for buttons to 
 * be rendered in OpenGL.
 * 
 * @author Cindy Li
 * @author Larissa Jin
 * @since Thursday, April 19th, 2018
 */
public class Button extends GUIComponent {

	// instance variables
	private AABB aabb;
	
	// constructor
	public Button(Model model, Vector3f position, Vector3f rotation, float scale, float width, float height) {
		
		super(model, position, rotation, scale);
		
		// create AABB
		
		float xMin = position.x - width/2;
		float xMax = position.x + width/2;
		float yMin = position.y - height/2;
		float yMax = position.y + height/2;
		
		this.aabb = new AABB(new Vector2f(xMin, yMin), new Vector2f(xMax, yMax));
	}
	
	public float[] button (float x, float x2, float y, float y2, float sHeight, float sWidth)
	{
		float X = x/(sWidth/2)-1;
		float X2 = x2/(sWidth/2)-1;
		float Y = -y/(sHeight/2)+1;
		float Y2 = -y2/(sHeight/2)+1;
		
		this.aabb = new AABB(new Vector2f(X, Y2), new Vector2f(X2,Y));
		
		float[] button = new float[]
				{
						 X,  Y,0,
						 X2,  Y,0,
						 X2,  Y2,0,
						 X,  Y2 ,0,
					
						
				};
		
		return button;
	}
	
	/**
	 * Returns the button's AABB.
	 * 
	 * @return aabb
	 */
	public AABB getAabb() {
		return aabb;
	}

}
