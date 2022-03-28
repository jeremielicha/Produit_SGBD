package produit_sgbd;

/**
 * @(#)PasserelleBdd.java
 *
 *
 * @author 
 * @version 1.00 2015/03/09
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
			unProd = new Produit(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
                        lesProds.add(unProd);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesProds;
	}
		
	
	// Méthode modifUs
	// Modification de données dans la table Usager
	// Paramètres :
	// - Type de la modification : char typeModif
	// 		'A' : ajouter
	//		'M' : modifier
	//		'S' : supprimer	
	// - Usager à modifier : Usage U
	// Valeur retournée : 1 si modification effectuée, 0 sinon

	public static int modifProd(char typeModif, Produit P) throws SQLException
	{
		
		String requete = null;
		int res;
                int unId;
		String unLib;
                float unPrix;
		int unStk;
                
		unId=P.getId();
		unLib=P.getLibelle();
                unPrix=(float) P.getPrix();
		unStk=P.getQuantite();
		
		switch (typeModif)
		{
		  case 'A' : // Ajouter
			requete = "INSERT INTO produit(id, lib, pu, qte)VALUES("+unId+",'"+unLib+"',"+unPrix+","+unStk+")";
			break;
		
			
		  default : // Erreur
			break;
		}
		Bdd laBdd = new Bdd();		
		res = laBdd.modif(requete);
		return res;
	}
}