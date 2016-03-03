--delete from T_MC_USER;
--delete from T_MC_USER_LOGIN;

-- the old table's lastdate & userid
--  USER_TYPE(1), REGISTER_TYPE(1), UPDATE_DATE

insert into T_MC_USER (USER_ID, USER_ACCOUNT, PASSWORD, EMAIL, MOBILE_PHONE, NICK_NAME, USER_NAME, IDENTIFY_TYPE, IDENTIFY_NUMBER, SEX, BIRTHDAY, HOME_PHONE, OFFICE_PHONE, CONTACT_ADDRESS, ZIP_CODE, USER_LOGO, USER_TYPE, REGISTER_TYPE, STATUS, CHANNEL_USER_ID, CHANNEL_USER_FLAG, CREATE_DATE, UPDATE_DATE, CHECK_STATUS, USER_LEVEL, FLAG)
select USERID, useraccount, CONCAT(SUBSTR(password, 11), SUBSTR(password, 1, 10)), email, mobilephone, null, username, identifytype, identifynumber, sex, birthday, homephone, officephone, contactaddress, zipcode, null, '1', '1', status, channeluserid, channeluserflag, createdate, createdate, checkstatus, userlevel, flag from GE_USER_PERSONAL where userid not in (select user_id from T_MC_USER);

insert into T_MC_USER_LOGIN (USER_ID, LAST_LOGIN_DATE, LAST_LOGIN_IP, LAST_LOGIN_APPNUM)
select userid, lastdate, null, null from GE_USER_PERSONAL where userid not in (select user_id from T_MC_USER_LOGIN);

commit;
select * from T_MC_USER;
select * from T_MC_USER_LOGIN;

select count(*) from T_MC_USER;
select count(*) from T_MC_USER_LOGIN;