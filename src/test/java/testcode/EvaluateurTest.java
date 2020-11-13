package testcode;

import code.EvaluateurNiveau;
import code.ExceptionNoteHorsBorne;
import code.ExceptionNoteNonEntiere;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateurTest {

	@ParameterizedTest(name = "Test limite avec cours = {0} et examen = {1}, niveau attendu: {2}")
	@CsvSource({ "0,0,D", "25,4,D", "0,30,C", "20,29,C", "20,30,B", "25,44,B", "25,45,A", "25,75,A" })
	void testLimite(String cours, String examen, String nivAttendu)
			throws ExceptionNoteNonEntiere, ExceptionNoteHorsBorne {
		String niveauObtenu = EvaluateurNiveau.evaluerNiveau(cours, examen);
		assertEquals(nivAttendu, niveauObtenu);
		// assertThrows(NumberFormatException.class, () -> {
		// Integer.valueOf(niveauObtenu); });
	}

	@ParameterizedTest
	@CsvSource({ "10.25,20", "xxx,20", "10,50.345", "10,exam" })
	void TestExceptionSiNoteExamenOuCoursNonEntier(String cours, String examen) {
		assertThrows(ExceptionNoteNonEntiere.class, () -> {
			EvaluateurNiveau.evaluerNiveau(cours, examen);
		});

	}

	@ParameterizedTest
	@CsvSource({ "-1,20", "26,20", "10,-1", "20,76" })
	void TestExceptionSiNotePasDansBornes(String cours, String examen) {
		assertThrows(ExceptionNoteHorsBorne.class, () -> {
			EvaluateurNiveau.evaluerNiveau(cours, examen);
		});
	}

}