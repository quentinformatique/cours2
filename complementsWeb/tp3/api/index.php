<?php

require_once "db.php";
require_once "functions.php";

if (!isset($_GET["demande"]))   
{
    print "Aucune demande.";
    die;
}

$decompositionRoute = explode('/', $_GET["demande"]);
$page = $decompositionRoute[0];

switch ($page)
{
    case "articlesStockPrix":
        articlesStocksPrix();
        break;

    case "modifPrixStock":
        var_dump($_GET);
        if (isset($_GET["prix"]) && isset($_GET["stock"]))
        {
            appelAPI("/ex1-3/modifPrixStock/" . $_GET['code_barre'], typeRequete: "PUT", donnees: [
                "stock" => $_GET["stock"],
                "prix" => $_GET["prix"],
            ]);
        }
        else
        {
            editPrixStock($decompositionRoute[1]);
        }
        break;

    default:
        print "Demande invalide.";
        break;
}


function getPut(): ?stdClass
{
    return json_decode(file_get_contents("php://input"));
}

function sendJSON($data, $status)
{
    header("Access-Control-Allow-Origin: *");
    header("Content-Type: application/json; charset=UTF-8");
    header("Access-Control-Allow-Methods: POST, GET, DELETE, PUT");

    http_response_code($status);
    echo json_encode($data, JSON_UNESCAPED_UNICODE);
}