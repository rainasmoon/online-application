


insert into T_MC_USER (USER_ID, USER_ACCOUNT, PASSWORD, EMAIL, MOBILE_PHONE, NICK_NAME, USER_NAME, IDENTIFY_TYPE, IDENTIFY_NUMBER, SEX, BIRTHDAY, HOME_PHONE, OFFICE_PHONE, CONTACT_ADDRESS, ZIP_CODE, USER_LOGO, USER_TYPE, REGISTER_TYPE, STATUS, CHANNEL_USER_ID, CHANNEL_USER_FLAG, CREATE_DATE, UPDATE_DATE, CHECK_STATUS, USER_LEVEL, FLAG)
select USERID, useraccount, password, email, mobilephone, null, username, identifytype, identifynumber, sex, birthday, homephone, officephone, contactaddress, zipcode, null, null, null, status, channeluserid, channeluserflag, createdate, null, checkstatus, userlevel, flag from GE_USER_PERSONAL;

-- the old table's lastdate & userid