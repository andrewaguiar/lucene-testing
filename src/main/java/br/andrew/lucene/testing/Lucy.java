package br.andrew.lucene.testing;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Lucy {

	private final IndexWriter indexWriter;

	public Lucy(final LucyConfig lucyConfig) throws IOException {

		final File indexesFolder = new File(lucyConfig.getIndexesFolder());
		final Directory dir = FSDirectory.open(indexesFolder);

		final Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);

		final IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_43, analyzer);
		indexWriterConfig.setOpenMode(OpenMode.CREATE);
		indexWriterConfig.setRAMBufferSizeMB(512);

		this.indexWriter = new IndexWriter(dir, indexWriterConfig);
	}

	public void addDocument(final Field... fields) throws IOException {
		final Document document = new Document();
		for (final Field field : fields) {
			document.add(field);
		}
		this.indexWriter.addDocument(document);
	}

	public void close() throws IOException {
		this.indexWriter.close();
	}
}
