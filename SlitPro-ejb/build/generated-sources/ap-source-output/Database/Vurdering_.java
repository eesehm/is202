package Database;

import Database.Besvarelse;
import Database.Student;
import Database.VurderingPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-18T09:32:59")
@StaticMetamodel(Vurdering.class)
public class Vurdering_ { 

    public static volatile SingularAttribute<Vurdering, String> karakter;
    public static volatile SingularAttribute<Vurdering, Student> student;
    public static volatile SingularAttribute<Vurdering, VurderingPK> vurderingPK;
    public static volatile SingularAttribute<Vurdering, String> vurdertAv;
    public static volatile SingularAttribute<Vurdering, String> kommentar;
    public static volatile SingularAttribute<Vurdering, Besvarelse> besvarelse;

}