package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	//createLigue getNom OK
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

	
	// setAdministrateur getAdministrateur OK
	@Test
	void testSetAdministrateur() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe administrateur = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		ligue.setAdministrateur(administrateur);
		assertEquals(administrateur, ligue.getAdministrateur());
	}
	
	// getEmployes et addEmploye OK
	@Test
	void getEmployes() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	
	// compareTo KO TODO
	@Test
	void compareTo() {
		Ligue ligue = new Ligue("Pétanque");
		Ligue autre = new Ligue("Fléchettes");
		assertTrue(ligue.compareTo(autre) >= 0);

		System.out.println(ligue.getNom().compareTo(autre.getNom()));
		
	}
	
	// setNom OK
	@Test
	void testSetNom() {
		String ligue = "Pétanque";
		String ligue2 = "Fléchettes";
		Ligue laligue = new Ligue(ligue);
		laligue.setNom(ligue2);
		assertTrue(laligue.getNom(),ligue);

	}
	
	@Test
	void remove() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		employe.remove();
		assertFalse(ligue.getEmployes().contains(employe));
	}
	
	
}

