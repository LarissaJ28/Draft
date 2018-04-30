package widgets;

import java.util.ArrayList;

import org.joml.Vector3f;

import objects.Entity;
import objects.Loader;
import objects.Model;
import widgets.Button;

public class sideBar1 {

	private static ArrayList<Button> buttonslevels;
	private static ArrayList<Button> buttonscust= new ArrayList<Button>();
	
	public static Button lev,lev1,lev2,lev3,lev4, Backg;
	private static String Lev_BUTTON_TEXTURE_FILE = "./res/Lev.png";
	private static String Lev1_BUTTON_TEXTURE_FILE = "./res/Lev1.png";
	private static String Lev2_BUTTON_TEXTURE_FILE = "./res/Lev2.png";
	private static String Lev3_BUTTON_TEXTURE_FILE = "./res/Lev3.png";
	private static String Lev4_BUTTON_TEXTURE_FILE = "./res/Lev4.png";
	private static String background = "./res/background.png";
	
//	public static ArrayList<Button> sideg(Loader loader, float screenWidth, float screenHeight, float z) 
//	{
//		float buttonWidth = 70f;
//		float buttonHeight = 80f;
//		float mButtonX = -450;
//		
//		float ButtonY = 200;
//		Vector3f lButtonPos = new Vector3f(mButtonX, ButtonY, z);
//		
//		float ButtonY1 =  ButtonY-buttonHeight;
//		Vector3f ButtonPos1 = new Vector3f(mButtonX, ButtonY1, z);
//		
//
//		float ButtonY2 =  ButtonY1-buttonHeight;
//		Vector3f ButtonPos2 = new Vector3f(mButtonX, ButtonY2, z);
//		
//
//		float ButtonY3 =  ButtonY2-buttonHeight;
//		Vector3f ButtonPos3 = new Vector3f(mButtonX, ButtonY3, z);
//		
//
//		float ButtonY4 =  ButtonY3-buttonHeight;
//		Vector3f ButtonPos4 = new Vector3f(mButtonX, ButtonY4, z);
//		
//		float[] vertices = Entity.getVertices(buttonWidth, buttonHeight, z);
//		float[] texCoords = Entity.getTexCoords();
//		int[] indices = Entity.getIndices();
//		
//		Vector3f rotation = new Vector3f(0,0,0);
//		float scale = 1f;
//		
//		int textureID = loader.loadTexture(Lev_BUTTON_TEXTURE_FILE);
//		Model lButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);
//		
//		lev = new Button(lButtonModel, lButtonPos, rotation, scale, buttonWidth, buttonHeight);
//		
//		 textureID = loader.loadTexture(Lev1_BUTTON_TEXTURE_FILE);
//		Model ButtonModel1 = loader.loadToVAO(vertices, texCoords, indices, textureID);
//		
//		lev1 = new Button(ButtonModel1, ButtonPos1, rotation, scale, buttonWidth, buttonHeight);
//		
//		 textureID = loader.loadTexture(Lev2_BUTTON_TEXTURE_FILE);
//			Model ButtonModel2 = loader.loadToVAO(vertices, texCoords, indices, textureID);
//			
//		lev2 = new Button(ButtonModel2, ButtonPos2, rotation, scale, buttonWidth, buttonHeight);
//		
//		 textureID = loader.loadTexture(Lev3_BUTTON_TEXTURE_FILE);
//				Model ButtonModel3 = loader.loadToVAO(vertices, texCoords, indices, textureID);
//				
//		lev3 = new Button(ButtonModel3, ButtonPos3, rotation, scale, buttonWidth, buttonHeight);
//				
//		textureID = loader.loadTexture(Lev4_BUTTON_TEXTURE_FILE);
//				Model ButtonModel4 = loader.loadToVAO(vertices, texCoords, indices, textureID);
//		
//		lev4 = new Button(ButtonModel4, ButtonPos4, rotation, scale, buttonWidth, buttonHeight);
//		
//		
//		ArrayList<Button> buttonslevels = new ArrayList<Button>();
//		buttonslevels.add(lev);
//		buttonslevels.add(lev1);
//		buttonslevels.add(lev2);
//		buttonslevels.add(lev3);
//		buttonslevels.add(lev4);
//		
//		return buttonslevels;
//		
//	}
	
