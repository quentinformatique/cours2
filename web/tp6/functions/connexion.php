<?php
function verfierConnection($id, $mdp) {
    if (file_exists('FichiersDonnees/Logins.csv')) {
        $Logins = file('FichiersDonnees/Logins.csv', FILE_IGNORE_NEW_LINES);
        array_shift($Logins); // on retire la premier ligne du tableau qui contient les noms des colonnes
        foreach ($Logins as $ligne) {
            $elementsLigne = explode(";", $ligne);
            if ($elementsLigne[0] == $id && $elementsLigne[1] == $mdp) {
                return true;
            }
        }
        return false;
    } else {
        throw new Exception("Le fichier Logins.csv n'existe pas");
    }

}

