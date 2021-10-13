
set foreign_key_checks=0;
truncate table product;
truncate table feedback;
insert into product(`id`,`name`,`price`,`details`,`currency`)
values(110,'luxury chair',4500.0,'the main body of matter in a manuscript','SRC'),
    (111,'luxury sofa',5500.0,'the main body of matter in a manuscript','USD'),
    (112,'luxury bench',9500.0,'the main body of matter in a manuscript','NGN'),
    (113,'luxury table',11500.0,'the main body of matter in a manuscript','NGN');
set foreign_key_checks=1;