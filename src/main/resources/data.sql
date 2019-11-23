DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(45) NOT NULL,
  middle_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  date_of_birth DATE NOT NULL,
  date_of_employment DATE NOT NULL,
  status TINYINT DEFAULT 1
);

INSERT INTO employee (first_name, middle_name, last_name, date_of_birth, date_of_employment, status) VALUES
  ('Bob', 'Snicket', 'Smithbobber', '1944-12-10', '1995-07-05', 1),
  ('Frank', 'Moonchie', 'Bumblechap', '1944-12-10', '1995-07-05', 1),
  ('Lisa', 'Flowbee', 'Grooder', '1944-12-10', '1995-07-05', 1);