## II - D'ordinateur

- de fait une Vm ne peut communiquer directment ni avec l'hote, ni avec toute autre machine réelle, ni mem une autre Vm

- tout passe par virtualBox qui sert d'intermediaire pour tout échange réseau

- pour ce faire, vbox fait office de :
  
  - routeur / passerelle, avec fonction NAT, entre les VM et l'hote
  
  - de serveur DHCP pour les VM
  
  - le tout est paramétrable

- 

- Vbox offre donc plusieurs posibilitées d'acces réseau

les principaux modes de réseau de vbox sont : 

- NAT (par défaut) :
  
  - crée un LAN virtuel isolé pour chaque invité
  
  - meme IP a tt les VMs
  
  - applique le NAT classique
  
  - Vbox affecte une IP privé a chaque VM, NAT est chargé de remplacer l'IP privé de la VM par l'IP de l'hote pour les échanges vers le LAN et internet. Mais comme les VM ont une IP privée, "l'exterieur" ne peut pas acceder a la VM (sauf si redirection de port).

- Réseau NAT
  
  - équivalent a NAT mais avec la possibilité de mettre plusieurs invité dans le meme réseau NAT
  
  - nécessite de crée / configurer un réseau NAT

- Accés par pont
  
  - Connecte la carte réseau (virtuelle) de l'invité a la carte réseau réelle de l'hote
  
  - Vbox installe un pitole spécifique pour l'interface réseau pour répartir les donnéees transitant via l'interface entre l'hote et l'invité
  
  - les VM peuvent avoir une IP dynamique ou statique

- Réseau interne
  
  - Vbox se mute en switch entre invité
  
  - les VM sont dans un LAN isolé
  
  - la config IP est alors manuelle ou via un serv DHCP dans l'un des invité

- Réseau privé hote
  
  - réseau interne incluant l'htoe en plus
  
  - Vbow installe une interface réseau supplémentaire sur l'hote, nécessite une config de cette interface virtuele
  
  - tt les IP, celles des VM et de l'interface doivent etre dans le même réseau
  
  - utilisation de DHCP possible

- Interface réseau
  
  - soit de type Ethernet parmi une liste tres restreinte mais classique d'interface réseau => reconnu par quasi tous les OS
  
  - soit para-virtuel. L'invité doit etre modifiable.

Cas particuler des postes de travail, pour un utilistation soit: 

- en local: test

- a distance:bureau viruel pour télé travail (on parle de VDI: Virtual Desktop Infrastructue)

Pas de transfert de VM mais controle a distance (RDP)

## III - D'application

avec une VM, executer une app dans un contexte virtualisé nécessite de virtualiser une machine, un OS et l'appinstallé dessus. Et il faut autant de VM que d'app a isoler. La virtualisation d'ap permet d'eviter les VM, il y a deux techniques:

- le streaming d'application

- les conteneurs

dans les deux cas, il repose sur la notio d'isolateur de bac a sable (sandbox)

Un isolateur est un mécanisme systeme qui consiste a créer un environement d'execution propre a l'app et séparé du reste, dans le but d'empecher des interactions entre l'app et le reste du systeme. techniques employées : 

- cacher l'arborescnece de l'hote a l'app

- creer des comptes dédiées a l'app, limiter les accés au périphériques

- dédier de la ram

- etc...

Contrairement au hyperviseurs, un isolateur utilise l'OS de l'hote => gain de perf notable - mais l'app doit etre compatible

Le streaming d'app est dispo sur serv, donc centralisé et a distance, ce que simplifie sa distrib et sa maintenance, 2 possibilitées: 

- Elle est exec sur le serv et on interagit a distance

- est est téléchargée et directemnt executé dans un isolateur: l'app est en général "packagé" i.e. pré-installée avec ses dépendances et param d'exec pret 



## II - de Stockage

**demander a lucas**
