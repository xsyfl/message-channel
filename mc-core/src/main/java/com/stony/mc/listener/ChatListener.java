package com.stony.mc.listener;

import com.stony.mc.protocol.ExchangeProtocol;
import com.stony.mc.protocol.ExchangeTypeEnum;

/**
 * <p>message-channel
 * <p>com.stony.mc.listener
 *
 * @author stony
 * @version 上午10:10
 * @since 2019/4/18
 */
public interface ChatListener extends SubscribeListener {

    default void onSubscribe(ExchangeProtocol value) {
        if(support(value.getType())) {
            onChat(value);
        }
    }
    //TODO 消息实体优化
    void onChat(ExchangeProtocol value);

    default boolean support(ExchangeTypeEnum typeEnum) {
        return ExchangeTypeEnum.CHAT == typeEnum;
    }
}