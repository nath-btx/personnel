package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.Employe;
import personnel.Ligue;

class TestEmploye {

	@Test
	void testEmploye() {
		fail("Not yet implemented");
	}

	@Test
	void testEstAdmin() {
		fail("Not yet implemented");
	}

	@Test
	void testEstRoot() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = new Employe (ligue,"surname","name","mail","pass");
		String nom = "Janothan";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}
	@Test
	void testSetNom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = new Employe (ligue,"surname","name","mail","pass");
		String nom = "Janothan";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}

	@Test
	void testGetPrenom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = new Employe (ligue,"surname","name","mail","pass");
		String prénom = "Mickael";
		employe.setPrenom(prénom);
		assertEquals(employe.getPrenom(),prénom);
	}

	@Test
	void testSetPrenom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = new Employe (ligue,"surname","name","mail","pass");
		String prénom = "Mickael";
		employe.setPrenom(prénom);
		assertEquals(employe.getPrenom(),prénom);
	}

	@Test
	void testGetMail() {
		fail("Not yet implemented");
	}

	@Test
	void testSetMail() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckPassword() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPassword() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLigue() {
		fail("Not yet implemented");
	}

	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
