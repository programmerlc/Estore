package cn.programminglife.service;

import cn.programminglife.bean.Shopcart;

import java.util.List;

/**
 * @author programmerlc
 * @create 2019-10-15-19:46
 */
public interface ShopcartService {

    public List<Shopcart> findAllShopcartByUid(int user_id);

    public void addToShopcart(Shopcart shopcart);

    public void deleteShopcartById(int shopid,int user_id);

    public void clearShopcartByUid(int user_id);
}
