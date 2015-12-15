package RDFReader;

import java.util.ArrayList;
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

public class Reader {
	public static List<String> RDFreader_yn(){
		Model model = ModelFactory.createDefaultModel();
		model.read("/data/RDF/news.rdf", "RDF/XML");
		String queryString = "PREFIX schema: <http://schema.org/>"+
				 "SELECT DISTINCT  ?o  " +
	             "WHERE {"+
				 "?s schema:publisher \"yn\"."+
				 "?s schema:articleBody ?o.}";
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();

		List<QuerySolution> Temp = ResultSetFormatter.toList(results);
		List<String> yn = new ArrayList<String>();
		for(int i=0;i < Temp.size(); i++)
			yn.add(Temp.get(i).toString().replace("( ?o = \"", "").replace("\" )", ""));
		qe.close();
		return yn;
	}

	public static List<String> RDFreader_livedoor(){
		Model model = ModelFactory.createDefaultModel();
		model.read("/data/RDF/news.rdf", "RDF/XML");
		String queryString = "PREFIX schema: <http://schema.org/>"+
				 "SELECT DISTINCT  ?o  " +
	             "WHERE {"+
				 "?s schema:publisher \"livedoor\"."+
				 "?s schema:articleBody ?o.}";
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();

		List<QuerySolution> Temp = ResultSetFormatter.toList(results);
		List<String> livedoor = new ArrayList<String>();
		for(int i=0;i < Temp.size(); i++)
			livedoor.add(Temp.get(i).toString().replace("( ?o = \"", "").replace("\" )", ""));
		qe.close();
		return livedoor;
	}

	public static List<String> RDFreader_sankei(){
		Model model = ModelFactory.createDefaultModel();
		model.read("/data/RDF/news.rdf", "RDF/XML");
		String queryString = "PREFIX schema: <http://schema.org/>"+
				 "SELECT DISTINCT  ?o  " +
	             "WHERE {"+
				 "?s schema:publisher \"sankei\"."+
				 "?s schema:articleBody ?o.}";
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();

		List<QuerySolution> Temp = ResultSetFormatter.toList(results);
		List<String> sankei = new ArrayList<String>();
		for(int i=0;i < Temp.size(); i++)
			sankei.add(Temp.get(i).toString().replace("( ?o = \"", "").replace("\" )", ""));
		qe.close();
		return sankei;
	}
}
