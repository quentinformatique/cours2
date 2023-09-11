import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("8abbda1e-848e-4589-87fe-66fe7377d859")
public class Matiere {
    @objid ("7a8419e7-efa2-42fb-8676-23b5f3617bde")
     String intitule;

    @objid ("f47da8dd-d1cf-4d99-b70a-c4bfa9a5dda4")
     List<Etudiant> etudiantInscrits = new ArrayList<Etudiant> ();

}
