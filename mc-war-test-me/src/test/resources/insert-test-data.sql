delete from T_MC_USER_CHANNEL where user_id = '11112';
delete from T_MC_USER where user_id = '11112' or mobile_phone = '13690000123' or user_account = 'testThirdAccount' or user_account = 'test';
delete from t_Mc_User_Login where user_id = '11112';

--111111
insert into T_MC_USER (USER_ID, USER_ACCOUNT, PASSWORD, EMAIL, MOBILE_PHONE, NICK_NAME, USER_NAME, IDENTIFY_TYPE, IDENTIFY_NUMBER, SEX, BIRTHDAY, HOME_PHONE, OFFICE_PHONE, CONTACT_ADDRESS, ZIP_CODE, USER_LOGO, USER_TYPE, REGISTER_TYPE, STATUS, CHANNEL_USER_ID, CHANNEL_USER_FLAG, CREATE_DATE, UPDATE_DATE, CHECK_STATUS, USER_LEVEL, FLAG)
values ('11112', 'testGlen', '5eb72c92a549dd5a33011296e7921896', null, '13456781234', null, null, 0, null, 0, null, null, null, null, null, null, 0, 0, 1, 'testChannelUserId', '00', to_date('31-12-2015', 'dd-mm-yyyy'), to_date('31-12-2015', 'dd-mm-yyyy'), 0, null, null);

insert into T_MC_USER_CHANNEL (USER_ID, CHANNEL_USER_FLAG, CHANNEL_USER_ID, LAST_LOGIN_DATE)
values ('11112', '10', 'testChannelUserId', null);

insert into t_Mc_User_Login (USER_ID, LAST_LOGIN_DATE, LAST_LOGIN_IP, LAST_LOGIN_APPNUM)
values ('11112', to_date('08-01-2016 13:00:48', 'dd-mm-yyyy hh24:mi:ss'), '1.2.3.4', 'testData');

commit;

select * from T_MC_USER T where USER_ACCOUNT = 'testGlen' OR MOBILE_PHONE= 'testGlen';


