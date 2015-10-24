/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launch;

import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.material.Material;
import de.jarnbjo.oggtools.Player;

/**
 *
 * @author Jacob
 */
public class Launch extends SimpleApplication {

    private Geometry player;
    private Spatial ninja;
    private Spatial floor;

    public static void main(String[] args) {
        Launch app = new Launch();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Material mat_default = new Material(assetManager, "Common/MatDefs/Misc/ShowNormals.j3md");
        Material mat_brick = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        Spatial teapot = assetManager.loadModel("Models/Teapot/Teapot.obj");
        teapot.setMaterial(mat_default);
      //  rootNode.attachChild(teapot);
        
        Box floorDim = new Box (10f, 1f, 10f);
        floor = new Geometry("floor", floorDim);
        floor.setMaterial(mat_brick);
        floor.setLocalTranslation(0.0f, 0.0f, 0.0f);
        rootNode.attachChild(floor);
        
        // Create a wall with a simple texture from test_data
        Box b = new Box(2.5f, 2.5f, 1.0f);
        player = new Geometry("blue cube", b);
        Spatial wall = new Geometry("Box", b);
        mat_brick.setTexture("ColorMap", assetManager.loadTexture("Textures/Terrain/BrickWall/BrickWall.jpg"));
        wall.setMaterial(mat_brick);
        wall.setLocalTranslation(2.0f, -2.5f, 0.0f);
        player.setMaterial(mat_brick);
      //  rootNode.attachChild(player);
      //  rootNode.attachChild(wall);
        

        // Display a line of text with a default font
        guiNode.detachAllChildren();
        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
        BitmapText helloText = new BitmapText(guiFont, false);
        helloText.setSize(guiFont.getCharSet().getRenderedSize());
        helloText.setText("Hello World");
        helloText.setLocalTranslation(300, helloText.getLineHeight(), 0);
        guiNode.attachChild(helloText);

        // Load a model from test_data (OgreXML + material + texture)
        ninja = assetManager.loadModel("Models/Ninja/Ninja.mesh.xml");
        ninja.scale(0.05f, 0.05f, 0.05f);
        ninja.rotate(0.0f, -3.0f, 0.0f);
        ninja.setLocalTranslation(0.0f, 1.0f, -2.0f);
        rootNode.attachChild(ninja);

        // You must add a light to make the model visible
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rootNode.addLight(sun);
    }

    /* Use the main event loop to trigger repeating actions. */
    @Override
    public void simpleUpdate(float tpf) {
        // make the player rotate:
        player.rotate(0, 2 * tpf, 0);
        ninja.rotate(0, 2 * tpf, 0);
    }
}
