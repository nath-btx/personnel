package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.GestionPersonnel;

class TestEmploye {

	@Test
	void testEmploye() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}

	@Test
	void testEstAdmin() {
<<<<<<< HEAD
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		ligue.setAdministrateur(employe);
		//assertTrue(ligue.getAdministrateur(), employe);
=======
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		ligue.setAdministrateur(employe);
		assertTrue(ligue.getAdministrateur(),employe);
>>>>>>> b9163f480e9bd298fb8afb0156c815bbd2ce6c72
	}

	@Test
	void testEstRoot() {
<<<<<<< HEAD
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		//ligue.getRoot(employe);
		//assertTrue(employe, getRoot());
=======
		Employe employe = getRoot();
		assertEquals(ligue.getAdministrateur(),employe);
>>>>>>> b9163f480e9bd298fb8afb0156c815bbd2ce6c72
	}

	@Test
	void testGetNom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Janothan","Druker","Michou@gmail.com","motdepasse");
		String nom = "Janothan";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}
	@Test
	void testSetNom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Janothan","Druker","Michou@gmail.com","motdepasse");
		String nom = "Janothan";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}

	@Test
	void testGetPrenom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Mickael","Druker","Michou@gmail.com","motdepasse");
		String prénom = "Mickael";
		employe.setPrenom(prénom);
		assertEquals(employe.getPrenom(),prénom);
	}

	@Test
	void testSetPrenom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Mickael","Druker","Michou@gmail.com","motdepasse");
		String prénom = "Mickael";
		employe.setPrenom(prénom);
		assertEquals(employe.getPrenom(),prénom);
	}

	@Test
	void testGetMail() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		System.out.println(employe.getMail());
	}

	@Test
	void testSetMail() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		String mail = "MickaelJanothan@gmail.com";
		employe.setMail(mail);
		assertEquals(employe.getMail(),mail);
	}

	@Test
	void testCheckPassword() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		String mdp = "motdepasse";
		assertTrue(employe.checkPassword(mdp));
	}

	@Test
	void testSetPassword() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		String password = "toto94200";
		employe.setPassword(password);
		assertTrue(employe.checkPassword(password));
		
	}

	@Test
	void testGetLigue() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		assertEquals(employe.getLigue(), ligue);
	}

	@Test
	void testRemove() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe1 = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		Employe employe2 = ligue.addEmploye("Gisèle","Prune","Prunette@gmail.com","azertyuiop");
		employe1.remove();
		assertTrue(ligue.getEmployes().contains(employe2));
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
