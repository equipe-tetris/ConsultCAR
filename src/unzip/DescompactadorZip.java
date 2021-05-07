package unzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DescompactadorZip {
	
	 List fileList;
	    private static final String ARQUIVO_ZIP_ENTRADA = "C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\ArquivoCompactado\\AREA_IMOVEL.zip";
	    private static final String DIRETORIO_SAIDA = "C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\ArquivoDescompactado";
	    public static void main( String[] args )
	    {
	    	DescompactadorZip unZip = new DescompactadorZip();
	    	unZip.Descompactador(ARQUIVO_ZIP_ENTRADA, DIRETORIO_SAIDA);
	    }
	    
	    public void Descompactador(String arquivoZip, String dirSaida){
	     byte[] buffer = new byte[4096];
	     try{
	    	
	    	File folder = new File(DIRETORIO_SAIDA);
	    	if(!folder.exists()){
	    		folder.mkdirs();
	    	}
	    	
	    	ZipInputStream zipInput =
	    		new ZipInputStream(new FileInputStream(arquivoZip));
	    	
	    	ZipEntry zipEntry =  zipInput.getNextEntry();
	    	while(zipEntry!=null){
	    	   String nomeArquivo = zipEntry.getName();
	           File newFile = new File(dirSaida + File.separator + nomeArquivo);
	           System.out.println("Arquivo descompactado: " + newFile.getAbsoluteFile());
	          
	            new File(newFile.getParent()).mkdirs();
	            FileOutputStream fos = new FileOutputStream(newFile);
	            int len;
	            while ((len =  zipInput.read(buffer)) > 0) {
	       		fos.write(buffer, 0, len);
	            }
	            fos.close();
	            zipEntry =  zipInput.getNextEntry();
	    	}
	    	 zipInput.closeEntry();
	    	 zipInput.close();
	    	
	    	System.out.println("Finalizado");
	    }catch(IOException ex){
	       ex.printStackTrace();
	    }
	   }
	}


