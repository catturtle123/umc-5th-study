package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.User_mission;
import umc.spring.validator.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MissionRequestDto {

    @Getter
    public static class addMissionDto{
        @NotBlank
        private String name;
        @NotNull
        private String content;
        @NotNull
        private int distinctNumber;
        @NotNull
        private boolean isSuccess;
        @NotNull
        private int point;
        @NotNull
        private Long marketId;
    }

    @Getter
    public static class allocateMissionDto{
        @NotNull
        private Long userId;
        @NotNull
        private Long missionId;
    }

}
