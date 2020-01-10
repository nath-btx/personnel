package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	//createLigue getNom de ligue OK
	@Test
	void createLigue() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

	//addEmploye getEmployes OK
	@Test
	void addEmploye() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}

	@Test
	void compareTo() {
		fail("Not yet implemented");
	}
	
	
	// setAdministrateur KO
	@Test
	void setAdministrateur() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe administrateur = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		setAdministrateur(administrateur);
		assertEquals(administrateur, ligue.getAdministrateur());
		System.out.println(ligue.getAdministrateur());
	}
	
	@Test
	void getEmployes() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	
	
	// Test setNom et getNom OK
	@Test
	void setNom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = new Employe (ligue,"surname","name","mail","pass");
		String nom = "Janothan";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}
	
}

