DROP TABLE IF EXISTS workout_category;
CREATE TABLE workout_category (
  category_id INT NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(64) NOT NULL,
  PRIMARY KEY (category_id));

DROP TABLE IF EXISTS workout_collection;
CREATE TABLE workout_collection (
  workout_id INT NOT NULL AUTO_INCREMENT,
  workout_title VARCHAR(128) NOT NULL,
  workout_note VARCHAR(256) NOT NULL,
  calories_burn_per_min FLOAT,
  category_id INT,
  PRIMARY KEY (workout_id),
  FOREIGN KEY (category_id) REFERENCES workout_category(category_id) ON DELETE CASCADE);

DROP TABLE IF EXISTS workout_active;
CREATE TABLE workout_active (
  workout_id INT,
  start_time TIME,
  start_date DATE,
  end_date DATE,
  end_time TIME,
  comment VARCHAR(64),
  status BOOLEAN,
  FOREIGN KEY (workout_id) REFERENCES workout_collection(workout_id) ON DELETE CASCADE);
  
INSERT INTO workout_category ( category_name)
VALUES ('Jogging');
INSERT INTO workout_category ( category_name)
VALUES ('Sprint');
INSERT INTO workout_category ( category_name)
VALUES ('Slow Walk');
INSERT INTO workout_category ( category_name)
VALUES ('Cardio');
INSERT INTO workout_category ( category_name)
VALUES ('Aerobics');
INSERT INTO workout_category ( category_name)
VALUES ('Yoga');