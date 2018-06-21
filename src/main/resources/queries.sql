select * FROM Book b
left join Book_Author ba on b.book_id = ba.book_id
left join Author a on a.author_id = ba.author_id
left join Publisher p on b.publisher_id = p.publisher_id
where b.book_id=4