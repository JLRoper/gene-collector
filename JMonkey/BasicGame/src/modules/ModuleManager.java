/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;


import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jacob Container class for a set of Module(s).
 */
public class ModuleManager {

    private ArrayList<ModKey> modKeyRing;
    private HashMap<ModKey, Module> ModuleBank;

    public boolean initializeModuleBank() {
        boolean returnSuccess = false;
        if (ModuleBank == null) {
            ModuleBank = new HashMap<ModKey, Module>();
            modKeyRing = new ArrayList<ModKey>();
            returnSuccess = true;
        } 
        return returnSuccess;
    }

    @Override
    public String toString() {
        if(!modKeyRing.isEmpty()){
            return modKeyRing.toString();
        }    
        return "NO KEYS";
    }
    
}
