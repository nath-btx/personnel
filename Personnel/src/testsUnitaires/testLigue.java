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
}
