CREATE SCHEMA IF NOT EXISTS user CHARACTER SET utf8 COLLATE utf8_bin;
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'pass';
GRANT ALL ON user.* TO 'user'@'%';