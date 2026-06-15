package kr.ac.kopo.gnuyog.myflix.service;

import kr.ac.kopo.gnuyog.myflix.model.WishList;
import kr.ac.kopo.gnuyog.myflix.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    // 찜 토글 (있으면 제거, 없으면 추가) → 현재 상태 반환
    public boolean toggle(String username, Long movieId) {
        WishList wishList = wishListRepository.findByUsername(username);
        if (wishList.contains(movieId)) {
            wishList.removeMovie(movieId);
            wishListRepository.save(wishList);
            return false; // 찜 해제
        } else {
            wishList.addMovie(movieId);
            wishListRepository.save(wishList);
            return true; // 찜 추가
        }
    }

    // 특정 영화 찜 여부
    public boolean isWished(String username, Long movieId) {
        return wishListRepository.findByUsername(username).contains(movieId);
    }

    // 찜한 영화 ID 목록
    public List<Long> getWishedMovieIds(String username) {
        return wishListRepository.findByUsername(username).getMovieIds();
    }
}