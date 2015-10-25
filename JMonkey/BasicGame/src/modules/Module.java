/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import com.jme3.material.Material;
import com.jme3.scene.Mesh;
import com.jme3.scene.Spatial;

/**
 *
 * @author Jacob
 */
public class Module {

    private String moduleName;
    private Material material; // pattern
    private Spatial spatial; //handler
//  private Mesh mesh; //shape: gets attached to spatial outside module instance. 

    public void Module() {

    }

    public void Module(String moduleName, Material material, Spatial spatial) {
        this.moduleName = moduleName;
        this.material = material;
        this.spatial = spatial;
    }

    public boolean initialize() {
        if (spatial != null && material != null) {
            spatial.setMaterial(material);
        }
        return false;
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
