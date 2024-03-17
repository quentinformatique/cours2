document.addEventListener('DOMContentLoaded', function (event) {


    const REJOUER = document.getElementById('rejouer');

    const FLAG = document.getElementById('theFlag');
    const ERROR_FLAG = document.getElementById('ErrorFlag');

    const BUTTON_FR = document.getElementById('leBoutonFr');
    const BUTTON_En = document.getElementById('leBoutonEn');
    const BUTTON_Es = document.getElementById('leBoutonEs');

    const PROPOSITIONS = document.getElementById('Propositions');
    const QUESTION = document.getElementById('theQuestion');

    let rightAnswer = '';
    let langueChoisie = null;

    // on cache le bouton rejouer et les boutons radio
    REJOUER.style.display = 'none';
    PROPOSITIONS.style.display = 'none';

    /**
     * Retourne un pays aléatoire à partir d'une liste de pays.
     * @param {Array} list - La liste des pays.
     * @returns {Object} - Un pays aléatoire.
     */
    function getRandomCountry(list) {
        let random = Math.floor(Math.random() * list.length);
        return list[random];
    }

    /**
     * Génère une liste de réponses aléatoires, y compris la bonne réponse.
     * @param {string} rightAnswer - La bonne réponse.
     * @param {Array} list - La liste des pays.
     * @returns {Array} - Une liste de réponses aléatoires.
     */
    function randomAnswer(rightAnswer, list) {
        let answers = [rightAnswer];
        for (let i = 0; i < 4; i++) {
            let randomCountry = getRandomCountry(list);
            while (answers.includes(randomCountry.nom)) {
                randomCountry = getRandomCountry(list);
            }
            answers.push(randomCountry.nom);
        }
        answers.sort(() => Math.random() - 0.5);
        return answers;
    }

    /**
     * Affiche les réponses sur l'interface utilisateur.
     * @param {Array} answers - La liste des réponses à afficher.
     */
    function displayAnswers(answers) {
        for (let i = 0; i < answers.length; i++) {
            let radio = document.getElementById('labelRadio' + i);
            radio.innerHTML = answers[i];
        }
        for (let i = 0; i < answers.length; i++) {
            let radio = document.getElementById('radio' + i);
            radio.value = answers[i];
        }
    }

    /**
     * Décoche tous les boutons radio.
     */
    function uncheckedAll() {
        for (let i = 0; i < 5; i++) {
            let button = document.getElementById('radio' + i);
            button.checked = false;
        }
    }

    function radioClicked(radio) {
        let radioValue = radio.value;

        if (radioValue === rightAnswer) {
            // on ajoute au label du radio la classe radioOK
            let label = radio.nextElementSibling;
            label.classList.add('radioOK');
            // on affiche OK.jpg
            ERROR_FLAG.setAttribute('src', './images/OK.jpg');
            REJOUER.style.display = 'block';
            // on désactive les boutons radio
            for (let i = 0; i < 5; i++) {
                let button = document.getElementById('radio' + i);
                button.disabled = true;
            }

        } else {
            // on ajoute au label du radio la classe radioKO
            let label = radio.nextElementSibling;
            label.classList.add('radioKO');
            // on affiche OK.jpg
            ERROR_FLAG.setAttribute('src', './images/OK.jpg');

            // on affiche dans la div erreur le mauvais drapeau qui correspond à la mauvaise réponse
            let badFlag = list_Fr.find(x => x.nom === radioValue).drapeau;
            ERROR_FLAG.setAttribute('src', badFlag);

        }
    }

    /**
     * Génère un pays aléatoire, une liste de réponses aléatoires et met à jour l'interface utilisateur.
     * @param {Array} list - La liste des pays.
     */
    function buttonClicked(list) {
        // affiche les boutons radio et on reset leur style
        PROPOSITIONS.style.display = 'block';
        for (let i = 0; i < 5; i++) {
            let label = document.getElementById('labelRadio' + i);
            label.classList.remove('radioOK');
            label.classList.remove('radioKO');
        }

        // on supprimer le drapeau d'erreur
        ERROR_FLAG.setAttribute('src', '');

        // on cache le bouton rejouer
        REJOUER.style.display = 'none';

        let random = getRandomCountry(list);
        rightAnswer = random.nom;
        let answers = randomAnswer(rightAnswer, list);
        displayAnswers(answers);
        uncheckedAll();
        FLAG.setAttribute('src', random.drapeau);
    }

    // Ajoute des écouteurs d'événements pour les boutons de langue au chargement du document.
    // Lorsque le bouton français est cliqué, génère un pays aléatoire et une liste de réponses aléatoires, puis met à jour l'interface utilisateur.
    BUTTON_FR.addEventListener('click', function () {
        buttonClicked(list_Fr);
        langueChoisie = list_Fr;
        // on affiche la question
        QUESTION.innerHTML = 'A quel pays appartient ce drapeau ?';
        BUTTON_FR.disabled = true;
        BUTTON_En.disabled = false;
        BUTTON_Es.disabled = false;
    });

    // Lorsque le bouton anglais est cliqué, génère un pays aléatoire et une liste de réponses aléatoires, puis met à jour l'interface utilisateur.
    BUTTON_En.addEventListener('click', function () {
        buttonClicked(list_En);
        langueChoisie = list_En;
        // on affiche la question
        QUESTION.innerHTML = 'To which country does this flag belong?';
        BUTTON_FR.disabled = false;
        BUTTON_En.disabled = true;
        BUTTON_Es.disabled = false;
    });

    // Lorsque le bouton espagnol est cliqué, génère un pays aléatoire et une liste de réponses aléatoires, puis met à jour l'interface utilisateur.
    BUTTON_Es.addEventListener('click', function () {
        buttonClicked(list_Es);
        langueChoisie = list_Es;
        // on affiche la question
        QUESTION.innerHTML = '¿A qué país pertenece esta bandera?';
        BUTTON_FR.disabled = false;
        BUTTON_En.disabled = false;
        BUTTON_Es.disabled = true;
    });


    for (let i = 0; i < 5; i++) {
        let RADIO = document.getElementById('radio' + i);
        RADIO.addEventListener('change', function () {
            radioClicked(RADIO);
        });
    }

    REJOUER.addEventListener('click', function () {
        //cache le bouton rejouer
        REJOUER.style.display = 'none';

        // retire le drapeau d'erreur
        ERROR_FLAG.setAttribute('src', '');

        // retire le drapeau
        FLAG.setAttribute('src', '');

        // reactive les boutons de langue
        BUTTON_FR.disabled = false;
        BUTTON_En.disabled = false;
        BUTTON_Es.disabled = false;

        // on reactive les boutons radio
        for (let i = 0; i < 5; i++) {
            let button = document.getElementById('radio' + i);
            button.disabled = false;
        }

        // reset le style des labels des boutons radio
        for (let i = 0; i < 5; i++) {
            let radio = document.getElementById('radio' + i);
            radio.checked = false;
            let label = document.getElementById('labelRadio' + i);
            label.classList.remove('radioOK');
            label.classList.remove('radioKO');
        }

        // cache les boutons radio
        PROPOSITIONS.style.display = 'none';

        // Relance le jeu avec la langue choisie
        buttonClicked(langueChoisie);
    });

});