package Persistencia;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public final class XMLayudante{
    private XMLayudante(){}

    public static Document nuevoDocumento(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.newDocument();
        }catch(Exception e){
            throw new RuntimeException("No se pudo crear el documento XML",e);
        }
    }

    public static Document cargarDoc(String path){
        try{
            File f=new File(path);
            if(!f.exists()) return null;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(f);
        }catch(Exception e){
            throw new RuntimeException("No se pudo cargar XML" + path,e);
        }
    }
    public static void guardarDoc(Document doc, String path){
        try{
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);
        }catch(Exception e){
            throw new RuntimeException("No se pudo guardar XML en: " + path, e);
        }
    }
}
