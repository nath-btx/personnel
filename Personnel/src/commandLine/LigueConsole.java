package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;
import static commandLineMenus.rendering.examples.util.InOut.getInt;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import commandLineMenus.List;
import commandLineMenus.Menu;
import commandLineMenus.Option;

import personnel.*;

public class LigueConsole 
{
	private GestionPersonnel gestionPersonnel;
	private EmployeConsole employeConsole;

	public LigueConsole(GestionPersonnel gestionPersonnel, EmployeConsole employeConsole)
	{
		this.gestionPersonnel = gestionPersonnel;
		this.employeConsole = employeConsole;
	}

	Menu menuLigues()
	{
		Menu menu = new Menu("Gérer les ligues", "l");
		menu.add(afficherLigues());
		menu.add(ajouterLigue());
		menu.add(selectionnerLigue());
		menu.addBack("q");
		return menu;
	}

	private Option afficherLigues()
	{
		return new Option("Afficher les ligues", "l", () -> {System.out.println(gestionPersonnel.getLigues());});
	}

	private Option afficher(final Ligue ligue)
	{
		return new Option("Afficher la ligue", "l", 
				() -> 
				{
					System.out.println(ligue);
					System.out.println("administrée par " + ligue.getAdministrateur());
				}
		);
	}
	
	private Option afficherEmployes(final Ligue ligue)
	{
		return new Option("Afficher les employes", "l", () -> {System.out.println(ligue.getEmployes());});
	}
	

	private Option ajouterLigue()
	{
		return new Option("Ajouter une ligue", "a", () -> {new Ligue (getString("nom : "));});
	}
	
	private Menu editerLigue(Ligue ligue)
	{
		Menu menu = new Menu("Editer " + ligue.getNom());
		menu.add(afficher(ligue));
		menu.add(gererEmployes(ligue));
		menu.add(changerAdministrateur(ligue));
		menu.add(changerNom(ligue));
		menu.add(supprimer(ligue));
		menu.addBack("q");
		return menu;
	}

	private Option changerNom(final Ligue ligue)
	{
		return new Option("Renommer", "r", 
				() -> {ligue.setNom(getString("Nouveau nom : "));});
	}

	private List<Ligue> selectionnerLigue()
	{
		return new List<Ligue>("Sélectionner une ligue", "e", 
				() -> new ArrayList<>(gestionPersonnel.getLigues()),
				(element) -> editerLigue(element)
				);
	}
	
	private Option ajouterEmploye(final Ligue ligue)
	{
		return new Option("Ajouter un employé", "a",
				() -> 
				{
					try {
						ligue.addEmploye(getString("nom : "), 
							getString("prenom : "), getString("mail : "), 
							getString("password : "), getDate());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		);
	}
	
	public static LocalDate getDate(){
		int day = getInt("Jour : ");
		int month = getInt("Mois : ");
		int year = getInt("Année : ");
		
		return LocalDate.of(year,month,day);
		
	}
	
	// TODO attraper l'exception si les valeurs rentrées ne sont pas bonnes
	// 
	// Passer de 3 getInt à un LocalDate

	private Menu gererEmployes(Ligue ligue)
	{
		Menu menu = new Menu("Gérer les employés de " + ligue.getNom(), "e");
		menu.add(afficherEmployes(ligue));
		menu.add(ajouterEmploye(ligue));
		menu.add(selectionnerEmployes(ligue));
		//menu.add(changerAdministrateur(ligue));
		menu.addBack("q");
		return menu;
	}
	
	private Menu selectionnerEmployes(Ligue ligue)
	{
		
		return new List<>("Sélectionner un employé", "e", 
				() -> new ArrayList<>(ligue.getEmployes()),
				(element) -> employeConsole.editerEmploye(element));
		
		/*
		Menu menu = new Menu("Sélectionner les employés de " + ligue.getNom(), "s");	
		menu.add(afficherEmployes(ligue));
		menu.add(modifierEmploye(ligue));
		menu.add(supprimerEmploye(ligue));
		menu.addBack("q");
		
		
		 return menu;
		 */
	}
	/*
	private Menu editer(Employe employe) {
		Menu menu = new Menu("Gérer l'employé ");
		menu.add(employeConsole.editerEmploye(employe));
		menu.add(supprimerEmploye(employe));
		menu.addBack("q");
		return menu;
	}
	*/
	
	
	private Option supprimerEmploye(final Employe employe)
	{
		return new Option("Supprimer " + employe.getNom()+" "+ employe.getPrenom(), "v"
				,()->{employe.remove();});
	}
	
	private List<Employe> changerAdministrateur(final Ligue ligue)
	{
			return new List<>("Sélectionner un nouvel administrateur", "s", 
					() -> new ArrayList<>(ligue.getEmployes()),
					(index, element) -> {ligue.setAdministrateur(element);}
					);
	}	
/*		
		return new List<Employe>("Sélectionner l'employé qui deviendra admin", "o", 
				() -> new ArrayList<>(ligue.getEmployes()),
				(element) -> ligue.setAdministrateur(element)
				);
	}

/*
	private List<Employe> modifierEmploye(final Ligue ligue)
	{
		
		return new List<>("Modifier un employé", "e", 
				() -> new ArrayList<>(ligue.getEmployes()),
				(index, element) -> {employeConsole.editerEmploye(element);}
				);
	}
	*/

	private Option supprimer(Ligue ligue)
	{
		return new Option("Supprimer", "d", () -> {ligue.remove();});
	}
}
