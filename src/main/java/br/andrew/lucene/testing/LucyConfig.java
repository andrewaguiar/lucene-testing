package br.andrew.lucene.testing;

public class LucyConfig {

	private final String indexesFolder;

	public LucyConfig(final String indexesFolder) {
		this.indexesFolder = indexesFolder;
	}

	public String getIndexesFolder() {
		return this.indexesFolder;
	}
}
