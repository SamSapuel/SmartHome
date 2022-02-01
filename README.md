# Omo-smarthome

Simple smarthome application for OMO

## Členové týmu

- Richard Fritsch
- Dmitriy Shevchenko

## Popis zpracování

### UML Diagramy

[UML Class diagram](class-diagram.png)

[UML Use case diagram](use-case-diagram.png)

[UML State machine diagram](state-machine-diagram.png)

### Slovní popis

Prvním krokem simulace je náhodná generace akcí u všech osob v domu. Ty si
náhodně zařízení v domě podle své momentální strategie, přesunou se do místnosti,
ve které se nachází a zkusí ho použít. Následně se aktualizují stav a spotřeba
všech zařízení. Ty mají vždy nepatrnou šanci se rozbít.

Všechny entity, jako například konkrétní lidé, zařízení či eventy, mají nějakou
abstraktní třídu, ze které dědí společné vlastnosti. Ty jsou umístěny v hlavních
balíčcích, jejich implementace jsou pak v podbalíčcích. Většina kódu je pak
přivedena dohromady v třídách balíčku `api`.

## Návrhové vzory

- State machine, třída `DeviceState` a její implementace
- Factory, třídy `LivingFactory` a `DeviceFactory`
- Singleton, třída `House`
- Listener, třída `EventService` a všechny třídy implementující `EventListener` interface
- Bridge, např. `Event`
- Strategy, třída `Strategy` a její implementace

## Funkční požadavky

- [x] F1 - Entity se kterými pracujeme je dům, okno (+ venkovní žaluzie), patro v domu, senzor, zařízení (=spotřebič), osoba, auto, kolo, domácí zvíře jiného než hospodářského typu, plus libovolné další entity
  - obsaženo v třídách, které se nalézají např. v balíčcích `devices`, `house`, `living`, `sensors`.

- [x] F2. Jednotlivá zařízení v domu mají API na ovládání. Zařízení mají stav, který lze měnit pomocí API na jeho ovládání. Akce z API jsou použitelné podle stavu zařízení. Vybraná zařízení mohou mít i obsah - lednice má jídlo, CD přehrávač má CD.
  - Implementováno v třídách `Device` a `DeviceState` a jejich konkrétních implementacích

- [x] F3. Spotřebiče mají svojí spotřebu v aktivním stavu, idle stavu, vypnutém stavu
  - zaznamenává se při použití metody `update()`
  - mapy stavu na spotřebu uloženy v `DeviceEnergyConsumption`

- [x] F4. Jednotlivá zařízení mají API na sběr dat o tomto zařízení. O zařízeních sbíráme data jako spotřeba elektřiny, plynu, vody a funkčnost (klesá lineárně s časem)
  - uloženo v `DeviceReportService`

- [x] F5. Jednotlivé osoby a zvířata mohou provádět aktivity(akce), které mají nějaký efekt na zařízení nebo jinou osobu.
  - implementováno pomocí tříd v balíčku `entityAction`

- [x] F6. Jednotlivá zařízení a osoby se v každém okamžiku vyskytují v jedné místnosti (pokud nesportují) a náhodně generují eventy (eventem může být důležitá informace a nebo alert)
  - generování eventů využito zatím jen u zařízení, balíček `events`

- [x] F7. Eventy jsou přebírány a odbavovány vhodnou osobou (osobami) nebo zařízením (zařízeními).
  - vyřešeno skrze `EventService` třídu a `handle` metody v třídě `Event`

- F8. Vygenerování reportů
  - [x] HouseConfigurationReport
  - [x] EventReport
  - [x] ActivityAndUsageReport
  - [x] ConsumptionReport
  - implementováno v balíčku `reports`

- [ ] F9. Při rozbití zařízení musí obyvatel domu prozkoumat dokumentaci k zařízení - najít záruční list, projít manuál na opravu a provést nápravnou akcí (např. Oprava svépomocí, koupě nového atd.). Manuály zabírají mnoho místa a trvá dlouho než je najdete.
  - opravování probíhá zjednoduššeně

- [x] F10. Rodina je aktivní a volný čas tráví zhruba v poměru (50% používání spotřebičů v domě a 50% sport kdy používá sportovní náčiní kolo nebo lyže). Když není volné zařízení nebo sportovní náčiní, tak osoba čeká.
  - implementováno částečně skrze strategie (chybí využití "dopravních prostředků" a čekání na zařízení)

## Dodatek

### Richard Fritsch

Pochválil bych se za vyřešení handlování eventů pomocí double dispatch.
Dále se mi líbí využití abstraktních tříd pro sdílení společných vlastností.

### Dmitriy Shevchenko
Za sebe budu chválit implementaci generování reportů a jejich sčítání do souboru
Taky bych řekl, že využití abstraktních třid a interfaců je docela šikovná věc k implementaci do velkých projektů
