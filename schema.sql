use db1;

CREATE TABLE `t1` (
  `c1` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `t1` (`c1`)
VALUES
	('content in t1');



--
use db2;

CREATE TABLE `t1` (
  `c1` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `t1` (`c1`)
VALUES
	('content in t1 of db2');

