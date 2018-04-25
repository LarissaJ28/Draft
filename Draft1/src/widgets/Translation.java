package widgets;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.opengl.GL11.GL_TRUE;

import org.joml.Vector3f;

import objects.Model;

public class Translation {

	private static final int GLFW_KEY_LEFT = 0;
	public static void translate(float height, float width, float X,float Y, Vector3f rotation, float scale, Model model, long window)
	{
		
		//Vector3f nButtonPos = new Vector3f(BX, BY, z1);
		
		if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE)
		{
			
		}
		
		if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE)
		{
			
		}
		
		if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE)
		{
			
		}
		
		
		if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE)
		{
			
		}
	}
	public static void translate(long window, int i)
	{
		if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE)
		{
			
		}
		
		if(glfwGetKey(window, GLFW_KEY_LEFT) == GL_TRUE)
		{
			
		}
		
		if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE)
		{
			
		}
		
		
		if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE)
		{
			
		}
	}
}