	public static ArrayList<Button>  sidec(Loader loader, float screenWidth, float screenHeight, float z)
	{
		float width = 80f;
		float height = 75f;
		float x = -450;
		float y = -42;
		
		Vector3f ButtonPos = new Vector3f(x, y, z);
		
		
		
		float buttonWidth = 70f;
		float buttonHeight = 80f;
		float mButtonX = -450;
		
		float ButtonY = 200;
		Vector3f lButtonPos = new Vector3f(mButtonX, ButtonY, z);
		
		float ButtonY1 =  ButtonY-buttonHeight;
		Vector3f ButtonPos1 = new Vector3f(mButtonX, ButtonY1, z);
		

		float ButtonY2 =  ButtonY1-buttonHeight;
		Vector3f ButtonPos2 = new Vector3f(mButtonX, ButtonY2, z);
		

		float ButtonY3 =  ButtonY2-buttonHeight;
		Vector3f ButtonPos3 = new Vector3f(mButtonX, ButtonY3, z);
		

		float ButtonY4 =  ButtonY3-buttonHeight;
		Vector3f ButtonPos4 = new Vector3f(mButtonX, ButtonY4, z);
		
		float[] vertices = Entity.getVertices(buttonWidth, buttonHeight, z);
		float[] texCoords = Entity.getTexCoords();
		int[] indices = Entity.getIndices();
		
		Vector3f rotation = new Vector3f(0,0,0);
		float scale = 1f;
		
		int textureID = loader.loadTexture(background);
		Model back = loader.loadToVAO(vertices, texCoords, indices, textureID);
		
		Backg = new Button(back, ButtonPos, rotation, scale, width, height);
		
		 textureID = loader.loadTexture(Lev_BUTTON_TEXTURE_FILE);
		Model lButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);
		
		lev = new Button(lButtonModel, lButtonPos, rotation, scale, buttonWidth, buttonHeight);
		
		
		
		 textureID = loader.loadTexture(Lev1_BUTTON_TEXTURE_FILE);
		Model ButtonModel1 = loader.loadToVAO(vertices, texCoords, indices, textureID);
		
		lev1 = new Button(ButtonModel1, ButtonPos1, rotation, scale, buttonWidth, buttonHeight);
		
		 textureID = loader.loadTexture(Lev2_BUTTON_TEXTURE_FILE);
			Model ButtonModel2 = loader.loadToVAO(vertices, texCoords, indices, textureID);
			
		lev2 = new Button(ButtonModel2, ButtonPos2, rotation, scale, buttonWidth, buttonHeight);
		
		 textureID = loader.loadTexture(Lev3_BUTTON_TEXTURE_FILE);
				Model ButtonModel3 = loader.loadToVAO(vertices, texCoords, indices, textureID);
				
		lev3 = new Button(ButtonModel3, ButtonPos3, rotation, scale, buttonWidth, buttonHeight);
				
		textureID = loader.loadTexture(Lev4_BUTTON_TEXTURE_FILE);
				Model ButtonModel4 = loader.loadToVAO(vertices, texCoords, indices, textureID);
		
		lev4 = new Button(ButtonModel4, ButtonPos4, rotation, scale, buttonWidth, buttonHeight);
		
		
		
		buttonscust.add(Backg);
		buttonscust.add(lev);
		buttonscust.add(lev1);
		buttonscust.add(lev2);
		buttonscust.add(lev3);
		buttonscust.add(lev4);
		
		return buttonscust;
		
		
	}
	 public static Button sidecAdd (Loader loader, float screenWidth, float screenHeight, float z, float index)
	 {
		 float buttonWidth = 70f;
			float buttonHeight = 80f;
			float ButtonX = -450;
			
			float ButtonY = 200 - (4+index)*buttonHeight;
			System.out.println(index);
			Vector3f ButtonPos = new Vector3f(ButtonX, ButtonY, z);
			
			float[] vertices = Entity.getVertices(buttonWidth, buttonHeight, z);
			float[] texCoords = Entity.getTexCoords();
			int[] indices = Entity.getIndices();
			
			Vector3f rotation = new Vector3f(0,0,0);
			float scale = 1f;
			
			int textureID = loader.loadTexture(Lev_BUTTON_TEXTURE_FILE);
			Model ButtonModel = loader.loadToVAO(vertices, texCoords, indices, textureID);
			
		 Button newB = new Button(ButtonModel, ButtonPos, rotation, scale, buttonWidth, buttonHeight);
		 
		 buttonscust.add(newB);
		 return newB;
		 
	 }
	public Button lev1()
	{
		return lev1;
	}
	
	public Button lev2()
	{
		return lev2;
	}
	
	public Button lev3()
	{
		return lev3;
	}
	
	public Button lev4()
	{
		return lev4;
	}
}
