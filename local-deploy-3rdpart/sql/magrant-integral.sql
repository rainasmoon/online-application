delete from t_mc_integral;
delete from t_mc_wjb;

insert into t_mc_integral (USER_ID, STATUS, INTEGRAL, AVAILABLE_INTEGRAL, FREEZE_INTEGRAL, CREATE_DATE, UPDATE_DATE, VERSION)
select USER_ID, 1, 200, 200, 0, sysdate, sysdate, 1 from T_MC_USER where USER_ID not in (select USER_ID from t_mc_integral);

insert into t_mc_wjb (USER_ID, STATUS, AMOUNT, AVAILABLE_AMOUNT, FREEZE_AMOUNT, CREATE_DATE, UPDATE_DATE, VERSION)
select USER_ID, 1, 0, 0, 0, sysdate, sysdate, 0 from T_MC_USER where USER_ID not in (select USER_ID from t_mc_wjb);

commit;
select * from t_mc_integral;

