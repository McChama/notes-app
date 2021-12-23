DROP TABLE IF EXISTS NOTE;

CREATE TABLE NOTE(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  TITLE VARCHAR(50) NOT NULL,
  CONTENT VARCHAR(255) NOT NULL,
  CREATED_AT TIME,
  UPDATED_AT TIME
);