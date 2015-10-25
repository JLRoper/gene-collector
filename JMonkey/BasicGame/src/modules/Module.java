/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;
import com.jme3.material.Material;

/**
 *
 * @author Jacob Wrapper class for all individual units/structures in game.
 */
public class Module {

    protected AssetManager assetManager;
    Material mat_default = new Material(assetManager, "Common/MatDefs/Misc/ShowNormals.j3md");

    private String moduleName;
    private Material material; // pattern
    private Spatial spatial; //handler
//  private Mesh mesh; //shape: gets attached to spatial outside module instance. 

    public void Module() {

    }

    public void Module(String moduleName, Material material, Spatial spatial) {
        setModuleName(moduleName);
        setMaterial(material);
        setSpacial(spatial);
    }

    public boolean initialize() {
        boolean isInitialized = false; 
        Vector3f vect = spatial.getLocalScale();
        System.out.println(vect.y);
        if (spatial != null) {
            if (material != null) {
                spatial.setMaterial(material);
            } else {
                spatial.setMaterial(mat_default);
            }
            isInitialized = true;
        } else {
            isInitialized = false;
        }
        return isInitialized;
    }

    public void setSpacial(Spatial spacial) {
        this.spatial = spacial;
    }

    public Spatial getSpatial() {
        return spatial;
    }

    public void setModuleName(String name) {
        moduleName = name;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }
}
