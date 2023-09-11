import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("f937732f-0372-41e8-925c-68e15f27de1a")
public class Particulier extends Client {
    @objid ("8ad0bba6-d6fb-4991-a935-ab6d1b653b07")
    private String nom;

    @objid ("e4f71a45-7757-4034-a148-17071756c7e7")
    private String prenom;

    @objid ("edcf7ef2-7c68-41ad-8d96-e3c39c2b7f12")
    Particulier(String nom, String prenom) {
    }

    @objid ("d1197718-6f52-4d73-b08b-43904fce08fe")
    public String toString() {
    }

}
