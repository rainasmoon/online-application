package com.rainasmoon.onepay.service;

import com.rainasmoon.onepay.service.dto.TransferResult;

public interface AccountService {

	/**
	 * 下单，转账，时用，从一个账户转账到另一个账户
	 * 
	 * @param fromUserId
	 * @param toUserId
	 * @param amount
	 * @return
	 * @exception @Author wlcic-glen
	 * @Date 2016年3月22日 上午11:25:13
	 * @since 1.0.0
	 * @see
	 */
	TransferResult transferAccount(Long fromUserId, Long toUserId,
			Integer amount);

	/**
	 * 买市场上的猿币时用到。
	 * 
	 * @param fromUserId
	 * @param toUserId
	 * @param amount
	 * @return
	 * @exception @Author wlcic-glen
	 * @Date 2016年3月22日 上午11:29:46
	 * @since 1.0.0
	 * @see
	 */
	TransferResult transferToFreezeAccount(Long fromUserId, Long toUserId,
			Integer amount);

	/**
	 * 解冻
	 * 
	 * @param userId
	 * @param amount
	 * @return
	 * @exception @Author wlcic-glen
	 * @Date 2016年3月22日 上午11:26:05
	 * @since 1.0.0
	 * @see
	 */
	TransferResult unfreeze(Long userId, Integer amount);

	/**
	 * 发布卖猿币市场信息时用到，直接从账户上减去。
	 * 
	 * @param userId
	 * @param amount
	 * @return
	 * @exception @Author wlcic-glen
	 * @Date 2016年3月22日 上午11:26:25
	 * @since 1.0.0
	 * @see
	 */
	TransferResult minusAccount(Long userId, Integer amount);

	/**
	 * 买市场猿币时用到，
	 * 
	 * @param dealerId
	 * @param amount
	 * @return
	 * @exception @Author wlcic-glen
	 * @Date 2016年3月22日 上午11:28:45
	 * @since 1.0.0
	 * @see
	 */
	TransferResult addFreezeAccount(Long dealerId, Integer amount);

	/**
	 * 直接充值时使用
	 * 
	 * @param userId
	 * @param amount
	 * @return
	 */
	TransferResult addAccount(Long userId, Integer amount);
}
