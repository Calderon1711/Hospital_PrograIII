package Persistencia;


import Modelo.*;
import javafx.collections.ObservableList;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class PersistenciaPersonalXML {

    public static void guardar(ListaPersonal lista) {
        try{
            //Factory para crear DocumentBuilder(DOM)
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();

            //esto solo son medidas de seguridad(no es necesario esto es por si cargamos un archivo malicioso o asi  )
            try{
                //Este evita que alguien meta definiciones externas peligrosas
                Factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
                //esta bloquea las entidades externas generales
                Factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
                //esta es casi lo mismo q la de arriba
                Factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
                //esta deshabilita incluir otros xml dentro del doc
                Factory.setXIncludeAware(false);
                //evita que se resuelvan cosas raras automáticamente.
                Factory.setExpandEntityReferences(false);
            }catch(ParserConfigurationException ignored){}

                DocumentBuilder Builder = Factory.newDocumentBuilder();
                Document documento = Builder.newDocument();

                //Nodo Raiz <Personal>
                Element raiz = documento.createElement("personal");
                documento.appendChild(raiz);//inserto la raiz en el documento

                //Se Toma la ObservableList
                ObservableList<Personal> listaobs= lista.getPersonal();
                //recorre toda la lista
                for(Personal p : listaobs){
                    Element personaElem=documento.createElement("persona");

                    //guardar el tipo
                    //-------------------*
                    if (p.tipo() != null) {
                        personaElem.setAttribute("tipo", p.tipo());
                    } else {
                        personaElem.setAttribute("tipo", "");
                    }
                    documento.appendChild(personaElem);
                    //-----------------------------*

                    //guardar id
                    //--------------------------------------*
                    Element idElem=documento.createElement("id");
                    if (p.getId() != null) {
                        idElem.setTextContent(p.getId());
                    } else {
                        idElem.setTextContent("");
                    }
                    documento.appendChild(idElem);
                    //-----------------------------------*

                    //guardar nombre
                    //--------------------------------------*
                    Element nombreElem=documento.createElement("nombre");
                    if (p.getNombre() != null) {
                        nombreElem.setTextContent(p.getNombre());
                    }else {
                        nombreElem.setTextContent("");
                    }
                    documento.appendChild(nombreElem);
                    //--------------------------------------*

                    //guardarClave
                    //*--------------------------------------*
                    Element claveElem=documento.createElement("clave");
                    if(p.getClave() != null) {
                        claveElem.setTextContent(p.getClave());
                    }else{
                        claveElem.setTextContent("");
                    }
                    documento.appendChild(claveElem);
                    //-------------------------------------------*

                    //guardarRol
                    //---------------------------------------------*
                    Element rolElem= documento.createElement("rol");
                    if(p.getRol() != null) {
                        rolElem.setTextContent(p.getRol().toString());
                    }else {
                        rolElem.setTextContent("");
                    }
                    documento.appendChild(rolElem);
                    //-----------------------------------------------*

                    // Campo exclusivo de Medico
                    if (p instanceof Medico) {
                        Medico m = (Medico) p;
                        Element espElem = documento.createElement("especialidad");
                        if(((Medico) p).getEspecialidad() != null) {
                            espElem.setTextContent(((Medico) p).getEspecialidad());
                        }else{
                            espElem.setTextContent("");
                        }
                        personaElem.appendChild(espElem);
                    }

                    raiz.appendChild(personaElem);

                }
            // Transformador para escribir el DOM en archivo
            TransformerFactory tf = TransformerFactory.newInstance();// crea una fabrica es responsable de convertir un documento DOM a un xml
            Transformer transformer = tf.newTransformer();//el que toma el Document y lo convierta en un archivo
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");//Le indica al transformador que indente el XML al escribirlo
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");//codifique el archivo en UTF-8.
            // Propiedad para controlar cantidad de espacios en la indentación (funciona en Xalan/Apache)
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");//controla cuántos espacios se usan por nivel de indentación.

            DOMSource source = new DOMSource(documento); //es un contenedor que le dice al transformador que se va transformar
            StreamResult result = new StreamResult(new File("ListaPersonal.xml"));//indica dónde se va a escribir el XML.
            transformer.transform(source, result);//aca se transforma

            System.out.println("✅ Personal guardado en " + "ListaPersonal.xml");
        }catch(ParserConfigurationException | TransformerException e){
                e.printStackTrace();
        }
    }
/*
    public static ListaPersonal cargar() {
        ListaPersonal lista = new ListaPersonal();
        try {
            File archivo = new File("ListaPersonal.xml");
            if (!archivo.exists()) {
                System.out.println(" Archivo no encontrado: " + "ListaPersonal.xml" + " — devolviendo lista vacía.");
                return lista;
            }
        }catch(Exception e) {}
    }*/
}
