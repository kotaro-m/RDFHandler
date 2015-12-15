package RDFUpdater;

import java.io.FileOutputStream;
import java.io.IOException;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFWriter;
import com.hp.hpl.jena.rdf.model.Resource;

public class Updater {
	public static void RDFUpdater(Resource subject,String object) throws IOException{
		Model model = ModelFactory.createDefaultModel();
		model.read("/data/RDF/news.rdf", "RDF/XML");

		final String SCHEMA_NS = "http://schema.org/";
		Property associatedArticle = model.createProperty(SCHEMA_NS + "associatedArticle");

		model.add(subject, associatedArticle , object);

		FileOutputStream out = new FileOutputStream("/data/RDF/news.rdf");
		RDFWriter writer = model.getWriter("RDF/XML");
		writer.write(model, out, "RDF/XML");
	}
}
