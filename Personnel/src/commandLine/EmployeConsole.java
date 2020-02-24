package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getInt;
import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.time.LocalDate;

import commandLineMenus.Menu;
import commandLineMenus.Option;
import personnel.Employe;
import personnel.GestionPersonnel;
import commandLine.LigueConsole;


public class EmployeConsole 
{
	private Option afficher(final Employe employe)
	{
		return new Option("Afficher l'employ�", "l", () -> {System.out.println(employe);});
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
		menu.addBack("q");
		return menu;
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
		return new Option("Changer la date d'arriv�e", "a", () -> {employe.setDateArrivee(getDate());});
	}
	
	private Option changerDateDepart(final Employe employe)
	{
		return new Option("Changer la date de d�part", "d", () -> {employe.setDateDepart(getDate());});
	}
	
	private LocalDate getDate(){
		int day = getInt("Jour : ");
		int month = getInt("Mois : ");
		int year = getInt("Ann�e : ");
		
		LocalDate inputDate = LocalDate.of(year,month,day);
		
		return inputDate;
	}
}
