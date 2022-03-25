/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produit_sgbd;

/**
 *
 * @author Jérémie
 */
public class Produit {
    private int id;
    private String libelle;
    private double prix;
    private int quantite;

    public Produit(int id, String libelle, double prix, int quantite) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.quantite = quantite;
    }
    
    public Produit() {
        id=0;
        libelle="";
        prix=0;
        quantite=0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * @return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void afficher() 
	{
		System.out.println("Identifiant : " + id);
		System.out.println("Libelle : " + libelle);
		System.out.println("Prix    : " + prix);
		System.out.println("Stock    : "+ quantite+"\n");
	}
}
