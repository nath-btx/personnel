package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.Employe;
import personnel.Ligue;
import personnel.GestionPersonnel;

class TestEmploye {

	
//testEmploye = OK
	@Test
	void testEmploye() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertTrue(ligue.getEmployes().contains(employe));
		assertEquals(employe.getLigue(),ligue);
	}
	//estAdmin = OK
	@Test
	void testEstAdmin() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		ligue.setAdministrateur(employe);
		assertTrue(employe.estAdmin(ligue));
	}
	//estRoot = Ok
	@Test
	void testEstRoot() {
		Employe root = GestionPersonnel.getGestionPersonnel().getRoot();
		assertTrue(root.estRoot());
	}
	//textSetNom & GetNom = ok 
	@Test
	void testSetNom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		String nom = "Janothan";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}

	//SetPrenom & GetPrenom = ok
	@Test
	void testSetPrenom() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		String prénom = "Mickael";
		employe.setPrenom(prénom);
		assertEquals(employe.getPrenom(),prénom);
	}

	//SetMail & GetMail = ok
	@Test
	void testSetMail() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		String mail = "MickaelJanothan@gmail.com";
		employe.setMail(mail);
		assertEquals(employe.getMail(),mail);
	}
//CheckPassword = ok
	@Test
	void testCheckPassword() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		String mdp = "motdepasse";
		assertTrue(employe.checkPassword(mdp));
		assertFalse(employe.checkPassword("troll"));
	}
//SetPassword = ok
	@Test
	void testSetPassword() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		String password = "toto94200";
		employe.setPassword(password);
		assertTrue(employe.checkPassword(password));
		
	}
// GetLigue = ok
	@Test
	void testGetLigue() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		assertEquals(employe.getLigue(), ligue);
	}
	// Remove = Ko
	@Test
	void testRemove() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe1 = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		employe1.estAdmin(ligue);
		employe1.remove();
		assertFalse(ligue.getEmployes().contains(employe1));
		assertEquals(employe1.getLigue(),null);
		assertEquals(ligue.getAdministrateur(), GestionPersonnel.getGestionPersonnel().getRoot());
	}
	// CompareTo = ok
	@Test
	void testCompareTo() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe1 = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		Employe employe2 = ligue.addEmploye("Giselle","Du trou","Giselledutrou@gmail.com","puit");
		assertNotEquals(employe1.getPrenom().compareTo(employe2.getPrenom()),0);
	}
	// ToString = OK
	@Test
	void testToString() {
		Ligue ligue = new Ligue("Pétanque");
		Employe employe = ligue.addEmploye("Michel","Druker","Michou@gmail.com","motdepasse");
		assertEquals(employe.toString(), "Michel Druker Michou@gmail.com ("+ligue.toString()+")");
	}
}


