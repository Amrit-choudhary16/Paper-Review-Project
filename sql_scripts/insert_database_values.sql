INSERT INTO AUTHOR (EmailAddr, FirstName, LastName)
VALUES ('steven.king@author.com', 'Steven', 'King'),
('jkrowling@author.com', 'J.K.', 'Rowling'),
('jamespatterson@author.com', 'James', 'Patterson');

INSERT INTO PAPER (Id, Title, Abstract, FileName)
VALUES (1, 'Chocolates', 'Benifits of chocolates', 'chocolates.pdf'),
(2, 'Nature', 'Importance of nature', 'nature.pdf'),
(3, 'Sports', 'competition in sports', 'sports.pdf');


INSERT INTO REVIEWER (EmailAddr, FirstName, AuthorFeedback, LastName, CommitteeFeedback, PhoneNum, Affiliation)
VALUES ('John@reviewing.com', 'John', 'book is good', 'Doe', 'Book is great', '551-456-1234', 'institute of reviews'),
 ('randy@reviewing.com', 'Randy', 'book is great', 'Doe', 'Book is good', '531-456-7654', 'committee of reviews'),
 ('amenda@reviewing.com', 'Amenda', 'book is not up to the mark', 'Doe', 'Book could be better', '534-890-9807', 'institute of books and magazines');



INSERT INTO TOPIC (Id, TopicName)
VALUES (1, 'Dark chocolate'),
(2, 'Climate change'),
(3,'World cup soccer');



INSERT INTO REVIEW (Id, Recommendation, Meritscore, PaperId, ReadabilityScore, ReviewerId, OriginalityScore, RelevanceScore)
VALUES (1, 'The paper should be read', 8, 1, 9, 'John@reviewing.com',7, 8),
(2, 'The paper should be read', 6, 1, 8, 'randy@reviewing.com',7, 7),
(3, 'The paper could be read', 7, 1, 6, 'amenda@reviewing.com',6, 7),
(4, 'The paper should be read', 9, 2, 8, 'John@reviewing.com',8, 8),
(5, 'The paper could be read', 7, 2, 6, 'randy@reviewing.com',6, 5),
(6, 'The paper should be read', 8, 2, 8, 'amenda@reviewing.com',6, 6),
(7, 'The paper should not be read', 5, 3, 4, 'John@reviewing.com',4, 3),
(8, 'The paper should not be read', 4, 3, 4, 'randy@reviewing.com',5, 5),
(9, 'The paper should not be read', 3, 3, 2, 'amenda@reviewing.com',2, 1);