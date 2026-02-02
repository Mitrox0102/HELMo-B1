package labo5;

public class Chatbot {

	public static void main(String[] args) {

	}

	/**
	 * Retourne une réponse sur base de la demande spécifiée.
	 * 
	 * @param demande La demande formulée par l'utilisateur.
	 * @return Une réponse appropriée à la demande si cette dernière est comprise,
	 *         une demande reformulation dans le cas contraire.
	 */
	private static String choisirReponse(String demande) {
		final String REPONSE_PAR_DEFAUT = "Je ne suis pas sûr de comprendre. Pouvez-vous reformuler ?";
		String reponse;

		// Retirer les caractères non significatifs de la demande

		demande = demande.trim().replaceAll("[\s,-]+", " ").toLowerCase();

		// Sélectionnez la réponse la plus appropriée

		if (demande.contains("au revoir")) {
			reponse = "Au revoir !";
		} else if (demande.contains("et vous") || demande.contains("et toi") || demande.contains("comment ça va")
				|| demande.contains("comment vas tu") || demande.contains("comment allez vous")) {
			reponse = "Je suis un logiciel, donc je ne ressens rien, mais merci de demander.";
		} else if (demande.contains("bonjour") || demande.contains("salut")) {
			reponse = "Comment allez-vous ?";
		} else if (demande.contains("ton nom") || demande.contains("votre nom")) {
			reponse = "Je suis une intelligence artificielle sans nom propre, mais vous pouvez m'appeler Chatbot.";
		} else if (demande.contains("sens de la vie")) {
			reponse = "Le sens de la vie est un mystère, mais certains disent que c'est 42.";
		} else {
			reponse = REPONSE_PAR_DEFAUT;
		}

		return reponse;
	}
}
