package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	@Test
	void createLigue() 
	{
		Ligue ligue = new Ligue("Fl�chettes");
		assertEquals("Fl�chettes", ligue.getNom());
	}

	@Test
	void addEmploye() 
	{
		Ligue ligue = new Ligue("Fl�chettes");
		Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}

	@Test
	void compareTo() {
		
	}
	
	@Test
	void getAdministrateur() {
		Ligue ligue = new Ligue("Fl�chettes");
		Employe administrateur = ligue.adminstrateur("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty")
	}
	
	@Test
	void getEmployes() {
		Ligue ligue = new Ligue("Fl�chettes");
		return addEmploye();
	}
	
	@Test
	void getNom() {
		
	}
	@Test
	void setAdministrateur(Employe administrateur) {
		Ligue ligue = new Ligue("Fl�chettes");
		Employe administrateur = ligue.getAdministrateur("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty")
	}
//	Employe(Ligue ligue, String nom, String prenom, String mail, String password)
	
	@Test
	void setNom() {
		
	}
}
