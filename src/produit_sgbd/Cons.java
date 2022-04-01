package produit_sgbd;

// classe Cons : saisies au clavier

import java.io.*;

public class Cons {

	public	static int saisirEntier() throws IOException{
	
		InputStreamReader lecteur = new InputStreamReader(System.in);
		BufferedReader entree = new BufferedReader(lecteur);
	
		String texte;
		Integer x;
		
		texte = entree.readLine();
		x = new Integer(texte);
		
		return(x);		
	} 

	public	static float saisirReel() throws IOException{
	
		InputStreamReader lecteur = new InputStreamReader(System.in);
		BufferedReader entree = new BufferedReader(lecteur);
	
		String texte;
		Float x;
		
		texte = entree.readLine();
		x = new Float(texte);
		
		return(x);	
	}

	public	static String saisirChaine() throws IOException{
	
		InputStreamReader lecteur = new InputStreamReader(System.in);
		BufferedReader entree = new BufferedReader(lecteur);
	
		String texte;
		Float x;
		
		texte = entree.readLine();
		
		return(texte);	
	} 
}