package objects;
import org.joml.Vector2f;
import org.joml.Vector3f;

/**
 * This class specifies a rectangular entity. It manages and updates 
 * the rectangle's AABB bounding-box.
 * 
 * @author Cindy Li
 * @author Larissa Jin
 * @since Tuesday, April 17th, 2018
 */
public class Cannon extends Rectangle {

	// instance variables
	
	
	// constructor
	public Cannon(Model model, Vector3f position, Vector3f velocity, Vector3f acceleration, Vector3f rotation,
			float scale, float mass, float e, float width, float height, float staticFriction, 
			float kineticFriction) {
		
		super(model, position, velocity, acceleration, rotation, scale, mass, e,width,height, 
				staticFriction, kineticFriction);
		
	}

	

}
