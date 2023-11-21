package umc.spring.base.exception.handler;

import umc.spring.base.Code;
import umc.spring.base.exception.GeneralException;

public class MarketCategoryHandler extends GeneralException {
    public MarketCategoryHandler(Code errorCode) {
        super(errorCode);
    }
}
