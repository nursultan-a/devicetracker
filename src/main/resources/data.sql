truncate user;

insert into user (id, user_name, password, active, roles ) values (2, "q", "q", true, "ROLE_USER"), (1, "admin", "admin", true, "ROLE_ADMIN");
