ALTER TABLE `user`
	ALTER `user_e-mail` DROP DEFAULT;
ALTER TABLE `user`
	CHANGE COLUMN `user_e-mail` `user_e-mail` VARCHAR(45) NOT NULL AFTER `passwordhash`,
	ADD COLUMN `userfirstname` VARCHAR(50) NULL AFTER `user_photo`,
	ADD COLUMN `userlastname` VARCHAR(50) NULL AFTER `userfirstname`;
	
ALTER TABLE `user`
	CHANGE COLUMN `user_phone_num` `user_phone_num` VARCHAR(50) NULL DEFAULT NULL AFTER `user_e-mail`;