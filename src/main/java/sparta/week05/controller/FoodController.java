package sparta.week05.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sparta.week05.dto.FoodRequestDto;
import sparta.week05.dto.FoodResponseDto;
import sparta.week05.repository.FoodRepository;
import sparta.week05.service.FoodService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;


    //메뉴 등록

    @PostMapping("/restaurant/{restaurantId}/food/register") // 받아오는 것 자체를 리스트로 받아버린다.
    public ResponseEntity registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> requestDto) {
        return foodService.validateRegister(restaurantId, requestDto);
    }


    //가게에 있는 메뉴 전체 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> showMenu(@PathVariable Long restaurantId) {
        return foodService.showMenu(restaurantId);
    }
}
