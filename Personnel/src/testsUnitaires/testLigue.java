package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	@Test
	void createLigue() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

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
	
	@Test
	void getAdministrateur() {
//		Ligue ligue = new Ligue("Fléchettes");
//		Employe administrateur = ligue.administrateur("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
	}
	
	@Test
	void getEmployes() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	
	@Test
	void setAdministrateur(Employe administrateur) {
//		Ligue ligue = new Ligue("Fléchettes");
//		Employe administrateur = ligue.getAdministrateur("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
	}
//	Employe(Ligue ligue, String nom, String prenom, String mail, String password)
	
	// Test setNom OK
	@Test
	void setNom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = new Employe (ligue,"surname","name","mail","pass");
		String nom = "Janothan";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}
	
}

