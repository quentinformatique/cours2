function displayTable(list) {
    let table = "<table class='table table-striped table-bordered'><tr><th>Numéro</th><th>Code Pays</th><th>Nom</th><th>Drapeau</th></tr>";
    for (let i = 0; i < list.length; i++) {
        table += "<tr><td class='centrer'>" + i + "</td><td class='centrer'>" + list[i].code + "</td><td class='centrer'>" + list[i].nom + "</td><td class='centrer'><img src='" + list[i].drapeau + "' class='hightFlag'></td></tr>";
    }
    table += "</table>";
    return table;
}

document.addEventListener('DOMContentLoaded', function (event) {
    // Attente que le DOM soit chargé avant d'utiliser Javascript
    // Ecrire votre code ici

    const BUTTON_FR = document.getElementById('leBoutonFr');
    const BUTTON_En = document.getElementById('leBoutonEn');
    const BUTTON_Es = document.getElementById('leBoutonEs');
    const A_REMPLIR = document.getElementById('myContent');

    console.log("list_Fr :")
    console.log(list_Fr);
    console.log("list_En :")
    console.log(list_En);
    console.log("list_Es :")
    console.log(list_Es);

    BUTTON_FR.addEventListener('click', function () {
        A_REMPLIR.innerHTML = displayTable(list_Fr);
        BUTTON_FR.disabled = true;
        BUTTON_En.disabled = false;
        BUTTON_Es.disabled = false;
    });

    BUTTON_En.addEventListener('click', function () {
        A_REMPLIR.innerHTML = displayTable(list_En);
        BUTTON_FR.disabled = false;
        BUTTON_En.disabled = true;
        BUTTON_Es.disabled = false;
    });

    BUTTON_Es.addEventListener('click', function () {
        A_REMPLIR.innerHTML = displayTable(list_Es);
        BUTTON_FR.disabled = false;
        BUTTON_En.disabled = false;
        BUTTON_Es.disabled = true;
    });
});
