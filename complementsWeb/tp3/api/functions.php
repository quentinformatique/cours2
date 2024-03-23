<?php

function articlesStocksPrix() {
    global $db;
    $stock = $db->prepare("SELECT ar.CATEGORIE, ca.DESIGNATION AS CATEGORIE, ar.CODE_ARTICLE, ar.DESIGNATION, ta.CODE_TAILLE, ta.DESIGNATION as TAILLE, co.CODE_COULEUR, co.DESIGNATION as COULEUR, sp.CODE_BARRE, sp.PRIX, sp.STOCK 
                        FROM stockprix sp left join articles ar on sp.ARTICLE=ar.ID_ARTICLE 
                        LEFT JOIN a_couleurs co ON sp.COULEUR = co.CODE_COULEUR 
                        LEFT JOIN a_tailles ta ON sp.TAILLE = ta.CODE_TAILLE
                        LEFT JOIN a_categories ca ON ar.CATEGORIE = ca.CODE_CATEGORIE
                        order by ar.CATEGORIE, ar.CODE_ARTICLE, ta.CODE_TAILLE, co.DESIGNATION");
    $stock->execute([]);

    $articles = $stock->fetchAll();

    sendJSON([
        "Status" => "OK",
        "message" => "Articles loaded successfully",
        "articles" => $articles,
    ], 200);
}



function editPrixStock(string $codeBarre): void
{
    global $db;

    $put = getPut();
    $request = [];

    if ($put === null)
    {
        $request["Status"] = "KO";
        $request["message"] = "Requête impossible.";
        $status = 404;
    }
    else
    {
        try
        {
            $edition = $db->prepare("UPDATE stockprix SET prix = :prix, stock = :stock WHERE code_barre = :codeBarre");
            $edition->execute([
                                  ":prix" => $put->prix,
                                  ":stock" => $put->stock,
                                  ":codeBarre" => $codeBarre,
                              ]);

            $request["Status"] = "Success";
            $request["message"] = "Modifications réalisées avec succès.";
            $status = 200;
        }
        catch (Exception $e)
        {
            $request["Status"] = "KO";
            $request["message"] = "Requête impossible.";
            $status = 404;
        }
    }

    sendJSON($request, $status);
}