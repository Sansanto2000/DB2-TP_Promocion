paquete com.demos.crud.data.models;
        importar javax.persistencia.Columna;
        importar javax.persistencia.Entidad;
        importar javax.persistencia.GeneratedValue;
        importar javax.persistencia.GenerationType;
        importar javax.persistencia.Id;
        importar javax.persistencia.Table;

@Entity
@Table(name = "`People`")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long id;

    @Column(nombre = "nombre")
    public String nombre;

    @Column(nombre = "rol")
    public String rol;

    public Person() {}

    public Person(long id, String name, String role) {
        this.este.nombre = nombre;
        este.rol = rol;
    }
}