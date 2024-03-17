$(document).ready(function () {
    // Afficher le spinner
    $('#loaderDiv').show();

    // Récupérer les régions
    $.get('https://geo.api.gouv.fr/regions', function (data) {
        $('#listeRegionsNB').text(data.length);
        data.forEach(function (region) {
            $('#listeRegions').append(new Option(region.nom, region.code));
        });

        // Cacher le spinner
        $('#loaderDiv').hide();

        // Si une seule région, la sélectionner automatiquement
        if (data.length === 1) {
            $('#listeRegions').change();
        }
    });

    // Récupérer les départements lorsqu'une région est sélectionnée
    $('#listeRegions').change(function () {
        // Afficher le spinner
        $('#loaderDiv').show();

        $.get('https://geo.api.gouv.fr/regions/' + this.value + '/departements', function (data) {
            $('#listeDepartementsNB').text(data.length);
            data.forEach(function (department) {
                $('#listeDepartements').append(new Option(department.nom, department.code));
            });

            // Cacher le spinner
            $('#loaderDiv').hide();

            // Si un seul département, le sélectionner automatiquement
            if (data.length === 1) {
                $('#listeDepartements').change();
            }
        });
    });

    // Récupérer les communes lorsqu'un département est sélectionné
    $('#listeDepartements').change(function () {
        // Afficher le spinner
        $('#loaderDiv').show();

        $.get('https://geo.api.gouv.fr/departements/' + this.value + '/communes', function (data) {
            $('#listeCommunesNB').text(data.length);
            data.forEach(function (commune) {
                $('#listeCommunes').append(new Option(commune.nom, commune.code));
            });

            // Cacher le spinner
            $('#loaderDiv').hide();

            // Si une seule commune, la sélectionner automatiquement
            if (data.length === 1) {
                $('#listeCommunes').change();
            }
        });
    });

    // Récupérer et afficher les détails de la commune lorsqu'une commune est sélectionnée
    $('#listeCommunes').change(function () {
        // Afficher le spinner
        $('#loaderDiv').show();

        $.get('https://geo.api.gouv.fr/communes/' + this.value, function (data) {
            // Afficher les détails de la commune
            $('#libelleNomCommune').text(data.nom);
            $('#libelleCommune').text(data.nom);
            $('#LibelleSiren').text(data.codesPostaux.join(', '));
            $('#nbHabitantsCommune').text(data.population);
            $('#CodesPostaux').empty();
            data.codesPostaux.forEach(function (code) {
                $('#CodesPostaux').append('<li>' + code + '</li>');
            });

            // Récupérer et afficher le nom de la région
            $.get('https://geo.api.gouv.fr/regions/' + data.codeRegion, function (regionData) {
                $('#libelleRegion').text(regionData.nom);
            });

            // Récupérer et afficher le nom du département
            $.get('https://geo.api.gouv.fr/departements/' + data.codeDepartement, function (departementData) {
                $('#libelleDepartement').text(departementData.nom);
            });

            // Récupérer et afficher les détails de la communauté de communes
            if (data.codeEpci) {
                $.get('https://geo.api.gouv.fr/epcis/' + data.codeEpci, function (epciData) {
                    $('#codeComCom').text(epciData.code);
                    $('#NomComCom').text(epciData.nom);
                    $('#nbHComCom').text(epciData.population);

                    // Récupérer et afficher la liste des communes de la communauté de communes
                    $.get('https://geo.api.gouv.fr/epcis/' + data.codeEpci + '/communes', function (comData) {
                        $('#ListeCommunesComCom').empty();
                        comData.forEach(function (commune) {
                            $('#ListeCommunesComCom').append('<li>' + commune.nom + '</li>');
                        });
                    });
                });
            } else {
                $('#codeComCom').text('Pas de communauté de communes');
            }

            // Cacher le spinner
            $('#loaderDiv').hide();
        });
    });
});