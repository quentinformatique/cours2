<?php
function verfierConnection($id, $mdp) {

    try {
        $query = "SELECT * FROM clients";
        $stmt = sendQuery($query);
        $result = $stmt->fetchAll();
        foreach ($result as $row) {
            if ($row['login'] == $id && $row['pwd'] == $mdp) {
                return true;
            }
        }
        return false;
    } catch (Exception $e) {
        throw new Exception("Erreur de connexion à la base de données");
    }
}

function getNom($id) {
    try {
        $query = "SELECT nom FROM clients WHERE login = :login";
        $param = ["login" => $id];
        $stmt = sendQuery($query, $param);
        return $stmt->fetchAll();

    } catch (Exception $e) {
        throw new Exception("Erreur de connexion à la base de données");
    }
}

