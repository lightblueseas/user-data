create table permissions (id int4 not null, description varchar(64), permissionName varchar(64) unique, shortcut varchar(10) unique, primary key (id));
create table relation_permissions (id int4 not null, provider_id int4, subscriber_id int4, primary key (id));
create table reset_passwords (id int4 not null, expiry_date timestamp, generated_password varchar(1024), starttime timestamp, user_id int4, primary key (id));
create table role_permissions (role_id int4 not null, permission_id int4 not null, primary key (role_id, permission_id));
create table roles (id int4 not null, description varchar(64), rolename varchar(64) unique, primary key (id));
create table user_relation_permissions (user_relation_permission_id int4 not null, permission_id int4 not null, primary key (user_relation_permission_id, permission_id));
create table user_roles (user_id int4 not null, role_id int4 not null, primary key (user_id, role_id));
create table user_tokens (id int4 not null, expiry timestamp, token varchar(128) unique, username varchar(256) unique, primary key (id));
create table users (id int4 not null, active bool, locked bool, pw varchar(1024), salt varchar(8), username varchar(256) unique, primary key (id));
