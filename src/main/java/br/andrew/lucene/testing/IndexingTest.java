package br.andrew.lucene.testing;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

public class IndexingTest {

	public static void main(final String[] args) throws Exception {

		final LucyConfig lucyConfig = new LucyConfig("index");

		final Lucy lucy = new Lucy(lucyConfig);

		for (final String [] data : IndexingTest.getDatas()) {
			lucy.addDocument(
					new StringField("id", data[0], Field.Store.YES),
					new StringField("name", data[1], Field.Store.YES),
					new TextField("contents", data[2], Field.Store.YES));
		}

		lucy.close();
	}

	private static String[][] getDatas() {
		return new String[][] {
				{"1", "Christop Schneider", "Nam eaque earum ipsum."},
				{"2", "Carolina Sanford", "Facilis nisi ut ipsa quibusdam est explicabo."},
				{"3", "Reta Hirthe", "Molestias pariatur laboriosam eveniet saepe cumque."},
				{"4", "Sofia Bernhard", "Non assumenda nisi et reprehenderit perferendis fugiat."},
				{"5", "Hattie Ernser", "Maiores id adipisci eum vel."},
				{"6", "Armand Hamill", "Voluptas iure culpa est ipsum."},
				{"7", "Vida McDermott", "Quaerat consequuntur est autem porro voluptates exercitationem qui."},
				{"8", "Emmalee Schuppe", "Et quae consequatur quis hic sunt."},
				{"9", "Darren Wyman", "Qui officia dicta ex voluptatem ducimus dolorem."},
				{"10", "Shannon Satterfield", "Illum nihil rerum exercitationem et cumque quaerat eos consequuntur."},
				{"11", "Leanne Lockman", "Error aperiam tempora voluptatem excepturi ut."},
				{"12", "Icie Anderson", "Dolorem quod et sapiente veniam aspernatur repudiandae explicabo."},
				{"13", "Geovanny Jakubowski Jr.", "Nesciunt quis eum velit beatae animi qui."},
				{"14", "Zoie Abbott", "Magni quos dolor dolores velit."},
				{"15", "Mr. Trever Howe", "Occaecati ut vitae ut qui assumenda iusto."},
				{"16", "Dalton Ortiz", "Maiores ratione iusto accusamus omnis."},
				{"17", "Ms. Danika Dickens", "Harum consequatur pariatur ipsum ut ratione non reiciendis."},
				{"18", "Pierce Roob", "Dolorum voluptatem quam nihil ipsam magni occaecati harum molestiae."},
				{"19", "Tomas Paucek Sr.", "Dolor possimus voluptate facere veniam molestiae dolorem."},
				{"20", "Brad Leffler", "Iure nesciunt vitae vel sit atque tenetur dignissimos."}
		};
	}
}
