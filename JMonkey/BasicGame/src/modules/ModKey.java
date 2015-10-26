/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

/**
 *
 * @author Jacob
 * Key to HashMap contained by ModuleManager instance. 
 * Each ModKey has a corresponding Module.
 */
public class ModKey {
    private String modKeyID;
    
    public void ModKey(){
        setModKeyID("DUMMY");
    }
    
    public void ModKey(String modKeyID){
        setModKeyID(modKeyID);
    }
    
    public String getModKeyID(){
        return modKeyID;
    }
    
    public void setModKeyID(String modKeyID){
        this.modKeyID = modKeyID;
    }
}
