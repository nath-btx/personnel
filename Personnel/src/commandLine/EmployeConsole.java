package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.*;

import java.sql.SQLException;
import java.time.LocalDate;

import commandLineMenus.Menu;
import commandLineMenus.Option;
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.dateArriveException;
import personnel.dateDepartException;
import commandLine.LigueConsole;


public class EmployeConsole 
{
	private Option afficher(final Employe employe)
	{
		return new Option("Afficher l'employ�", "g", () -> {System.out.println(employe);});
	}

	Menu editerEmploye(Employe employe)
	{
		Menu menu = new Menu("G�rer le compte " + employe.getNom(), "c");
		menu.add(afficher(employe));
		menu.add(changerNom(employe));
		menu.add(changerPrenom(employe));
		menu.add(changerMail(employe));
		menu.add(changerPassword(employe));
		menu.add(changerDateArrivee(employe));
		menu.add(changerDateDepart(employe));
		menu.add(supprimerEmploye(employe));
		menu.addBack("q");
		return menu;
	}
	
	private Option supprimerEmploye(final Employe employe)
	{
		return new Option("Supprimer " + employe.getNom()+" "+ employe.getPrenom(), "v"
				,()->{employe.remove();});
	}
	

	private Option changerNom(final Employe employe)
	{
		return new Option("Changer le nom", "n", 
				() -> {employe.setNom(getString("Nouveau nom : "));}
			);
	}
	
	private Option changerPrenom(final Employe employe)
	{
		return new Option("Changer le pr�nom", "p", () -> {employe.setPrenom(getString("Nouveau pr�nom : "));});
	}
	
	private Option changerMail(final Employe employe)
	{
		return new Option("Changer le mail", "e", () -> {employe.setMail(getString("Nouveau mail : "));});
	}
	
	private Option changerPassword(final Employe employe)
	{
		return new Option("Changer le password", "x", () -> {employe.setPassword(getString("Nouveau password : "));});
	}
	
	private Option changerDateArrivee(final Employe employe)
	{
		return new Option("Changer la date d'arriv�e", "a", () -> {
			try {
				employe.setDateArrivee(getDate());
			} 
			catch (dateArriveException e) {
				System.out.println("La date de d�part ne peut pas �tre avant la date d'arriv�e");
			} 
			catch (SQLException e) {
				System.out.println("Invalid Values");
			}
			});
	}
	
	private Option changerDateDepart(final Employe employe)
	{
		return new Option("Changer la date de d�part", "d", () -> {
			try {
				employe.setDateDepart(getDate());
			} 
			catch (dateDepartException e) {
				System.out.println("La date d'arriv�e ne peut pas �tre apr�s la date de depart");
			} catch (SQLException e) {
				System.out.println("Invalid Values");			}
			});
	}
	
	
	
	private LocalDate getDate(){
		int day = getInt("Jour : ");
		int month = getInt("Mois : ");
		int year = getInt("Ann�e : ");
		
		LocalDate inputDate = LocalDate.of(year,month,day);
		
		return inputDate;
	}
}
