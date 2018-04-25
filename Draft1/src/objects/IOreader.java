package objects;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.opengl.GL11.GL_TRUE;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.joml.Vector3f;

import widgets.Button;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_UP;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT;
import static org.lwjgl.glfw.GLFW.*;
public class IOreader {
	
	private int num;
	private String filePath ="1.txt";
	
//	private static ArrayList<String> rect = new ArrayList<String>();
//	private static ArrayList<Integer> width= new ArrayList<Integer>();
//	private static ArrayList<Integer> height= new ArrayList<Integer>();
//	private static ArrayList<Integer> x= new ArrayList<Integer>();
//	private static ArrayList<Integer> y= new ArrayList<Integer>();
	
//	public static void flush() throws IOException
//	{
//		PrintWriter pw = new PrintWriter(new FileWriter(filePath));
//		String filePath = "1.txt";
//		pw.flush();
//		IO.closeOutputFile();
//		
//	}
	
	
	//method for inputting data and sorting data into the textfile
	public static void changeX(int n, long window)
	{
		int num8=0;
		Scanner s = new Scanner(System.in);
		
		ArrayList<String> rect = new ArrayList<String>();
		ArrayList<Integer> width= new ArrayList<Integer>();
		ArrayList<Integer> height= new ArrayList<Integer>();
		ArrayList<Integer> x= new ArrayList<Integer>();
		ArrayList<Integer> y= new ArrayList<Integer>();
		
		//sets string as filepath
		 String filePath = "1.txt";
		
		IO.appendOutputFile(filePath);
		IO.openInputFile(filePath);
		
		String line;
		
			try {
				
				line = IO.readLine();
				
				//while the line is not empty
				while (line != null)
				{
					num8++;
				
					
					
					//save the odd numbered lines as the score and even numbered as the users
					if(num8%5==0 )
					{
						//add the string in the line into the arraylist
						y.add(Integer.parseInt(line));
						//System.out.println("Test");
					}
					if((num8+1)%5 ==0)
					{
						x.add(Integer.parseInt(line));
					}
					 if((num8+2)%5 ==0)
					{
						height.add(Integer.parseInt(line));
					}
					 if((num8+3)%5 ==0)
					{
						width.add(Integer.parseInt(line));
					}
					 if((num8+4)%5 ==0)
					{
						rect.add(line);
					}
						
					line=IO.readLine(); //read the next line
					
					//System.out.println(num8);
				}
				}
				
				catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	
		
		//create a new textfile
		IO.createOutputFile(filePath);
		
		System.out.println(y.get(n));
		int num1 =0;
		while(num1==0)
		{
		if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE)
		{
			y.set(n,y.get(n)-50);
		}
		
		if(glfwGetKey(window, GLFW_KEY_UP) == GL_TRUE)
		{
			y.set(n,y.get(n)+50);
		}
		
		if(glfwGetKey(window, GLFW_KEY_LEFT) == GL_TRUE)
		{
			x.set(n,x.get(n)+50);
		}
		
		
		if(glfwGetKey(window, GLFW_KEY_RIGHT) == GL_TRUE)
		{
			x.set(n,x.get(n)+50);
		}
		if(glfwGetKey(window, GLFW_KEY_ENTER) == GL_TRUE)
		{
			num1=1;
		}
		}
		int size=height.size();
		
		//System.out.println(size);
	
	//outprint everything in the arraylists into the textfile again
	for(int i=0;i<size;i++)
	{
	
	IO.println(rect.get(i));
	IO.println(width.get(i)+"");
	IO.println(height.get(i)+"");
	IO.println(x.get(i)+"");
	IO.println(y.get(i)+"");
	
	}
		
	IO.closeOutputFile();
	
