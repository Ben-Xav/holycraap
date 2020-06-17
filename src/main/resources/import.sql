/* Item */
insert into `item` (name, price, weight) values ('Dent de dragon', '100', '1');

/* People */
insert into `people` (name, current_hp, hp_max, current_mp, mp_max) values ('Loup Ardent', '12', '12', '6', '6');
insert into `people` (name, current_hp, hp_max, current_mp, mp_max) values ('Hardy Xav', '1000', '1000', '1000', '1000');
insert into `people` (name, current_hp, hp_max, current_mp, mp_max) values ('Conan le Barbare', '14', '18', '4', '4');

/* People-Item */
insert into `people_item` (item_id, people_id) values ('1', '1');
