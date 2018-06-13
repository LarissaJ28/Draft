package objects;

/**
 * This class is the blueprint for models to be 
 * rendered in OpenGL.
 * 
 * @author Cindy Li
 * @author Larissa Jin
 * @since Monday, April 16th, 2018
 */
public class Model {

	// instance variables
	private int vaoID;
	private int textureID;
	private int vertexCount;
	
	/**
	 * Creates a model.
	 * 
	 * @param vaoID
	 * @param vertexCount
	 * @param textureID
	 */
	public Model(int vaoID, int vertexCount, int textureID) {
		
		this.vaoID = vaoID;
		this.textureID = textureID;
		this.vertexCount = vertexCount;
	}

	/**
	 * Returns the model's VAO ID.
	 * 
	 * @return vaoID
	 */
	public int getVaoID() {
		return vaoID;
	}

	/**
	 * Returns the model's vertex count.
	 * 
	 * @return vertexCount
	 */
	public int getVertexCount() {
		return vertexCount;
	}

	/**
	 * Returns the model's texture ID.
	 * 
	 * @return textureID
	 */
	public int getTextureID() {
		return textureID;
	}
	
	/**
	 * Sets the model's texture ID
	 * @param texture	the texture file
	 * @param loader
	 */
	public void setTextureID(String texture, Loader loader) {
		this.textureID = loader.loadTexture(texture);
	}
	
}
