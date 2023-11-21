package umc.spring.converter;

import umc.spring.domain.Food;
import umc.spring.domain.mapping.Food_user;

import java.util.List;
import java.util.stream.Collectors;

public class FoodConverter {

    public static List<Food_user> toMemberPreferList(List<Food> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory ->
                        Food_user.builder().food(foodCategory).build()).collect(Collectors.toList());
    }
}
