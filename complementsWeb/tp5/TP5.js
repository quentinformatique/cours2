$(document).ready(function () {
    // Afficher le spinner
    $('#loaderDiv').show();

    // Cacher les éléments au début
    $('#zoneDepartements').hide();
    $('#zoneCommunes').hide();
    $('#zoneResultat').hide();

    // Récupérer les régions
    fetchRegions();

    // Récupérer les départements lorsqu'une région est sélectionnée
    $('#listeRegions').change(function () {
        fetchDepartments(this.value);
    });

    // Récupérer les communes lorsqu'un département est sélectionné
    $('#listeDepartements').change(function () {
        fetchCommunes(this.value);
    });

    // Récupérer et afficher les détails de la commune lorsqu'une commune est sélectionnée
    $('#listeCommunes').change(function () {
        fetchCommuneDetails(this.value);
    });
});

function fetchRegions() {
    $.get('https://geo.api.gouv.fr/regions', function (data) {
        displayRegions(data);
    });
}

function fetchDepartments(regionCode) {
    $('#loaderDiv').show();
    $('#zoneDepartements').show();
    $('#listeDepartements').empty(); // Ajouté pour vider la liste des départements


    $.get('https://geo.api.gouv.fr/regions/' + regionCode + '/departements', function (data) {
        displayDepartments(data);
    });
}

function fetchCommunes(departmentCode) {
    $('#loaderDiv').show();
    $('#zoneCommunes').show();
    $('#listeCommunes').empty(); // Ajouté pour vider la liste des communes

    $.get('https://geo.api.gouv.fr/departements/' + departmentCode + '/communes', function (data) {
        displayCommunes(data);
    });
}

function fetchCommuneDetails(communeCode) {
    $('#loaderDiv').show();
    $('#zoneResultat').show();

    $.get('https://geo.api.gouv.fr/communes/' + communeCode, function (data) {
        displayCommuneDetails(data);
    });
}

function displayRegions(data) {
    $('#listeRegions').empty();
    $('#listeRegionsNB').text(data.length)
    data.sort((a, b) => a.nom.localeCompare(b.nom)).forEach(function (region) {
        $('#listeRegions').append(new Option(region.nom, region.code));
    });

    $('#loaderDiv').hide();

    if (data.length === 1) {
        $('#listeRegions').change();
    }
}

function displayDepartments(data) {
    $('#listeDepartements').empty();
    $('#listeDepartementsNB').text(data.length);
    data.sort((a, b) => a.nom.localeCompare(b.nom)).forEach(function (department) {
        $('#listeDepartements').append(new Option(department.nom, department.code));
    });

    $('#loaderDiv').hide();

    if (data.length === 1) {
        $('#listeDepartements').change();
    }
}

function displayCommunes(data) {
    $('#listeCommunes').empty();
    $('#listeCommunesNB').text(data.length);
    data.sort((a, b) => a.nom.localeCompare(b.nom)).forEach(function (commune) {
        $('#listeCommunes').append(new Option(commune.nom, commune.code));
    });

    $('#loaderDiv').hide();

    if (data.length === 1) {
        $('#listeCommunes').change();
    }
}

function displayCommuneDetails(data) {
    $('#libelleNomCommune').text(data.nom);
    $('#libelleCommune').text(data.nom);
    $('#LibelleSiren').text(data.codesPostaux.join(', '));
    $('#nbHabitantsCommune').text(data.population);
    $('#CodesPostaux').empty();
    data.codesPostaux.forEach(function (code) {
        $('#CodesPostaux').append('<li>' + code + '</li>');
    });

    fetchRegionName(data.codeRegion);
    fetchDepartmentName(data.codeDepartement);
    fetchEpciDetails(data.codeEpci);

    $('#loaderDiv').hide();
}

function fetchRegionName(regionCode) {
    $.get('https://geo.api.gouv.fr/regions/' + regionCode, function (regionData) {
        $('#libelleRegion').text(regionData.nom);
    });
}

function fetchDepartmentName(departmentCode) {
    $.get('https://geo.api.gouv.fr/departements/' + departmentCode, function (departementData) {
        $('#libelleDepartement').text(departementData.nom);
    });
}

function fetchEpciDetails(epciCode) {
    if (epciCode) {
        $.get('https://geo.api.gouv.fr/epcis/' + epciCode, function (epciData) {
            $('#codeComCom').text(epciData.code);
            $('#NomComCom').text(epciData.nom);
            $('#nbHComCom').text(epciData.population);

            fetchCommunesInEpci(epciCode);
        });
    } else {
        $('#codeComCom').text('Pas de communauté de communes');
    }
}

function fetchCommunesInEpci(epciCode) {
    $.get('https://geo.api.gouv.fr/epcis/' + epciCode + '/communes', function (comData) {
        $('#ListeCommunesComCom').empty();
        comData.forEach(function (commune) {
            $('#ListeCommunesComCom').append('<li>' + commune.nom + '</li>');
        });
    });
}