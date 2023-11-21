package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

public class MarketRequestDto {

    @Getter
    public static class addDto {
        @NotNull
        private String name;
    }
}
