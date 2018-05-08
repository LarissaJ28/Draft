package io;


	import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
	import static org.lwjgl.glfw.GLFW.glfwGetKey;
	import static org.lwjgl.opengl.GL11.GL_TRUE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
	import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
	import java.util.Scanner;

	import org.joml.Vector3f;

import objects.Circle;
import objects.Entity;

import objects.Rectangle;
import widgets.Button;
import widgets.SidebarCust;
import widgets.SimulationWindow;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_UP;
	import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT;
	import static org.lwjgl.glfw.GLFW.*;
	
	public class IOreader {
		
		private int num;
		private String filePath ="1.txt";
		private static String type;
		private static float x;
		private static float y;
		private static float z;
		private static float sidelength;
		private static float e;
		private static float mass;
		private static SidebarCust sidebar;
		
		public static void getSimulation(String filePath, SimulationWindow simulation)
		{
			
			IO.appendOutputFile("./Customized/"+filePath+".txt");
			IO.openInputFile("./Customized/"+filePath+".txt");
			int num8=0;
			String line;
			
			try {
				
				line = IO.readLine();
				
				//while the line is not empty
				while (line != null)
				{
					num8++;
					
					if(num8%7 ==0)// seventhline
					{
					  e =Float.parseFloat(line);
					}
					if((num8+1)%7 ==0)// sixth line
					{
						 mass =Float.parseFloat(line);
					}
					if((num8 + 2)%7 ==0)//fifth line
					{
						z =Float.parseFloat(line);
					}
					if((num8+3)%7 ==0)//fourthline
					{
						y = Float.parseFloat(line);
					}
					
					if((num8+4)%7 ==0)//third line
					{
						 x =Float.parseFloat(line);
					}
					if((num8+5)%7 ==0)//second line
					{
						 sidelength = Float.parseFloat(line);
					}
					if((num8+6)%7 == 0)//first line
					{
						 type = line;
					}
					if(num8%7==0)
					{
						
						if ( type.equals("Rect"))
						{
							
							simulation.createCrateEntity(sidelength, x, y, z, mass, e);
							
						}
						
						if(type.equals("Circ"))
						{
							simulation.createBallEntity(sidelength, x, y, z, mass, e);
						}
					}
					line=IO.readLine(); //read the next line
					
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			IO.closeOutputFile();
			try {
				IO.closeInputFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//return entities;
		}
		
		public static int getButtons()
		{
			IO.appendOutputFile("./Customized/Customize.txt");
			IO.openInputFile("./Customized/Customize.txt");
			
			String line;
			int integer=0;
			try {
				
				line = IO.readLine();
				
				//while the line is not empty
				while (line != null)
				{
					integer = Integer.parseInt(line);
					
					line = IO.readLine();
				}
			}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			System.out.println(integer);
			
			IO.closeOutputFile();
			return integer;
		}
		
		public static void SaveButton(int size) {
			
			IO.createOutputFile("./Customized/Customize.txt");
			
			
			
			
			IO.println(String.valueOf(size));
			

			IO.closeOutputFile();
		}
		
		
		public static void saveSim(String filePath, SimulationWindow simulation)
		{
			createTxtFile(filePath);
			
			ArrayList<Entity> entities = new ArrayList<Entity>();
			ArrayList<Rectangle> rectangle = new ArrayList<Rectangle>();
			ArrayList<Circle> circle = new ArrayList<Circle>();
			IO.createOutputFile("./Customized/"+filePath+".txt");
			
			entities = simulation.getEntities();
			rectangle = simulation.getRectangles();
			circle = simulation.getCircle();
			
			int size = entities.size();
			for(int i=0;i<size;i++)
			{
			
			IO.println(entities.get(i).getType());
			if(entities.get(i).getType() == "Rect")
			{
				IO.println(String.valueOf(rectangle.get(i).getHeight()));
			}
			else
			{
				IO.println(String.valueOf(circle.get(0).getRadius()));
			}
			IO.println(String.valueOf(entities.get(i).getPosition().x));
			IO.println(String.valueOf(entities.get(i).getPosition().y));
			IO.println(String.valueOf(entities.get(i).getPosition().z));
			IO.println(String.valueOf(entities.get(i).getMass()));
			IO.println(String.valueOf(entities.get(i).getCoefficientOfRestitution()));
			
			}
				
			IO.closeOutputFile();
			try {
				IO.closeInputFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public static void createTxtFile(String filePath)
		{
			  try {
				     File file = new File("./Customized/"+filePath+".txt");
				     /*If file gets created then the createNewFile() 
				      * method would return true or if the file is 
				      * already present it would return false
				      */
			             boolean fvar = file.createNewFile();
				     if (fvar){
				          System.out.println("File has been created successfully");
				     }
				     else{
				          System.out.println("File already present at the specified location");
				     }
				     
				    
			    	} catch (IOException e) {
			    		System.out.println("Exception Occurred:");
				        e.printStackTrace();
				  }
			  
			  
		}
		
		public static void deleteTxtFile(int index, ArrayList<SimulationWindow> list)
		{try {
			for (int i = index; i<list.size();i++)
			{
				File file = new File("./Customized/Custom"+i+".txt");
				int nindex = i -1;
				File file2 = new File("./Customized/Custom"+nindex+".txt");

				if(file.renameTo(file2)){
					System.out.println("Rename succesful");
				}else{
					System.out.println("Rename failed");
				}
			}
			/*If file gets created then the createNewFile() 
			 * method would return true or if the file is 
			 * already present it would return false
			 */


			int nindex = list.size()-1;
			File file3 = new File("./Customized/Custom"+nindex+".txt");
			if (file3.delete()){

				System.out.println("File has been deleted successfully");
			}
			else{
				System.out.println("File has not been deleted");
			}
		}
		catch(Exception e){

			e.printStackTrace();

		}



		}


	}
