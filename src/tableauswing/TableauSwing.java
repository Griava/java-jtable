/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableauswing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author clement
 */
public class TableauSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        // TODO code application logic here
               
        CatalogueDePannes sourceDonneesPannes = new CatalogueDePannes();
        
        
        JFrame fenetre = new JFrame();
        
        Container containerPrincipalFenetre = fenetre.getContentPane();
        fenetre.setSize(400, 400);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        // Tableau à partir de la source de données de pannes :
        
        JTable table = new JTable(sourceDonneesPannes);
        
        // On ajoute le tableau au container principal :
        containerPrincipalFenetre.add(new JScrollPane(table));
        
        // Faire un container
        
        Container footer = new Container();     
        
        // Mettre un layout au container en columns
        
        footer.setLayout(new GridLayout(1, 3));
        
        // Faire des componsants :
        
        JTextField idTextField = new JTextField("id");
        JTextField nomTextField = new JTextField("nom");
        
        JButton bouton = new JButton("+");
        bouton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
                sourceDonneesPannes.add(new Long(idTextField.getText()), nomTextField.getText());
            }  
        });
        
        
                
                
        
        // Mettre les champs dans le container
        
        footer.add(idTextField);
        footer.add(nomTextField);
        footer.add(bouton);
        
        // Ajouter le container ci-dessous :        
        
        containerPrincipalFenetre.add(footer, BorderLayout.SOUTH);
        fenetre.setVisible(true);
        
        
        
        
        
         
        

        sourceDonneesPannes.loadFromJSON();   
        sourceDonneesPannes.loadFromXML();
        sourceDonneesPannes.loadFromCode();        
        sourceDonneesPannes.loadFromCSV();
        


    }

    
}
