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
		Ligue ligue = new Ligue("Fl�chettes");
		assertEquals("Fl�chettes", ligue.getNom());
	}

	//addEmploye getEmployes OK
	@Test
	void addEmploye() 
	{
		Ligue ligue = new Ligue("Fl�chettes");
		Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}

	
	// setAdministrateur OK
	@Test
	void testSetAdministrateur() {
		Ligue ligue = new Ligue("Fl�chettes");
		Employe administrateur = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty"); 
		ligue.setAdministrateur(administrateur);
		assertEquals(administrateur, ligue.getAdministrateur());
	}
	
	// getEmployes et addEmploye OK
	@Test
	void getEmployes() {
		Ligue ligue = new Ligue("Fl�chettes");
		Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	
	// compareTo KO
	@Test
	void compareTo() {
		Ligue ligue = new Ligue("P�tanque");
		Ligue autre = new Ligue("Flechettes");
		
		assertEquals(ligue.compareTo(autre), ligue.getNom().compareTo(autre.getNom()));

		System.out.println(ligue.getNom().compareTo(autre.getNom()));
		
	}
	
	// getNom & setNom
	@Test
	void testGetNom() {
		Ligue ligue = new Ligue("P�tanque");
		ligue.setNom("P�tanque");
		assertEquals(ligue.getNom(),ligue);
		System.out.println(ligue.getNom());
	}
	
	@Test
	void testGetAdministrateur () {
		fail("Not yet implemented");
	}
}

