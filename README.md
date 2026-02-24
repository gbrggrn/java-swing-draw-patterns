# Draw + Design Patterns + UML
---
## Innehåll
- [Kravspecifikation](#kravspecifikation)
  - [UML-diagram](#uml-diagram)
  - [Designkrav](#designkrav)
  - [Generella krav](#generella-krav)
  - [Lagring](#lagring)
  - [Arkivmeny](#arkivmeny)
  - [Lab 3 - Nya krav](#lab-3-nya-krav)
- [UML-Diagram](#resultat-laboration-1-analys)
  - [Use case diagram](#use-case-diagram)
  - [Sequence diagrams](#sequence-diagrams)
  - [Class diagram](#class-diagram)
- [Implementering](#resultat-laboration-2-implementering)
  - [Tankar kring källkoden](#tankar-kring-källkoden)
- [Runtime-byte av View](#resultat-laboration-3-runtime-byte-av-view)
  - [Tankar kring källkoden](#tankar-kring-källkoden)

## Kravspecifikation

🕓 = Ej påbörjad
⏳ = Pågående
✅ = Klar

| UML-diagram    | Status |
|----------------|--------|
| Use-case       |  ✅   |
| Sequence analys|  ✅   |
| Sequence design|  ✅   |
| Class          |  ✅   |

| Designkrav                                      | Status |
|-------------------------------------------------|--------|
| UML-diagram för analys + design                 |  ✅   |
| Varje diagram ska ha förklarande namn           |  ✅   |
| Varje diagram ska noteras tillhöra analys/design|  ✅   |
| Följa MVC-struktur med definierade gränssnitt   |  ✅   |
| Lagring i vanliga textfiler (Unicode)           |  ✅   |

| Generella krav                      | Status |
|-------------------------------------|--------|
| Kompletta textredigeringsmöjligheter|  ✅   |
| Skriva in text                      |  ✅   |
| Klippa ut text (CTRL-X)             |  ✅   |
| Kopiera text (CTRL-C)               |  ✅   |
| Klistra in text (CTRL-V)            |  ✅   |
| Meny för ovanstående (krävs ej)     |  ✅   |

| Lagring                                 | Status |
|-----------------------------------------|--------|
| Lagring (valfritt format - men till fil)|  ✅   |

| Arkivmeny| Status |
|----------|--------|
| Open     |  ✅   |
| New      |  ✅   |
| Save     |  ✅   |
| Save as  |  ✅   |
| Exit     |  ✅   |

| Lab 3 - Nya krav                        | Status |
|-----------------------------------------|--------|
| Console-view                            |  ✅   |
| Val av view vid uppstart                |  ✅   |
| Använd factory för instantiera vald view|  ✅   |

---

## UML-Diagram

### Use case diagram
![Use case diagram](/assets/images/diagram-v4-final/use-case-diagram.png)

---

### Sequence diagrams
![Start app sequence](/assets/images/diagram-v4-final/sequence-start.png)
![Exit app sequence](/assets/images/diagram-v4-final/sequence-exit.png)
![Handle event sequence](/assets/images/diagram-v4-final/sequence-handle-event.png)
![Create new sequence](/assets/images/diagram-v4-final/sequence-create-new.png)
![Save sequence analys](/assets/images/diagram-v4-final/sequence-save.png)
![Save as sequence analys](/assets/images/diagram-v4-final/sequence-save-as.png)
![Open sequence analys](/assets/images/diagram-v4-final/sequence-open.png)
![Edit text sequence analys](/assets/images/diagram-v4-final/sequence-edit-text.png)
![Delete sequence analys](/assets/images/diagram-v4-final/sequence-delete.png)

---

### Class diagram
![Class diagram](/assets/images/diagram-v4-final/class-diagram.png)

## Implementering

### Tankar kring källkoden

<ul>
	<li>Väldigt bantad Controller som enbart blir kallad och skickar returer</li>
	<li>Detta med syftet att göra den fullständigt obrydd om vilken view som kommmunicerar med den</li>
	<li>Controllern sköter ingen flow-logik som det ser ut nu - tanken med detta var att swing/console-gränssnitt sköter interaktion på ganska olika sätt (ta swings namngivna static final int:s som returneras av dialogrutorna vs sifferval som behöver validering i console). Det kändes riskfyllt att ta hänsyn till alla små specifika quirks i controllern, bättre låta vyerna bry sig om sina egna problem.</li>
	<li>Viss feedback till användaren bör läggas till i nästa skede, tex visa aktiv fil, antal ord, antal tecken etc...</li>
</ul>

## Runtime-byte av View

### Tankar kring källkoden

<ul>
	<li>Stor refaktorering av MainController för att förlytta programflödeslogik dit.</li>
	<li>Skrev ett interface IView för ett generiskt "kontrakt" mellan controller-view.</li>
	<li>Definierade enums för val (Choices) med syftet att ge både swing-, och konsol vyn ett enhetligt sätt att kommunicera val till controllern.</li>
</ul>
