package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.base.Code;
import umc.spring.base.exception.handler.FoodCategoryHandler;
import umc.spring.converter.FoodConverter;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Food;
import umc.spring.domain.User;
import umc.spring.domain.mapping.Food_user;
import umc.spring.repository.FoodRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.web.dto.MemberRequestDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodRepository foodRepository;


    @Transactional
    @Override
    public User joinMember(MemberRequestDto.JoinDto request) {
        User newMember = MemberConverter.toUser(request);
        List<Food> foodcategoryList = request.getFoodUserList().stream()
                .map(category -> {
                    return foodRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(Code.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<Food_user> foodUserList = FoodConverter.toMemberPreferList(foodcategoryList);

        foodUserList.forEach(memberPrefer -> {memberPrefer.setUser(newMember);});

        return memberRepository.save(newMember);
    }
}
