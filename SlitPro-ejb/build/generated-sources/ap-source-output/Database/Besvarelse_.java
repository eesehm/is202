package Database;

import Database.Student;
import Database.Vurdering;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-18T09:32:59")
@StaticMetamodel(Besvarelse.class)
public class Besvarelse_ { 

    public static volatile ListAttribute<Besvarelse, Vurdering> vurderingList;
    public static volatile SingularAttribute<Besvarelse, Integer> besvarelseID;
    public static volatile SingularAttribute<Besvarelse, Integer> modulNummer;
    public static volatile SingularAttribute<Besvarelse, Date> dato;
    public static volatile ListAttribute<Besvarelse, Student> studentList;
    public static volatile SingularAttribute<Besvarelse, Boolean> vurderingsvarsel;
    public static volatile SingularAttribute<Besvarelse, Boolean> opplastetFil;
    public static volatile SingularAttribute<Besvarelse, String> kommentar;

}