CREATE TABLE `user` (
                        `username` varchar(50) NOT NULL,
                        `password` varchar(30) NOT NULL,
                        `name` varchar(50) DEFAULT NULL,
                        `birthday` date DEFAULT NULL,
                        `gender` char(1) DEFAULT NULL,
                        `telephone` varchar(11) DEFAULT NULL,
                        `email` varchar(50) DEFAULT NULL,
                        `province` varchar(50) DEFAULT NULL,
                        `city` varchar(50) DEFAULT NULL,
                        UNIQUE KEY `username` (`username`),
                        KEY `idx_user_username` (`username`)
)
CREATE TABLE `edu_work` (
                            `username` varchar(50) NOT NULL,
                            `edu_level` varchar(15) DEFAULT NULL,
                            `edu_start` date DEFAULT NULL,
                            `edu_end` date DEFAULT NULL,
                            `school` varchar(50) DEFAULT NULL,
                            `degree` varchar(10) DEFAULT NULL,
                            `workplace` varchar(50) DEFAULT NULL,
                            `work_start` date DEFAULT NULL,
                            `work_end` date DEFAULT NULL,
                            `job` varchar(30) DEFAULT NULL,
                            PRIMARY KEY (`username`)
)

CREATE TABLE `friends` (
                           `fid` int(11) NOT NULL,
                           `user_1` varchar(50) NOT NULL,
                           `user_2` varchar(50) NOT NULL,
                           PRIMARY KEY (`fid`),
                           KEY `user_1` (`user_1`),
                           KEY `user_2` (`user_2`),
                           CONSTRAINT `friends_ibfk_1` FOREIGN KEY (`user_1`) REFERENCES `user` (`username`),
                           CONSTRAINT `friends_ibfk_2` FOREIGN KEY (`user_2`) REFERENCES `user` (`username`)
)
CREATE TABLE `blog` (
                        `bid` int(11) NOT NULL,
                        `title` varchar(50) NOT NULL,
                        `main_body` text,
                        `username` varchar(50) NOT NULL,
                        `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        PRIMARY KEY (`bid`),
                        KEY `username` (`username`),
                        KEY `idx_blog_bid` (`bid`),
                        CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
)
CREATE TABLE `comment` (
                           `cid` int(11) NOT NULL,
                           `bid` int(11) NOT NULL,
                           `commenter` varchar(50) NOT NULL,
                           `content` text NOT NULL,
                           `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           PRIMARY KEY (`cid`),
                           KEY `commenter` (`commenter`),
                           KEY `bid` (`bid`),
                           CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`commenter`) REFERENCES `user` (`username`),
                           CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`bid`) REFERENCES `blog` (`bid`) ON DELETE CASCADE
)
CREATE TABLE `replytocom` (
                              `rid` int(11) NOT NULL,
                              `cid` int(11) NOT NULL,
                              `replier` varchar(50) NOT NULL,
                              `content` text NOT NULL,
                              `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              PRIMARY KEY (`rid`),
                              KEY `replier` (`replier`),
                              KEY `cid` (`cid`),
                              CONSTRAINT `replytocom_ibfk_2` FOREIGN KEY (`replier`) REFERENCES `user` (`username`),
                              CONSTRAINT `replytocom_ibfk_3` FOREIGN KEY (`cid`) REFERENCES `comment` (`cid`) ON DELETE CASCADE
)
CREATE TABLE `replytorep` (
                              `rid` int(11) NOT NULL,
                              `target_rid` int(11) NOT NULL,
                              `replier` varchar(50) NOT NULL,
                              `content` text NOT NULL,
                              `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              PRIMARY KEY (`rid`),
                              KEY `replier` (`replier`),
                              KEY `target_rid` (`target_rid`),
                              CONSTRAINT `replytorep_ibfk_2` FOREIGN KEY (`replier`) REFERENCES `user` (`username`),
                              CONSTRAINT `replytorep_ibfk_3` FOREIGN KEY (`target_rid`) REFERENCES `replytocom` (`rid`) ON DELETE CASCADE
)
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reply_com` AS
select `replytocom`.`rid` AS `rid`,`comment`.`bid` AS `bid`,`replytocom`.`replier` AS `replier`,
       `comment`.`commenter` AS `commenter`,`replytocom`.`content` AS `content`,`comment`.`time` AS `com_time`,
       `replytocom`.`time` AS `rep_time` from (`replytocom` join `comment`) where (`replytocom`.`cid` = `comment`.`cid`)