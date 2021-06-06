package shape;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
import org.geotools.geometry.jts.WKBReader;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.Filter;


import db_connection.ConnectionFactory;


public class ShapeService {
	
	ShapeItem shape = new ShapeItem();
	
	ShapeItemDAO con = new ShapeItemDAO();
	
	List<ShapeItem> shapeList = new ArrayList<>();
	
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
                System.out.println(feature.getAttributes());
                
                
                
                
            }
        }
	}
	
	public void dbfItem() throws IOException, ClassNotFoundException, SQLException {
		  File file = new File("C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\Unzip\\AREA_IMOVEL.shp");
	        FileDataStore myData = FileDataStoreFinder.getDataStore(file);
	        SimpleFeatureSource source = myData.getFeatureSource();
	        SimpleFeatureType schema = source.getSchema();
	        
	        //System.out.println(schema);

	        Query query = new Query(schema.getTypeName());
	        //query.setMaxFeatures(1);
	        
	        Geometry geometry = null;

	        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(query);
	        try (FeatureIterator<SimpleFeature> features = collection.features()) {
	            while (features.hasNext()) {
	            	
	                SimpleFeature feature = features.next();
	                //System.out.println(feature.getID() + ": ");
	                Collection<Property> att = feature.getProperties();
	                for (Property pro : att) {
	                    //System.out.println("\t" + pro.getName() + ":" + pro.getValue() );
	                	
	                	
	                	
	                	String ID = feature.getID().toString();
	                	Geometry the_geom = (Geometry) feature.getAttribute(0);
	                	String COD_IMOVEL = feature.getAttribute(1).toString();
	                	String NUM_AREA = feature.getAttribute(2).toString();
	                	String COD_ESTADO = feature.getAttribute(3).toString();
	                	String NOME_MUNICIPIO = feature.getAttribute(4).toString();
	                	String NUM_MODULO = feature.getAttribute(5).toString();
	                	String TIPO_IMOVEL = feature.getAttribute(6).toString();
	                	String SITUACAO = feature.getAttribute(7).toString();
	                	String CONDICAO_I = feature.getAttribute(8).toString();
	                	
	                
	                	
	                	
	              
	                	shape.setGid(ID);
	                	shape.setGeom(the_geom);
	                	shape.setCod_imovel(COD_IMOVEL);
	                	shape.setNum_area(Double.parseDouble(NUM_AREA));
	                	shape.setCod_estado(COD_ESTADO);
	                	shape.setNome_municipio(NOME_MUNICIPIO);
	                	shape.setNum_modulo(Double.parseDouble(NUM_MODULO));
	                	shape.setTipo_imovel(TIPO_IMOVEL);
	                	shape.setSituacao(SITUACAO);
	                	shape.setCondicao_imovel(CONDICAO_I);
	                	
	                	
	                	con.save(shape);
	             
	                	/*System.out.println("ID: " + ID);
	                	System.out.println("the_geom: " + the_geom);
	                	System.out.println("COD_IMOVEL: " + COD_IMOVEL);
	                	System.out.println("NUM_AREA: " + NUM_AREA);
	                	System.out.println("COD_ESTADO: " + COD_ESTADO);
	                	System.out.println("NOME_MUNICIPIO: " + NOME_MUNICIPIO);
	                	System.out.println("NUM_MODULO: " + NUM_MODULO);
	                	System.out.println("TIPO_IMOVEL: " + TIPO_IMOVEL);
	                	System.out.println("SITUACAO: " + SITUACAO);
	                	System.out.println("CONDICAO_I: " + CONDICAO_I);*/
	                 }
	                
	                
	               
	                 //shapeList.add(shape);
	                 
	                 //System.out.println(shapeList);
	                 
	                }
	            }
	        
	        }
    
	}