	IO.openInputFile(filePath);
		
	}
	public static void add(int n)  {
		
		int trck=0;
		int num8=0;
		Scanner s = new Scanner(System.in);
		
		ArrayList<String> rect = new ArrayList<String>();
		ArrayList<Integer> width= new ArrayList<Integer>();
		ArrayList<Integer> height= new ArrayList<Integer>();
		ArrayList<Integer> x= new ArrayList<Integer>();
		ArrayList<Integer> y= new ArrayList<Integer>();
		
		//sets string as filepath
		 String filePath = "1.txt";
		
		IO.appendOutputFile(filePath);
		IO.openInputFile(filePath);
		
		String line;
		
			try {
				
				line = IO.readLine();
				
				//while the line is not empty
				while (line != null)
				{
					num8++;
				
					
					
					//save the odd numbered lines as the score and even numbered as the users
					if(num8%5==0 )
					{
						//add the string in the line into the arraylist
						y.add(Integer.parseInt(line));
						//System.out.println("Test");
					}
					if((num8+1)%5 ==0)
					{
						x.add(Integer.parseInt(line));
					}
					 if((num8+2)%5 ==0)
					{
						height.add(Integer.parseInt(line));
					}
					 if((num8+3)%5 ==0)
					{
						width.add(Integer.parseInt(line));
					}
					 if((num8+4)%5 ==0)
					{
						rect.add(line);
					}
						
					line=IO.readLine(); //read the next line
					trck++;
					//System.out.println(num8);
				}
				}
				
				catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		//create a new textfile
		IO.createOutputFile(filePath);
		
		
		
			//add the user and score into the array
			y.add(0);
			x.add(0);
			height.add(70);
			width.add(70);
			rect.add("rect"+n);			
			int size=height.size();
	
			//System.out.println(size);
		
		//outprint everything in the arraylists into the textfile again
		for(int i=0;i<size;i++)
		{
		
		IO.println(rect.get(i));
		IO.println(width.get(i)+"");
		IO.println(height.get(i)+"");
		IO.println(x.get(i)+"");
		IO.println(y.get(i)+"");
		
		}
	System.out.println(size);
		IO.closeOutputFile();
		
		IO.openInputFile(filePath);

	}
	
	//method for getting the scores
	public static ArrayList getWidth(int file)
	{
		 String filePath = file+".txt";
		ArrayList<Integer> width= new ArrayList<Integer>();
		
		IO.openInputFile(filePath);
		int num8=0;
		try {
			
			String line = IO.readLine();
			while (line != null)
			{
				num8++;
				
				
				
				if((num8+3)%5==0)//get all odd numbered lines
				{
					
					width.add(Integer.parseInt(line)); //save the numbers
				}
				
				line=IO.readLine();
				
			}
			}
			
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return width; //return the arraylist with the saved scores 
	}
	//method for getting the users
	public static ArrayList getHeight(int file)
	{
		ArrayList<Integer> height= new ArrayList<Integer>();
		
		 String filePath = file+".txt";
		
		IO.openInputFile(filePath);
		int num8=0;
		try {
			
			String line = IO.readLine();
			while (line != null)
			{
				num8++;

				if((num8+2)%5==0) //get all even numbered lines
				{
					
					height.add(Integer.parseInt(line));//save the users 
				}
				
				line=IO.readLine();
				
			}
			}
			
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return height; //return the arraylist with the saved users
	}
	
	public static ArrayList getX(int file)
	{
		ArrayList<Integer> X= new ArrayList<Integer>();
		
		 String filePath = file+".txt";
		
		IO.openInputFile(filePath);
		int num8=0;
		try {
			
			String line = IO.readLine();
			while (line != null)
			{
				num8++;

				if((num8+1)%5==0) //get all even numbered lines
				{
					
					X.add(Integer.parseInt(line));//save the users 
				}
				
				line=IO.readLine();
				
			}
			}
			
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return X; //return the arraylist with the saved users
	}
	
	public static ArrayList getY(int file)
	{
		ArrayList<Integer> Y= new ArrayList<Integer>();
		
		 String filePath = file+".txt";
		
		IO.openInputFile(filePath);
		int num8=0;
		try {
			
			String line = IO.readLine();
			while (line != null)
			{
				num8++;

				if((num8)%5==0) //get all even numbered lines
				{
					
					Y.add(Integer.parseInt(line));//save the users 
				}
				
				line=IO.readLine();
				
			}
			}
			
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Y; //return the arraylist with the saved users
	}
	}









