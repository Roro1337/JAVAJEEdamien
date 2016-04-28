package dd.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dd.metier.Formation;
import dd.metier.ListeFormation;

/**
 * Servlet implementation class ServletListeFormation
 */
@WebServlet("/ServletListeFormation")
public class ServletListeFormation extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListeFormation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {

		// File cv = new File("../workspace/Projet_Cv/WebContent/monCv.html");
		// lireFichierHtml(cv);

	}

	private void chargerListeEtudiants(ListeFormation listeFormation2) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ListeFormation listeFormation = chargeXmlFormation();
		chargerListeEtudiants(listeFormation);

		// response.getWriter() flux de sortie ligne par ligne methode de
		// HttpResponse dans le doGet
		PrintWriter out = response.getWriter();
		File f = new File("../workspace/Projet_Cv/WebContent/WEB-INF/page/pageListeFormation.html");
		BufferedReader bR = new BufferedReader(new FileReader(f));
		String line = bR.readLine();
		while (line != null) {
			if (line.contains("%%name%%") || line.contains("%%valeur%%") || line.contains("%%date%%")
					|| line.contains("%%lieu%%") || line.contains("%%date%%")) {
				affListeFormation(out, line, listeFormation);
			} else {
				out.println(line);
			}

			line = bR.readLine();
		}
		// todo
		bR.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ListeFormation listeFormation = (ListeFormation) session.getAttribute("listeForm");
		int sel = 0;
		String sSel = req.getParameter("bFormation");
		Formation formation;
		// Enumeration<String> par = req.getParameterNames();
		// while (par.hasMoreElements()) {
		// String sVal = par.nextElement();
		// if (sVal.contains("sel")) {
		// sel = Integer.valueOf(sVal.replace("sel", ""));
		// break;
		// }
		// }
		// Formation formation =
		// listeFormation.get(Integer.valueOf(sel).intValue());
		// session.setAttribute("formation", formation);

	}

	private void affListeFormation(PrintWriter out, String line, ListeFormation listeFormation) {
		for (Formation formation : listeFormation) {
			String ligneAAfficher = line;
			ligneAAfficher = ligneAAfficher.replace("%%name%%", "unchiffre");
			ligneAAfficher = ligneAAfficher.replace("%%valeur%%", "" + listeFormation.indexOf(formation));
			ligneAAfficher = ligneAAfficher.replace("%%date%%", formation.getDateFormation());
			ligneAAfficher = ligneAAfficher.replace("%%lieu%%", formation.getLieuFormation());
			ligneAAfficher = ligneAAfficher.replace("%%domaine%%", formation.getDomaineFormation());
			out.println(ligneAAfficher);
			// // meme chose
			// out.println("<tr><td style=\"width: 5%\">sel</td><td
			// style=\"width: 20%\">" + formation.getDateFormation()
			// + "</td><td style=\"width 50%\">" + formation.getLieuFormation()
			// + "</td><td style=\"width: 30%\">"
			// + formation.getDomaineFormation() + "</td></td>");
		}

	}

	private ListeFormation chargeXmlFormation() {
		// Créer des Objets à partir d'un fichier XML
		File f = new File("../workspace/Projet_Cv/WebContent/WEB-INF/xml/formation.xml");
		BufferedReader buf = null;
		ListeFormation listeFormation = null;
		try {
			buf = new BufferedReader(new FileReader(f.getAbsolutePath()));
			String line = buf.readLine();
			while (line != null) {
				if (line.contains("<ListeFormation>")) {
					// String nomListeFormation = extraitAtt(line,
					// "listeFormation='");
					listeFormation = new ListeFormation();
				} else if (line.contains("<Formation ")) {
					String dateFormation = extraitAtt(line, "dateFormation='");
					String lieuFormation = extraitAtt(line, "lieuFormation='");
					String domaineFormation = extraitAtt(line, "domaineFormation='");
					Formation a = new Formation(dateFormation, lieuFormation, domaineFormation);
					listeFormation.add(a);

				} else if (line.contains("</ListeFormation>")) {
					for (Formation formation : listeFormation) {
						System.out.println(formation.toString());
					}
				}
				line = buf.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return listeFormation;
	}

	public String extraitAtt(String line, String ch) {
		// Extrait la valeur de l'attribut
		String res = "";
		String newLine = line.replace("\"", "'");

		int ind0 = newLine.indexOf(ch);
		int ind1 = newLine.indexOf("'", ind0 + ch.length());
		res = newLine.substring(ind0 + ch.length(), ind1);
		return res;
	}

}
