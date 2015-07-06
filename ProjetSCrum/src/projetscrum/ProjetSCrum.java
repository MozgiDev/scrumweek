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
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException ex) {
    //Handle Exception
        } catch (InstantiationException ex) {
    //Handle Exception
        } catch (IllegalAccessException ex) {
    //Handle Exception
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //Handle Exception
        }
        IHM_ListerDevoir window = new IHM_ListerDevoir();
        window.setVisible(true);
    }

}
