delete from T_MC_USER;
delete from T_MC_USER_LOGIN;
-- the old table's lastdate & userid
--  USER_TYPE(1), REGISTER_TYPE(1), UPDATE_DATE

insert into T_MC_USER (USER_ID, USER_ACCOUNT, PASSWORD, EMAIL, MOBILE_PHONE, NICK_NAME, USER_NAME, IDENTIFY_TYPE, IDENTIFY_NUMBER, SEX, BIRTHDAY, HOME_PHONE, OFFICE_PHONE, CONTACT_ADDRESS, ZIP_CODE, USER_LOGO, USER_TYPE, REGISTER_TYPE, STATUS, CHANNEL_USER_ID, CHANNEL_USER_FLAG, CREATE_DATE, UPDATE_DATE, CHECK_STATUS, USER_LEVEL, FLAG)
select USERID, useraccount, CONCAT(SUBSTR(password, 11), SUBSTR(password, 1, 10)), email, mobilephone, null, username, identifytype, identifynumber, sex, birthday, homephone, officephone, contactaddress, zipcode, null, null, null, status, channeluserid, channeluserflag, createdate, null, checkstatus, userlevel, flag from GE_USER_PERSONAL;

insert into t_Mc_User_Login (USER_ID, LAST_LOGIN_DATE, LAST_LOGIN_IP, LAST_LOGIN_APPNUM)
select userid, lastdate, null, null from GE_USER_PERSONAL where lastdate is not null;

commit;
select * from T_MC_USER;