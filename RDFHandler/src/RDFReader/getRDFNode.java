package RDFReader;

import java.util.List;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

public class getRDFNode {
	public static Resource getSubject(String o){
		Model model = ModelFactory.createDefaultModel();
		model.read("/data/RDF/news.rdf", "RDF/XML");
		Resource subject = null;
		String queryString = "PREFIX schema: <http://schema.org/>"+
				 "SELECT DISTINCT  ?s  " +
	             "WHERE {"+
				 "?s schema:articleBody \"" + o + "\".}";
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();

		List<QuerySolution> Temp = ResultSetFormatter.toList(results);
		String ID = null;
		if(!Temp.isEmpty()){
			ID=Temp.get(0).toString().replace("( ?s = <", "").replace("> )", "");
			subject = model.createResource(ID);
		}
		qe.close();


		return subject;
	}

	public static String getURL(Resource resource){
		Model model = ModelFactory.createDefaultModel();
		model.read("/data/RDF/news.rdf", "RDF/XML");
		String s = resource.toString();
		String queryString = "PREFIX schema: <http://schema.org/>"+
				 "SELECT DISTINCT *" +
	             "WHERE {"+
				 		"<" + s + "> schema:url ?o.}";
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();

		List<QuerySolution> Temp = ResultSetFormatter.toList(results);
		String URL = null;
		URL=Temp.get(0).toString().replace("( ?o = \"", "").replace("\" )", "");
		qe.close();

		return URL;
	}
}
