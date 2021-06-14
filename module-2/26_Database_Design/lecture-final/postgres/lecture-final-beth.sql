DROP TABLE IF EXISTS customer_purchases;
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS artists;


CREATE TABLE customers (
        customer_id serial,
        customer_name varchar(100) not null,
        mailing_address varchar(500) not null,
        main_phone varchar(20) null,
        
        constraint pk_customers primary key (customer_id)
);

CREATE TABLE artists (
        artist_id serial,
        artist_name varchar(200), --fix this null
        
        constraint pk_artists primary key (artist_id)
);

CREATE TABLE customer_purchases (
        customer_id int not null,
        art_code char(3) not null,
        purchase_date timestamp not null,
        price money not null,
        
        constraint pk_customer_purchases primary key (customer_id, art_code, purchase_date),
        constraint fk_customer_purchases_customers foreign key (customer_id) references customers (customer_id)
);

CREATE TABLE art (
        art_code char(3),
        art_title varchar(100) not null,
        artist_id int not null,
        
        constraint pk_art primary key (art_code),
        constraint fk_art_artists foreign Key (artist_id) references artists (artist_id)
);


ALTER TABLE art 
ADD COLUMN description varchar(5000);

ALTER TABLE artists
ALTER COLUMN artist_name SET NOT NULL;

ALTER TABLE customer_purchases
ADD constraint fk_customer_purchases_art foreign key (art_code) references art (art_code);