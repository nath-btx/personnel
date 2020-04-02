package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	//createLigue getNom OK
	@Test
	void createLigue() throws SQLException 
	{
		Ligue ligue = new Ligue("Fl�chettes");
		assertEquals("Fl�chettes", ligue.getNom());
	}

	//addEmploye getEmployes OK
	@Test
	void addEmploye() throws SQLException 
	{
		Ligue ligue = new Ligue("Fl�chettes");
		Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty", LocalDate.now()); 
		assertEquals(employe, ligue.getEmployes().first());
	
	}

	
	// setAdministrateur getAdministrateur OK
	@Test
	void testSetAdministrateur() throws SQLException {
		Ligue ligue = new Ligue("Fl�chettes");
		Employe administrateur= ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty", LocalDate.now()); 
		ligue.setAdministrateur(administrateur);
		assertEquals(administrateur, ligue.getAdministrateur());
	}
	
	// getEmployes et addEmploye OK
	@Test
	void getEmployes() throws SQLException {
		Ligue ligue = new Ligue("Fl�chettes");
		Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty", LocalDate.now()); 
		assertEquals(employe, ligue.getEmployes().first());
		//V�rifier qu'il n'est pas ajout� 2 fois
	}
	
	
	// compareTo OK
	@Test
	void compareTo() throws SQLException {
		Ligue ligue = new Ligue("P�tanque");
		Ligue autre = new Ligue("Fl�chettes");
		assertEquals(ligue.compareTo(autre), ligue.getNom().compareTo(autre.getNom()));
		assertTrue(ligue.compareTo(autre) > 0);
		assertTrue(ligue.compareTo(ligue) == 0);
		assertTrue(autre.compareTo(ligue) < 0);

		
	}
	
	// setNom OK
	@Test
	void testSetNom() throws SQLException {
		String ligue = "P�tanque";
		String ligue2 = "Fl�chettes";
		Ligue laligue = new Ligue(ligue);
		laligue.setNom(ligue2);
		assertTrue(laligue.getNom() == ligue2);
		assertTrue(laligue.getNom() != ligue);
	}
	
	@Test
	void remove() throws SQLException {
		Ligue ligue = new Ligue("Fl�chettes");
		Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty", LocalDate.now()); 
		ligue.remove();
		System.out.println(ligue.getEmployes());
		System.out.println(employe.getLigue());
		assertNull(ligue.getEmployes().contains(employe));
		assertNull(employe.getLigue());
		//TODO
		// getLigue de G�rard -> me retourne nul
	}
	
	
	
}

