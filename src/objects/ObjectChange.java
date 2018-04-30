package objects;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ENTER;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_UP;
import static org.lwjgl.glfw.GLFW.glfwGetCursorPos;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.opengl.GL11.GL_TRUE;

import java.nio.DoubleBuffer;
import java.util.ArrayList;

import org.joml.Vector2f;
import org.lwjgl.BufferUtils;

import widgets.GUIComponent;
import widgets.SimulationWindow;

public class ObjectChange {

	public static void changepos ( long window, float screenWidth, float screenHeight, SimulationWindow s)
	{
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
				
				ArrayList<Entity> sim = s.getEntities();
				int size = sim.size();
				
				Entity e = sim.get(size-1);
				e.setPosition(x,y);
				
				if (e instanceof Rectangle) {
					Rectangle r = (Rectangle) e;
					
					r.getAabb().setMin(new Vector2f(r.getPosition().x - r.getWidth()/2, r.getPosition().y - r.getHeight()/2)); 
					r.getAabb().setMax(new Vector2f(r.getPosition().x + r.getWidth()/2, r.getPosition().y + r.getHeight()/2));
				}
				
	}
	
	public static boolean insidesim(Rectangle rect, SimulationWindow sim)
	{
		if(rect.getAabb().getMin().x < sim.getMin().x || rect.getAabb().getMax().x > sim.getMax().x) {
			return false;
		}
		
		if(rect.getAabb().getMin().y < sim.getMin().y || rect.getAabb().getMax().y > sim.getMax().y) {
			return false;
		}
		
		for(Entity entity : sim.getEntities())
		{
			boolean notItself = false;
			
			if(entity instanceof Rectangle) {
				
				if (!((Rectangle) entity).equals(rect)) {
					notItself = true;
				}
			}
			else {
				notItself = true;
			}
			
			if (notItself) {
				
				if (entity.intersects(rect)) {
					return false;
				}
			}
		}
		return true;
		
//		ArrayList<Entity> sim = SimulationWindow.getEntity();
//		int size = sim.size();
//		System.out.println(sim.get(size-1).min());
//		float[] de = new float[4];
//		 de = SimulationWindow.simWindow();	
//		 float Minx= de[0];
//		 float Maxx = de[1];
//		 float Miny = de[2]+35f;
//		 float Maxy =de[3] + 35f;
//		for (int i=0; i<4; i++)
//		{
//			
//			System.out.println(de[i]);
//		}
//		de = sim.get(size-1).min();
//		for (int i=0; i<4; i++)
//		{
//			
//			
//		}
//		float x = sim.get(size-1).getPosition().x;
//		float y = sim.get(size-1).getPosition().y;
//		System.out.println("width" + width+ " Height"+height);
//		float xMin = x-width/2;
//		float xMax = x+width/2;
//		float yMin = y-height/2;
//		float yMax = y+height/2;
//		System.out.println(xMin+" "+xMax+" "+yMin+" "+yMax);
//		AABB aabb = new AABB(new Vector2f(xMin, yMin), new Vector2f(xMax, yMax));
//		Boolean inside =false;
////		if(Minx<=xMin && Maxx >=xMax && Miny<=yMin &&Maxy>=yMax)
////		{
////			inside=true;
////			System.out.println(inside);
////		}
//		 //Boolean inside = SimulationWindow.sim1Window().intersects(aabb);
//		return inside;
		
	}
	public static void down(Rectangle rect, SimulationWindow sim)
	{
		Boolean inside = insidesim(rect, sim);
		System.out.println(inside);
		if(inside==false)
		{
			sim.getEntities().remove(sim.getEntities().size()-1);
		}
	}
	
	public static ArrayList<GUIComponent> scrollside(ArrayList<GUIComponent> guiComponents, long window)
	{
		int size = guiComponents.size();
		if(glfwGetKey(window, GLFW_KEY_UP) == GL_TRUE)
		{
		for (int i=0 ; i<size; i++)
		{
			guiComponents.get(i).changey(10f);
		}
		}
		
		if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE)
		{
			for (int i=0 ; i<size; i++)
			{
				guiComponents.get(i).changey(-10f);
			}
		}
		return guiComponents;
	}
}
