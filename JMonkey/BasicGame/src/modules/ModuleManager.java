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

    private ArrayList<Key> moduleKeyRing;
    private HashMap<Key, Module> ModuleBank;

    public boolean initializeModuleBank() {
        boolean returnSuccess = false;
        if (ModuleBank == null) {
            ModuleBank = new HashMap<Key, Module>();
            moduleKeyRing = new ArrayList<Key>();
        } else {
            returnSuccess = true;
        }
        return returnSuccess;
    }

    @Override
    public String toString() {
        if(!moduleKeyRing.isEmpty()){
            return moduleKeyRing.toString();
        }    
        return "NO KEYS";
    }
    
}
