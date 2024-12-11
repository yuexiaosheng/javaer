DROP TABLE IF EXISTS `website`;
CREATE TABLE `website` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `url` varchar(30) COLLATE utf8_unicode_ci DEFAULT '',
  `age` tinyint(3) unsigned NOT NULL,
  `country` char(3) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `createtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;