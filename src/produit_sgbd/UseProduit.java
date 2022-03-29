package produit_sgbd;

/**
 * @(#)UseProduit.java
 *
 *
 * @author 
 * @version 1.00 2015/03/09
 */

import java.io.*;
import java.util.*;

public class UseProduit {

	
static public void main(String[] arg)throws Exception 
{
	 
	char choix;
        int leId;
	String leLib;
	float lePrix;
	int leStock;	
	int i;	
	Produit leProd;
	int result;
	
	ArrayList<Produit> lesProds;
	
	choix = '1';
	while (choix!='0')
	{
		//system ("cls");
		System.out.println("\nGestion des produits :");	
		System.out.println("1. Ajouter un produit");
		System.out.println("2. Lister les produits");	
		System.out.println("3. Rechercher un produit");	
		System.out.println("4. Modifier un produit");              
		System.out.println("0. Terminer");	
		System.out.print("Choisir une action : ");
		
		String texte = Cons.saisirChaine();
		choix = texte.charAt(0);
		
		switch (choix)
		{
			case '1' : // Ajouter un produit
                            
				System.out.print("\nEntrez les informations : \n");
                                System.out.print("Identifiant : ");
				leId = Cons.saisirEntier();				
				System.out.print("Libelle : ");
				leLib = Cons.saisirChaine();
				System.out.print("Prix    : ");
				lePrix = Cons.saisirReel();
				System.out.print("Stock    : ");
				leStock = Cons.saisirEntier();
                                
				leProd = new Produit(leId, leLib, lePrix, leStock);
				
                                PasserelleBdd.ajouterProd(leProd);
				
				break;

			case '2' : // Lister les produits
                                lesProds = PasserelleBdd.lireProd();
                                i=0;
                                while (i<lesProds.size())
                                {
                                    leProd=lesProds.get(i);
                                    leProd.afficher();                                
                                    i = i + 1;
                                }
				
				break;

 			case '3' : // Rechercher un produit                           
                                System.out.print("\nEntrez l'identifiant : \n");
                               leId = Cons.saisirEntier();
                                lesProds = PasserelleBdd.rechercherProd(leId);
                                i=0;
                                while (i<lesProds.size())
                                {
                                    leProd=lesProds.get(i);
                                    leProd.afficher();                                
                                    i = i + 1;
                                }
			
                                
				break;
                           

			/*case '4' :
                System.out.print("\nEntrez les informations du produit à modifier :\n");
                System.out.print("Identifiant:");
                leId = Cons.saisirEntier();
                System.out.print("nouveau libellé : ");
                leLib = Cons.saisirChaine();
                System.out.print("Nouveau prix : ");
                lePrix = Cons.saisirReel();
                System.out.print("Nouveau stock : ");
                leStock = Cons.saisirEntier();
                leProd = new Produit(leId, leLib, lePrix, leStock);
                result = PasserelleBdd.modifierProd(leProd);

                if (result == 1){
                System.out.print("\n le produit est modifié\n");
                                }
                else{
                System.out.print("\nle produit n'est pas modifié\n");
                                }
            break;*/
		}
	}
}
	
} // fin classe