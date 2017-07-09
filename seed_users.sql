CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled SMALLINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
CREATE SEQUENCE user_roles_seq;

CREATE TABLE user_roles (
  user_role_id int NOT NULL DEFAULT NEXTVAL ('user_roles_seq'),
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  CONSTRAINT uni_username_role UNIQUE (role,username)
 ,
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));

CREATE INDEX fk_username_idx ON user_roles (username);
INSERT INTO users(username,password,enabled)
VALUES ('priya','priya', 1);
INSERT INTO users(username,password,enabled)
VALUES ('naveen','naveen', 1);
INSERT INTO user_roles (username, role)
VALUES ('priya', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('priya', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('naveen', 'ROLE_USER');