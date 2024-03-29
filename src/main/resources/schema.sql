CREATE TABLE IF NOT EXISTS Content (
   id INTEGER AUTO_INCREMENT, 
   title VARCHAR(256) NOT NULL,
   desc text,
   status VARCHAR(20) NOT NULL,
   content_type VARCHAR(50) NOT NULL,
   date_created TIMESTAMP NOT NULL,
   data_updated TIMESTAMP,
   url VARCHAR(255),
   primary key (id)

);

INSERT INTO Content(title, desc, status, content_type, date_created)
VALUES('My Spring Data Blog Post', 'My Spring Data Blog Post', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP)