package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.IsSuccessMission;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
        private int point;
        @NotNull
        private Long marketId;
    }

    @Getter
    public static class allocateMissionDto{
        @NotNull
        private Long userId;
        @NotNull
        @IsSuccessMission
        private Long missionId;
    }

}
