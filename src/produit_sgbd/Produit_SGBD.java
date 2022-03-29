/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produit_sgbd;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Jérémie
 */
public class Produit_SGBD 
{

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        Scanner input=new Scanner(System.in);
        ArrayList<Produit> mesProduits=new ArrayList();
        
//        // 1) Charger le driver mysql
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        // 2) Creer la connection
//        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/entrepot", "root", "");
//        // 3) Creer un etat de connection
//        Statement st=con.createStatement();

        Produit p;
        int leId;
	String leLib;
	float lePrix;
	int leStock;	
	int i;
        ArrayList<Produit> lesProds;
        
        int choix=1;
        while(choix!=0)
        {
            System.out.println("1 : Afficher les produits");
            System.out.println("2 : Inserer un produit");
            System.out.println("0 : Arreter le programme");
            
            choix=input.nextInt();
            try 
            {
                switch(choix)
                {
                    case 1:
                        lesProds = PasserelleBdd.lireProd();
                                i=0;
                                while (i<lesProds.size())
                                {
                                    p=lesProds.get(i);
                                    p.afficher();
                                    i = i + 1;
                                }
                        break;

                    case 2:
                        System.out.print("\nEntrez les informations : \n");
                        System.out.print("Identifiant : ");
                        leId = input.nextInt();
                        System.out.print("Libelle : ");
                        leLib = input.next();
                        System.out.print("Prix    : ");
                        lePrix = input.nextFloat();
                        System.out.print("Stock    : ");
                        leStock = input.nextInt();

                        p = new Produit(leId, leLib, lePrix, leStock);

                        PasserelleBdd.ajouterProd(p);
                        break;

                    case 3:
    
                        break;
                    
                    case 4:

                        break;
                        
                    case 5:
                }
            }
            catch (SQLException e)
            {
                System.out.println("Erreur : "+e);
            }
            
        }
        
    }
    
}