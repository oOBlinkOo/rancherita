package rancherita.ooblinkoo.rancheritav2.entities;

/**
 * Created by oOBlinkOo on 9/27/15.
 */
public class Noticia {

    private String titulo;
    private String fecha;
    private String descripcion;
    private String imageURl;

    public Noticia(String title, String icon) {
        this.titulo = title;
        this.fecha = icon;

    }

    public Noticia(String title, String icon, String imageURl,String descripcion) {
        this.titulo = title;
        this.fecha = icon;
        this.imageURl=imageURl;
        this.descripcion=descripcion;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }
//    private ImageView imagen;

}
