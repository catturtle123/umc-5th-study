package umc.spring.base.exception.handler;

import umc.spring.base.Code;
import umc.spring.base.exception.GeneralException;

public class MemberCategoryHandler extends GeneralException {
    public MemberCategoryHandler(Code errorCode) {
        super(errorCode);
    }
}
