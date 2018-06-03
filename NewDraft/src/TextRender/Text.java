package TextRender;

import java.util.ArrayList;

import org.joml.Vector3f;

import objects.Entity;
import objects.Loader;
import objects.Model;
import widgets.Button;
import widgets.GUIComponent;
/**
 * This class contains the methods for text rendering
 * 
 * @author Cindy Li
 * @author Larissa Jin
 * @since Monday, May 21th, 2018
 */
public class Text {

	private String str;
	private float x;
	private float y;
	private float height;
	private float width;
	private Loader loader;
	private float z;
	private ArrayList<GUIComponent> GUIlist = new ArrayList<GUIComponent>();
	
	//constructor
	public Text(String str, float x, float y, float z, float height, float width, Loader loader)
	{
		this.str = str;
		this.x = x;
		this.y = y;
		this.z = z;
		this.height = height;
		this.width = width;
		this.loader = loader;
		getList();

	}
	
	/**
	 * Changes a string of characters into an ArrayList of Strings
	 * 
	 * @returns ArrayList of each character
	 */
	private ArrayList<String> changeText()
	{
		int sizeS = this.str.length();
       
		ArrayList<String> New = new ArrayList<String>();
		for( int i=0;i<sizeS; i++)
		{
			if((Character.toString(this.str.charAt(i))).equals(" "))
			{
				New.add("space");
			}
			else {
			New.add(Character.toString(this.str.charAt(i)));
			}

		}

		return New;	
	}


	/**
	 * Changes a string of characters into an ArrayList of Strings
	 * 
	 * @param the string that needs to be rendered
	 * @return ArrayList of each character 
	 */
	private ArrayList<String> changeText(String str)
	{
		int sizeS = str.length();

		ArrayList<String> New = new ArrayList<String>();
		for( int i=0;i<sizeS; i++)
		{
			if((Character.toString(str.charAt(i))).equals(" "))
			{
				New.add("space");
			}
			else {
			New.add(Character.toString(str.charAt(i)));
			}

		}

		return New;	
	}
	
	/**
	 * Returns the position of the string
	 * (most left x value)
	 * 
	 * @return x value position
	 */
	public float getPositionOfLineX()
	{
		return x;
		
	}

	/**
	 * Returns the position of the string
	 * (bottom y value)
	 * 
	 * @return y value position
	 */
	public float getPositionOfLineY()
	{
		return y;
	}
	
	/**
	 * sets the position of the string
	 * 
	 * @param x changes the strings x value
	 */
	public void setPositionX(float x)
	{
		this.x=x;
		for (int i = 0 ; i<GUIlist.size();i++)
		{
			Vector3f New = new Vector3f(x+width/2 +0.3f*width*i,y+height,z);
			GUIlist.get(i).setPosition(New);
		}
	}
	
	/**
	 * sets the position of the string
	 * 
	 * @param y changes the strings y value
	 */
	public void setPositionY(float y)
	{
		this.y=y;
		for (int i = 0 ; i<GUIlist.size();i++)
		{
			Vector3f New = new Vector3f(x+width/2 +0.3f*width*i,y+height,z);
			GUIlist.get(i).setPosition(New);
		}
	}
	/**
	 * sets the position of the string
	 * 
	 * @param z changes the strings z value
	 */
	public void setPositionZ(float z)
	{
		this.z=z;
		for (int i = 0 ; i<GUIlist.size();i++)
		{
			Vector3f New = new Vector3f(x+width/2 +0.3f*width*i,y+height,z);
			GUIlist.get(i).setPosition(New);
		}
	}
	
	public void setSize(int size)
	{
		this.height = this.height*size;
		this.width = this.width*size;
		
	}
	
	/**
	 * Returns the height of the string
	 * 
	 * @return height gets the strings height
	 */
	public float getHeight()
	{
		return height;

	}

	/**
	 * Returns the width of the string
	 * 
	 * @return width gets the strings width
	 */
	public float getWidth()
	{
		return width;
	}


	/**
	 * Creates each character of the string as a quad
	 * Saves all the quads into the Guilist ArrayList
	 * 
	 * 
	 */
	public void getList(){
		ArrayList<String> list = new ArrayList<String>();
		list = changeText();
		int size = list.size();


		for(int i = 0; i<size;i++ )
		{
			float height = this.height;
			float width = this.width;
			float x = this.x +width/2 +0.3f*width*i;
			float y = this.y+height;
			float z=this.z;

			float[] vertices = Entity.getVertices(width, height, z);
			float[] texCoords = Entity.getTexCoords();
			int[] indices = Entity.getIndices();

			Vector3f rotation = new Vector3f(0,0,0);
			float scale = 1f;

			Vector3f Pos = new Vector3f(x, y, z);
			
			
			 int textureID = loader.loadTexture("./num/"+list.get(i)+".png");
			
			Model nButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);

			Button letter = new Button(nButtonModel, Pos, rotation, scale, width, height);

			GUIlist.add(letter);
		}


	}

	/**
	 * Adds more spots in the GUIlist for other characters to be added 
	 * 
	 * @param index which index in the Arraylist the new character is going to be added to 
	 */
	public void addStr(int index)
	{
		float height = this.height;
		float width = this.width;
		float x = this.x +width/2 +0.3f*width*index;
		float y = this.y+height;
		float z=this.z;

		float[] vertices = Entity.getVertices(width, height, z);
		float[] texCoords = Entity.getTexCoords();
		int[] indices = Entity.getIndices();

		Vector3f rotation = new Vector3f(0,0,0);
		float scale = 1f;

		Vector3f Pos = new Vector3f(x, y, z);

		int textureID = loader.loadTexture("./num/1.png");
		Model nButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);

		Button letter = new Button(nButtonModel, Pos, rotation, scale, width, height);

		GUIlist.add(letter);
	}





	/**
	 * Changes the rendered texts characters
	 * 
	 * @param str The string that the rendered text is going to be changed to 
	 */
	public void changeStr(String str)
	{

		int length = this.str.length();
		str.replaceAll(" ","space");
		ArrayList<String> intList = changeText(str);
		if(length==str.length())
		{
			for(int i = 0; i<length;i++)
			{
				GUIlist.get(i).getModel().setTextureID("./num/"+intList.get(i)+".png", loader);
			}

		}
		else if(length<str.length())
		{
			for(int i = 0; i<length;i++)
			{
				GUIlist.get(i).getModel().setTextureID("./num/"+intList.get(i)+".png", loader);
			}
			for(int n= length;n<str.length();n++)
			{
				addStr(n);
				GUIlist.get(n).getModel().setTextureID("./num/"+intList.get(n)+".png", loader);

			}
		}
		else if(length>str.length())
		{
			for(int i = 0; i<str.length();i++)
			{
				GUIlist.get(i).getModel().setTextureID("./num/"+intList.get(i)+".png", loader);
			}
			for(int n=length-1;n>=str.length();n--)
			{

				GUIlist.remove(n);

			}
		}
		this.str = str;
	}


	/**
	 * Returns the list of quads containing the characters 
	 * 
	 * @return GUIlist ArrayList of quads to be rendered
	 */
	public ArrayList<GUIComponent> getGUIlist()
	{
		return GUIlist;
	}
}
