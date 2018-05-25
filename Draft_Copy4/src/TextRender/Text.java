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
	public Text(String str, float x, float y, float z, float height, float width, Loader loader)
	{
		this.str = str;
		this.x = x;
		this.y = y;
		this.z = z;
		this.height = height;
		this.width = width;
		this.loader = loader;
		
		
	}
	private ArrayList<Integer> changeText()
	{
		int sizeS = this.str.length();

		ArrayList<String> New = new ArrayList<String>();
		for( int i=0;i<sizeS; i++)
		{
			New.add(Character.toString(this.str.charAt(i)));
		}
		
		ArrayList<Integer> integer = new ArrayList<Integer>();
		for(int i=0; i<sizeS;i++)
		{
			integer.add(Integer.parseInt(New.get(i)));
		}
		
		return integer;	
	}
	 public void setPositionOfLine(float x, float y)
	 {
		 this.x = x;
		 this.y=y;
	 }
	 
	 public float getPositionOfLineX()
	 {
		 return x;
	 }
	 
	 public float getPositionOfLineY()
	 {
		 return y;
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
	 
	 public ArrayList<GUIComponent> getList(){
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 list = changeText();
		 int size = list.size();
		 ArrayList<GUIComponent> gui = new ArrayList<GUIComponent>();
		 
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
				
				gui.add(letter);
		 }
		 
		 return gui;
	 }
}
