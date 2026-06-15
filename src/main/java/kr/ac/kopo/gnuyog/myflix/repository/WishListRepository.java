package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.WishList;

public interface WishListRepository {
    WishList findByUsername(String username);  // 없으면 새로 생성해서 반환
    void save(WishList wishList);
}
