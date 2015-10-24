/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launch;
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
/**
 *
 * @author Jacob
 */
public class HelloNode extends SimpleApplication {
    public static void main(String[] args){
        HelloNode app = new HelloNode();
        app.start();
    }

    @Override
    public void simpleInitApp() {

        /** create a blue box at coordinates (1,-1,1) */
        Box box1 = new Box(10,.1f,10);
        Geometry green = new Geometry("Box", box1);
        green.setLocalTranslation(new Vector3f(1,-2,1));
        Material mat1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat1.setColor("Color", ColorRGBA.Green);
        green.setMaterial(mat1);
        
        /** create a red box straight above the blue one at (1,3,1) */
        Box box2 = new Box(1,1,1);      
        Geometry red = new Geometry("Box", box2);
        red.setLocalTranslation(new Vector3f(1,3,1));
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Red);
        red.setMaterial(mat2);
        
        /** Create a pivot node at (0,0,0) and attach it to the root node */
        Node sceneNode = new Node("pivot");
        rootNode.attachChild(sceneNode); // put this node in the scene
        
        /** Attach the two boxes to the *pivot* node. (And transitively to the root node.) */
        sceneNode.attachChild(green);
        sceneNode.attachChild(red);
        rootNode.detachChildNamed("pivot");
        /** Rotate the pivot node: Note that both boxes have rotated! */
        red.rotate(1f,1f,1f);
    }
}