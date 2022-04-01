package produit_sgbd;

/**
 * @(#)PasserelleBdd.java
 *
 *
 * @author 
 * @version 2.00 2022/03/22
 */

// librairie pour utiliser les classes pour la base de données
import java.sql.*;
import java.util.*;


public class PasserelleBdd
{	
	// Méthode lireUs
	// Lecture de données dans la table Usager
	// Valeur retournée : liste des usagers
	 
	public static ArrayList<Produit> lireProd() throws SQLException
	{
		String requete;	
		ResultSet rs  = null;
		boolean alire;		
		Produit unProd;               
                ArrayList<Produit> lesProds;
                int unId;
                String unLib;
                float unPrix;
                int unStk;
                	
		unProd = new Produit();
                lesProds = new ArrayList<>();
                              
		// Définition de la requête          
		requete = "select * from produit;";
	
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		//Si il  ya un enregistrement à lire
		while (alire==true)
		{
                        unId = rs.getInt(1);
                        unLib = rs.getString(2);
                        unPrix = rs.getFloat(3);
                        unStk = rs.getInt(4);
                        
			unProd = new Produit(unId, unLib, unPrix,unStk);
                        lesProds.add(unProd);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesProds;
	}
	
        public static ArrayList<Produit> rechercherProd(int unId) throws SQLException
	{
		String requete;	
		ResultSet rs  = null;
		boolean alire;		
		Produit unProd;               
                ArrayList<Produit> lesProds;
                //int unId;
                String unLib;
                float unPrix;
                int unStk;
                	
		unProd = new Produit();
                lesProds = new ArrayList<>();
                              
		// Définition de la requête          
		requete = "select * from produit where id = "+unId+  ";";
	
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		//Si il  ya un enregistrement à lire
		while (alire==true)
		{
                        unId = rs.getInt(1);
                        unLib = rs.getString(2);
                        unPrix = rs.getFloat(3);
                        unStk = rs.getInt(4);
                        
			unProd = new Produit(unId, unLib, unPrix,unStk);
                        lesProds.add(unProd);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesProds;
	}
		
	
	
	// Méthode ajouterProd
	// Ajout de données dans la table Usager
	// Paramètres :
	// - Prodfuit à ajouter : Produit P
	// Valeur retournée : 1 si modification effectuée, 0 sinon

	public static int ajouterProd(Produit P) throws SQLException
	{		
		String requete = null;
		int res;
                int unId;
		String unLib;
                float unPrix;
		int unStk;
               	
		unId=P.getId();
		unLib=P.getLib();
                unPrix=P.getPrix();
		unStk=P.getStock();
		
                requete = "INSERT INTO produit(id, libelle, prix, quantite)VALUES("+unId+",'"+unLib+"',"+unPrix+","+unStk+")";	
		
		Bdd laBdd = new Bdd();		
		res = laBdd.exec(requete);		
		return res;
	}
	
	public static int modifierProd(Produit P) throws SQLException
    {
        String requete = null;
        int res;
        int unId;
        String unLib;
        double unPrix;
        int unStk;

        unId=P.getId();
        unLib=P.getLib();
        unPrix=P.getPrix();
        unStk=P.getStock();

        requete = "UPDATE produit SET libelle = '"+unLib+"',prix = "+unPrix+",quantite = "+unStk+ " WHERE id = "+unId+";";

        Bdd laBdd = new Bdd();
        res = laBdd.exec(requete);
        return res;
    }

}