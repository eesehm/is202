package Database;

import Database.Link;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-15T16:02:31")
@StaticMetamodel(Modul.class)
public class Modul_ { 

    public static volatile SingularAttribute<Modul, Link> linkId;
    public static volatile SingularAttribute<Modul, String> lagdAv;
    public static volatile SingularAttribute<Modul, Integer> modulNummer;
    public static volatile SingularAttribute<Modul, String> innhold;
    public static volatile SingularAttribute<Modul, Boolean> varsel;
    public static volatile SingularAttribute<Modul, Date> frist;

}