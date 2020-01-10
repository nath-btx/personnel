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
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = new Employe (ligue,"surname","name","mail","pass");
		String mail = "MickaelJanothan@gmail.com";
		employe.setMail(mail);
		assertEquals(employe.getMail(),mail);
	}

	@Test
	void testSetMail() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = new Employe (ligue,"surname","name","mail","pass");
		String mail = "MickaelJanothan@gmail.com";
		employe.setMail(mail);
		assertEquals(employe.getMail(),mail);
	}

	@Test
	void testCheckPassword() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = new Employe (ligue,"surname","name","mail","pass");
		String password = "toto94200";
		employe.setPassword(password);
		assertEquals(employe.CheckPassword(),password);
	}

	@Test
	void testSetPassword() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = new Employe (ligue,"surname","name","mail","pass");
		String password = "toto94200";
		employe.setPassword(password);
		assertEquals(employe.CheckPassword(),password);
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
