DROP TABLE IF EXISTS event_members;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS member_interest_group;
DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS interest_group;

CREATE TABLE members (
        member_id serial,
        member_name varchar(100) not null,
        email_address varchar(100) not null,
        phone_number varchar(20) null,
        birthdate varchar(20) not null,
        want_reminders boolean not null,
        
        constraint pk_members primary key (member_id)
);

CREATE TABLE interest_group (
        group_id serial,
        group_name varchar(100),
        
        constraint pk_interest_group primary key (group_id)      
);

CREATE TABLE member_interest_group (
        member_id int not null,
        group_id int not null,
        
        constraint pk_member_interest_group primary key (member_id, group_id),
        constraint fk_member_interest_group_members foreign key (member_id) references members (member_id),
        constraint fk_member_interest_group_interest_group foreign key (group_id) references interest_group (group_id)
        
);

CREATE TABLE event (
        event_id serial,
        event_name varchar(100) not null,
        description varchar(500) not null,
        start_date DATE not null,
        start_time TIME not null,
        duration_minutes INT DEFAULT (30) not null CHECK (duration_minutes >= 30),
        group_in_charge INT not null,
        
        constraint pk_event primary key (event_id),
        constraint fk_event_interest_group foreign key (group_in_charge) references interest_group (group_id)
        
        
);

CREATE TABLE event_members (
        member_id INT not null,
        event_id INT not null,
        
        constraint pk_event_members primary key (member_id, event_id),
        constraint fk_event_members_members foreign key (member_id) references members (member_id),
        constraint fk_event_members_event foreign key (event_id) references event (event_id)
        
);

INSERT INTO members (member_name, email_address, phone_number, birthdate, want_reminders)
VALUES ('Evan Tortola', 'etortola58@gmail.com', '330-209-2173', '10-20-1990', false),
       ('Tony Soprano', 'mobBoss500@aol.com', '330-555-8844', '09-25-1955', false),
       ('Ken Carman', 'KCarman@923Fan.com', '216-578-0092', '08-15-1986', true),
       ('Walter White', 'Heisenberg@aol.com', '555-888-3344', '06-17-1955', false),
       ('Jesse Pinkman', 'JPink@hotmail.com', '555-323-9834', '03-12-1990', false),
       ('Baker Mayfield', 'QB1@Browns.com', '216-330-6666', '05-18-1996', false),
       ('Kevin Stefanski', 'GOATcoach@Browns.com', '216-330-1111', '06-12-1983', true),
       ('Jessica Pastore', 'JPastore5@gmail.com', '330-936-1583', '12-26-1991', true);
       
INSERT INTO interest_group (group_name)
VALUES ('Browns Fans'),
       ('Ohio Natives'),
       ('Fans Of Naps');
       
INSERT INTO event (event_name, description, start_date, start_time, duration_minutes, group_in_charge)
VALUES ('Browns Fans 101', 'A Meeting for any and all Browns fans', '2021-06-18', '12:00:00', 30, 1),
       ('Mafia Discussions', 'What do we know about the mafia?', '2021-07-01', '01:00:00', 60, 2),
       ('Finest Establishments in Ohio', 'The best places to visit in Ohio', '2021-08-02', '14:30:00', 45, 2),
       ('Discussion of Naps', 'Talk about all things you love about napping', '2021-06-16', '16:00:00', 90, 3);
       
