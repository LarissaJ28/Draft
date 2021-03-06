package TextRender;

import java.util.ArrayList;

import org.joml.Vector3f;

import objects.Entity;
import objects.Loader;
import objects.Model;
import widgets.Button;
import widgets.GUIComponent;

public class Text {

	private String str;
	private float x;
	private float y;
	private float height;
	private float width;
	private Loader loader;
	private float z;
	private ArrayList<GUIComponent> GUIlist = new ArrayList<GUIComponent>();
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
	
	public float getPositionOfLineX()
	{
		return x;
		
	}

	public float getPositionOfLineY()
	{
		return y;
	}
	
	public void setPositionX(float x)
	{
		this.x=x;
		for (int i = 0 ; i<GUIlist.size();i++)
		{
			Vector3f New = new Vector3f(x+width/2 +0.3f*width*i,y+height,z);
			GUIlist.get(i).setPosition(New);
		}
	}
	public void setPositionY(float y)
	{
		this.y=y;
		for (int i = 0 ; i<GUIlist.size();i++)
		{
			Vector3f New = new Vector3f(x+width/2 +0.3f*width*i,y+height,z);
			GUIlist.get(i).setPosition(New);
		}
	}
	
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
	public float getHeight()
	{
		return height;

	}

	public float getWidth()
	{
		return width;
	}

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

	public ArrayList<GUIComponent> getGUIlist()
	{
		return GUIlist;
	}
}
