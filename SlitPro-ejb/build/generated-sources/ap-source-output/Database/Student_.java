package Database;

import Database.Besvarelse;
import Database.Vurdering;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-18T09:32:59")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Integer> studentID;
    public static volatile ListAttribute<Student, Vurdering> vurderingList;
    public static volatile SingularAttribute<Student, String> innleveringer;
    public static volatile ListAttribute<Student, Besvarelse> besvarelseList;
    public static volatile SingularAttribute<Student, String> varslinger;

}