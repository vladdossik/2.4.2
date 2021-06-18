INSERT INTO user (id, name, password)
VALUES  (1,'Vladdossik','Vladik7540*');

INSERT INTO role (id,name)
VALUES (1,'ROLE_ADMIN');

INSERT INTO user_role (user_id,role_id)
VALUES((select id from user where name = 'Max'),(select id from role where name = 'ROLE_ADMIN'));