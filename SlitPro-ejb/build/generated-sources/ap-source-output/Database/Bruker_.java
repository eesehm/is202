package Database;

import Database.Foreleser;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-18T09:32:59")
@StaticMetamodel(Bruker.class)
public class Bruker_ { 

    public static volatile SingularAttribute<Bruker, String> password;
    public static volatile SingularAttribute<Bruker, String> etternavn;
    public static volatile SingularAttribute<Bruker, String> epost;
    public static volatile SingularAttribute<Bruker, Integer> id;
    public static volatile SingularAttribute<Bruker, String> fornavn;
    public static volatile ListAttribute<Bruker, Foreleser> foreleserList;

}