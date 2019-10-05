create database `blogdemo` default character set utf8;

USE `blogdemo`;

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