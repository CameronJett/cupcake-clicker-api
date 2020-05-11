DROP TABLE IF EXISTS user;
 
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    clicks INT NOT NULL
);
 
INSERT INTO user (name, clicks) VALUES
  ('Cameron', 1000000),
  ('Petros', 0),
  ('Mikey', 2000);