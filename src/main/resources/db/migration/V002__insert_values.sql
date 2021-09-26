insert into users (id_user, email, password, phone, username)
values (0, 'livros@mail.com', 'livros', '999999999', 'livros');

insert into roles(id_roles, roles)
values (1, 0);

insert into image_links (id_image_links, small_thumbnail, thumbnail)
values (
    0,
    'http://books.google.com/books/content?id=RhqJWjZ_6o4C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api',
    'http://books.google.com/books/content?id=RhqJWjZ_6o4C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api'
);

insert into book_info (
    id_book_info,
    canonical_volume_link,
    description,
    id_image_links,
    info_link,
    preview_link,
    publisher_date,
    publisher,
    text_snippet,
    title
)
values (
    0,
    'https://play.google.com/store/books/details?id=RhqJWjZ_6o4C',
    'description": "Considerado um dos maiores clássicos da literatura de ficção científica, O Guia do Mochileiro das Galáxias vem encantando gerações de leitores ao redor do mundo com seu humor afiado. Este é o primeiro título da famosa série escrita por Douglas Adams, que conta as aventuras espaciais do inglês Arthur Dent e de seu amigo Ford Prefect. A dupla escapa da destruição da Terra pegando carona numa nave alienígena, graças aos conhecimentos de Prefect, um E.T. que vivia disfarçado de ator desempregado enquanto fazia pesquisa de campo para a nova edição do Guia do Mochileiro das Galáxias, o melhor guia de viagens interplanetário. Mestre da sátira, Douglas Adams cria personagens inesquecíveis e situações mirabolantes para debochar da burocracia, dos políticos, da \"alta cultura\" e de diversas instituições atuais. Seu livro, que trata em última instância da busca do sentido da vida, não só diverte como também faz pensar.',
    1,
    'https://play.google.com/store/books/details?id=RhqJWjZ_6o4C&source=gbs_api',
    'http://books.google.com.br/books?id=RhqJWjZ_6o4C&printsec=frontcover&dq=O+guia+do+mochileiro+das+galaxias&hl=&cd=1&source=gbs_api',
    '2010-12-15',
    'Editora Arqueiro',
    null,
    'O guia do mochileiro das galáxias'
);

insert into book (id_book, self_link, id_book_info)
values (
    0,
    'https://www.googleapis.com/books/v1/volumes/RhqJWjZ_6o4C',
    1
);

insert into donation (id_donation, status, book_id, id_user, create_date)
values (0, 2, 1, 1, NOW());

insert into authors (id_authors, authors)
values (0, 'Douglas Adams');

insert into categories (id_categories, categories)
values (0, 'Fiction');
