import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EcrireDom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EcrireDom eD = new EcrireDom();
		eD.ecrireDom();
	}

	public void ecrireDom() {

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;

		try {
			documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			Element racine = document.createElement("listeEtudiant");
			document.appendChild(racine);

			Comment commentaire = document.createComment("Ceci est la listedes etudiants");
			racine.appendChild(commentaire);

			for (int i = 0; i < 3; i++) {
				Element form = document.createElement("formation");
				racine.appendChild(form);
				form.setAttribute("id", Integer.toString(i));

				for (int j = 0; j < 5; j++) {

					Element eEtudiant = document.createElement("etudiant");
					form.appendChild(eEtudiant);
					eEtudiant.setAttribute("nom", "etudiant" + Integer.toString(j));
					eEtudiant.setAttribute("prenom", "prenom" + Integer.toString(j));
					eEtudiant.setAttribute("nom", "metier" + Integer.toString(j));
					System.out.println("ceci est un exemple:" + i + " " + j);
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(document);
			StreamResult sortie = new StreamResult(new File("donnee/creEtudiants.xml"));

			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			transformer.transform(source, sortie);

		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
