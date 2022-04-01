package produit_sgbd;

/**
 * @(#)Produit.java
 *
 *
 * @author 
 * @version 1.00 2015/03/09
 */




public class Produit {

	// atributs 
	private int ident;
	private String libelle;
	private float prix_achat;
	private int stock;

	// m�thodes
	public Produit() 
	{
		ident = 0;
		libelle = "";
		prix_achat = 0;	
		stock = 0;	
	}
	
	public Produit(int id, String lib,float prx, int stk) 
	{
		ident = id;
		libelle = lib;
		prix_achat = prx;	
		stock = stk;	
	}
	
	public int getId() 
	{
		return ident;
	}


	public String getLib() 
	{
		return libelle;
	}

	public float getPrix() {
		return prix_achat;
	}

	public int getStock() {
		return stock;
	}


	public void afficher() 
	{
		System.out.println("Identifiant : " + ident);
		System.out.println("Libelle : " + libelle);
		System.out.println("Prix    : " + prix_achat);
		System.out.println("Stock    : "+ stock+"\n");
	}
}	