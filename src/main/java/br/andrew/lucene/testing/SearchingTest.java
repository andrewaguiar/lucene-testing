package br.andrew.lucene.testing;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class SearchingTest {

	public static void main(final String[] args) throws Exception {
		final String searchTerm = "ipsum";

		final IndexReader reader = DirectoryReader.open(FSDirectory.open(new File("index")));
		final IndexSearcher searcher = new IndexSearcher(reader);
		final Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);

		final QueryParser parser = new QueryParser(Version.LUCENE_43, "contents", analyzer);

		final Query query = parser.parse(searchTerm);

		final TopDocs topDocs = searcher.search(query, 10);

		System.out.println("searching for '" + searchTerm + "'");
		System.out.println(topDocs.totalHits + " results found");
		System.out.println("------------------------------------------------------");

		for (final ScoreDoc doc : topDocs.scoreDocs) {
			final Document document = searcher.doc(doc.doc);

			String json = "{";
			for (final IndexableField field : document.getFields()) {
				json += "'" + field.name() + "' : '" + field.stringValue() + "', ";
			}
			json = json.substring(0, json.length() - 1) + "}";

			System.out.println(doc.doc + ": " + doc.score + " = " + json);
		}
	}
}
