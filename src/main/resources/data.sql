insert into Publisher values ( 1, 'Manning Publications', 'https://www.manning.com/' );
insert into Publisher values ( 2, 'Addison Wesley Longman, Inc.', null );
insert into Publisher values ( 3, 'O''Reilly', 'https://www.oreilly.com/' );
insert into Publisher values ( 4, 'Apress', 'https://www.apress.com/us' ); 
insert into Publisher values ( 5, 'Pragmatic Bookshelf', 'https://pragprog.com/' ); 


insert into Author values ( 1, 'Craig', 'Walls', null );
insert into Author values ( 2, 'Ken', 'Kousen', null );
insert into Author values ( 3, 'Andrew', 'Hunt', '' );
insert into Author values ( 4, 'David', 'Thomas', 'Matthew' );
insert into Author values ( 5, 'Venkat', 'Subramaniam', null );


insert into Book values ( 1, 'https://images-na.ssl-images-amazon.com/images/I/51XDLVLQOOL._SX396_BO1,204,203,200_.jpg', '1617292540', 44.99, 'Spring Boot in Action', 1 );
insert into Book values ( 2, 'https://images-na.ssl-images-amazon.com/images/I/51j3SzJmJ6L._SX397_BO1,204,203,200_.jpg', '1935182943', 44.99, 'Making Java Groovy', 1 );
insert into Book values ( 3, 'https://images-na.ssl-images-amazon.com/images/I/41BKx1AxQWL._SX396_BO1,204,203,200_.jpg', '020161622X', 49.99, 'The Pragmatic Programmer', 2 );
insert into Book values ( 4, 'https://images-na.ssl-images-amazon.com/images/I/51BPStYoh-L._SX413_BO1,204,203,200_.jpg', '097451408X', 29.99, 'Practices of an Agile Developer', 5 );


insert into Book_Author values ( 1, 1 );
insert into Book_Author values ( 2, 2 );
insert into Book_Author values ( 3, 3 );
insert into Book_Author values ( 4, 3 );
insert into Book_Author values ( 5, 4 );
insert into Book_Author values ( 3, 4 );


