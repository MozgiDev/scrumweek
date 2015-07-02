/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetscrum;
import View.*;
import java.net.UnknownHostException;
/**
 *
 * @author Jérôme
 */
public class ProjetSCrum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        
        IHM_ListerDevoir window = new IHM_ListerDevoir();
        window.setVisible(true);
    }
    
}
