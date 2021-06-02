package shape;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.Query;
import org.geotools.data.shapefile.dbf.DbaseFileReader;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.Filter;

public class shapeService {
	
	public void shapeItem() throws IOException {
	    File file = new File("C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\Unzip\\AREA_IMOVEL.shp");
        Map<String, Object> map = new HashMap();
        map.put("url", file.toURI().toURL());

        DataStore dataStore = DataStoreFinder.getDataStore(map);
        String typeName = dataStore.getTypeNames()[0];

        FeatureSource<SimpleFeatureType, SimpleFeature> source = dataStore.getFeatureSource(typeName);
        Filter filter = Filter.INCLUDE; 

        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(filter);
        try (FeatureIterator<SimpleFeature> features = collection.features()) {
            while (features.hasNext()) {
                SimpleFeature feature = features.next();
                System.out.print(feature.getID());
                System.out.print(": ");
                System.out.println(feature.getDefaultGeometryProperty().getValue());
            }
        }
	}
	
	public void dbfItem() throws IOException {
		  File file = new File("C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\Unzip\\AREA_IMOVEL.shp");
	        FileDataStore myData = FileDataStoreFinder.getDataStore(file);
	        SimpleFeatureSource source = myData.getFeatureSource();
	        SimpleFeatureType schema = source.getSchema();

	        Query query = new Query(schema.getTypeName());
	        //query.setMaxFeatures(1);

	        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(query);
	        try (FeatureIterator<SimpleFeature> features = collection.features()) {
	            while (features.hasNext()) {
	                SimpleFeature feature = features.next();
	                System.out.println(feature.getID() + ": ");
	                for (Property attribute : feature.getProperties()) {
	                    System.out.println("\t" + attribute.getName() + ":" + attribute.getValue());
	                }
	            }
	        }
	}
}
