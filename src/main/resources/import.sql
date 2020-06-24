/* People */
insert into `people` (name, current_hp, hp_max, current_mp, mp_max) values ('Loup Ardent', '12', '12', '6', '6');
insert into `people` (name, current_hp, hp_max, current_mp, mp_max) values ('Hardy Xav', '1000', '1000', '1000', '1000');
insert into `people` (name, current_hp, hp_max, current_mp, mp_max) values ('Conan le Barbare', '14', '18', '4', '4');

/* Inventory */
insert into `inventory` (people_id) values (1);
insert into `inventory` (people_id) values (2);
insert into `inventory` (people_id) values (3);

/* Item */
insert into `item` (name, price, slot, inventory_people_id) values ('Dent de dragon', '100', '1', '1');
insert into `item` (name, price, slot, inventory_people_id) values ('salicorne', '2', '1', '2');
insert into `item` (name, price, slot, inventory_people_id) values ('gousse de mandragore', '5', '1', '3');

/* Inventory-Items associations */
insert into `inventory_items` (items_id, inventory_people_id) values ('1', '1');
insert into `inventory_items` (items_id, inventory_people_id) values ('2', '2');
insert into `inventory_items` (items_id, inventory_people_id) values ('3', '3');