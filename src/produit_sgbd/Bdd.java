package produit_sgbd;

/**
 * @(#)Bdd.java
 *
 *
 * @author 
 * @version 1.00 2022/03/22
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


class Bdd
{
	Connection connection;
	String nom; // Nom de la base

	public Bdd()
	{
		 connection = null;
		 nom="entrepot";
	}

	// Connexion � la base de donnees
	private Connection ouvrir () 
	{
    	try
        {
			// Chargement des drivers SQL
			Class.forName ("com.mysql.cj.jdbc.Driver").newInstance();
		}
		catch (ClassNotFoundException a)
		{
			System.out.println ("Driver non trouve");
		}
		catch (Exception b)
		{      
			System.out.println ("Probl�me de chargement de driver");			
		}

		try
        {		
			// Etablissement de la connexion avec la base
			connection = DriverManager.getConnection ("jdbc:mysql://localhost/"+nom, "root", "");
		}
		catch (SQLException c)
		{
			System.out.println ("Connexion refusee ou base inconnue");
		}
		catch (Exception d)
		{
			System.out.println ("Probl�me de connexion");
		}
		return connection;
	}


	// Fermer la connexion � la base
	private void fermer()
	{
		try
		{
			// Fermeture de la connexion
			connection.close();
		}
		catch (Exception d)
		{
			System.out.println ("Problème à la fermeture de la connexion");	
		}
	}
	
	// Obtenir le ResultSet correspondant
	// � la requete pass�e en param�tre
	public ResultSet lire(String requete) throws SQLException
	{
		Connection cnx;		
		ResultSet rs  = null;
	
		// Ouverture d'une connexion � la base
		cnx = ouvrir();
		
		// Si la connexion � r�ussi
		if (cnx!=null)
		{			
			// Cr�ation d'un objet de classe Statement permettant
			// de transmettre une requ�te � la base
			Statement stmt = cnx.createStatement();
								
			// Ex�cution de la requete et r�cup�ration 
			// du r�sultat dans un jeu d'enregistrements
			rs = stmt.executeQuery(requete);
		
			// fermeture de la connexion
			// laBdd.fermer();
		}
		return rs;
	}
	

	// Méthode exec
	// Paramètre : requête Insert, Update ou Delete
	// Valeur retournée : 1 si modification effectuée, 0 sinon
	
	public int exec(String requete) throws SQLException
	{
		Connection cnx;
		int res;
		
		res = 0;		

		// Ouverture d'une connexion � la base
		cnx = ouvrir();

		// Si la connexion a r�ussi
		if (cnx!=null)
		{
			// Cr�ation d'un objet de classe Statement permettant
			// de transmettre une requ�te � la base
			Statement stmt = cnx.createStatement();	
		
			// Trace de la requete
			// System.out.println("Requete : "+requete);
			
			// Ex�cution de la requete 
			try {
				res = stmt.executeUpdate(requete);
			    }
			catch (Exception e) {
				// Probl�mes tels que :
				// - valeur de cl� primaire d�ja existante
			    // System.out.println("Probl�me d'ex�cution !");
			    //affichage de la pile d'exceptions :
			    // e.printStackTrace();
				}
		
			// fermeture de la connexion
			fermer();
		}		
		return res;	
	}	

	
}