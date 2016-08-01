use dochub;

CREATE TABLE `appointment` (
  `appt_id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `slotid` varchar(20) DEFAULT NULL,
  `slottime` varchar(20) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`appt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `dob` varchar(45) NOT NULL,
  `email_id` varchar(100) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `security_question` varchar(100) NOT NULL,
  `sec_answer` varchar(20) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `addressline1` varchar(50) NOT NULL,
  `addressline2` varchar(30) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `zipcode` varchar(8) NOT NULL,
  `insurances_covered` varchar(30) NOT NULL,
  `license_number` varchar(50) NOT NULL,
  `specialization` varchar(100) NOT NULL,
  PRIMARY KEY (`doctor_id`),
  UNIQUE KEY `email_id` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `dob` varchar(45) NOT NULL,
  `email_id` varchar(100) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `security_question` varchar(100) NOT NULL,
  `sec_answer` varchar(20) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `addressline1` varchar(50) NOT NULL,
  `addressline2` varchar(30) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `zipcode` varchar(8) NOT NULL,
  `insurance_provider` varchar(30) NOT NULL,
  `insurance_id` varchar(50) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `email_id` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `doctoravailability` (
  `slotid` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_id` int(11) DEFAULT NULL,
  `avdate` varchar(50) DEFAULT NULL,
  `slot1` tinyint(1) DEFAULT NULL,
  `slot2` tinyint(1) DEFAULT NULL,
  `slot3` tinyint(1) DEFAULT NULL,
  `slot4` tinyint(1) DEFAULT NULL,
  `slot5` tinyint(1) DEFAULT NULL,
  `slot6` tinyint(1) DEFAULT NULL,
  `slot7` tinyint(1) DEFAULT NULL,
  `slot8` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`slotid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;


CREATE TABLE `feedback` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `appt_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `feedback` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


CREATE TABLE `slots` (
  `slotid` varchar(10) NOT NULL,
  `times` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`slotid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into slots values('slot1','09AM-10AM');
insert into slots values('slot2','10AM-11AM');
insert into slots values('slot3','11AM-12PM');
insert into slots values('slot4','12PM-01PM');
insert into slots values('slot5','2PM-03PM');
insert into slots values('slot6','3PM-04PM');
insert into slots values('slot7','04PM-05PM');
insert into slots values('slot8','05PM-06PM');

