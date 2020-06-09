--USERS
INSERT INTO user_credentials (name, password, roles)
VALUES ('admin', '$2a$10$g7GLjMR8JiPP0vivHdRHF.bMVmnaEZWHo5c4RFw0VvEjT43pr7zwO', 'ROLE_ADMIN,ROLE_USER');

INSERT INTO user_credentials (name, password, roles)
VALUES ('kiiru', '$2a$10$Z9UTCk39gscuA2lbs0iW7.Ii9jT2qbjB7VWKR1b9aG/mYy4B88bwC', 'ROLE_USER');

--NOTES
INSERT INTO note (user_id, title, text)
VALUES (1,'Paladin',
        'Paladins are front-line specialists, sporting a veritable arsenal of defensive and supportive tools to protect both themselves and their allies. Paladin''s also utilize MP to heal their comrades and to deal burst damage.');
INSERT INTO note (user_id, title, text)
VALUES (1,'Warrior',
        'Warriors are mighty front-liners wielding terrifying two-handed axes which are used to perform huge burst damage after filling their Beast Gauge. Unlike their tanking counterparts, Warriors forgo some mitigation abilities in exchange for a whopping health-pool and self-healing abilities.');
INSERT INTO note (user_id, title, text)
VALUES (1,'Dark Knight',
        'Dark Knights strive to occupy the proverbial middle-ground between Warrior and Paladin, providing the player with a balanced offering of mitigation and damage-dealing tools, complemented by their skill with two-handed greatswords.');
INSERT INTO note (user_id, title, text)
VALUES (1,'Gunbreaker',
        'Gunbreakers blend solid damage, mitigation and utility into a straightforward playstyle. They possess consistent combos that generate Cartridges, which can be used to increase their damage further or to aim special abilities (such as shields or regen) at party-members.');
INSERT INTO note (user_id, title, text)
VALUES (1,'Astrologian',
        'Astrologians are masters of fate that provide shields and regeneration to allies in a large area, and can also use Cards to provide damage buffs to fellow party members through use of their Star Globe.');
INSERT INTO note (user_id, title, text)
VALUES (1,'Scholar',
        'Scholars, accompanied by their faithful healing pets, pepper allies with powerful barriers whilst debilitating enemies with their devastating damage-over-time (DoT) effects.');
INSERT INTO note (user_id, title, text)
VALUES (1,'White Mage',
        'White Mage is a straightforward healing class that forgoes utility to provide immense healing output and regeneration effects to their allies. In times of need, they can also blast their enemies with devastating elemental attacks.');
INSERT INTO note (user_id, title, text)
VALUES (2, 'Bard',
        'Bards are ranged damage dealers sporting mobility, utility, and a proc-based combat style that debilitates enemies through damage-over-time effects wrought by their bow and arrows. Through the power of song, they can also provide party-wide buffs and inspire their allies to greater feats of damage.');
INSERT INTO note (user_id, title, text)
VALUES (2,'Black Mage',
        'Black Mages resemble the classical elemental mage, trading defense and mobility for unmatched area spells. Their unique mechanics revolve around balancing Astral Fire and Umbral Ice to mitigate MP consumption while dealing massive damage with offensive fire, ice and lightning magicks.');
INSERT INTO note (user_id, title, text)
VALUES (2,'Blue Mage',
        'Blue Mages learn skills by copying the abilities of their defeated enemies. They have access to a wide variety of spells, which make them more and more versatile and powerful as they learn. However, their status as a Limited Job restricts their access to content.');
INSERT INTO note (user_id, title, text)
VALUES (2, 'Dancer',
        'The Dancer is a highly-mobile job providing damage, utility and support capabilities to those around them while slicing their enemies with their vicious Chakra. Dancer''s can also choose a party member as their Dance Partner, causing some of their skill''s effects to activate on the selected player.');
INSERT INTO note (user_id, title, text)
VALUES (2,'Dragoon',
        'Dragoons are famous for launching themselves across battlefields and decimating their foes using lance-based weapons, often bombarding enemies with vicious leaping attacks and positional combos.');
INSERT INTO note (user_id, title, text)
VALUES (2,'Machinist',
        'Machinists are gun-toting tinkerers that specialize in blasting foes in rapid succession, building up their Heat gauge, which is used to fuel their abilities further. They can also deploy an automaton to assist the player in combat temporarily.');
INSERT INTO note (user_id, title, text)
VALUES (2,'Monk',
        'Monks are very agile combatants that deal impressive sustained single-target damage, darting across the battlefield to annihilate foes with lightning speed using their fist-based weapons and martial techniques.');
INSERT INTO note (user_id, title, text)
VALUES (2,'Ninja',
        'Ninja''s are agile and elusive fighters that utilize ninjutsu and dual-daggers, slicing unsuspecting foes from the shadows in the blink of an eye. By using the right combination of mudras, they can also blast enemies with a variety of elemental attacks. Their ace-in-the-hole, Trick Attack, also increases the damage a target takes from all sources.');
INSERT INTO note (user_id, title, text)
VALUES (2,'Red Mage',
        'The Red Mage is a versatile class capable of using both magic and weapon skills effectively. The class focuses on building and balancing white and black mana by casting magic, then expending them on their melee rapier skills to deal a finishing blow. In addition to dealing damage, Red Mages can learn healing magic and can even raise fallen party members.');
INSERT INTO note (user_id, title, text)
VALUES (2,'Samurai',
        'The Samurai uses a two-handed katana to deal out tremendous single-target damage. Their attacks are slow, methodical and deliberate, yet extremely potent, able to carve even the most stalwart opponent into mere ribbons.');
INSERT INTO note (user_id, title, text)
VALUES (2,'Summoner',
        'Summoners conjure one of three battle-pets into the fray and bombard their enemies with devastating damage-over-time effects, as well as other abilities performed through their use of aetherflow. Summoner, like Red Mage, is also one of the few DPS jobs that can resurrect fallen allies in combat.');