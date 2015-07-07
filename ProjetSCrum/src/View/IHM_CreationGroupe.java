/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Devoir;
import Entity.Etudiant;
import Entity.Groupe;
import Model.DAO_Devoir;
import Model.DAO_Etudiant;
import java.awt.Component;
import static java.lang.System.out;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author Quentin
 */
public class IHM_CreationGroupe extends javax.swing.JFrame {

    private DefaultListModel modeljList1 = null;
    private DefaultListModel modeljList2 = null;
    public List<Entity.Etudiant> listeEtudiant;
    protected IHM_Devoir IHM_DevoirPapa = null;

    /**
     * Creates new form IHM_CreationGroupe
     */
    public IHM_CreationGroupe(IHM_Devoir pIHM_Devoir) {
        initComponents();
        IHM_DevoirPapa = pIHM_Devoir;
        modeljList1 = new DefaultListModel();
        modeljList2 = new DefaultListModel();
        initListEtudiant();

        if(IHM_DevoirPapa.newDevoir.getLibelle() != null)
            jLabel5.setText(IHM_DevoirPapa.newDevoir.getLibelle());
        else
            jLabel5.setText("Pas encore défini");
    }

    public void updateListeEtudiant() {
        listeEtudiant = getListeEtudiant();
        modeljList1.clear();
        for (int i = 0; i < listeEtudiant.size(); i++) {
            modeljList1.addElement(listeEtudiant.get(i));
        }
        jList1.setModel(modeljList1);
    }
    
    protected List<Etudiant> getListeEtudiant()
    {
        List<Etudiant> listeEtud = new ArrayList<Etudiant>();
        listeEtudiant = new ArrayList<Etudiant>();
        DAO_Etudiant dao;
        try {
            dao = new DAO_Etudiant(null);
            listeEtud = dao.findAll();
        } catch (UnknownHostException ex) {
            Logger.getLogger(IHM_CreationGroupe.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return IHM_DevoirPapa.newDevoir.getEtudiantInGroupe(listeEtud);
    }
    
    protected void initListEtudiant()
    {
        List<Etudiant> lstElevesDejaEnGroupe = new ArrayList();
        
        //On parcours la liste de tous les groupes associés à ce devoir
        for(int i = 0; i < IHM_DevoirPapa.newDevoir.getLstGroupe().size(); i++)
        {            
            //On parcours chaque groupe
            for(int j = 0; j < IHM_DevoirPapa.newDevoir.getLstGroupe().get(i).getLstEtudiant().size(); j++)
            {
                //On récupère tous les élèves que l'on trouve dans une liste commune
                lstElevesDejaEnGroupe.add(IHM_DevoirPapa.newDevoir.getLstGroupe().get(i).getLstEtudiant().get(j));
            }
        }
        //On récupère la liste totale des élèves
        listeEtudiant = getListeEtudiant();
        
        //On y enlève les élèves déjà affectés à un groupe
        //On parcours tous les eleves deja en groupe
        for(int i = 0; i < lstElevesDejaEnGroupe.size(); i++)
        {
            for(int j = 0; j < listeEtudiant.size(); j++)
            {
                if(listeEtudiant.get(j).equals(lstElevesDejaEnGroupe.get(i)))
                {
                    listeEtudiant.remove(j);
                }
            }
        }
        //On met à jour la liste
        modeljList1.clear();
        for (int i = 0; i < listeEtudiant.size(); i++) {
            modeljList1.addElement(listeEtudiant.get(i));
        }
        jList1.setModel(modeljList1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Création d'un groupe d'élèves pour le devoir :");

        jLabel2.setText("Nom du groupe");

        jLabel3.setText("Liste des élèves");

        jButton1.setText(">");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList2);

        jLabel4.setText("Elèves du groupe");

        jButton2.setText("<");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Annuler");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(jList1);

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(72, 72, 72)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton3))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (!jTextField1.getText().equals("") 
                && (modeljList2.size() > 0)) {
            
            //On check les noms de groupe existant et on empeche d'en créer un avec un nom qui existe deja
            List<String> lstNomGroupe = IHM_DevoirPapa.getLstNomGroupe();
            if(!lstNomGroupe.isEmpty())
            {
                for(int i = 0; i < lstNomGroupe.size(); i++)
                {
                    if(jTextField1.getText().equals(lstNomGroupe.get(i)))
                    {
                        JOptionPane.showMessageDialog(this, "Ce nom de groupe existe déjà.");
                        return;
                    }
                }
            }
            
            List<Etudiant> lstEdudiant = new ArrayList<Etudiant>();            
            for (int i = 0; i < modeljList2.size(); i++) {
                Etudiant unEtudiant = (Etudiant) modeljList2.get(i);
                lstEdudiant.add(unEtudiant);
            }
            Groupe grp = new Groupe(jTextField1.getText().toString(),lstEdudiant);
            IHM_DevoirPapa.newDevoir.addToListGroupe(grp);
                        
            IHM_DevoirPapa.updateListeGroupe();
            
            this.setVisible(false);
            IHM_DevoirPapa.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un nom à votre groupe, et y intégrer au moins un élève.");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        //On récupère les elements selectionnés et on les passent dans le model de la liste de droite
        
        List LstSelectedValues = jList1.getSelectedValuesList();
        
        for (int i = 0; i < LstSelectedValues.size(); i++) {
            modeljList2.addElement(LstSelectedValues.get(i));
            modeljList1.removeElement(LstSelectedValues.get(i));
        }

        //On récupère les indices des elements selectionnés et on les enlèves de la liste de gauche
        
        jList2.setModel(modeljList2);
        jList1.setModel(modeljList1);
        
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        for (int i = 0; i < jList2.getSelectedValuesList().size(); i++) {
            modeljList1.addElement(jList2.getSelectedValuesList().get(i));
        }

        int length = jList2.getSelectedIndices().length;
        for (int i = 0; i < length; i++) {
            modeljList2.remove(jList2.getSelectedIndices()[0]);
        }
        jList1.setModel(modeljList1);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
        IHM_DevoirPapa.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        IHM_DevoirPapa.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(IHM_CreationGroupe.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(IHM_CreationGroupe.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(IHM_CreationGroupe.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(IHM_CreationGroupe.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new IHM_CreationGroupe().setVisible(true);
//                } catch (UnknownHostException ex) {
//                    Logger.getLogger(IHM_CreationGroupe.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
