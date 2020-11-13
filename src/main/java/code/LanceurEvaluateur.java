package code;

public class LanceurEvaluateur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length==2) {
			try {
				String cours=args[0];
				String examen=args[1];
				String niveau = EvaluateurNiveau.evaluerNiveau(cours, examen);
				System.out.println("Niveau étudiant : "+niveau);
			}
			catch(ExceptionNoteNonEntiere enne) {
				System.out.println("Notes doivent etre entiere");
			}
			catch(ExceptionNoteHorsBorne enhb) {
				System.out.println("Notes hors bornes");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("2 arguments attendus : cours examen");
		}
		
	}

}
