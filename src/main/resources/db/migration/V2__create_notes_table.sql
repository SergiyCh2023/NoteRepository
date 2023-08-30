CREATE TABLE notes (
    id BIGINT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title VARCHAR(100),
    content VARCHAR,
    access_type VARCHAR NOT NULL
);

ALTER TABLE notes ADD CONSTRAINT  notes_users_fk
FOREIGN KEY (user_id) REFERENCES users(id) on delete cascade;




INSERT INTO notes (id, user_id, title, content, access_type) VALUES
 (1, 2, 'some title note #1', 'some context note#1', 'isPublic'),
 (2, 2, 'some title note #2', 'some context note#2', 'isPublic'),
 (3, 2, 'some title note #3', 'some context note#3', 'isPrivate');



