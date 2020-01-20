package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
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
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now(), LocalDate.now()); 
		assertEquals(employe, ligue.getEmployes().first());
	
	}

	
	// setAdministrateur getAdministrateur OK
	@Test
	void testSetAdministrateur() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe administrateur= ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now(), LocalDate.now()); 
		ligue.setAdministrateur(administrateur);
		assertEquals(administrateur, ligue.getAdministrateur());
	}
	
	// getEmployes et addEmploye OK
	@Test
	void getEmployes() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now(), LocalDate.now()); 
		assertEquals(employe, ligue.getEmployes().first());
		//Vérifier qu'il n'est pas ajouté 2 fois
	}
	
	
	// compareTo OK
	@Test
	void compareTo() {
		Ligue ligue = new Ligue("Pétanque");
		Ligue autre = new Ligue("Fléchettes");
		assertEquals(ligue.compareTo(autre), ligue.getNom().compareTo(autre.getNom()));
		assertTrue(ligue.compareTo(autre) > 0);
		assertTrue(ligue.compareTo(ligue) == 0);
		assertTrue(autre.compareTo(ligue) < 0);

		
	}
	
	// setNom OK
	@Test
	void testSetNom() {
		String ligue = "Pétanque";
		String ligue2 = "Fléchettes";
		Ligue laligue = new Ligue(ligue);
		laligue.setNom(ligue2);
		assertTrue(laligue.getNom() == ligue2);
		assertTrue(laligue.getNom() != ligue);
	}
	
	@Test
	void remove() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now(), LocalDate.now()); 
		ligue.remove();
		System.out.println(ligue.getEmployes());
		System.out.println(employe.getLigue());
		assertNull(ligue.getEmployes().contains(employe));
		assertNull(employe.getLigue());
		//TODO
		// getLigue de Gérard -> me retourne nul
	}
	
	
	
}

