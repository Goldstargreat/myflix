package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.WishList;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class WishListRepositoryImpl implements WishListRepository {

    // username → WishList 매핑
    private Map<String, WishList> store = new HashMap<>();

    @Override
    public WishList findByUsername(String username) {
        // 없으면 빈 WishList 자동 생성
        return store.computeIfAbsent(username, WishList::new);
    }

    @Override
    public void save(WishList wishList) {
        store.put(wishList.getUsername(), wishList);
    }
}