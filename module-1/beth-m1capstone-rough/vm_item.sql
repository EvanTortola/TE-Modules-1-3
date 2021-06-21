DROP TABLE IF EXISTS vm_item;
CREATE TABLE vm_item (
	slot_id varchar(5) PRIMARY KEY,
	description varchar(25) NOT NULL,
	price decimal(18, 2) NOT NULL,
	snack_type varchar(10) NOT NULL
);
INSERT INTO vm_item VALUES ('A1', 'Potato Crisps', 3.05, 'Chip');
INSERT INTO vm_item VALUES ('A2', 'Stackers', 1.45, 'Chip');
INSERT INTO vm_item VALUES ('A3', 'Grain Waves', 2.75, 'Chip');
INSERT INTO vm_item VALUES ('A4', 'Cloud Popcor', 3.65, 'Chip');
INSERT INTO vm_item VALUES ('B1', 'Moonpie', 1.80, 'Candy');
INSERT INTO vm_item VALUES ('B2', 'Cowtales', 1.50, 'Candy');
INSERT INTO vm_item VALUES ('B3', 'Wonka Bar', 1.50, 'Candy');
INSERT INTO vm_item VALUES ('B4', 'Crunchie', 1.75, 'Candy');
INSERT INTO vm_item VALUES ('C1', 'Cola', 1.25, 'Drink');
INSERT INTO vm_item VALUES ('C2', 'Dr. Salt', 1.50, 'Drink');
INSERT INTO vm_item VALUES ('C3', 'Mountain Melter', 1.50, 'Drink');
INSERT INTO vm_item VALUES ('C4', 'Heavy', 1.50, 'Drink');
INSERT INTO vm_item VALUES ('D1', 'U-Chews', 0.85, 'Gum');
INSERT INTO vm_item VALUES ('D2', 'Little League Chew', 0.95, 'Gum');
INSERT INTO vm_item VALUES ('D3', 'Chiclets', 0.75, 'Gum');
INSERT INTO vm_item VALUES ('D4', 'Triplemint', 0.75, 'Gum');