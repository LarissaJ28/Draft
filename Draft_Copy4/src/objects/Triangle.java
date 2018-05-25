package objects;

import org.joml.Vector2f;
import org.joml.Vector3f;

public class Triangle extends Entity {
	// instance variables
		private float base;
		private float height;
		
		private AABB aabb;
		
		// constructor
		public Triangle(Model model, Vector3f position, Vector3f velocity, Vector3f acceleration, Vector3f rotation,
				float scale, float mass, float e, float base, float height, float staticFriction, float kineticFriction) {
			
			super(model, position, velocity, acceleration, rotation, scale, mass, e, 
					staticFriction, kineticFriction);
			
			this.base = base;
			this.height = height;
			
			float xMin = position.x - base/2;
			float xMax = position.x + base/2;
			float yMin = position.y - height/2;
			float yMax = position.y + height/2;
					
			this.aabb = new AABB(new Vector2f(xMin, yMin), new Vector2f(new Vector2f(xMax, yMax)));
			
		}
		
		
		/**
		 * Checks whether or not this circle intersects another circle. 
		 * 
		 * @param c  the other circle
		 * @return true if they intersect, false otherwise
		 */
		public boolean intersects(Circle c) {
			
			float r = this.radius + c.getRadius();
			r *= r;
			
			return r > Math.pow(this.getPosition().x - c.getPosition().x, 2) 
					+ Math.pow(this.getPosition().y - c.getPosition().y, 2);
		}
		
		/**
		 * Checks whether or not this circle intersects with an AABB.
		 * 
		 * @param a  the AABB
		 * @return true if they intersect, false otherwise
		 */
		public boolean intersects(AABB a) {
			
			return a.intersects(this);
		}
		
		/**
		 * Checks whether or not this circle intersects with a point.
		 * 
		 * @param x		the x coordinate of the point
		 * @param y		the y coordinate of the point
		 * @return true if they intersect, false otherwise
		 */
		public boolean intersects(float x, float y) {
			
			System.out.println(this.aabb.getMax().x +"   "+ x);
			if (this.aabb.getMax().x>x && this.aabb.getMin().x<x && this.aabb.getMax().y>y && this.aabb.getMin().y<y)
			{
				float m = base/height;
				float b = this.getPosition().y - (m*this.getPosition().x);
				float yValue = m*this.getPosition().x +b;
				

				if(y<yValue)
				{
					return true;
					
				}
			}

			return false;
		}

		/**
		 * Returns the circle's radius.
		 * 
		 * @return radius
		 */
		public float getBase() {
			return base;
		}
		
		public float getHeight() {
			return height;
		}

		/**
		 * Sets the circle's radius.
		 * 
		 * @param radius
		 */
		public void setBase(float base) {
			this.base = base;
		}
		
		public void setHeight(float height) {
			this.height = height;
		}

}
