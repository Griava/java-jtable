/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableauswing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        fenetre.setVisible(true);
        
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
        
        // Mettre les champs dans le container
        
        footer.add(idTextField);
        footer.add(nomTextField);
        footer.add(bouton);
        
        // Ajouter le container ci-dessous :        
        
        containerPrincipalFenetre.add(footer, BorderLayout.SOUTH);
 
        
        
        
        
        
         
        

        sourceDonneesPannes.loadFromJSON();   
        sourceDonneesPannes.loadFromXML();
        sourceDonneesPannes.loadFromCode();        
        sourceDonneesPannes.loadFromCSV();
        


    }

    
}
