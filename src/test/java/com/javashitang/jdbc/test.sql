CREATE TABLE `kf_user_info` (
`id` int(11) NOT NULL COMMENT '用户id',
`gid` int(11) NOT NULL COMMENT '客服组id',
`name` varchar(25) NOT NULL COMMENT '客服名字'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客服信息表';

DROP PROCEDURE IF EXISTS create_kf;
DELIMITER //
CREATE PROCEDURE create_kf()
BEGIN
    INSERT INTO kf_user_info (`id`,`gid`,`name`) VALUES (1, 1, 1);
    INSERT INTO kf_user_info (`id`,`gid`,`name`) VALUES (2, 2, 2);
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS create_kf_use_arg;
DELIMITER //
CREATE PROCEDURE create_kf_use_arg(IN loop_times INT)
BEGIN
    DECLARE var INT;
    SET var = 1;
    WHILE var <= loop_times DO
    INSERT INTO kf_user_info (`id`,`gid`,`name`)
    VALUES (var, var, var);
    SET var = var + 1;
    END WHILE;
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS get_kf;
DELIMITER //
CREATE PROCEDURE get_kf(IN num int)
BEGIN
    SELECT `id`,`gid`,`name` FROM kf_user_info kf_user_info WHERE id = num;
END //
DELIMITER ;
