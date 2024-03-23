<?php

function callApi($url)
{
    $curl = curl_init();									// Initialisation

    curl_setopt($curl, CURLOPT_URL, $apiUrl);				// Url de l'API à appeler
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);			// Retour dans une chaine au lieu de l'afficher
    curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false); 		// Désactive test certificat
    curl_setopt($curl, CURLOPT_FAILONERROR, true);

    $result = curl_exec($curl);								// Exécution
    $http_status = curl_getinfo($curl, CURLINFO_HTTP_CODE);	// Récupération statut
    // Si 404  indique qu'un serveur ne peut pas trouver la ressource demandée
    // Si 200 c'est OK
    curl_close($curl);										// Cloture curl

    if ($http_status=="200") {								// OK, l'appel s'est bien passé
        return json_decode($result,true); 					// Retourne la collection
    } else {
        $result=[]; 										// retourne une collection Vide
        return $result;
    }
}