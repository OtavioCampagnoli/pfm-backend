ALTER TABLE `transaction` 
CHANGE COLUMN `type` `type_cla` INT NOT NULL ,
CHANGE COLUMN `category` `category_cla` INT NOT NULL ,
ADD INDEX `fk_type_cla_idx` (`type_cla` ASC) VISIBLE,
ADD INDEX `fk_category_cla_idx` (`category_cla` ASC) VISIBLE;
;
ALTER TABLE `transaction` 
ADD CONSTRAINT `fk_type_cla`
  FOREIGN KEY (`type_cla`)
  REFERENCES `classifier` (`cla_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_category_cla`
  FOREIGN KEY (`category_cla`)
  REFERENCES `classifier` (`cla_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
