INSERT INTO category(id, name) values (0, 'Equipment')
INSERT INTO category(id, name) values (1, 'Materials')
INSERT INTO category(id, name) values (2, 'Tools')

INSERT INTO sub_category(id, name, category_id) values (0, 'Vest', 0)
INSERT INTO sub_category(id, name, category_id) values (1, 'Hardhat', 0)
INSERT INTO sub_category(id, name, category_id) values (2, 'Light', 0)

INSERT INTO sub_category(id, name, category_id) values (3, 'Lumber', 1)
INSERT INTO sub_category(id, name, category_id) values (4, 'Rebar', 1)
INSERT INTO sub_category(id, name, category_id) values (5, 'Concrete', 1)

INSERT INTO sub_category(id, name, category_id) values (6, 'Wrench', 2)
INSERT INTO sub_category(id, name, category_id) values (7, 'Hammer', 2)
INSERT INTO sub_category(id, name, category_id) values (8, 'Screwdriver', 2)

