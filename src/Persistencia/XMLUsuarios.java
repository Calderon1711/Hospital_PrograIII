package Persistencia;

import Modelo.Rol;
import Modelo.Usuario;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class XMLUsuarios implements Repositorio<Usuario, String> {
    private final String path;                 // p.ej. "data/usuarios.xml"
    private final List<Usuario> cache = new ArrayList<>();  // <-- ESTA ES LA QUE FALTABA

    public XMLUsuarios(String path) {
        this.path = path;
        cargar(); // lee el XML (si existe) y llena cache
    }

    // -------- util interno --------
    private static String getText(Element parent, String tag) {
        NodeList list = parent.getElementsByTagName(tag);
        if (list.getLength() == 0) return "";
        return list.item(0).getTextContent();
    }

    private void cargar() {
        cache.clear();
        Document doc = XMLayudante.cargarDoc(path);
        if (doc == null) return; // primera ejecución sin archivo
        NodeList nodos = doc.getElementsByTagName("usuario");
        for (int i = 0; i < nodos.getLength(); i++) {
            Element e = (Element) nodos.item(i);
            String id = e.getAttribute("id");
            String clave = getText(e, "clave");
            String nombre = getText(e, "nombre");
            Rol rol = Rol.valueOf(getText(e, "rol"));
            cache.add(new Usuario(id, clave, nombre, rol));
        }
    }

    // -------- implementación Repositorio --------
    @Override
    public List<Usuario> listar() {
        return new ArrayList<>(cache);
    }

    @Override
    public Optional<Usuario> buscarPorId(String id) {
        return cache.stream().filter(u -> u.getId().equalsIgnoreCase(id)).findFirst();
    }

    @Override
    public void insertar(Usuario entidad) {
        if (buscarPorId(entidad.getId()).isPresent())
            throw new IllegalArgumentException("Ya existe un usuario con id " + entidad.getId());
        cache.add(entidad);
    }

    @Override
    public void actualizar(Usuario entidad) {
        eliminar(entidad.getId());
        cache.add(entidad);
    }

    @Override
    public boolean eliminar(String id) {
        return cache.removeIf(u -> u.getId().equalsIgnoreCase(id));
    }

    @Override
    public void guardar() {
        Document doc = XMLayudante.nuevoDocumento();
        Element root = doc.createElement("usuarios");
        doc.appendChild(root);

        for (Usuario u : cache) {
            Element e = doc.createElement("usuario");
            e.setAttribute("id", u.getId());

            Element c = doc.createElement("clave");
            c.setTextContent(u.getClave());
            e.appendChild(c);

            Element n = doc.createElement("nombre");
            n.setTextContent(u.getNombre());
            e.appendChild(n);

            Element r = doc.createElement("rol");
            r.setTextContent(u.getRol().name());
            e.appendChild(r);

            root.appendChild(e);
        }
        XMLayudante.guardarDoc(doc, path);
    }
}