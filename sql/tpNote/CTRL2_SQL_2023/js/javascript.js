$(function() {
    // Attache un gestionnaire d'événements à l'élément <select>
    $('#laBD').on('change', function() {
        // Appel à une fonction de validation lors du changement de la liste
		$('#FormBD').submit();
        //validerFormulaire();
    });
	
	$('#laTable').on('change', function() {
        // Appel à une fonction de validation lors du changement de la liste
		$('#FormTable').submit();
        //validerFormulaire();
    });
	// FormTable
	
	
    /*
    // Fonction de validation du formulaire
    function validerFormulaire() {
        // Récupère la valeur sélectionnée dans la liste
        var selectedValue = $('#maListe').val();
        
        // Vérifie si une option valide a été sélectionnée
        if (selectedValue === '') {
            alert('Veuillez sélectionner une option.');
            // Empêche l'envoi du formulaire
            return false;
        }
        // Autres validations si nécessaire
        
        // Si toutes les validations réussissent, soumet le formulaire
        $('#monFormulaire').submit();
    }
	*/
});



	
	
	
	