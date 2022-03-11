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
        
        // 1) Charger le driver mysql
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2) Creer la connection
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/entrepot", "root", "");
        // 3) Creer un etat de connection
        Statement st=con.createStatement();
        ResultSet res;
        String query;
        Produit p;
        
        int choix=1;
        while(choix!=0)
        {
            System.out.println("1 : Afficher les produits");
            System.out.println("2 : Inserer un produit");
            System.out.println("3 : Compter le nombre de produits en tout");
            System.out.println("4 : Supprimer tout les produits");
            System.out.println("0 : Arreter le programme");
            
            choix=input.nextInt();
            try 
            {
                switch(choix)
                {
                    case 1:
                        // 4) Creation de la requete
                        res=st.executeQuery("select * from produit");
                        // 5) Parcours des données
                        int i=1;
                        while (res.next())
                        {
                            System.out.println("Produit "+i+"\nLibelle : "+res.getString(2)+"\nPrix : "+res.getString(3)+"\nQuantité : "+res.getString(4));
                            System.out.println("-------------------------");
                            i++;
                        }
                        break;

                    case 2:
                        System.out.print("Saisir le libellé : ");
                        String lib=input.next();
                        System.out.print("Saisir le prix : ");
                        double prix=input.nextDouble();
                        System.out.print("Saisir la quantité : ");
                        int qte=input.nextInt();
                        query="insert into produit (libelle,prix,quantite) values('"+lib+"','"+prix+"','"+qte+"')";
                        st.executeUpdate(query);
                        break;

                    case 3:
                        System.out.print("Nombre de produits : ");
                        res=st.executeQuery("select sum(quantite) from produit");
                        res.next();
                        if(res.getInt(1)==0)
                        {
                            System.out.println("Aucun produits dans l'entrepot");
                        }
                        else
                        {
                            System.out.println(res.getInt(1));
                        }
                        break;
                    
                    case 4:
                        query="delete from produit";
                        st.executeUpdate(query);
                        System.out.println("Produits supprimés !");
                        break;
                }
            }
            catch (SQLException e)
            {
                System.out.println("Erreur : "+e);
            }
            
        }
        
    }
    
}