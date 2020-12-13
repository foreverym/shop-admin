package com.wy.shop.facade;

import com.wy.shop.common.result.Result;
import com.wy.shop.facade.request.OrderMainRequest;
import com.wy.shop.facade.response.OrderPageResponse;
import java.util.List;

/**
 * @author wangyibo
 */
public interface OrderFacade {

    public Result<List<OrderPageResponse>> queryPageOrder(Integer page,
                                                          String logistic_code,
                                                          Integer status);

}
