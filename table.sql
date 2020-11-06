DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` VALUES ('1', '章佳欢', '1979-11-06', '1');
INSERT INTO `user` VALUES ('2', '何鑫', '1989-11-06', '0');
INSERT INTO `user` VALUES ('3', '仲海刚', '1999-11-06', '1');
INSERT INTO `user` VALUES ('4', '余涵颖', '2009-11-06', '0');


