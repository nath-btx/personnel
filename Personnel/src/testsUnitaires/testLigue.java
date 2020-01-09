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
		
	}
	
	@Test
	void getAdministrateur() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe administrateur = ligue.adminstrateur("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty")
	}
	
	@Test
	void getEmployes() {
		Ligue ligue = new Ligue("Fléchettes");
		return addEmploye();
	}
	
	@Test
	void getNom() {
		
	}
	@Test
	void setAdministrateur(Employe administrateur) {
		Ligue ligue = new Ligue("Fléchettes");
		Employe administrateur = ligue.getAdministrateur("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty")
	}
//	Employe(Ligue ligue, String nom, String prenom, String mail, String password)
	
	@Test
	void setNom() {
		
	}
}
