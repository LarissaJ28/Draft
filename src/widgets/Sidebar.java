package widgets;

import java.util.ArrayList;

import org.joml.Vector3f;

import objects.Entity;
import objects.Loader;
import objects.Model;
import widgets.Button;

public class SideBar {

	private static ArrayList<Button> buttons;
	public static Button lev,lev1,lev2,lev3,lev4;
	private static String Lev_BUTTON_TEXTURE_FILE = "./res/Lev.png";
	private static String Lev1_BUTTON_TEXTURE_FILE = "./res/Lev1.png";
	private static String Lev2_BUTTON_TEXTURE_FILE = "./res/Lev2.png";
	private static String Lev3_BUTTON_TEXTURE_FILE = "./res/Lev3.png";
	private static String Lev4_BUTTON_TEXTURE_FILE = "./res/Lev4.png";
	
	public static ArrayList<Button> sideg(Loader loader, float screenWidth, float screenHeight, float z) 
	{
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
		
		int textureID = loader.loadTexture(Lev_BUTTON_TEXTURE_FILE);
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
		
		
		ArrayList<Button> buttons = new ArrayList<Button>();
		buttons.add(lev);
		buttons.add(lev1);
		buttons.add(lev2);
		buttons.add(lev3);
		buttons.add(lev4);
		
		return buttons;
		
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
