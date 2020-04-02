package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import personnel.Employe;
import personnel.Ligue;
import personnel.dateArriveeException;
import personnel.dateDepartException;
import personnel.GestionPersonnel;

class TestEmploye {

	
//testEmploye = OK
	@Test
	void testEmploye() {
		Ligue ligue = new Ligue("Fl�chettes");
		Employe employe = null;
		try {
			employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		assertTrue(ligue.getEmployes().contains(employe));
		assertEquals(employe.getLigue(),ligue);
	}
	//estAdmin = OK
	@Test
	void testEstAdmin() {
		Ligue ligue = new Ligue("P�tanque");
		Employe employe = null;
		try {
			employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ligue.setAdministrateur(employe);
		assertTrue(employe.estAdmin(ligue));
	}
	//estRoot = Ok
	@Test
	void testEstRoot() {
		Ligue ligue = new Ligue("bilboquet");
		Employe root = GestionPersonnel.getGestionPersonnel().getRoot();
		Employe employer = null;
		try {
			employer = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(root.estRoot());
		assertFalse(employer.estRoot());
	}
	//textSetNom & GetNom = ok 
	@Test
	void testSetNom() {
		Ligue ligue = new Ligue("P�tanque");
		Employe employe = null;
		try {
			employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nom = "Janothan";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}

	//SetPrenom & GetPrenom = ok
	@Test
	void testSetPrenom() {
		Ligue ligue = new Ligue("P�tanque");
		Employe employe = null;
		try {
			employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pr�nom = "Mickael";
		employe.setPrenom(pr�nom);
		assertEquals(employe.getPrenom(),pr�nom);
	}

	//SetMail & GetMail = ok
	@Test
	void testSetMail() {
		Ligue ligue = new Ligue("P�tanque");
		Employe employe = null;
		try {
			employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mail = "MickaelJanothan@gmail.com";
		employe.setMail(mail);
		assertEquals(employe.getMail(),mail);
	}
//CheckPassword & SetPassword = ok
	@Test
	void testCheckPassword() {
		Ligue ligue = new Ligue("P�tanque");
		Employe employe = null;
		try {
			employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String password = "toto94200";
		employe.setPassword(password);
		assertTrue(employe.checkPassword(password));
		assertFalse(employe.checkPassword("troll"));
	}
// GetLigue = ok
	@Test
	void testGetLigue() {
		Ligue ligue = new Ligue("P�tanque");
		Employe employe = null;
		try {
			employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(employe.getLigue(), ligue);
	}
	// Remove = ok
	@Test
	void testRemove() {
		Ligue ligue = new Ligue("P�tanque");
		Employe employe1 = null;
		try {
			employe1 = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Employe employe2 = GestionPersonnel.getGestionPersonnel().getRoot();
		ligue.setAdministrateur(employe1);
		employe1.remove();
		assertFalse(ligue.getEmployes().contains(employe1));
		assertNull(employe1.getLigue());
		assertTrue(ligue.getAdministrateur().equals(employe2));		
	}
	// CompareTo = ok
	@Test
	void testCompareTo() {
		Ligue ligue = new Ligue("P�tanque");
		Employe employe1 = null;
		try {
			employe1 = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Employe employe2 = null;
		try {
			employe2 = ligue.addEmploye("Giselle","Du trou","Giselledutrou@gmail.com","puit",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(employe1.getPrenom().compareTo(employe2.getPrenom()),0);
	}
	// ToString = OK
	@Test
	void testToString() {
		Ligue ligue = new Ligue("P�tanque");
		Employe employe = null;
		try {
			employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(employe.toString(), "Bouchard G�rard g.bouchard@gmail.com ("+ligue.toString()+")");
	}
	// SetDateArriver & GetDateArriver = Ok
	@Test
	void testSetDateArriver() {
		Ligue ligue = new Ligue("P�tanque");
		Employe employe = null;
		try {
			employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalDate date = LocalDate.of(2000, 12, 12);
		try {
			employe.setDateArrivee(date);
		} catch (dateArriveeException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(employe.getDateArrivee(),date);
	}
	// SetDateDepart & GetDateDepart = Ok
	@Test
	void testSetDateDepart() {
		Ligue ligue = new Ligue("P�tanque");
		Employe employe = null;
		try {
			employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalDate date = LocalDate.of(2020, 12, 22);
		try {
			employe.setDateDepart(date);
		} catch (dateDepartException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(employe.getDateDepart(),date);
	}
	
}


