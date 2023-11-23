package umc.spring.base.exception.handler;

import umc.spring.base.Code;
import umc.spring.base.exception.GeneralException;

public class MissionCategoryHandler extends GeneralException {
    public MissionCategoryHandler (Code errorCode){
        super(errorCode);
    }
}
