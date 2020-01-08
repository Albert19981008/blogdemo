drop database if exists `blogdemo`;
create database `blogdemo` default character set utf8;

use `blogdemo`;

drop table if exists `value_table`;
create table `value_table`
(
    `id`          int primary key,
    `name`        text default null,
    `explanation` text default null
);

insert into `value_table`(`id`, `name`, `explanation`)
values (1, '追求极致', 'Aim for the highest');

insert into `value_table`(`id`, `name`, `explanation`)
values (2, '务实敢为', 'Be grounded & courageous');

insert into `value_table`(`id`, `name`, `explanation`)
values (3, '始终创业', 'Always Day 1');


drop table if exists `topic`;
create table `topic`
(
    `id`   int primary key,
    `name` text default null
);

insert into `topic`(`id`, `name`)
values (1, 'Java后端');

insert into `topic`(`id`, `name`)
values (2, 'docker');

insert into `topic`(`id`, `name`)
values (3, 'git');


drop table if exists `user`;
create table `user`
(
    `id`       int primary key,
    `username` text default null,
    `password` text default null,
    `role`     text default null
);

insert into `user`(`id`, `username`, `password`, `role`)
values (1, 'root', '63a9f0ea7bb98050796b649e85481845', 'root');


drop table if exists `article`;
create table `article`
(
    `article_id`   int primary key,
    `user_id`      int,
    `topic_id`     int,
    `title`        text,
    `article_text` text
);

insert into `article`
values (1, 1, 2, 'test_article_title', 'test_article_text');