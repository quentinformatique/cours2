<?php

const DB = [
    "host" => "localhost",
    "dbname" => "mezabi3",
    "user" => "root",
    "password" => "root",
];

try
{
    $db = new PDO("mysql:host=" . DB["host"] . ";dbname=" . DB["dbname"], DB["user"], DB["password"]);
}
catch (PDOException $e)
{
    print $e->getMessage();
    die;
}