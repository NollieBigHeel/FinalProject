DROP TABLE IF EXISTS `pokedex`;

CREATE TABLE pokedex( 
id long AUTO_INCREMENT, 
name VARCHAR(30) NOT NULL,
type VARCHAR(30) NOT NULL,
hp INT,
description VARCHAR(250),
traded BOOLEAN,
PRIMARY KEY (id)
);

INSERT INTO `pokedex` (`name`, `type`, `hp`, `description`, `traded`) VALUES ('pokemon 1', 'type 1', 1, 'description 1', true);
INSERT INTO `pokedex` (`name`, `type`, `hp`, `description`, `traded`) VALUES ('pokemon 2', 'type 2', 2, 'description 2', false);